package edu.uoc.pac3;

import java.time.LocalDate;
import java.util.UUID;

public class Movie {
    public static final String ERR_DURATION = "[ERROR] The duration of the movie cannot be 0 or negative";
    private static final int MAX_SUMMARY_LENGTH = 450;
    public static final String ERR_SUMMARY_LENGTH = "[ERROR] Summary's length cannot be greater than " + MAX_SUMMARY_LENGTH + " characters";

    private UUID id;

    private String title;

    private String summary;

    private int duration;

    private LocalDate releaseDate;

    private boolean ov;

    private Trailer trailer;

    public Movie(String title, String summary, int duration, LocalDate releaseDate, boolean ov) {
        setId();
        setTitle(title);
        setSummary(summary);
        setDuration(duration);
        setReleaseDate(releaseDate);
        setOv(ov);
    }

    public Movie(String title, String summary, int duration, LocalDate releaseDate, boolean ov, String url, int trailerDuration, LocalDate trailerReleaseDate) {
        this(title, summary, duration, releaseDate, ov);
        setTrailer(url, trailerDuration, trailerReleaseDate);
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
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

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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
        this.trailer = new Trailer(url, duration, releaseDate);
    }
}
