import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShowHighScoreDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    public ShowHighScoreDialog(JFrame parent, String title, String message) {
        super(parent, title);
        System.out.println("creating the window..");
        // set the position of the window
        Point p = new Point(400, 400);
        setLocation(p.x, p.y);
        setModal(true);


        // Create a message
        JTextArea ta = new JTextArea();

        JScrollPane sp = new JScrollPane(ta);

        JPanel messagePane = new JPanel();
        messagePane.add(sp);
        ta.setText("High Scores\n");
        ta.append(message);
        ta.setEditable(false);
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
        setPreferredSize(new Dimension(900,600));
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
            System.out.println("disposing the window..");
            setVisible(false);
            dispose();
        }
    }

//    public static void main(String[] a) {
//        MyJDialog dialog = new MyJDialog(new JFrame(), "hello JCGs", "This is a JDialog example");
//        // set the size of the window
//        dialog.setSize(300, 150);
//    }
}
