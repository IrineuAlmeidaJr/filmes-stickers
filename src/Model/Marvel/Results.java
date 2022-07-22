package Model.Marvel;

public class Results {
    private int id;
    private String title;
    private Thumbnail thumbnail;

    public Results(int id, String title, Thumbnail thumbnail) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
