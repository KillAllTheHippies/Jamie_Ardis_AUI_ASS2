

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamie on 11/12/14.
 */
public class CentrePanel extends JPanel {

    private JLabel label = new JLabel("Ready to play?");
    private JButton checkAnsButton = new JButton("Check Answer");
    private JTextField tfAnswer = new JTextField(5);

    public CentrePanel() {

        setLayout(new FlowLayout());
        //panel.add(startButton);
        //add(Box.createRigidArea(new Dimension(0, 5)));
        add(label);
//        add(Box.createRigidArea(new Dimension(0, 5)));

        add(tfAnswer);
//        add(Box.createRigidArea(new Dimension(0, 5)));
        add(checkAnsButton);


    }
    public void displaySum(int diff)
    {
        int x = getRandomNumber(diff);
        Main.x = x;
        int y = getRandomNumber(diff);
        Main.y = y;
        label.setText("What is " + x + " " + Main.gameMode + " " + y + "?");
    }

    public int getRandomNumber(int size) {
        double randomNum = Math.random();
        String n = String.valueOf(randomNum);
        String number = n.substring(2, 2 + size);
        return Integer.parseInt(number);

    }




    public boolean checkMultiply(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x * y == ans)
            b = true;

        return b;

    }
    public boolean checkAdd(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x + y == ans)
            b = true;

        return b;

    }
    public boolean checkSubtract(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x - y == ans)
            b = true;

        return b;

    }

}
