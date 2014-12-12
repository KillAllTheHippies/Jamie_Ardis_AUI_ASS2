

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
    private JButton checkAnsButton = new JButton("Check Answer");
    private int score, lives;


    public CentrePanel() {


        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //panel.add(startButton);
        //add(Box.createRigidArea(new Dimension(0, 5)));

        label = new JLabel("Ready to play?");
        JPanel panel2 = new JPanel();
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.LINE_AXIS);
        panel2.setLayout(layout2);
        panel2.add(label);
//        add(Box.createRigidArea(new Dimension(0, 5)));

        tfAnswer = new JTextField(5);
        panel2.add(tfAnswer);
//        add(Box.createRigidArea(new Dimension(0, 5)));
        add(panel2);

        add(checkAnsButton);

        checkAnsButton.addActionListener(new ChkAnsListener());


    }
    public class ChkAnsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (Main.gameMode.equals("+"))
            {
                if (checkAdd(Main.x, Main.y)){
                    System.out.println("CORRECT!!");
                    score++;
                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                }

            }else  if (Main.gameMode.equals("-"))
            {
                if (checkSubtract(Main.x, Main.y)) {
                    System.out.println("CORRECT!!");
                    score++;

                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                }

            }else
            {
                if (checkMultiply(Main.x, Main.y)) {
                    System.out.println("CORRECT!!");
                    score++;

                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                }
            }


        }
    }

    public boolean checkMultiply(int x, int y) {
        boolean b = false;
        String s = CentrePanel.tfAnswer.getText();
        if (isNumeric(s)) {
            int ans = Integer.parseInt(s);
            if (x * y == ans)
                b = true;

        }
        return b;

    }
    public boolean checkAdd(int x, int y) {
        boolean b = false;
        String s = CentrePanel.tfAnswer.getText();
        if (isNumeric(s)) {
            int ans = Integer.parseInt(s);
            if (x + y == ans)
                b = true;

        }
        return b;

    }
    public boolean checkSubtract(int x, int y) {
        boolean b = false;
        String s = CentrePanel.tfAnswer.getText();
        if (isNumeric(s)) {
            int ans = Integer.parseInt(s);
            if (x - y == ans)
                b = true;

        }
        return b;

    }

    public static boolean isNumeric(String str)
    {
        try
        {
            int i = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


    public void startGame(int diff)
    {
        score = 0;
        if (diff == 1)
            Main.lives = 3;
        else if (diff == 2)
            Main.lives = 2;
        else if (diff == 3)
            Main.lives = 1;

        displaySum(diff);
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
