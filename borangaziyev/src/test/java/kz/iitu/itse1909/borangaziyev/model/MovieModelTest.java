package kz.iitu.itse1909.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieModelTest {
    MovieModel movieModel = new MovieModel(0, 0, "title", "description");

    @Test
    void testToString() {
        String result = movieModel.toString();
        Assertions.assertEquals("Movie: ID: 0\n" +
                "Title: title\n" +
                "Minutes: 0\n" +
                "Published Year: 0\n" +
                "Description: description\n", result);
    }

    @Test
    void testSetMovieId() {
        movieModel.setMovieId(0L);
    }

    @Test
    void testSetMinutes() {
        movieModel.setMinutes(0);
    }

    @Test
    void testSetPublishedYear() {
        movieModel.setPublishedYear(0);
    }

    @Test
    void testSetTitle() {
        movieModel.setTitle("title");
    }

    @Test
    void testSetDescription() {
        movieModel.setDescription("description");
    }

    @Test
    void testEquals() {
        boolean result = movieModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = movieModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = movieModel.hashCode();
        int result2 = movieModel.hashCode();
        Assertions.assertEquals(result2, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme