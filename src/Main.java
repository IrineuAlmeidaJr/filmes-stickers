import Extractors.ContentExtractorImdb;
import Interfaces.ConsoleColors;
import Extractors.Content;
import utils.ClientHttp;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main implements ConsoleColors {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Fazer uma conexão HTTP e buscar os dados IMDB
//        String url = "https://alura-imdb-api.herokuapp.com/movies";
//        var extractor = new ContentExtractorImdb();

        // Fazer uma conexão HTTP e buscar os dados NASA
//        String url = "https://api.nasa.gov/planetary/apod?api_key=07Ym1FwXQml5jSjvhvpPCsicpcgBo8TV15V7GrhT&start_date=2022-06-12&end_date=2022-06-14";
//        var extractor = new Extractors.ContentExtractorNasa();

        // Fazer uma conexão HTTP e buscar os dados MARVEL
        String url = "https://gateway.marvel.com/v1/public/events";
        var extractor = new Extractors.ContentExtractorMarvel();

        String json = new ClientHttp().fetchData(url);

        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url

        List <Content> contentList = extractor.ContentsExtractor(json);

        // Leitura da frase que irá aparecer nos stickers
        System.out.printf(ANSI_BLUE + "\nInsira um texto para aparecer no seu sticker: ");
        String phrase = sc.nextLine();

        MakeFigures makeFigure = new MakeFigures();
        for(int i=0; i < 3; i++) {
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
            DESAFIOS:
                - Trocar a classe conteudo para um record, que tem nas versões mais novas do java
                - Criar sua própria exceção
                - Mapear uma lista na outra usando Java 8
                - Colocar uma enum que tenha uma url e um extrator de conteudo e usar na main só colocando o valor da enum
                - Pegar uma outra API, ao exemplo, Marvel

         */
















        /*  Parte do código de exibir e gerar figurinha Filmes IMDB  */
        /*
          //Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies";

        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        var gson = new Gson();
        Model.Imdb.ImdbApi items = gson.fromJson(body, Model.Imdb.ImdbApi.class);
        List <Model.Imdb.FilmApi> listFilm = List.of(items.getItems());

        // Leitura da frase que irá aparecer nos stickers
        System.out.printf(ANSI_BLUE + "\nInsira um texto para aparecer no seu sticker: ");
        String phrase = sc.nextLine();

        // Exibir e manipular os dados
        System.out.println(ANSI_BLUE + "\n\t\t- - - - LISTA MELHORES FILMES - - - -");
        System.out.println(ANSI_BLUE + "Lista de filme classificadas conforme avaliação no site IMDB\n");
        Model.Imdb.FilmApi film;
        var makeFigure = new MakeFigures();
        for(int i=0; i < 10; i++) {
            film = listFilm.get(i);
            try {
                String imgSmall = film.getImage();
                String imgLarge = imgSmall.split("_" )[0] + "jpg";
                InputStream inputStream = new URL(imgLarge).openStream();
                makeFigure.create(inputStream, film.getTitle(), phrase);
            } catch (Exception e) {
                System.out.println(ANSI_RED  + "ATENÇÃO: imagem não encontrada!");
                System.out.println(ANSI_RED  + "ENTER para Continuar");
                sc.nextLine();
            }

            System.out.println(ANSI_BLUE + "TOP " + (i+1) + " - " + film.getEmoticon(i));
            System.out.println(ANSI_YELLOW + "Título: " + film.getTitle());
            film.getRatingStar();
        }

        */


        /*
            ***OBS: olhar na documentação o InputStream: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
            https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html
         */

    }
}









