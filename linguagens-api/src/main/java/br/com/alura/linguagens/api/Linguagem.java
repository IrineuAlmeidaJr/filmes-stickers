package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Linguagem {
    @Id
    private String id;
    private int ranking;
    private String title;
    private String image;

    public Linguagem() {

    }

    public Linguagem(int ranking, String title, String image) {
        this.ranking = ranking;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public int getRanking() {
        return ranking;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
