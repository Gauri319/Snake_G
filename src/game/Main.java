package game;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Snake Game");
        // setting close operation
        frame.setBounds(10,10,905,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GameFrame panel=new GameFrame();
        panel.setBackground(Color.darkGray);
        frame.add(panel);

        // makes the frame visible
        frame.setVisible(true);
    }


}
