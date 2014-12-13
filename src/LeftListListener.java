import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jamie on 13/12/14.
 */
public class LeftListListener implements ListSelectionListener {

    final JTextArea ta;
    final JScrollPane sp;
    public LeftListListener(JTextArea ta, JScrollPane sp) {

        this.ta = ta;
        this.sp = sp;

    }

    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        System.out.println("First index: " + listSelectionEvent.getFirstIndex());
        System.out.println(", Last index: " + listSelectionEvent.getLastIndex());
        boolean adjust = listSelectionEvent.getValueIsAdjusting();
        System.out.println(", Adjusting? " + adjust);
        if (!adjust) {
            JList list = (JList) listSelectionEvent.getSource();
            //int selection = list.getSelectedIndex();
            Object selectedValue = list.getSelectedValue();
            System.out.println(selectedValue);
            ta.setText("");
            ta.append(readData("assets/" + selectedValue + ".txt"));



//                    for (int i = 0, n = selections.length; i < n; i++) {
//                        if (i == 0) {
//                            System.out.println(" Selections: ");
//                        }
//                        System.out.println(selections[i] + "/" + selectionValues[i] + " ");
//                    }
        }
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
