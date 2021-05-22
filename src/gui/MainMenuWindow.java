package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class MainMenuWindow {

	private JFrame frmMainGame;
	
	private JButton btnEnterShop;
	private JButton btnRepairShip;
	private JButton btnSetSail;
	private JButton btnViewInventory;
	private JButton btnViewShipInfo;
	private JButton btnViewIslandInfo;
	private JButton btnEndGame;
	private JLabel lblDayNum;
	private JPanel panelMenuButtons;
	private JFrame popup;
	

	/**
	 * Create the application.
	 */
	public MainMenuWindow(Game game) {
		initialize(game);
		this.openMenu();
	}
	
	public void openMenu() {
		frmMainGame.setVisible(true);
	}
	
	public void exitMenu() {
		frmMainGame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		frmMainGame = new JFrame();
		frmMainGame.setTitle("Main Game");
		frmMainGame.setBounds(100, 100, 1000, 800);
		frmMainGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmMainGame.getContentPane().setLayout(null);
		
		panelMenuButtons = new JPanel();
		panelMenuButtons.setBounds(350, 50, 300, 521);
		frmMainGame.getContentPane().add(panelMenuButtons);
		panelMenuButtons.setLayout(null);
		
		btnEndGame = new JButton("END GAME");
		btnEndGame.setBounds(0, 456, 300, 65);
		panelMenuButtons.add(btnEndGame);
		btnEndGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnEnterShop = new JButton("Enter Shop");
		btnEnterShop.setBounds(0, 0, 300, 65);
		panelMenuButtons.add(btnEnterShop);
		btnEnterShop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.setBounds(0, 76, 300, 65);
		panelMenuButtons.add(btnRepairShip);
		btnRepairShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSetSail = new JButton("Set Sail");
		btnSetSail.setBounds(0, 152, 300, 65);
		panelMenuButtons.add(btnSetSail);
		btnSetSail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBounds(0, 228, 300, 65);
		panelMenuButtons.add(btnViewInventory);
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnViewShipInfo = new JButton("View Ship");
		btnViewShipInfo.setBounds(0, 304, 300, 65);
		panelMenuButtons.add(btnViewShipInfo);
		btnViewShipInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnViewIslandInfo = new JButton("View Island Information");
		btnViewIslandInfo.setBounds(0, 380, 300, 65);
		panelMenuButtons.add(btnViewIslandInfo);
		btnViewIslandInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnEnterShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openStore();
			}
		});
		
		btnRepairShip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (player.getCoins() < player.getRepairCost()) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to repair the ship (" + player.getRepairCost() + " required). Sell some items or weapons to get more");
				} else if (player.getShipDamage() == 0) {
					JOptionPane.showMessageDialog(popup, "Your ship doesn't need repairing");
				} else {
					
					int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to repair your ship for " + player.getRepairCost() + " coins?", "Repair Confirmation",JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						player.repairShip();
					}
				}
			}
		});
		
		btnViewInventory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openInventory();
			}
		});
	}

}
