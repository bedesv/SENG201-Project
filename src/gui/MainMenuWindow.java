package gui;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

import backEnd.Game;
import backEnd.Player;

public class MainMenuWindow {

	private JFrame frmMainMenuWindow;
	private JFrame popup;
	
	private JLabel lblCoins;
	
	

	/**
	 * Creates the window object.
	 */
	public MainMenuWindow() {
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		openWindow(game);
		frmMainMenuWindow.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmMainMenuWindow.setVisible(false);
	}

	/**
	 * Initializes the main menu.
	 * Displays buttons for activities
	 * Displays a welcome message and shows the players coins and the current day
	 * @param game The current game
	 * @wbp.parser.entryPoint
	 */
	private void openWindow(Game game) {
		
		Player player = game.getPlayer();
		frmMainMenuWindow = new JFrame();
		frmMainMenuWindow.setTitle("Main Game");
		frmMainMenuWindow.setBounds(100, 100, 1000, 800);
		frmMainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenuWindow.getContentPane().setLayout(null);
		frmMainMenuWindow.setLocationRelativeTo(null);
		
		JPanel panelMenuButtons = new JPanel();
		panelMenuButtons.setBounds(340, 168, 300, 521);
		frmMainMenuWindow.getContentPane().add(panelMenuButtons);
		panelMenuButtons.setLayout(null);
		
		JButton btnEndGame = new JButton("END GAME");
		btnEndGame.setBounds(0, 456, 300, 65);
		panelMenuButtons.add(btnEndGame);
		btnEndGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEnterShop = new JButton("Enter Shop");
		btnEnterShop.setBounds(0, 0, 300, 65);
		panelMenuButtons.add(btnEnterShop);
		btnEnterShop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.setBounds(0, 76, 300, 65);
		panelMenuButtons.add(btnRepairShip);
		btnRepairShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSetSail = new JButton("Set Sail");
		btnSetSail.setBounds(0, 152, 300, 65);
		panelMenuButtons.add(btnSetSail);
		btnSetSail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBounds(0, 228, 300, 65);
		panelMenuButtons.add(btnViewInventory);
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnViewShipInfo = new JButton("View Ship Information");
		btnViewShipInfo.setBounds(0, 304, 300, 65);
		panelMenuButtons.add(btnViewShipInfo);
		btnViewShipInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnViewIslandInfo = new JButton("View Island Information");
		btnViewIslandInfo.setBounds(0, 380, 300, 65);
		panelMenuButtons.add(btnViewIslandInfo);
		btnViewIslandInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnHiddenMenu = new JButton("");
		btnHiddenMenu.setBounds(36, 297, 242, 55);
		frmMainMenuWindow.getContentPane().add(btnHiddenMenu);
		btnHiddenMenu.setOpaque(false);
		btnHiddenMenu.setContentAreaFilled(false);
		btnHiddenMenu.setBorderPainted(false);
		javax.swing.ToolTipManager.sharedInstance().setInitialDelay(0 );
		btnHiddenMenu.setToolTipText("I'm a secret menu, click me!");
		
		lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 65, 142, 35);
		frmMainMenuWindow.getContentPane().add(lblCoins);
		
		JLabel lblWelcome = new JLabel("Hello " + player.getName() + ". Welcome to " + player.getCurrLocation().getName());
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setBounds(42, 30, 568, 35);
		frmMainMenuWindow.getContentPane().add(lblWelcome);
		
		JLabel lblDays = new JLabel();
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDays.setBounds(817, 30, 100, 35);
		frmMainMenuWindow.getContentPane().add(lblDays);
		if (player.unlimitedDays()) {
			lblDays.setText("Day " + player.getCurrDay());
		} else {
			lblDays.setText("Day " + player.getCurrDay() + "/" + player.getMaxDays());
		}
		
		/*
		 * Button clicked listeners that open the relevant window
		 */
		btnHiddenMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openSecretMenu();
			}
		});
		
		btnEnterShop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openStore();
			}
		});
		
		btnRepairShip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (player.getCoins() < player.getShipRepairCost()) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to repair the ship (" + player.getShipRepairCost() + " required). Sell some items or weapons to get more");
					
				} else if (player.getShipDamage() == 0) {
					JOptionPane.showMessageDialog(popup, "Your ship doesn't need repairing");
					
				} else {
					int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to repair your ship for " + player.getShipRepairCost() + " coins?", "Repair Confirmation",JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						player.repairShip();
						lblCoins.setText("Coins: " + player.getCoins());
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
		
		btnViewIslandInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openIslandInformation();
			}
		});
		
		btnViewShipInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.openShipInformation();
			}
		});
		
		btnSetSail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (player.getShipDamage() > 0) {
					JOptionPane.showMessageDialog(popup, "Error: You must repair your ship before setting sail.");
					
				} else {
					game.openSetSail();
				}
			}
		});
		
		btnEndGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to end the game?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(popup,"Game Finished: Thanks for playing " + player.getName() + "! You lasted for " + player.getCurrDay() + 
							" days, ammassed " + player.getCoins() + " coins and had " + player.getInventoryValue() + " coins worth of items and weapons.");
					game.endGame();
				}
				
			}
		});
	}

}
