package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class StoreWindow {

	private JFrame frmStoreWindow;
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
	private JButton btnExitStore;
	private JLabel lblCapacity;
	private JLabel lblCoins;
	private JTextArea lblWelcomeMessage;
	private JFrame popup;
	
	private ArrayList<Item> itemsToBuyArray = new ArrayList<Item>();
	private ArrayList<Item> itemsToSellArray = new ArrayList<Item>();
	
	private ArrayList<Weapon> weaponsToBuyArray = new ArrayList<Weapon>();
	private ArrayList<Weapon> weaponsToSellArray = new ArrayList<Weapon>();
	private StoreWindow storeWindow = this;
	
	private boolean purchaseSuccess = false;
	private boolean saleSuccess = false;
	
	


	/**
	 * Create the application.
	 */
	public StoreWindow() {
		
	}
	
	public void open(Game game) {
		initialize(game);
		frmStoreWindow.setVisible(true);
	}
	
	public void close() {
		frmStoreWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		frmStoreWindow = new JFrame();
		frmStoreWindow.setBounds(100, 100, 1000, 800);
		frmStoreWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreWindow.getContentPane().setLayout(null);
		frmStoreWindow.setLocationRelativeTo(null);
		
		Player player = game.getPlayer();
		Ship playersShip = player.getSelectedShip();
		Store store = playersShip.getLocation().getStore();
		
		frmStoreWindow.setTitle(store.getStoreName());
		
		String[] itemTableHeaders = {"Item", "Description", "Size", "Price"};
		String[] weaponTableHeaders = {"Weapon", "Description", "Size", "Price"};
		itemsToBuyArray = store.getItemsSold();
		itemsToSellArray = store.getItemsPlayerCanSell(playersShip);
		weaponsToBuyArray = store.getWeaponsSold();
		weaponsToSellArray = store.getWeaponsPlayerCanSell(playersShip);
		
		
		weaponsToSellPanel = new JPanel();
		weaponsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToSellPanel.setBounds(509, 387, 450, 250);
		frmStoreWindow.getContentPane().add(weaponsToSellPanel);
		
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
		weaponsToSellTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToSellPanel.getWidth() - (90 + 35 + 40 + 15));
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
		frmStoreWindow.getContentPane().add(weaponsToBuyPanel);
		
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
		frmStoreWindow.getContentPane().add(itemsToSellPanel);
		
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
		frmStoreWindow.getContentPane().add(itemsToBuyPanel);
		
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
		frmStoreWindow.getContentPane().add(btnBuyItem);
		
		// Create a button to buy the selected weapon
		btnBuyWeapon = new JButton("Buy Weapon");
		btnBuyWeapon.setBounds(674, 337, 120, 40);
		btnBuyWeapon.setEnabled(false);
		frmStoreWindow.getContentPane().add(btnBuyWeapon);
		
		// Create a button to sell the selected item
		btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(189, 647, 120, 40);
		btnSellItem.setEnabled(false);
		frmStoreWindow.getContentPane().add(btnSellItem);
		
		// Create a button to sell the selected weapon
		btnSellWeapon = new JButton("Sell Weapon");
		btnSellWeapon.setBounds(674, 648, 120, 40);
		btnSellWeapon.setEnabled(false);
		frmStoreWindow.getContentPane().add(btnSellWeapon);
		
		lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 30, 142, 35);
		frmStoreWindow.getContentPane().add(lblCoins);
		
		lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacity.setBounds(509, 30, 285, 35);
		frmStoreWindow.getContentPane().add(lblCapacity);
		
		lblWelcomeMessage = new JTextArea("Welcome to the " + store.getStoreName() + ".\nSelect an item or weapon to buy or sell");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomeMessage.setBackground(SystemColor.control);
		lblWelcomeMessage.setBounds(24, 11, 376, 59);
		frmStoreWindow.getContentPane().add(lblWelcomeMessage);
		
		btnExitStore = new JButton("Exit Store");
		btnExitStore.setBounds(434, 710, 120, 40);
		frmStoreWindow.getContentPane().add(btnExitStore);
		
		btnExitStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.exitStore();
			}
		});
		
		
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
			public void actionPerformed(ActionEvent f) {
				
				// Fetch the selected item from the table of items to buy
				Item item = itemsToBuyArray.get(itemsToBuyTable.getSelectedRow());
				
				// Clear the selection  in the table of items to buy and disable the sell weapon button
				itemsToBuyTable.clearSelection();
				btnBuyItem.setEnabled(false);
				
				try {
					purchaseSuccess = player.buyItem(item, store.getPurchasePrice(item), storeWindow);
					
				} catch (InsufficientCoinsException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to buy a(n) " + item.getName() + ". Sell some items or weapons to get more");
					
				} catch (InsufficientInventorySpaceException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough inventory space to buy a(n) " + item.getName() + ". Sell some items or weapons to free some up");
				}
				
				if (purchaseSuccess) {
					// Update the coins and capacity labels
					lblCoins.setText("Coins: " + player.getCoins());
					lblCapacity.setText("Ship Capacity: " + player.getShipCapacity());
					
					// Update the array of items the player can sell
					itemsToSellArray = store.getItemsPlayerCanSell(playersShip);
					
					// Clear all items from the table of items to sell
					itemsToSellModel.setRowCount(0);
					itemsToSellTable.removeAll();
					
					// Add the items the player can sell to the table of items to sell
					for (Item i: itemsToSellArray) {
						Object[] temp = {i.getName(), i.getDescription(), i.getSize(), store.getSalePrice(i)};
						itemsToSellModel.addRow(temp);
					}
				}
			}
		});
		
		btnBuyWeapon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent d) {
				
				// Fetch the selected weapon from the table of weapons to buy
				Weapon weapon = weaponsToBuyArray.get(weaponsToBuyTable.getSelectedRow());
				
				// Clear the selection in the table of weapons to buy and disable the buy weapon button
				weaponsToBuyTable.clearSelection();
				btnBuyWeapon.setEnabled(false);
				
				try {
					purchaseSuccess = player.buyWeapon(weapon, store.getPurchasePrice(weapon), storeWindow);
					
				} catch (InsufficientCoinsException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to buy a(n) " + weapon.getName() + ". Sell some items or weapons to get more");
					
				} catch (InsufficientInventorySpaceException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough inventory space to buy a(n) " + weapon.getName() + ". Sell some items or weapons to free some up");
				}
				
				if (purchaseSuccess) {
					// Update the coins and capacity labels
					lblCoins.setText("Coins: " + player.getCoins());
					lblCapacity.setText("Ship Capacity: " + player.getShipCapacity());
					
					// Update the array of weapons the player can sell
					weaponsToSellArray = store.getWeaponsPlayerCanSell(playersShip);
					
					// Clear all weapons from the table of weapons to sell
					weaponsToSellModel.setRowCount(0);
					weaponsToSellTable.removeAll();
					
					// Add the weapons the player can sell to the table of weapons to sell
					for (Weapon w: weaponsToSellArray) {
						Object[] temp = {w.getName(), w.getDescription(), w.getSize(), store.getSalePrice(w)};
						weaponsToSellModel.addRow(temp);
					}
				}
			}
		});
		
		btnSellItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Fetch the selected item from the table of items to sell
				Item item = itemsToSellArray.get(itemsToSellTable.getSelectedRow());
				
				// Clear the selection in the table of items to sell and disable the sell item button
				itemsToSellTable.clearSelection();
				btnSellItem.setEnabled(false);
				

					
				// Sell the selected item
				saleSuccess = player.sellItem(item, store.getSalePrice(item), storeWindow);
				
				if (saleSuccess) {
					
					// Update the coins and capacity labels
					lblCoins.setText("Coins: " + player.getCoins());
					lblCapacity.setText("Ship Capacity: " + player.getShipCapacity());
					
					// Update the array of items the player can sell
					itemsToSellArray = store.getItemsPlayerCanSell(playersShip);
					
					// Clear all items from the table of items to sell
					itemsToSellModel.setRowCount(0);
					itemsToSellTable.removeAll();
					
					// Add the items the player can sell to the table of items to sell
					for (Item i: itemsToSellArray) {
						Object[] temp = {i.getName(), i.getDescription(), i.getSize(), store.getSalePrice(i)};
						itemsToSellModel.addRow(temp);
					}
				}
			}
		});
		
		btnSellWeapon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Fetch the selected weapon from the table of weapons to sell
				Weapon weapon = weaponsToSellArray.get(weaponsToSellTable.getSelectedRow());
				
				// Clear the selection in the table of weapons to sell and disable the sell weapon button
				weaponsToSellTable.clearSelection();
				btnSellWeapon.setEnabled(false);
				
					
				// Sell the selected weapon
				saleSuccess = player.sellWeapon(weapon, store.getSalePrice(weapon), storeWindow);
				
				if (saleSuccess) {
					
					// Update the coins and capacity labels
					lblCoins.setText("Coins: " + player.getCoins());
					lblCapacity.setText("Ship Capacity: " + player.getShipCapacity());
					
					// Update the array of weapons the player can sell
					weaponsToSellArray = store.getWeaponsPlayerCanSell(playersShip);
					
					// Clear all weapons from the table of weapons to sell
					weaponsToSellModel.setRowCount(0);
					weaponsToSellTable.removeAll();
					
					// Add the weapons the player can sell to the table of weapons to sell
					for (Weapon w: weaponsToSellArray) {
						Object[] temp = {w.getName(), w.getDescription(), w.getSize(), store.getSalePrice(w)};
						weaponsToSellModel.addRow(temp);
					}
				}
			}
		});
		
	}
	
	public boolean confirmPurchase(Item item, int price) {
		int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to buy" + " a(n) " + item.getName() + " for " + price + " coins?", "Purchase Confirmation",JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean confirmSale(Item item, int price) {
		int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to sell" + " a(n) " + item.getName() + " for " + price + " coins?", "Sale Confirmation",JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
}
