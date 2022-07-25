package extractors;

import interfaces.ContentExtractor;
import model.Content;
import model.MarvelCharacters.MarvelCharactersApi;
import model.MarvelCharacters.Results;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContentExtractorMarvelCharacters implements ContentExtractor {

    @Override
    public List<Content> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        MarvelCharactersApi data = gson.fromJson(json, MarvelCharactersApi.class);
        List<Results> contentList = List.of(data.getData().getResults());

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Results content : contentList) {
            String img = content.getThumbnail().getPath() + "." + content.getThumbnail().getExtension();
            contents.add(new Content(content.getName(), img));
        }

        return contents;

    }
}
