import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewHighScoreDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    ArrayList<HighScore> highScores;
    JTextField tf;
    int score;
    public NewHighScoreDialog(JFrame parent, String title, String message, ArrayList<HighScore> highScores, int score) {
        super(parent, title);
        System.out.println("creating the window..");
        this.highScores = highScores;
        this.score = score;
        setModal(true);
        // set the position of the window
        Point p = new Point(400, 400);
        setLocation(p.x, p.y);

        // Create a message
        tf = new JTextField("Please enter your name");
        JButton btn = new JButton("Ok");

        JPanel messagePane = new JPanel();
        messagePane.add(tf);

        // get content pane, which is usually the
        // Container of all the dialog's components.
        getContentPane().add(messagePane);

        // Create a button
        JPanel buttonPane = new JPanel();
        JButton button = new JButton("Close me");
        buttonPane.add(button);
        // set action listener on the button
        button.addActionListener(new MyActionListener());
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // override the createRootPane inherited by the JDialog, to create the rootPane.
    // create functionality to close the window when "Escape" button is pressed
    public JRootPane createRootPane() {
        JRootPane rootPane = new JRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action action = new AbstractAction() {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                System.out.println("escaping..");
                setVisible(false);
                dispose();
            }
        };
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", action);
        return rootPane;
    }


    // an action listener to be used when an action is performed
    // (e.g. button is pressed)
    class MyActionListener implements ActionListener {

        //close and dispose of the window.
        public void actionPerformed(ActionEvent e) {
            highScores.add(new HighScore(score,tf.getText()));
            try {
                writeScores("assets/highScores.ser");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("disposing the window..");
            setVisible(false);
            dispose();
        }
    }

    public void writeScores (String fileName) throws IOException {
        FileOutputStream fout= new FileOutputStream (fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(highScores);
        fout.close();
    }
//    public static void main(String[] a) {
//        MyJDialog dialog = new MyJDialog(new JFrame(), "hello JCGs", "This is a JDialog example");
//        // set the size of the window
//        dialog.setSize(300, 150);
//    }
}
