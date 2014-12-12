

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Jamie on 11/12/14.
 */
public class RightPanel extends JPanel implements ActionListener {


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

        JRadioButton rdbAdd = new JRadioButton("Add");
        rdbAdd.setMnemonic(KeyEvent.VK_A);
        rdbAdd.setActionCommand("Add");
        rdbAdd.setSelected(true);

        JRadioButton rdbSubtract = new JRadioButton("Subtract");
        rdbSubtract.setMnemonic(KeyEvent.VK_S);
        rdbSubtract.setActionCommand("Subtract");

        JRadioButton rdbMultiply = new JRadioButton("Multiply");
        rdbMultiply.setMnemonic(KeyEvent.VK_M);
        rdbMultiply.setActionCommand("Multiply");

        ButtonGroup group = new ButtonGroup();
        group.add(rdbAdd);
        group.add(rdbSubtract);
        group.add(rdbMultiply);

        rdbAdd.addActionListener(this);
        rdbSubtract.addActionListener(this);
        rdbMultiply.addActionListener(this);

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
        add(rdbAdd);
        add(rdbSubtract);
        add(rdbMultiply);


    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Add") )
        {
            Main.gameMode = "+";
        }
        if (e.getActionCommand().equals("Subtract") )
        {
            Main.gameMode = "-";
        }
        if (e.getActionCommand().equals("Multiply") )
        {
            Main.gameMode = "*";
        }
    }




}

