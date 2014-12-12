

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamie on 11/12/14.
 */
public class CentrePanel extends JPanel {

    private JLabel label;

    public static JTextField tfAnswer;

    public CentrePanel() {


        super(new FlowLayout());
        //panel.add(startButton);
        //add(Box.createRigidArea(new Dimension(0, 5)));
        label = new JLabel("Ready to play?");
        add(label);
//        add(Box.createRigidArea(new Dimension(0, 5)));

        tfAnswer = new JTextField(5);
        add(tfAnswer);
//        add(Box.createRigidArea(new Dimension(0, 5)));



    }
    public void displaySum(int diff)
    {
        int x = getRandomNumber(diff);
        Main.x = x;
        int y = getRandomNumber(diff);
        Main.y = y;
        label.setText("What is " + x + " " + Main.gameMode + " " + y + "?");
        //label.repaint();

    }

    public int getRandomNumber(int size) {
        double randomNum = Math.random();
        String n = String.valueOf(randomNum);
        String number = n.substring(2, 2 + size);
        return Integer.parseInt(number);

    }




}
