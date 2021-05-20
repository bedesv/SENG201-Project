package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGame {

	JFrame frmMainGame;
	private JTextField textCoinNum;

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
		btnEnterShop.setBounds(84, 22, 193, 29);
		
		JButton btnRepair = new JButton("Repair Ship");
		btnRepair.setBounds(84, 57, 193, 29);
		
		JButton btnSail = new JButton("Set Sail");
		btnSail.setBounds(84, 92, 193, 29);
		
		JButton btnViewItems = new JButton("View Inventory");
		btnViewItems.setBounds(84, 127, 193, 29);
		
		JButton btnViewShip = new JButton("View Ship");
		btnViewShip.setBounds(84, 162, 193, 29);
		
		JButton btnViewIsland = new JButton("View Island Information");
		btnViewIsland.setBounds(84, 197, 193, 29);
		
		JButton btnEndGame = new JButton("END GAME");
		btnEndGame.setBounds(84, 232, 193, 29);
		
		JLabel lblCoin = new JLabel("Coins");
		lblCoin.setBounds(22, 22, 36, 16);
		
		JLabel lblDayRemain = new JLabel(Player.getIsland().getName());
		lblDayRemain.setBounds(311, 27, 101, 16);
		
		JLabel lblDayNum = new JLabel(Player.name + " in days");
		lblDayNum.setBounds(341, 47, 49, 16);
		
		textCoinNum = new JTextField();
		textCoinNum.setBounds(14, 44, 58, 26);
		textCoinNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmMainGame.getContentPane().setLayout(null);
		textCoinNum.setEnabled(false);
		textCoinNum.setEditable(false);
		textCoinNum.setColumns(10);
		frmMainGame.getContentPane().add(textCoinNum);
		frmMainGame.getContentPane().add(lblCoin);
		frmMainGame.getContentPane().add(btnEndGame);
		frmMainGame.getContentPane().add(btnEnterShop);
		frmMainGame.getContentPane().add(btnRepair);
		frmMainGame.getContentPane().add(btnSail);
		frmMainGame.getContentPane().add(btnViewItems);
		frmMainGame.getContentPane().add(btnViewShip);
		frmMainGame.getContentPane().add(btnViewIsland);
		frmMainGame.getContentPane().add(lblDayRemain);
		frmMainGame.getContentPane().add(lblDayNum);
	}

}
