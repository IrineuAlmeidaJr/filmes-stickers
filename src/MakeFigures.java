import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MakeFigures implements ConsoleColors {

    public void create(InputStream inputStream, String fileName, String phrase) {

        try {
            // leitura da imagem
            //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpeg"));
            //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
            BufferedImage original = ImageIO.read(inputStream);

            // cria nova imagem em memória com transparência e com tamanho novo
            int width = original.getWidth();
            int height = original.getHeight();
            int newHeight = (int) (height + (height * 0.26));
            BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

            // copia a imagem original pra nova imagem (em memória)
            Graphics2D graphics = (Graphics2D) newImage.getGraphics();
            graphics.drawImage(original, 0, 0, null);

            // configurar a fonte
            phrase = phrase.toUpperCase();
            int fontSize = height / 16;
            var font = new Font("Comic Sans MS", Font.BOLD, fontSize);
            graphics.setColor(Color.YELLOW);
            graphics.setFont(font);

            // encontra o meio da imagem (eixo x)
            int posX = (int) ((width / 2) - (phrase.length() * (fontSize * 0.3)));
            int posY = (int) (newHeight - (newHeight * 0.1484));
            graphics.drawString(phrase, posX, posY);

            // cria imagem/carimbo pessoal que será acrescentado
            int resizeWidth, resizeHeight;
            resizeWidth = resizeHeight = (int) (width * 0.28);
            InputStream imgStamp = new FileInputStream(new File("stamp/hangLoose.png"));
            BufferedImage bufferedImageInput = ImageIO.read(imgStamp);
            graphics.drawImage(bufferedImageInput, width - resizeWidth, newHeight - resizeHeight,
                    resizeWidth, resizeHeight, null);

            // Faz contorno na imagem
            graphics.setStroke(new BasicStroke((float) (height *  0.002)));
            var textLayout = new TextLayout(phrase, font, graphics.getFontRenderContext());
            var shape = textLayout.getOutline(null);
            graphics.setColor(Color.BLACK);
            graphics.translate(posX, posY);
            graphics.draw(shape);

            // escrever a nova imagem em um arquivo
            fileName.concat(".png");
            File figure = new File("saida/"+fileName + ".png");
            // Se não existir o diretório ele cria
//            if(figure.mkdirs())
                ImageIO.write(newImage, "png", figure);
//            else {
//                System.out.println(ANSI_RED + "Imagem como nome já existente");
//            }

        } catch (IOException e) {
            System.out.println("Não foi possível ler a imagem");
        }

    }

}
