package Model.Language;

public class Language {
    private int racking;
    private String title;
    private String image;

    public Language(int racking, String title, String image) {
        this.racking = racking;
        this.title = title;
        this.image = image;
    }

    public int getRacking() {
        return racking;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
