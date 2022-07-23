import enumerator.API;
import extractors.ContentExtractorImdb;
import extractors.ContentExtractorMarvelCharacters;
import interfaces.ConsoleColors;
import model.Content;
import utils.ClientHttp;
import utils.GenerateUrlMarvel;
import utils.MakeFigures;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main implements ConsoleColors {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        API api = API.MARVEL_EVENTS;
        String json = new ClientHttp().fetchData(api.getUrl());
        List <Content> contentList = api.getExtractor().ContentsExtractor(json);

        // Leitura da frase que será colocada nos stickers
        System.out.printf(ANSI_BLUE + "\nInsira um texto para aparecer no seu sticker: ");
        String phrase = sc.nextLine();

        MakeFigures makeFigure = new MakeFigures();
        for(int i=0; i < 2; i++) {
            Content content = contentList.get(i);
            try {
                System.out.println(ANSI_YELLOW + content.getTitle());
                InputStream inputStream = new URL(content.getUrlImage()).openStream();
                makeFigure.create(inputStream, content.getTitle(), phrase);
            } catch (Exception e) {
                System.out.println(ANSI_RED  + "ATENÇÃO: imagem não encontrada!");
                System.out.println(ANSI_RED  + "ENTER para Continuar");
                sc.nextLine();
            }
        }

        /*
            ***OBS: olhar na documentação o InputStream: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
            https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html
         */

    }
}









