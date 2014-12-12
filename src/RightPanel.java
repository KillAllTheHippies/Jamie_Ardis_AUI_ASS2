

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamie on 11/12/14.
 */
public class RightPanel extends JPanel {

    private JButton checkAnsButton = new JButton("Check Answer");
    private JComboBox comboBox;

    public RightPanel() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

       // Buttons go here.

        comboBox = new JComboBox<String>();
        comboBox.addItem("Select Difficulty");
        comboBox.addItem("Easy");
        comboBox.addItem("Challenging");
        comboBox.addItem("Hard");

        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String selectedDifficulty = (String) combo.getSelectedItem();

                if (selectedDifficulty.equals("Select Difficulty")) {
                    System.out.println("Select Difficulty");
                } else if (selectedDifficulty.equals("Easy")) {
                    Main.diff = 1;
                }else if (selectedDifficulty.equals("Challenging")) {
                    Main.diff = 2;
                }else if (selectedDifficulty.equals("Hard")) {
                    Main.diff = 3;
                } // end if
            }
        });

        add(comboBox);
        add(checkAnsButton);
        checkAnsButton.addActionListener(new ChkAnsListener());

    }


    public class ChkAnsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (Main.gameMode.equals("+"))
            {
                if (checkAdd(Main.x, Main.y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");

            }else  if (Main.gameMode.equals("-"))
            {
                if (checkSubtract(Main.x, Main.y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");

            }else
            {
                if (checkMultiply(Main.x, Main.y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");
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

}

