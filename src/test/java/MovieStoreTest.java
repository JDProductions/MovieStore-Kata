import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie starWars = new Movie("Star Wars", "Adams", 1999);
    private final Movie starTrek = new Movie("STAR Trek", "Adams", 2002);
    private final MovieStore movieStore = new MovieStore();
    private final Movie goonies = new Movie("Goonies", "Frank", 2001);
    private final Movie shawShank = new Movie("Shawshank Redemption", "Adams", 2010);

    @Before
    public void setUp() throws Exception {
        movieStore.add(goonies);
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(starTrek);
        movieStore.add(shawShank);
    }


    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }


    @Test
    public void findAMovieWhenTitleIsPartiallyMatchedCaseInsenitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void findMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Adams");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars,shawShank));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByReleaseYear(1999,2002);

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harryPotter, goonies));
    }
}
