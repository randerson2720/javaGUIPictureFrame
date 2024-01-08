import java.io.IOException;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PictureFrame extends JFrame {
    PicturePanel picturePanel = new PicturePanel();
    int index = 0;
    ArrayList<PictureData> pics;
    ArrayList<BufferedImage> images;
    JTextField date = new JTextField();
    JTextArea description = new JTextArea();

    public PictureFrame() throws IOException {
        super();
        pics = PictureDataReader.readPictureDataFromFile("descriptions.txt");       // loads the file and puts the data into the pics arraylist
        images = PictureLoader.loadImagesFromPictureData(pics);                     // takes the pics arraylist and loads the images into the images arraylist

        Container component = getContentPane();
        component.setLayout(new BorderLayout());
        component.add(picturePanel, BorderLayout.CENTER);   // places the picturePanel in the center slot of the BorderLayout
        setTitle("Picture Frame");                          // sets the title for the GUI  
        //setBounds(50,50,290,400);                          
        
        JPanel buttons = new JPanel();                      // creates the buttons Prev, Save, and Next
        JButton btnPrev = new JButton("Prev");
        JButton btnSave = new JButton("Save");
        JButton btnNext = new JButton("Next");

        buttons.add(btnPrev);
        buttons.add(btnSave);
        buttons.add(btnNext);

        btnSave.addActionListener(new ActionListener() {        // adds an action listener for the save button
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        btnNext.addActionListener(new ActionListener() {        // adds an action listener for the next button
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                if(index == pics.size()) {
                    index = 0;
                }
                setImage(index);
            }
        });

        btnPrev.addActionListener(new ActionListener() {    // adds an action listener for the prev button
            @Override
            public void actionPerformed(ActionEvent e) {
                index--;
                if(index ==-1) {
                    index = pics.size() -1;
                }
                setImage(index);
            }
        }); 

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panel.add(date, BorderLayout.NORTH);                    // places everything in the GUI correctly and sets the sizes
        panel.add(description, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        BufferedImage img = images.get(0);
        int height = 400 - img.getHeight();
        panel.setSize(img.getWidth(), height);
        panel.setMinimumSize(new Dimension(img.getWidth(), height));
        component.add(panel, BorderLayout.SOUTH);

        JMenuBar jmb = new JMenuBar();          // creates the menubar that includes the File and Help buttons/menus
        JMenu jmFile = new JMenu("File");
        JMenu jmHelp = new JMenu("Help");

        setJMenuBar(jmb);

        jmb.add(jmFile);        // adds jmFile and jmHelp into the jmb menubar
        jmb.add(jmHelp);

        JMenuItem jmSave = new JMenuItem("Save");               // menu items inside of the jmFile and jmHelp menus
        JMenuItem jmExit = new JMenuItem("Exit");
        JMenuItem jmAbout = new JMenuItem("About");

        jmFile.add(jmSave);
        jmFile.add(jmExit);
        jmHelp.add(jmAbout);

        jmAbout.addActionListener(new ActionListener(){         // Action listener for the about menu option
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(picturePanel, "Created by Ryan Anderson in November, 2021.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jmSave.addActionListener(new ActionListener() {         // Action listener for the save menu option
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        jmExit.addActionListener(new ActionListener() {         // Action listener for the exit menu option
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setImage(0);

    }

    private void save() {                           // save function that overrides the file when user presses the save button                                                                                        
        System.out.println("Saved");
        PictureData pic = pics.get(index);
        pic.setDate(date.getText());
        pic.setDescription(description.getText());
        try {
            PictureWriter.writePicture("descriptions.txt", pics);
        } catch (IOException iex) {
            JOptionPane.showMessageDialog(picturePanel, " Could not save ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setImage(int i) {                                                                                                                                                                                             
        PictureData p = pics.get(i);
        picturePanel.setPicture(images.get(i));
        description.setText(p.getDescription());
        date.setText(p.getDate());
    }

}





