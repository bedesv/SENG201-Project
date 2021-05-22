package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class InventoryWindow {

	private JFrame inventoryWindowFrame;
	
	private JTable itemsBoughtTable;
	private JTable itemsSoldTable;
	private JTable weaponsBoughtTable;
	private JTable weaponsSoldTable;
	private JPanel itemsSoldPanel;
	private JScrollPane itemsSoldScrollPane;
	private JPanel weaponsBoughtPanel;
	private JScrollPane weaponsBoughtScrollPane;
	private JPanel weaponsSoldPanel;
	private JScrollPane weaponsSoldScrollPane;
	private JButton btnMainMenu;
	private JLabel lblCapacity;
	private JLabel lblCoins;
	private JFrame popup;
	
	private ArrayList<Item> itemsBoughtArray = new ArrayList<Item>();
	private ArrayList<Item> itemsSoldArray = new ArrayList<Item>();
	
	private ArrayList<Weapon> weaponsBoughtArray = new ArrayList<Weapon>();
	private ArrayList<Weapon> weaponsSoldArray = new ArrayList<Weapon>();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InventoryWindow window = new InventoryWindow();
//					window.inventoryWindowFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InventoryWindow(Game game) {
		initialize(game);
		inventoryWindowFrame.setVisible(true);
		
	}
	
	public void exitInventory() {
		inventoryWindowFrame.setVisible(false);
	}
	

	/**
	 * Initialize the contents of the inventoryWindowFrame.
	 */
	private void initialize(Game game) {
		inventoryWindowFrame = new JFrame();
		inventoryWindowFrame.setBounds(100, 100, 1000, 800);
		inventoryWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryWindowFrame.getContentPane().setLayout(null);
		
		Player player = game.getPlayer();
		Ship playersShip = player.getSelectedShip();
		
		inventoryWindowFrame.setTitle(playersShip.getName() + " Inventory");
		
		String[] itemsBoughtTableHeader = {"Item", "Purchased For"};
		String[] itemsSoldTableHeader = {"Item", "Purchased For", "Sold For", "Sold At"};
		String[] weaponsBoughtTableHeader = {"Weapon", "Purchased For"};
		String[] weaponsSoldTableHeader = {"Weapon", "Purchased For", "Sold For", "Sold At"};
		itemsBoughtArray = playersShip.getItemsBought();
		itemsSoldArray = playersShip.getItemsSold();
		weaponsBoughtArray = playersShip.getWeaponsBought();
		weaponsSoldArray = playersShip.getWeaponsSold();
		
		
		weaponsSoldPanel = new JPanel();
		weaponsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsSoldPanel.setBounds(509, 387, 450, 250);
		inventoryWindowFrame.getContentPane().add(weaponsSoldPanel);
		
		weaponsSoldScrollPane = new JScrollPane();
		GroupLayout gl_weaponsSoldPanel = new GroupLayout(weaponsSoldPanel);
		gl_weaponsSoldPanel.setHorizontalGroup(
			gl_weaponsSoldPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(weaponsSoldScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_weaponsSoldPanel.setVerticalGroup(
			gl_weaponsSoldPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(weaponsSoldScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsSoldModel = new DefaultTableModel(weaponsSoldTableHeader, 0);
		weaponsSoldTable = new JTable(weaponsSoldModel);
		weaponsSoldScrollPane.setViewportView(weaponsSoldTable);
		weaponsSoldPanel.setLayout(gl_weaponsSoldPanel);
		
		// Add weapons to sell to the table
		for (Weapon weapon: weaponsSoldArray) {
			String location = weapon.getIslandSoldOn().getStore().getStoreName() + " on " + weapon.getIslandSoldOn().getName();
			Object[] temp = {weapon.getName(), weapon.getPurchasedPrice(), weapon.getSoldPrice(), location};
			weaponsSoldModel.addRow(temp);
		}
		
		weaponsBoughtPanel = new JPanel();
		weaponsBoughtPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Bought", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsBoughtPanel.setBounds(509, 76, 450, 250);
		inventoryWindowFrame.getContentPane().add(weaponsBoughtPanel);
		
		weaponsBoughtScrollPane = new JScrollPane();
		GroupLayout gl_weaponsBoughtPanel = new GroupLayout(weaponsBoughtPanel);
		gl_weaponsBoughtPanel.setHorizontalGroup(
			gl_weaponsBoughtPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(weaponsBoughtScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_weaponsBoughtPanel.setVerticalGroup(
			gl_weaponsBoughtPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(weaponsBoughtScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsBoughtModel = new DefaultTableModel(weaponsBoughtTableHeader, 0);
		weaponsBoughtTable = new JTable(weaponsBoughtModel);
		weaponsBoughtScrollPane.setViewportView(weaponsBoughtTable);
		weaponsBoughtPanel.setLayout(gl_weaponsBoughtPanel);
		
		// Add weapons to buy to the table
		for (Weapon weapon: weaponsBoughtArray) {
			Object[] temp = {weapon.getName(), weapon.getPrice()};
			weaponsBoughtModel.addRow(temp);
		}
		
		itemsSoldPanel = new JPanel();
		itemsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsSoldPanel.setBounds(24, 387, 450, 250);
		inventoryWindowFrame.getContentPane().add(itemsSoldPanel);
		
		itemsSoldScrollPane = new JScrollPane();
		GroupLayout gl_itemsSoldPanel = new GroupLayout(itemsSoldPanel);
		gl_itemsSoldPanel.setHorizontalGroup(
			gl_itemsSoldPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(itemsSoldScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsSoldPanel.setVerticalGroup(
			gl_itemsSoldPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(itemsSoldScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		DefaultTableModel itemsSoldModel = new DefaultTableModel(itemsSoldTableHeader, 0);
		itemsSoldTable = new JTable(itemsSoldModel);
		itemsSoldScrollPane.setViewportView(itemsSoldTable);
		itemsSoldPanel.setLayout(gl_itemsSoldPanel);
		
		// Add items to sell to the table
		for (Item item: itemsSoldArray) {
			String location = item.getIslandSoldOn().getStore().getStoreName() + " on " + item.getIslandSoldOn().getName();
			Object[] temp = {item.getName(), item.getPurchasedPrice(), item.getSoldPrice(), location};
			itemsSoldModel.addRow(temp);
		}
		
		JPanel itemsBoughtPanel = new JPanel();
		itemsBoughtPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Bought", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsBoughtPanel.setBounds(24, 76, 450, 250);
		inventoryWindowFrame.getContentPane().add(itemsBoughtPanel);
		
		JScrollPane itemsBoughtScrollPane = new JScrollPane();
		GroupLayout gl_itemsBoughtPanel = new GroupLayout(itemsBoughtPanel);
		gl_itemsBoughtPanel.setHorizontalGroup(
			gl_itemsBoughtPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsBoughtScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsBoughtPanel.setVerticalGroup(
			gl_itemsBoughtPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsBoughtScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel itemsBoughtModel = new DefaultTableModel(itemsBoughtTableHeader, 0);
		itemsBoughtTable = new JTable(itemsBoughtModel);
		itemsBoughtScrollPane.setViewportView(itemsBoughtTable);
		itemsBoughtPanel.setLayout(gl_itemsBoughtPanel);
		
		// Add items to buy to the table
		for (Item item: itemsBoughtArray) {
			Object[] temp = {item.getName(), item.getPrice()};
			itemsBoughtModel.addRow(temp);
		}
		
		lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 30, 142, 35);
		inventoryWindowFrame.getContentPane().add(lblCoins);
		
		lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacity.setBounds(509, 30, 285, 35);
		inventoryWindowFrame.getContentPane().add(lblCapacity);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(434, 710, 120, 40);
		inventoryWindowFrame.getContentPane().add(btnMainMenu);
		
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ask the player if they're sure they want to exit the store
				int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to return to the main menu?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
			
				// If the player confirms they want to exit the store
				if (choice == JOptionPane.YES_OPTION) {
					game.exitInventory();
				}
			}
		});
		
	}

}
