package edu.uoc.pac3;

import java.time.LocalDate;
import java.util.UUID;

public class Movie {
    private static final int MAX_SUMMARY_LENGTH = 450;
    public static final String ERR_DURATION = "[ERROR] The duration of the movie cannot be 0 or negative";
    public static final String ERR_SUMMARY_LENGTH = "[ERROR] Summary's length cannot be greater than " + MAX_SUMMARY_LENGTH + " characters";
    public static final String ERR_WRONG_INDEX = "[ERROR] Wrong index";
    public static final String ERR_THEATER_EXISTS = "[ERROR] Movie already exists in this theater";
    public static final int MAX_THEATERS = 5;

    private UUID id;

    private String title;

    private String summary;

    private int duration;

    private LocalDate releaseDate;

    private boolean ov;

    private Trailer trailer;

    private Theater[] theaters;

    public Movie(String title, String summary, int duration, LocalDate releaseDate, boolean ov) throws Exception {
        setId();
        setTitle(title);
        setSummary(summary);
        setDuration(duration);
        setReleaseDate(releaseDate);
        setOv(ov);
        this.trailer = null;
    }

    public Movie(String title, String summary, int duration, LocalDate releaseDate, boolean ov, String url, int trailerDuration, LocalDate trailerReleaseDate) throws Exception {
        this(title, summary, duration, releaseDate, ov);
        setTrailer(url, trailerDuration, trailerReleaseDate);
    }

    public UUID getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) throws Exception {
        if (summary.length() > MAX_SUMMARY_LENGTH)
            throw new Exception(ERR_SUMMARY_LENGTH);
        this.summary = summary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws Exception {
        if (duration <= 0)
            throw new Exception(ERR_DURATION);
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isOv() {
        return ov;
    }

    public void setOv(boolean ov) {
        this.ov = ov;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(String url, int duration, LocalDate releaseDate) {
        try {
            this.trailer = new Trailer(url, duration, releaseDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Theater[] getTheaters() {
        return theaters;
    }

    public Theater getTheater(int index) {
        return getTheaters()[index];
    }

    public boolean isInTheTheater(Theater theater) {
        return findTheaterIndex(theater) != -1;
    }

    private int findTheaterIndex(Theater theater) {
        for (int i = 0; i < getTheaters().length; i++) {
            if (getTheaters()[i].equals(theater))
                return i;
        }
        return -1;
    }

    private void setTheater(int index, Theater theater) throws Exception {
        getTheaters()[index] = theater;
    }

    public void addTheater(Theater theater) throws Exception {
    }

    public void removeTheater(Theater theater) throws Exception {
    }

    public void notInTheaters() {
    }
}
