import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
/** PictureWriter overrides the descriptions.txt file 
 * it takes in the user input for the date or description of the image and when user clicks save it is saved
 * @author ryana
 */
class PictureWriter {
    public static void writePicture(String fileName, ArrayList<PictureData> pics) throws FileNotFoundException {
        PrintStream printOut = new PrintStream(fileName);
        for(PictureData pic : pics) {
            printOut.println(pic);
        }
        printOut.close();
    }
}