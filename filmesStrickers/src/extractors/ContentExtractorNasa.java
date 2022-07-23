package extractors;

import interfaces.ContentExtractor;
import model.Content;
import model.Nassa.NasaApi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContentExtractorNasa implements ContentExtractor {
    @Override
    public List<Content> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        List <NasaApi> contentList = List.of(gson.fromJson(json, NasaApi[].class));

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (NasaApi content : contentList) {
            contents.add(new Content(content.getTitle(), content.getUrl()));
        }

        return contents;
    }
}
