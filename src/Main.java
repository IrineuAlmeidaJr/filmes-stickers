import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        var endereco = URI.create(url);
//        HttpClient client = HttpClient.newHttpClient();
        // Com as novas versões (11) de java podemos utilizar var ele irá inferir o tipo
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        // Pegas só os dados que interessam (título, classificação, imagem), seria
        // o parse para pegar os dados
        var parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

        // *** DESAFIO ***
        //    I - pegar os mais populadores
        //    II - fazer um for para mostrar o rating ao exemplo até 10 estrelas
        // ou 5 estrelas ai fazer a conta certinha para imprimir/exibir as estrelas
        // certinhas, ao exemplo, ***** OU tem jeito colocar estrela colorida e mudar
        // cor do título no terminal, tentar colocar imagem no terminal no terminal
        //    III - pegar os dados pelo menos em um dos casos, por exemplo dos filmes,
        // masi populares do momento com GSON ou Jackson (DESAFIO DOS PROFESSORES)
        //    IV - Esconder a chave não deixar ela colada na URL, só que no caso não
        // estamos usando chave, por que a api do Imdb está fora do ar, mas, desafio
        // seria estrair essa chave e colocar em alguma configuração externa, em um
        // arquivo de configuração em uma variável de ambiente, props, os aquivos .iner
        //    V - Método para dar pontuação perguntaria para o usuário e exibir as
        // estrelinhas

    }
}









