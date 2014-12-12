

import javax.swing.*;
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
        ta.setText("Multiplication tables go here");

        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("1x");
        listModel.addElement("2x");
        listModel.addElement("3x");
        listModel.addElement("4x");

        //create the list
        tablesList = new JList<String>(listModel);
        add(tablesList);
        //ta.setText(readData());
//        for (int i = 0; i < 5; i++) {
//            ta.append("High Score: " + i + "\n");
//        }
        //repaint();

    }

    static public String readData(String fileName)
    {
        char ch;
        int in = 0;
        String strTest = "";

        try
        {
            FileReader charRead = new FileReader(fileName);

            while (in != -1)
            {
                in = charRead.read();
                ch = (char)in;
                strTest = strTest + ch;
                System.out.println(strTest);
            }
        }
        catch (EOFException e)
        {
            System.out.println("end of file: " + e);
        }
        catch(IOException e)
        {
            System.out.println("Error reading file: " + e);
        }
        return strTest;
    }
}
