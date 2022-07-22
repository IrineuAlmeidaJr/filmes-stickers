package Extractors;

import Interfaces.ContentExtractor;
import Model.Imdb.FilmApi;
import Model.Marvel.MarvelApi;
import Model.Marvel.Results;
import com.google.gson.Gson;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ContentExtractorMarvel implements ContentExtractor {

    @Override
    public List<Content> ContentsExtractor(String json) {
        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url)
        Gson gson = new Gson();
        MarvelApi data = gson.fromJson(json, MarvelApi.class);
        List<Results> contentList = List.of(data.getData().getResults());

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Results content : contentList) {
            String img = content.getThumbnail().getPath() + "." + content.getThumbnail().getExtension();
            contents.add(new Content(content.getTitle(), img));
        }

        return contents;

    }
}
