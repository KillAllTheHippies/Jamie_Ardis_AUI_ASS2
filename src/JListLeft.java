/**
 * Created by Jamie on 12/12/14.
 */
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class JListLeft extends JFrame {
    private JList<String> tablesList;
    public JListLeft() {
        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("1x");
        listModel.addElement("2x");
        listModel.addElement("3x");
        listModel.addElement("4x");


        //create the list
        tablesList = new JList<String>(listModel);
        add(tablesList);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Multiplication Tables");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


  }
