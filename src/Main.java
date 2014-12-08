import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main implements Runnable, ActionListener {
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu playMenu;
	private JMenu modeMenu;
	private JMenuItem startMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem subtractMenuItem;
	private JMenuItem multiplyMenuItem;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// needed on mac os x
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		// the proper way to show a jframe (invokeLater)
		SwingUtilities.invokeLater(new Main());

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
		startMenuItem = new JMenuItem("Begin");
		startMenuItem.addActionListener(this);
		playMenu.add(startMenuItem);

		// build the Edit menu
		modeMenu = new JMenu("Game Mode");
		addMenuItem = new JMenuItem("Add");
		subtractMenuItem = new JMenuItem("Subtract");
		multiplyMenuItem = new JMenuItem("Multiply");
		modeMenu.add(addMenuItem);
		modeMenu.add(subtractMenuItem);
		modeMenu.add(multiplyMenuItem);

		// add menus to menubar
		menuBar.add(playMenu);
		menuBar.add(modeMenu);

		// put the menubar on the frame
		frame.setJMenuBar(menuBar);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	/**
	 * This handles the action for the File/Open event, and demonstrates the
	 * implementation of an ActionListener. In a real-world program you'd handle
	 * this differently.
	 */
	public void actionPerformed(ActionEvent ev) {
		SampleDialog dialog = new SampleDialog();
		dialog.setModal(true);
		dialog.setVisible(true);
	}

	/**
	 * This dialog is displayed when the user selects the Play/Begin menu item.
	 */
	private class SampleDialog extends JDialog implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JButton startButton = new JButton("Start");
		private JButton checkAnsButton = new JButton("Check Answer");
		private JTextField tfAnswer = new JTextField(1);
		private JLabel label = new JLabel();
		private int x, y;

		private SampleDialog() {
			super(frame, "Sample Dialog", true);
			JPanel panel = new JPanel(new FlowLayout());
			panel.add(startButton);
			panel.add(label);
			panel.add(tfAnswer);
			
			panel.add(checkAnsButton);
			getContentPane().add(panel);
			ActionListener inputListener = new InputListener();
			checkAnsButton.addActionListener(inputListener);

			startButton.addActionListener(this);
			setPreferredSize(new Dimension(300, 200));
			pack();
			setLocationRelativeTo(frame);
		}

		public boolean checkAnswer(int x, int y) {
			boolean b = false;
			String s = tfAnswer.getText();
			int ans = Integer.parseInt(s);
			if (x + y == ans)
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

		public void actionPerformed(ActionEvent ev) {
			int x = getRandomNumber(1);
			this.x = x;
			int y = getRandomNumber(1);
			this.y = y;
			label.setText("What is " + x + " + " + y + "?");

			// setVisible(false);
		}

		public class InputListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (checkAnswer(x, y))
					System.out.println("CORRECT!!");
				else
					System.out.println("INCORRECT!!");
			}
		}

	}
}
