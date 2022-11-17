package edu.uoc.pac3;

import java.time.LocalDate;

public class Trailer {
    public static final int MAX_DURATION = 180;

    public static final String ERR_DURATION = "[ERROR] The duration of the trailer cannot be 0, negative or greater than " + MAX_DURATION;

    public static final String ERR_RELEASE = "[ERROR] The release of the trailer cannot be null or a date that is later than today";

    private String url;

    private int duration;

    private LocalDate releaseDate;

    public Trailer(String url, int duration, LocalDate releaseDate) {
        setUrl(url);
        setDuration(duration);
        setReleaseDate(releaseDate);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFormattedDuration() {
        int hours = duration / 60;
        int minutes = duration % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
