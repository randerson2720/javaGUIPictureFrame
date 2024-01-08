import java.io.IOException;
import javax.swing.JFrame;
/** App is the main class of the program
 * @author ryana
 */

public class App extends JFrame {
    public static void main(String[] args) throws IOException {
        PictureFrame frame = new PictureFrame();
        frame.setSize(290, 400);                                // sets the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
