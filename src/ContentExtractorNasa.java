import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContentExtractorNasa implements ContentExtractor{

    public List<Conteudo> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        List <NasaApi> contentList = List.of(gson.fromJson(json, NasaApi[].class));

        List<Conteudo> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (NasaApi content : contentList) {
            contents.add(new Conteudo(content.getTitle(), content.getUrl()));
        }

        return contents;
    }
}
