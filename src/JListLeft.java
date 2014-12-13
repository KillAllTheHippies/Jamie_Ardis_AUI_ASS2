/**
 * Created by Jamie on 12/12/14.
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JListLeft extends JPanel {

    private DefaultListModel dlm = new DefaultListModel();
    private JList list = new JList(dlm);
    final JTextArea ta;
    final JScrollPane sp;

    public JListLeft(JTextArea ta, JScrollPane sp) {

        super();
        this.ta = ta;
        this.sp = sp;
        //create the model and add elements

        for (int i = 1; i <= 12; i++) {
            String name = i + "x";
            dlm.addElement(name);
        }


        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(4);
        //list.setCellRenderer(new ListRenderer());
        //list.addListSelectionListener(new SelectionHandler());
        this.add(list);

        LeftListListener listSelectionListener = new LeftListListener(ta,sp);
        list.addListSelectionListener(listSelectionListener);
        //ArrayList<String> listArray = new ArrayList<String>();
        //DefaultListModel<String> listModel = new DefaultListModel<String>();
//        listModel.addElement("1x");
//        listModel.addElement("2x");
//        listModel.addElement("3x");
//        listModel.addElement("4x");

//        listArray.add("1x");
//        listArray.add("2x");
//        listArray.add("3x");
//        listArray.add("4x");
//
//
//
//        //create the list
//        tablesList = new JList<String>(listModel);
//        tablesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//
//        tablesList.setVisibleRowCount(4);
//        listModel.add();
//
//
//
//        add(tablesList);


//        this.setSize(200,200);


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


