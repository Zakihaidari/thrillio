package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controller.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

import java.util.List;

public class View {

    public static void browese(User user, List<List<Bookmark>> bookmarks){
        System.out.println("\n" + user.getEmail() + " is browsing items");
        int bookmarkCount = 0;
        for (List<Bookmark> bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                //BookMarking....
               // if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmark = getBookmarkDecision(bookmark);
                    if (isBookmark) {
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);

                        System.out.println("New Item Bookmarked -- " + bookmark);
                    }
               // }
                if (user.getUserType().equals(UserType.EDITOR)
                        || user.getUserType().equals(UserType.CHIEF_EDITOR) ){
                    if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);

                        }
                    }

                    //Sharing!!
                    if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable){
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user , bookmark);
                        }

                    }
                }
            }
        }
    }

    //TODO: Belo Method simulate user input. After IO, We take input via console.
    private static boolean getShareDecision() {
        return Math.random() <0.5 ? true: false;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random();

        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
                (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED :
                        KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() <0.5 ? true: false;
    }

//    public static void bookmark(User user, Bookmark[][] bookmarks){
//        System.out.println("\n" + user.getEmail() + "is bookMarking");
//        for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++){
//            int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
//            int bookmarkOffset = (int) (Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
//
//            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//
//            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//
//            System.out.println(bookmark);
//        }
//    }
}
