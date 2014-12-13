

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jamie on 11/12/14.
 */
public class LeftPanel extends JPanel {

    private JList<String> tablesList;

    public LeftPanel() {

        super();
        JTextArea ta = new JTextArea();

        JScrollPane sp = new JScrollPane(ta);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(sp);
        ta.setText("Multiplication tables go here\n\n\n\n\n\n\n\n\n\n\n");
//        ta.append(readData("assets/1x.txt"));

        add(new JListLeft(ta, sp));
//        //create the model and add elements
//        DefaultListModel<String> listModel = new DefaultListModel<String>();
//        listModel.addElement("1x");
//        listModel.addElement("2x");
//        listModel.addElement("3x");
//        listModel.addElement("4x");
//
//        //create the list
//        tablesList = new JList<String>(listModel);
//        add(tablesList);
        //ta.setText(readData());
//        for (int i = 0; i < 5; i++) {
//            ta.append("High Score: " + i + "\n");
//        }
        //repaint();

    }


}
