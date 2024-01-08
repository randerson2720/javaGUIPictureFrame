import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/** PictureLoader loads images into the BufferedImage ArrayList 
 **/

public class PictureLoader {

    public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> picData) throws IOException {
        ArrayList<BufferedImage> pics = new ArrayList<>();
        for(PictureData d : picData) {
            BufferedImage bImage = ImageIO.read(new File(d.getFilename()));
            pics.add(bImage);
        }
        return pics;
    }
}
