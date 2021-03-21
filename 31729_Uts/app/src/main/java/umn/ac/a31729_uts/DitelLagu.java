package umn.ac.a31729_uts;

public class DitelLagu {
    private String path;
    private String title;
    private String artist;
    private String duration;


    public DitelLagu(String path, String title, String artist, String duration) {
        this.path = path;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public DitelLagu() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
