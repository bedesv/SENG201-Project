package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class IslandPropertiesWindow {

	private JFrame frmIslandPropertiesWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IslandPropertiesWindow window = new IslandPropertiesWindow();
					window.frmIslandPropertiesWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IslandPropertiesWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frmIslandPropertiesWindow.
	 */
	private void initialize() {
		frmIslandPropertiesWindow = new JFrame();
		frmIslandPropertiesWindow.setBounds(100, 100, 450, 300);
		frmIslandPropertiesWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
