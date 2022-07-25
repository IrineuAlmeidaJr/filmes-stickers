package model.Imdb;

import java.util.Map;

public class ImdbApi {
    private FilmApi items[];
    private Map<String, String> error;

    public ImdbApi(FilmApi[] items, Map<String, String> error) {
        this.items = items;
        this.error = error;
    }

    public FilmApi[] getItems() {
        return items;
    }
}
