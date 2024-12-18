package test.com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MovieTest {

    @Test
    public void testIsKidFriendlyEligible() {
        //Test 1: Horror Movie return false
        Movie movie = BookmarkManager.getInstacne().createMovies(
                3000,
                "Citizen Kane",
                "unknown",
                1941,
                new String[]{"Orson Welles", "Joseph Cotten"},
                new String[]{"Orson Welles"},
                MovieGenre.HORROR,
                8.5
        );
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse("For Horror Movie -- isKidFriendlyEligible() must return false" , isKidFriendlyEligible);

        //Test 2: Horror Movie return false
        movie = BookmarkManager.getInstacne().createMovies(
                3000,
                "Citizen Kane",
                "unknown",
                1941,
                new String[]{"Orson Welles", "Joseph Cotten"},
                new String[]{"Orson Welles"},
                MovieGenre.THRILLERS,
                8.5
        );
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse("For Horror Movie -- isKidFriendlyEligible() must return false" , isKidFriendlyEligible);
    }
}
