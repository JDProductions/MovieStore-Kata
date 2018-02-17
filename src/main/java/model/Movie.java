package model;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;

    public Movie(String title, String director, int releaseYear) {

        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

}
