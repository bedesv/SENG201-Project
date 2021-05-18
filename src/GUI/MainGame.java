package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainGame {

	private JFrame frmMainGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame window = new MainGame();
					window.frmMainGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainGame = new JFrame();
		frmMainGame.setTitle("Main Game");
		frmMainGame.setBounds(100, 100, 450, 300);
		frmMainGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEnterShop = new JButton("Enter Shop");
		
		JButton btnRepair = new JButton("Repair Ship");
		
		JButton btnSail = new JButton("Set Sail");
		
		JButton btnViewItems = new JButton("View Inventory");
		
		JButton btnViewShip = new JButton("View Ship");
		
		JButton btnViewIsland = new JButton("View Island Information");
		
		JButton btnEndGame = new JButton("END GAME");
		GroupLayout groupLayout = new GroupLayout(frmMainGame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEndGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEnterShop, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRepair, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewItems, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewShip, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewIsland, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(112))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(btnEnterShop)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRepair)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewItems)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewShip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewIsland)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEndGame)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		frmMainGame.getContentPane().setLayout(groupLayout);
	}

}
