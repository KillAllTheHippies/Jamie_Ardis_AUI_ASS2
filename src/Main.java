import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main implements Runnable, ActionListener {
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
    //private JButton startButton = new JButton("Start");
    private JButton checkAnsButton = new JButton("Check Answer");
    private JTextField tfAnswer = new JTextField(2);
    private JLabel label = new JLabel("Ready to play?");
    private  int x, y;
    private String gameMode = "+"; // initialise game mode to addition
    private int diff = 1; // difficulty level defines number size in 10s

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
            displaySum(diff);
        }
        if ("Subtract".equals(ev.getActionCommand())) {
            gameMode = "-";
            System.out.println(gameMode);
            displaySum(diff);
        }
        if ("Multiply".equals(ev.getActionCommand())) {
            gameMode = "*";
            System.out.println(gameMode);
            displaySum(diff);
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

    // set click handler for the start game menu item
    public class StartGameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            displaySum(diff);
        }
    }

    public void displaySum(int diff)
    {
        int x = getRandomNumber(diff);
        this.x = x;
        int y = getRandomNumber(diff);
        this.y = y;
        label.setText("What is " + x + " " + gameMode + " " + y + "?");
    }

    public class ChkAnsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (gameMode.equals("+"))
            {
                if (checkAdd(x,y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");

            }else  if (gameMode.equals("-"))
            {
                if (checkSubtract(x,y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");

            }else
            {
                if (checkMultiply(x,y))
                    System.out.println("CORRECT!!");
                else
                    System.out.println("INCORRECT!!");
            }


        }
    }


    public int getRandomNumber(int size) {
		double randomNum = Math.random();
		String n = String.valueOf(randomNum);
		String number = n.substring(2, 2 + size);
		return Integer.parseInt(number);

	}

	public void run() {
		frame = new JFrame("Childrens Maths Game");
		menuBar = new JMenuBar();

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

        // Create a new panel with a box layout and add the buttons and labels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));
        //panel.add(startButton);
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0,5)));

        panel.add(tfAnswer);
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(checkAnsButton);

        // Add the panel to the Frame
        //frame.add(panel);

        // Create a new panel (defaults to BorderLayout)
        JPanel pane =  new JPanel();
        //pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

        // Add some stuff to the borderlayout
        JButton button = new JButton("Button 1 (PAGE_START)");

//        add the flow layout to the border layout top frame
        pane.add(panel, BorderLayout.PAGE_START);

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        JTextArea ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);

        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        pane.add(sp, BorderLayout.CENTER);

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);

        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);

        // Add the panel to the frame
        frame.add(pane);
        // Add input listeners
        ActionListener inputListener = new ChkAnsListener();
        checkAnsButton.addActionListener(inputListener);
        //startButton.addActionListener(this);
        //setPreferredSize(new Dimension(300, 200));
        //pack();
        //setLocationRelativeTo(frame);
        for (int i = 0; i<5; i++)
        {
            ta.insert("High Score: " + i + "\n",i);
        }


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
    public boolean checkMultiply(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x * y == ans)
            b = true;

        return b;

    }
    public boolean checkAdd(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x + y == ans)
            b = true;

        return b;

    }
    public boolean checkSubtract(int x, int y) {
        boolean b = false;
        String s = tfAnswer.getText();
        int ans = Integer.parseInt(s);
        if (x - y == ans)
            b = true;

        return b;

    }


}

