package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

import java.util.List;

public class Launch {
    private static List<User> users;
    private  static List<List<Bookmark>> bookmarks;


    private static void loadData() {
        System.out.println("1.Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstacne().getBookmarks();

//        System.out.println("Printing Data...");
//        printUserData();
//        printBookmarkData();
    }

    private static void printUserData() {
        for (User user: users){
            System.out.println(user);
        }
    }

    private static void printBookmarkData() {
        for (List<Bookmark> bookmarkList: bookmarks){
            for (Bookmark bookmark: bookmarkList){
                System.out.println(bookmark);
            }
        }
    }

    private static void start() {
        //System.out.println("\n 2. BookMarking...");
        for(User user: users){
            View.browese(user,bookmarks);
        }
    }
    public static void main(String args[]){
        loadData();
        start();
    }


}
