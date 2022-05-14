package game;

import javax.swing.*;
import java.awt.*;

public class AddImage extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //JFrame Creation
        frame.setTitle("Add Image"); //Add the title to frame
        frame.setLayout(null); //Terminates default flow layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        frame.setBounds(100, 200, 400, 400); //Sets the position of the frame

        Container c = frame.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("src/game/snakeimage.png")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(50, 30, size.width, size.height); //Sets the location of the image

        c.add(label); //Adds objects to the container
        frame.setVisible(true); // Exhibit the frame
    }
}
