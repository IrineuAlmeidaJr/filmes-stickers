package Model.MarvelCharacters;

public class Results {
    private int id;
    private String name;
    private Thumbnail thumbnail;

    public Results(int id, String name, Thumbnail thumbnail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

}
