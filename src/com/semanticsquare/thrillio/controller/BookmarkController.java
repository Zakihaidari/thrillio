package com.semanticsquare.thrillio.controller;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController(){}

    public static BookmarkController getInstance(){
        return instance;
    }


    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstacne().saveUserBookmark( user, bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManager.getInstacne().setKidFriendlyStatus(user , kidFriendlyStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstacne().share(user , bookmark);
    }
}
