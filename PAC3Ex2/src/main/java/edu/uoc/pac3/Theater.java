package edu.uoc.pac3;

public class Theater {
    public static final String ERR_WRONG_INDEX = "[ERROR] Wrong index";
    public static final String ERR_NULL_MOVIE = "[ERROR] The movie cannot be null";
    public static final String ERR_NO_MORE_MOVIES = "[ERROR] This theater cannot screen more movies";
    public static final String ERR_MOVIE_EXISTS = "[ERROR] This movie is already screened in this theater";
    public static final String ERR_MOVIE_DOESNT_EXIST = "[ERROR] This movie does not exist in this theater";

    private String name;

    private int capacity;

    private Movie[] movies;

    public Theater(String name, int capacity, int MAX_MOVIES) {
        setName(name);
        setCapacity(capacity);
        this.movies = new Movie[MAX_MOVIES];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public Movie getMovie(int index) {
        return movies[index];
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    private int findMovieIndex(Movie movie) {
        for (int i = 0; i < getMovies().length; i++) {
            if (getMovie(i).equals(movie)) {
                return i;
            }
        }
        return -1;
    }

    public boolean movieExists(Movie movie) {
        return findMovieIndex(movie) != -1;
    }

    public boolean canScreenMoreMovies() {
        return getMovies().length < Movie.MAX_THEATERS; //ToDo Rev
    }

    private void setMovie(int index, Movie movie) {
        getMovies()[index] = movie;
    }

    public void addMovie(Movie movie) throws Exception {
    }

    public void removeMovie(Movie movie) throws Exception {
    }
}
