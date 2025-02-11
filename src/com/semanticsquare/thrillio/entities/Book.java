package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.partner.Shareable;

import java.util.Arrays;

public class Book extends Bookmark implements Shareable {

    private int publicationYear;
    private String publisher;
    private String [] author;
    private String genre;
    private double amazonRating;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", author=" + Arrays.toString(author) +
                ", genre='" + genre + '\'' +
                ", amazonRating=" + amazonRating +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        if (genre.equals(BookGenre.SELF_HELP) || genre.equals(BookGenre.PHILOSOPHY)){
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Book</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
        builder.append("<publisher>").append(publisher).append("</publisher>");
        builder.append("<authors>").append(String.join(",", author)).append("</authors>");
        builder.append("<genre>").append(genre).append("</genre>");
        builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
        builder.append("</item>");
        return builder.toString();
    }
}
