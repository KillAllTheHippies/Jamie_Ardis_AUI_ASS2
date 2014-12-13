

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jamie on 11/12/14.
 */
public class CentrePanel extends JPanel {

    private JLabel label, lblScore, lblLives;

    public static JTextField tfAnswer;
    private JButton checkAnsButton = new JButton("Check Answer");
    private int score, lives;
    private String strScore, strLives;
    private ArrayList<HighScore> highScores;

    public CentrePanel(ArrayList<HighScore> highScores) {


        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.highScores = highScores;
        //panel.add(startButton);
        //add(Box.createRigidArea(new Dimension(0, 5)));

        label = new JLabel("Ready to play?");
        lblLives = new JLabel("Lives: ");
        lblScore = new JLabel("Score: ");

        add(lblLives);
        add(lblScore);
        // put label and textfield in a horizontal box layout
        JPanel panel2 = new JPanel();
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.LINE_AXIS);
        panel2.setLayout(layout2);
        panel2.add(label);
        tfAnswer = new JTextField(5);
        panel2.add(tfAnswer);
//        add(Box.createRigidArea(new Dimension(0, 5)));
        add(panel2);

        add(checkAnsButton);

        checkAnsButton.addActionListener(new ChkAnsListener());
        checkAnsButton.setEnabled(false);


    }
    public void enableButton()
    {
        checkAnsButton.setEnabled(true);
    }
    public void disableButton()
    {
        checkAnsButton.setEnabled(false);
    }

    public boolean checkIfNewHighScore(int score)
    {
        int tmpScore;
        int highestScore = 0;
        boolean b = false;
        if (!highScores.isEmpty()) {
            for (HighScore item : highScores) {
                tmpScore = item.getScore();
                if (score > tmpScore)
                    highestScore = score;
                else
                    highestScore = tmpScore;
            }
            if (score == highestScore)
                b = true;
        }
        else b = true; // means highscores is empty
        return b;
    }
    public void startGame(int diff)
    {
        score = 0;
        if (diff == 1)
            lives = 3;
        else if (diff == 2)
            lives = 2;
        else if (diff == 3)
            lives = 1;

        lblScore.setText("Score: " + score);
        lblLives.setText("Lives: " + lives);
        displaySum(diff);
    }
    public void continueGame()
    {
        displaySum(Main.diff);
        tfAnswer.setText("");
    }
    public void gameOver()
    {
        lblLives.setText("Game Over");
        if (checkIfNewHighScore(score)) {
            NewHighScoreDialog dialog = new NewHighScoreDialog(new JFrame(), "New High Score!", "Please enter your Name",highScores,score);
            dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        }
        disableButton();

    }
    public void checkContinue()
    {
        if (lives <= 0)
        {
            gameOver();
        }
        else
        {
            continueGame();
        }
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
    public class ChkAnsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {


           if (lives > 0)
           {


            if (Main.gameMode.equals("+"))
            {
                if (checkAdd(Main.x, Main.y)){
                    System.out.println("CORRECT!!");
                    score++;
                    lblScore.setText("Score: " + score);
                    checkContinue();
                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                    lblLives.setText("Lives: " + lives);
                    checkContinue();
                }

            }else  if (Main.gameMode.equals("-"))
            {
                if (checkSubtract(Main.x, Main.y)) {
                    System.out.println("CORRECT!!");
                    score++;
                    lblScore.setText("Score: " + score);
                    checkContinue();

                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                    lblLives.setText("Lives: " + lives);
                    checkContinue();

                }

            }else
            {
                if (checkMultiply(Main.x, Main.y)) {
                    System.out.println("CORRECT!!");
                    score++;
                    lblScore.setText("Score: " + score);
                    checkContinue();

                }
                else {
                    System.out.println("INCORRECT!!");
                    lives--;
                    lblLives.setText("Lives: " + lives);
                    checkContinue();

                }
            }

           }else
               gameOver();

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




    public int getRandomNumber(int size) {
        double randomNum = Math.random();
        String n = String.valueOf(randomNum);
        String number = n.substring(2, 2 + size);
        return Integer.parseInt(number);

    }




}
