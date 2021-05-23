package GUI;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class MainMenuWindow {

	private JFrame mainMenuWindowFrame;
	
	private JButton btnEnterShop;
	private JButton btnRepairShip;
	private JButton btnSetSail;
	private JButton btnViewInventory;
	private JButton btnViewShipInfo;
	private JButton btnViewIslandInfo;
	private JButton btnEndGame;
	private JLabel lblCoins;
	private JLabel lblWelcome;
	private JLabel lblDays;
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
		mainMenuWindowFrame.setVisible(true);
	}
	
	public void exitMenu() {
		mainMenuWindowFrame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		mainMenuWindowFrame = new JFrame();
		mainMenuWindowFrame.setTitle("Main Game");
		mainMenuWindowFrame.setBounds(100, 100, 1000, 800);
		mainMenuWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenuWindowFrame.getContentPane().setLayout(null);
		
		panelMenuButtons = new JPanel();
		panelMenuButtons.setBounds(235, 167, 300, 521);
		mainMenuWindowFrame.getContentPane().add(panelMenuButtons);
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
		
		btnViewShipInfo = new JButton("View Ship Properties");
		btnViewShipInfo.setBounds(0, 304, 300, 65);
		panelMenuButtons.add(btnViewShipInfo);
		btnViewShipInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnViewIslandInfo = new JButton("View Island Information");
		btnViewIslandInfo.setBounds(0, 380, 300, 65);
		panelMenuButtons.add(btnViewIslandInfo);
		btnViewIslandInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 65, 142, 35);
		mainMenuWindowFrame.getContentPane().add(lblCoins);
		
		lblWelcome = new JLabel("Hello " + player.getName() + ". Choose an activity");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setBounds(42, 30, 351, 35);
		mainMenuWindowFrame.getContentPane().add(lblWelcome);
		
		lblDays = new JLabel();
		
		if (player.unlimitedDays()) {
			lblDays.setText("Day " + player.getCurrDay());
		} else {
			lblDays.setText("Day " + player.getCurrDay() + "/" + player.getMaxDays());
		}
		
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDays.setBounds(817, 30, 100, 35);
		mainMenuWindowFrame.getContentPane().add(lblDays);
		
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
		
		btnSetSail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setSail();
			}
		});
	}

}
