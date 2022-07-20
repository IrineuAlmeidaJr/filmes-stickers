import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;

public class Main implements ConsoleColors {

    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        var gson = new Gson();
        ImdbApi items = gson.fromJson(body, ImdbApi.class);
        List <FilmApi> listFilm = List.of(items.getItems());

        // Exibir e manipular os dados
        System.out.println(ANSI_BLUE + "\n\t\t- - - - LISTA MELHORES FILMES - - - -");
        System.out.println(ANSI_BLUE + "Lista de filme classificadas conforme avaliação no site IMDB\n");
        FilmApi film;
        var makeFigure = new MakeFigures();
        for(int i=0; i < 5; i++) {
            film = listFilm.get(i);
            try {
                String imgSmall = film.getImage();
                String imgLarge = imgSmall.split("_" )[0] + "jpg";
                InputStream inputStream = new URL(imgLarge).openStream();
                makeFigure.create(inputStream, film.getTitle());
            } catch (Exception e) {
                Scanner sc = new Scanner(System.in);

                System.out.println(ANSI_RED  + "ATENÇÃO: imagem não encontrada!");
                System.out.println(ANSI_RED  + "ENTER para Continuar");
                sc.nextLine();
            }

            System.out.println("" + film.getEmoticon(i));
            System.out.println(ANSI_YELLOW + "Título: " + film.getTitle());
            film.getRatingStar();
        }

        /*
            ***OBS: olhar na documentação o InputStream: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
            https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html
         */



    }
}









