package Extractors;

import Interfaces.ContentExtractor;
import Model.Content;
import Model.Imdb.FilmApi;
import Model.Imdb.ImdbApi;
import Model.Language.Language;
import Model.Nassa.NasaApi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContentExtractorLanguages implements ContentExtractor {

    @Override
    public List<Content> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        List <Language> contentList = List.of(gson.fromJson(json, Language[].class));

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Language content : contentList) {
            contents.add(new Content(content.getTitle(), content.getImage()));
        }

        return contents;
    }

}
