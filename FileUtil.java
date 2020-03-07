import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtil {
    public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> content = new ArrayList<>();
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static BufferedImage readImage(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static BufferedImage cropImage(BufferedImage img, double p) {
        BufferedImage dimg = img.getSubimage(0, 0, (int) (img.getWidth() * p), img.getHeight()); // Cut the Image
        return dimg;
    }

}
