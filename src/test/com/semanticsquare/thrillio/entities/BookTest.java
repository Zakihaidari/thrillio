package test.com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class BookTest {

    @Test
    public void testIsKidFriendlyEligible(){
        Book book = BookmarkManager.getInstacne().createBooks(
                4000,
                "Walden",
                1854,
                "Wilder Publications",
                new String[]{"Henry David Thoreau"},
                BookGenre.PHILOSOPHY,
                4.3
        );

        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse("For Philosophy Book -- isKidFriendlyEligible() must return false" , isKidFriendlyEligible);

         book = BookmarkManager.getInstacne().createBooks(
                4000,
                "Walden",
                1854,
                "Wilder Publications",
                new String[]{"Henry David Thoreau"},
                BookGenre.SELF_HELP,
                4.3
        );

         isKidFriendlyEligible = book.isKidFriendlyEligible();
         assertFalse("For Self help Book -- isKidFriendlyEligible() must return false" , isKidFriendlyEligible);
    }
    }

