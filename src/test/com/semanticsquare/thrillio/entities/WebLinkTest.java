package test.com.semanticsquare.thrillio.entities;



import com.semanticsquare.thrillio.entities.WebLinks;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;


public class WebLinkTest {

    @Test
    public void testIsKidFriendlyEligible(){
        //Test 1: porn in url --false
        WebLinks webLinks = BookmarkManager.getInstacne().createWeblinks(
                2000,
                "Taming Tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
                "http://www.javaworld.com"
        );
        boolean isKidFriendlyEligible = webLinks.isKidFriendlyEligible();
        assertFalse("For porn in url -- isKidFriendlyEligible() must return false ",isKidFriendlyEligible);

        //Test 2: porn in Title -- false
        webLinks = BookmarkManager.getInstacne().createWeblinks(
                2000,
                "Taming porn Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com"
        );
           isKidFriendlyEligible = webLinks.isKidFriendlyEligible();
        assertFalse("For porn in Title -- isKidFriendlyEligible() must return false ",isKidFriendlyEligible);

        //test 3: Adult in host --false
        webLinks = BookmarkManager.getInstacne().createWeblinks(
                2000,
                "Taming tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.adult.com"
        );
        isKidFriendlyEligible = webLinks.isKidFriendlyEligible();
        assertFalse("For Adult in host -- isKidFriendlyEligible() must return false ",isKidFriendlyEligible);

        //test 4: Adult in url but not in host --true
        webLinks = BookmarkManager.getInstacne().createWeblinks(
                2000,
                "Taming tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
                "http://www.javaworld.com"
        );
        isKidFriendlyEligible = webLinks.isKidFriendlyEligible();
        assertTrue("For Adult in url but not in host -- isKidFriendlyEligible() must return true ",isKidFriendlyEligible);

        //test 5: Adult in title only --true
        webLinks = BookmarkManager.getInstacne().createWeblinks(
                2000,
                "Taming adult Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com"
        );
        isKidFriendlyEligible = webLinks.isKidFriendlyEligible();
        assertTrue("For Adult in title only -- isKidFriendlyEligible() must return true ",isKidFriendlyEligible);

    }
}
