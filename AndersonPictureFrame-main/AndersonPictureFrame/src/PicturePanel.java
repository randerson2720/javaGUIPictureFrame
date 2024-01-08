import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
/** PicturePanel creates the picture and paints it for the GUI
 * Has all getter and setters and constructors for the PicturePanel
 * Sets the image height and width
 * @author ryana
 */
public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    BufferedImage img;
    private int msgX = 10;
	private int msgY = 15;
	private int mouseX = 0;
	private int mouseY = 0;
    private String message;

    public PicturePanel() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public PicturePanel(BufferedImage img) {
        super();
        this.img = img;
    }
    
    public void setPicture(BufferedImage img) {
        this.img = img;
        this.setSize(img.getWidth(), img.getHeight());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {     
        super.paintComponent(g);
        if(img != null) {
            g.drawImage(img, 0, 0, this);
        }
        message = "(x=" + mouseX + ", y=" + mouseY + ")";   // draws the coordinates of the mouse movement and clicks in the GUI.
        g.drawString(message, msgX, msgY);
    }
        
    @Override
    public void mouseDragged(MouseEvent e) {        // all mouse events
        mouseX = e.getX();
        mouseY = e.getY();
        msgX = e.getX();
        msgY = e.getY();
        repaint();
            
        }
    @Override
    public void mouseMoved(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        msgX = e.getX();
        msgY = e.getY();
        repaint();
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    	mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        
    }
    
}

