package interfaces;

import model.Content;

import java.util.List;

public interface ContentExtractor {

    public List<Content> ContentsExtractor(String json);

}