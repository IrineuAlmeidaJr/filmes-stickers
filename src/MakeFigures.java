import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class MakeFigures implements ConsoleColors {

    public void create(InputStream inputStream, String fileName) {

        try {
            // leitura da imagem
            //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpeg"));
//            InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
            BufferedImage original = ImageIO.read(inputStream);

            // cria nova imagem em memória com transparência e com tamanho novo
            int width = original.getWidth();
            int height = original.getHeight();
            int newHeight = (int) (height + (height * 0.2968));
            BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

            // copia a imagem original pra nova imagem (em memória)
            Graphics2D graphics = (Graphics2D) newImage.getGraphics();
            graphics.drawImage(original, 0, 0, null);

            // configurar a fonte
            int fontSize = 80;
            var font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
            graphics.setColor(Color.YELLOW);
            graphics.setFont(font);
            System.out.println();

            // escrever uma frase em uma nova imagem
            String phrase = "TOPZERA";
            // encontra o meio da imagem (eixo x)
            int posX = (int) ((width / 2) - (phrase.length() * (fontSize * 0.7)) / 2);
            graphics.drawString(phrase, posX, (int) (newHeight - (newHeight * 0.1484)));

            // escrever a nova imagem em um arquivo
            fileName.concat(".png");
            File figure = new File("saida/"+fileName + ".png");
//             Se não existir o diretório ele cria
            if(figure.mkdirs())
                ImageIO.write(newImage, "png", figure);
            else {
                System.out.println(ANSI_RED + "Imagem como nome já existente");
            }

        } catch (IOException e) {
            System.out.println("Não foi possível ler a imagem");
        }

    }

}
