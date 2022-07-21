import java.io.InputStream;
import java.net.URL;
import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;

public class Main implements ConsoleColors {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://api.nasa.gov/planetary/apod?api_key=07Ym1FwXQml5jSjvhvpPCsicpcgBo8TV15V7GrhT&start_date=2022-06-12&end_date=2022-06-14";

        String json = new ClientHttp().fetchData(url);

        var gson = new Gson();

        // Extrai os dados que interessam (no caso pegamos Titulo e Img/Url
        List <GenericAPI> contentList =  List.of(gson.fromJson(json, GenericAPI[].class));

        // Leitura da frase que irá aparecer nos stickers
        System.out.printf(ANSI_BLUE + "\nInsira um texto para aparecer no seu sticker: ");
        String phrase = sc.nextLine();

        MakeFigures makeFigure = new MakeFigures();
        for(int i=0; i < contentList.size(); i++) {
            GenericAPI content = contentList.get(i);
            try {
                String urlImage = content.getUrl().replace("(@+)(.*).jpg$", "$1.jpg");
                String title = content.getTitle();
                System.out.println(ANSI_YELLOW + title);
                InputStream inputStream = new URL(urlImage).openStream();
                makeFigure.create(inputStream, content.getTitle(), phrase);
            } catch (Exception e) {
                System.out.println(ANSI_RED  + "ATENÇÃO: imagem não encontrada!");
                System.out.println(ANSI_RED  + "ENTER para Continuar");
                sc.nextLine();
            }



        }
















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
        ImdbApi items = gson.fromJson(body, ImdbApi.class);
        List <FilmApi> listFilm = List.of(items.getItems());

        // Leitura da frase que irá aparecer nos stickers
        System.out.printf(ANSI_BLUE + "\nInsira um texto para aparecer no seu sticker: ");
        String phrase = sc.nextLine();

        // Exibir e manipular os dados
        System.out.println(ANSI_BLUE + "\n\t\t- - - - LISTA MELHORES FILMES - - - -");
        System.out.println(ANSI_BLUE + "Lista de filme classificadas conforme avaliação no site IMDB\n");
        FilmApi film;
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









