package enumerator;

import extractors.*;
import interfaces.ContentExtractor;
import utils.GenerateUrlMarvel;

public enum API {
    IMDB("https://alura-imdb-api.herokuapp.com/movies",
            new ContentExtractorImdb()),
    NASSA("https://api.nasa.gov/planetary/apod?api_key=07Ym1FwXQml5jSjvhvpPCsicpcgBo8TV15V7GrhT&start_date=2022-06-12&end_date=2022-06-14",
            new ContentExtractorNasa()),
    MARVEL_CHARACTERS(new GenerateUrlMarvel().generate("\"https://gateway.marvel.com/v1/public/characters\""),
            new ContentExtractorMarvelCharacters()),
    MARVEL_EVENTS(new GenerateUrlMarvel().generate("https://gateway.marvel.com/v1/public/events"),
            new ContentExtractorMarvelEvents()),
    LANGUAGES("https://alura-linguagens-api-sp.herokuapp.com/linguagens",
            new ContentExtractorLanguages());

    private String url;
    private ContentExtractor extractor;

    API(String url, ContentExtractor extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return url;
    }

    public ContentExtractor getExtractor() {
        return extractor;
    }
}
