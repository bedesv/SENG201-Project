package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.Bindings;
import javax.swing.*;
import java.util.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Font;

public class StoreWindow {

	private JFrame storeWindowFrame;
	private JTable itemsToBuyTable;
	private JTable itemsToSellTable;
	private JTable weaponsToBuyTable;
	private JTable weaponsToSellTable;
	private JPanel itemsToSellPanel;
	private JScrollPane itemsToSellScrollPane;
	private JPanel weaponsToBuyPanel;
	private JScrollPane weaponsToBuyScrollPane;
	private JPanel weaponsToSellPanel;
	private JScrollPane weaponsToSellScrollPane;
	private JButton btnBuyItem;
	private JButton btnBuyWeapon;
	private JButton btnSellItem;
	private JButton btnSellWeapon;
	private JLabel lblCapacity;
	private JLabel lblCoins;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StoreWindow window = new StoreWindow();
//					window.storeWindowFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public StoreWindow(Player player) {
		initialize(player);
		storeWindowFrame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player player) {
		storeWindowFrame = new JFrame();
		storeWindowFrame.setBounds(100, 100, 1000, 750);
		storeWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storeWindowFrame.getContentPane().setLayout(null);
		Store store = player.selectedShip.getLocation().getStore();
		String[] itemTableHeaders = {"Item", "Description", "Size", "Price"};
		String[] weaponTableHeaders = {"Weapon", "Description", "Size", "Price"};
		ArrayList<Item> itemsToBuyArray = store.getItemsSold();
		ArrayList<Item> itemsToSellArray = new ArrayList<Item>();
		
		ArrayList<Weapon> weaponsToBuyArray = store.getWeaponsSold();
		ArrayList<Weapon> weaponsToSellArray = new ArrayList<Weapon>();
		
		// Find all items the player owns and the store will buy
		for (Item i:player.selectedShip.getInventory()) {
			outerLoop:
				if (store.buysItem(i)) {
					// Ensure each item is only added once
					for (Item j:itemsToSellArray) {
						if (j.equals(i)) {
							break outerLoop;
						}
					}
					itemsToSellArray.add(i);
				}
		}
		
		// Find all weapons the player owns and the store will buy
		for (Weapon w:player.selectedShip.getWeapons()) {
			if (store.buysWeapon(w)) {
				weaponsToSellArray.add(w);
			}
		}
		
		weaponsToSellPanel = new JPanel();
		weaponsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToSellPanel.setBounds(509, 387, 450, 250);
		storeWindowFrame.getContentPane().add(weaponsToSellPanel);
		
		weaponsToSellScrollPane = new JScrollPane();
		GroupLayout gl_weaponsToSellPanel = new GroupLayout(weaponsToSellPanel);
		gl_weaponsToSellPanel.setHorizontalGroup(
			gl_weaponsToSellPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(weaponsToSellScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_weaponsToSellPanel.setVerticalGroup(
			gl_weaponsToSellPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(weaponsToSellScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsToSellModel = new DefaultTableModel(weaponTableHeaders, 0);
		weaponsToSellTable = new JTable(weaponsToSellModel);
		weaponsToSellScrollPane.setViewportView(weaponsToSellTable);
		weaponsToSellPanel.setLayout(gl_weaponsToSellPanel);
		
		// Set column widths for the weapons to sell table
		weaponsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsToSellTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToSellPanel.getWidth() - (85 + 35 + 40 + 20));
		weaponsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		// Add weapons to sell to the table
		for (Weapon weapon: weaponsToSellArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), store.getSalePrice(weapon)};
			weaponsToSellModel.addRow(temp);
		}
		
		weaponsToBuyPanel = new JPanel();
		weaponsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToBuyPanel.setBounds(509, 76, 450, 250);
		storeWindowFrame.getContentPane().add(weaponsToBuyPanel);
		
		weaponsToBuyScrollPane = new JScrollPane();
		GroupLayout gl_weaponsToBuyPanel = new GroupLayout(weaponsToBuyPanel);
		gl_weaponsToBuyPanel.setHorizontalGroup(
			gl_weaponsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(weaponsToBuyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_weaponsToBuyPanel.setVerticalGroup(
			gl_weaponsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(weaponsToBuyScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsToBuyModel = new DefaultTableModel(weaponTableHeaders, 0);
		weaponsToBuyTable = new JTable(weaponsToBuyModel);
		weaponsToBuyScrollPane.setViewportView(weaponsToBuyTable);
		weaponsToBuyPanel.setLayout(gl_weaponsToBuyPanel);
		
		// Set column widths for the weapons to buy table
		weaponsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToBuyPanel.getWidth() - (85 + 35 + 40 + 20));
		weaponsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		// Add weapons to buy to the table
		for (Weapon weapon: weaponsToBuyArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), weapon.getPrice()};
			weaponsToBuyModel.addRow(temp);
		}
		
		itemsToSellPanel = new JPanel();
		itemsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToSellPanel.setBounds(24, 387, 450, 250);
		storeWindowFrame.getContentPane().add(itemsToSellPanel);
		
		itemsToSellScrollPane = new JScrollPane();
		GroupLayout gl_itemsToSellPanel = new GroupLayout(itemsToSellPanel);
		gl_itemsToSellPanel.setHorizontalGroup(
			gl_itemsToSellPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
				.addComponent(itemsToSellScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsToSellPanel.setVerticalGroup(
			gl_itemsToSellPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addComponent(itemsToSellScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		DefaultTableModel itemsToSellModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToSellTable = new JTable(itemsToSellModel);
		itemsToSellScrollPane.setViewportView(itemsToSellTable);
		itemsToSellPanel.setLayout(gl_itemsToSellPanel);
		
		// Set column widths for the items to sell table
		itemsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		itemsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToSellTable.getColumnModel().getColumn(1).setPreferredWidth((int)itemsToSellPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		// Add items to sell to the table
		for (Item item: itemsToSellArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), store.getSalePrice(item)};
			itemsToSellModel.addRow(temp);
		}
		
		JPanel itemsToBuyPanel = new JPanel();
		itemsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToBuyPanel.setBounds(24, 76, 450, 250);
		storeWindowFrame.getContentPane().add(itemsToBuyPanel);
		
		JScrollPane itemsToBuyScrollPane = new JScrollPane();
		GroupLayout gl_itemsToBuyPanel = new GroupLayout(itemsToBuyPanel);
		gl_itemsToBuyPanel.setHorizontalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsToBuyPanel.setVerticalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel itemsToBuyModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToBuyTable = new JTable(itemsToBuyModel);
		itemsToBuyScrollPane.setViewportView(itemsToBuyTable);
		itemsToBuyPanel.setLayout(gl_itemsToBuyPanel);
		itemsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Set column widths for the items to buy table
		itemsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(itemsToBuyPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		// Add items to buy to the table
		for (Item item: itemsToBuyArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), item.getPrice()};
			itemsToBuyModel.addRow(temp);
		}
		
		// Create a button to buy the selected item
		btnBuyItem = new JButton("Buy Item");
		btnBuyItem.setBounds(189, 336, 120, 40);
		btnBuyItem.setEnabled(false);
		storeWindowFrame.getContentPane().add(btnBuyItem);
		
		// Create a button to buy the selected weapon
		btnBuyWeapon = new JButton("Buy Weapon");
		btnBuyWeapon.setBounds(674, 337, 120, 40);
		btnBuyWeapon.setEnabled(false);
		storeWindowFrame.getContentPane().add(btnBuyWeapon);
		
		// Create a button to sell the selected item
		btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(189, 647, 120, 40);
		btnSellItem.setEnabled(false);
		storeWindowFrame.getContentPane().add(btnSellItem);
		
		// Create a button to sell the selected weapon
		btnSellWeapon = new JButton("Sell Weapon");
		btnSellWeapon.setBounds(674, 648, 120, 40);
		btnSellWeapon.setEnabled(false);
		storeWindowFrame.getContentPane().add(btnSellWeapon);
		
		lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 24, 142, 35);
		storeWindowFrame.getContentPane().add(lblCoins);
		
		lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacity.setBounds(509, 24, 285, 35);
		storeWindowFrame.getContentPane().add(lblCapacity);
		
		itemsToBuyTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the itemsToBuyTable
		        if (itemsToBuyTable.getSelectedRow() > -1) {
		            // Enable the Buy Item button and disable all other buttons
		        	btnBuyItem.setEnabled(true);
		        	btnSellItem.setEnabled(false);
		        	btnBuyWeapon.setEnabled(false);
		        	btnSellWeapon.setEnabled(false);
		        	
		        	// Clear selection in all other tables
		        	itemsToSellTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		weaponsToBuyTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the weaponsToBuyTable
		        if (weaponsToBuyTable.getSelectedRow() > -1) {
		            // Enable the Buy Weapon button and disable all other buttons
		        	btnBuyWeapon.setEnabled(true);
		        	btnBuyItem.setEnabled(false);
		        	btnSellItem.setEnabled(false);
		        	btnSellWeapon.setEnabled(false);
		        	
		        	// Clear selection in all other tables
		        	itemsToBuyTable.clearSelection();
		        	itemsToSellTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		itemsToSellTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the itemsToSellTable
		        if (itemsToSellTable.getSelectedRow() > -1) {
		            // Enable the Sell Item button and disable all other buttons
		        	btnSellItem.setEnabled(true);
		        	btnBuyWeapon.setEnabled(false);
		        	btnBuyItem.setEnabled(false);
		        	btnSellWeapon.setEnabled(false);
		        	
		        	// Clear selection in all other tables
		        	itemsToBuyTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		weaponsToSellTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the weaponsToSellTable
		        if (weaponsToSellTable.getSelectedRow() > -1) {
		            // Enable the Sell Weapon button and disable all other buttons
		        	btnSellWeapon.setEnabled(true);
		        	btnSellItem.setEnabled(false);
		        	btnBuyWeapon.setEnabled(false);
		        	btnBuyItem.setEnabled(false);
		        	
		        	// Clear selection in all other tables
		        	itemsToBuyTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	itemsToSellTable.clearSelection();
		        }
		    }
		});
		
		btnBuyItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Buy Item")) {
					Item item = itemsToBuyArray.get(itemsToBuyTable.getSelectedRow());
					player.buyItem(item, store.getSalePrice(item));
					itemsToBuyTable.clearSelection();
					btnBuyItem.setEnabled(false);
					lblCoins.setText("Coins: " + player.getCoins());
					lblCapacity.setText("Ship Capacity: " + player.getShipCapacity());
					
					itemsToSellArray.clear();
					// Find all items the player owns and the store will buy
					for (Item i:player.selectedShip.getInventory()) {
						outerLoop:
							if (store.buysItem(i)) {
								for (Item j:itemsToSellArray) {
									if (j.equals(i)) {
										break outerLoop;
									}
								}
								itemsToSellArray.add(i);
							}
					}
					itemsToSellModel.setRowCount(0);
					itemsToSellTable.removeAll();
					// Add items to sell to the table
					for (Item i: itemsToSellArray) {
						Object[] temp = {i.getName(), i.getDescription(), i.getSize(), store.getSalePrice(i)};
						itemsToSellModel.addRow(temp);
					}
				}
			}
		});
		
	}
}
