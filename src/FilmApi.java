public class FilmApi {
    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    public FilmApi(String id, String rank, String title, String fullTitle, String year, String image, String crew, String imDbRating, String imDbRatingCount) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.fullTitle = fullTitle;
        this.year = year;
        this.image = image;
        this.crew = crew;
        this.imDbRating = imDbRating;
        this.imDbRatingCount = imDbRatingCount;
    }

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void getRatingStar() {
        int numberStars = (int) Math.ceil((Double.parseDouble(imDbRating) / 2));
//        String totalStars = " ";
//        for (int i = 0; i < numberStars; i++) {
//            totalStars += "⭐️";
//        }
//        System.out.println(totalStars);
        System.out.println("" + "⭐️".repeat(Math.max(0, numberStars)) + "\n");
    }

    public String getEmoticon(int pos) {
        String emoticon = null;
        if(pos > 50) {
            emoticon = "🎥";
        } else if(pos > 9) {
            emoticon = "🍿";
        } else if(pos > 2) {
            emoticon = "🏆🍿";
        } else {
            emoticon = "🍿🏆🍿";
        }
        return emoticon;
    }
}
