

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 11/12/14.
 */
public class LeftPanel extends JPanel {


    public LeftPanel() {

        super();
        JTextArea ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(sp);
        for (int i = 0; i < 5; i++) {
            ta.append("High Score: " + i + "\n");
        }
        repaint();

    }
}
