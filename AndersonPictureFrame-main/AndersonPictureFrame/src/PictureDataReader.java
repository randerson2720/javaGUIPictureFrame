import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/** PictureDataReader reads the data from the file
 * reads the image, date, and description
 */
public class PictureDataReader {

    public static ArrayList<PictureData> readPictureDataFromFile(String fileName) throws FileNotFoundException {
        ArrayList<PictureData> pics = new ArrayList<>();
        Scanner fscan = new Scanner(new File(fileName));
        while(fscan.hasNextLine()) {
            String[] parts = fscan.nextLine().split("\t");
            PictureData data = new PictureData(parts[0], parts[1], parts[2]);
            pics.add(data);
        }
        fscan.close();
        return pics;
    }
}
