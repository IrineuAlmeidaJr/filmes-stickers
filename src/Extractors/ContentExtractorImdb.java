package Extractors;

import Interfaces.ContentExtractor;
import Model.Imdb.FilmApi;
import Model.Imdb.ImdbApi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContentExtractorImdb implements ContentExtractor {
    @Override
    public List<Content> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        ImdbApi items = gson.fromJson(json, ImdbApi.class);
        List <FilmApi> contentList = List.of(items.getItems());

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (FilmApi content : contentList) {
            String img = content.getImage().split("_" )[0] + "jpg";
            contents.add(new Content(content.getTitle(), img));
        }

        return contents;
    }

}
