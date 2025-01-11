package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.*;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BookmarkManager {

    private static BookmarkManager instacne = new BookmarkManager();

    private static BookmarkDao dao = new BookmarkDao();

    private BookmarkManager() {
    }

    public static BookmarkManager getInstacne() {
        return instacne;
    }

    public Movie createMovies(long id, String title, String profileUrl, int releaseYear,
                              String[] cast, String[] directors, String genre, double imdRating) {

        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdRating(imdRating);

        return movie;
    }

    public Book createBooks(long id, String title, int publicationYear,
                            String publisher, String[] author, String genre, double amazonRating) {

        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;
    }

    public WebLinks createWeblinks(long id, String title, String url, String host){
        WebLinks webLinks = new WebLinks();
        webLinks.setId(id);
        webLinks.setTitle(title);
        webLinks.setUrl(url);
        webLinks.setHost(host);

        return webLinks;
    }

    public Bookmark[][] getBookmarks(){
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        if (bookmark instanceof WebLinks) {
            try {
                String url = ((WebLinks)bookmark).getUrl();
                if (!url.endsWith(".pdf")) {
                    String webpage = HttpConnect.download(((WebLinks)bookmark).getUrl());
                    if (webpage != null) {
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid- Friendly Status : " + kidFriendlyStatus + ", Marked By:  " + user.getEmail() + ", " +  bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);
        System.out.println("Data to be shared: ");
        if(bookmark instanceof Book){
            System.out.println(((Book) bookmark).getItemData());
        } else if(bookmark instanceof WebLinks){
            System.out.println(((WebLinks) bookmark).getItemData());
        }
    }
}
