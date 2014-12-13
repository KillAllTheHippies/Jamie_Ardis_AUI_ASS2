import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main implements Runnable, ActionListener, ComponentListener {
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu playMenu;
	private JMenu modeMenu;
    private JMenu diffMenu;
	private JMenuItem startMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem subtractMenuItem;
	private JMenuItem multiplyMenuItem;
    private JMenuItem easyItem;
    private JMenuItem normalItem;
    private JMenuItem hardItem;
    private LeftPanel leftPanel ;
    private CentrePanel centrePanel ;
    private RightPanel rightPanel;
    //private JFrame frame = new JFrame("Childrens Maths Game");
    //private JButton startButton = new JButton("Start");


   static int x, y;
    static String gameMode = "+"; // initialise game mode to addition
    static int diff = 1; // difficulty level defines number size in 10s
    static int lives = 3; // 3 lives for easy diff


    public static void main(String[] args) {
		// TODO Auto-generated method stub
		// needed on mac os x
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		// the proper way to show a jframe (invokeLater)
		SwingUtilities.invokeLater(new Main());

	}




    // set click handlers for the game mode menu
    public void actionPerformed(ActionEvent ev) {

        if ("Add".equals(ev.getActionCommand())) {
            gameMode = "+";
            System.out.println(gameMode);
            centrePanel.displaySum(diff);

        }
        if ("Subtract".equals(ev.getActionCommand())) {
            gameMode = "-";
            System.out.println(gameMode);
            centrePanel.displaySum(diff);
        }
        if ("Multiply".equals(ev.getActionCommand())) {
            gameMode = "*";
            System.out.println(gameMode);
            centrePanel.displaySum(diff);
        }
        if ("Easy".equals(ev.getActionCommand())) {
            diff = 1;
        }
        if ("Normal".equals(ev.getActionCommand())) {
            diff = 2;
        }
        if ("Hard".equals(ev.getActionCommand())) {
            diff = 3;
        }



        // setVisible(false);
    }

    @Override
    public void componentResized(ComponentEvent e) {

//        Dimension frameSize = frame.getContentPane().getSize();
//        leftPanel.setPreferredSize(new Dimension( (int)(frameSize.getWidth() /3 ), (int)(frameSize.getHeight() ) ));
//       centrePanel.setPreferredSize(new Dimension( (int)(frameSize.getWidth() /3 ), (int)(frameSize.getHeight() ) ));
//        rightPanel.setPreferredSize(new Dimension( (int)(frameSize.getWidth() /3 ), (int)(frameSize.getHeight() ) ));
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    // set click handler for the start game menu item
    public class StartGameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            centrePanel.startGame(diff);
        }
    }







	public void run() {

		menuBar = new JMenuBar();
        frame = new JFrame("Childrens Maths Game");
		// build the File menu
		playMenu = new JMenu("Play");
		startMenuItem = new JMenuItem("Start");
        ActionListener listn = new StartGameListener();
		startMenuItem.addActionListener(listn);
        startMenuItem.setActionCommand("Start");
		playMenu.add(startMenuItem);

		// build the Game Mode menu
		modeMenu = new JMenu("Game Mode");
		addMenuItem = new JMenuItem("Add");
        addMenuItem.setActionCommand("Add");
        addMenuItem.addActionListener(this);
		subtractMenuItem = new JMenuItem("Subtract");
        subtractMenuItem.setActionCommand("Subtract");
        subtractMenuItem.addActionListener(this);
		multiplyMenuItem = new JMenuItem("Multiply");
        multiplyMenuItem.setActionCommand("Multiply");
        multiplyMenuItem.addActionListener(this);
		modeMenu.add(addMenuItem);
		modeMenu.add(subtractMenuItem);
		modeMenu.add(multiplyMenuItem);

        // Build the difficulty menu
        diffMenu = new JMenu("Difficulty");
        easyItem = new JMenuItem("Easy");
        easyItem.setActionCommand("Easy");
        easyItem.addActionListener(this);
        normalItem = new JMenuItem("Normal");
        normalItem.setActionCommand("Normal");
        normalItem.addActionListener(this);
        hardItem = new JMenuItem("Hard");
        hardItem.setActionCommand("Hard");
        hardItem.addActionListener(this);
        diffMenu.add(easyItem);
        diffMenu.add(normalItem);
        diffMenu.add(hardItem);

		// add menus to menubar
		menuBar.add(playMenu);
		menuBar.add(modeMenu);
        menuBar.add(diffMenu);

		// put the menubar on the frame
		frame.setJMenuBar(menuBar);


        frame.addComponentListener(this);



        // Create the layout panels
         leftPanel = new LeftPanel();
         centrePanel = new CentrePanel();
         rightPanel = new RightPanel();

        // Create a new panel (defaults to BorderLayout)
        JPanel pane =  new JPanel();
        pane.setBackground(new Color(255, 191, 32));
        pane.setPreferredSize(new Dimension(640, 480));


        // ADD AN INSTANCE OF LEFTPANEL TO THE LAYOUT

        pane.add(leftPanel, BorderLayout.LINE_START);

        // ADD CENTREPANEL
        pane.add(centrePanel, BorderLayout.CENTER);

       // ADD RIGHTPANEL
        pane.add(rightPanel, BorderLayout.PAGE_END);

//        JButton button = new JButton("5 (LINE_END)");
//        pane.add(button, BorderLayout.LINE_END);

        // Add the panel to the frame
        frame.add(pane);



		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640, 480));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}


}

