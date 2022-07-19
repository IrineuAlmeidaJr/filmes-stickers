import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
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
        for(int i=0; i < listFilm.size(); i++) {
            film = listFilm.get(i);
            System.out.println("" + film.getEmoticon(i));
            System.out.println(ANSI_YELLOW + "Nome: " + film.getTitle());
            System.out.println("Capa(url): " + film.getImage());
            film.getRatingStar();
        }

    }
}









