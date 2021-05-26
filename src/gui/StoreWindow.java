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

import backEnd.Game;
import backEnd.Item;
import backEnd.Player;
import backEnd.Ship;
import backEnd.Store;
import backEnd.Weapon;
import exceptions.AttackMultiplierTooHighException;
import exceptions.InsufficientCoinsException;
import exceptions.InsufficientInventorySpaceException;
import exceptions.WeaponAlreadyOwnedException;

import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.UIManager;

public class StoreWindow {

	private JFrame frmStoreWindow;
	private JFrame popup;
	
	private JTable itemsToBuyTable;
	private JTable itemsToSellTable;
	private JTable weaponsToBuyTable;
	private JTable weaponsToSellTable;
	
	private JButton btnBuyItem;
	private JButton btnBuyWeapon;
	private JButton btnSellItem;
	private JButton btnSellWeapon;
	
	private JLabel lblCapacity;
	private JLabel lblCoins;
	
	private ArrayList<Item> itemsToBuyArray = new ArrayList<Item>();
	private ArrayList<Item> itemsToSellArray = new ArrayList<Item>();
	private ArrayList<Weapon> weaponsToBuyArray = new ArrayList<Weapon>();
	private ArrayList<Weapon> weaponsToSellArray = new ArrayList<Weapon>();
	
	private boolean purchaseCheck = false;
	
	


	/**
	 * Creates the window object.
	 */
	public StoreWindow() {
		
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		initialize(game);
		frmStoreWindow.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmStoreWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("serial")
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
		
		
		JPanel weaponsToSellPanel = new JPanel();
		weaponsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToSellPanel.setBounds(509, 387, 450, 250);
		frmStoreWindow.getContentPane().add(weaponsToSellPanel);
		
		JScrollPane weaponsToSellScrollPane = new JScrollPane();
		weaponsToSellScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		
		DefaultTableModel weaponsToSellModel = new DefaultTableModel(weaponTableHeaders, 0) {
			/**
			 * A method that prevents the editing of the weaponsToSellTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		weaponsToSellTable = new JTable(weaponsToSellModel);
		weaponsToSellTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		
		JPanel weaponsToBuyPanel = new JPanel();
		weaponsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToBuyPanel.setBounds(509, 76, 450, 250);
		frmStoreWindow.getContentPane().add(weaponsToBuyPanel);
		
		JScrollPane weaponsToBuyScrollPane = new JScrollPane();
		weaponsToBuyScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		
		DefaultTableModel weaponsToBuyModel = new DefaultTableModel(weaponTableHeaders, 0) {
			/**
			 * A method that prevents the editing of the weaponsToBuyTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		weaponsToBuyTable = new JTable(weaponsToBuyModel);
		weaponsToBuyTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		
		JPanel itemsToSellPanel = new JPanel();
		itemsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToSellPanel.setBounds(24, 387, 450, 250);
		frmStoreWindow.getContentPane().add(itemsToSellPanel);
		
		JScrollPane itemsToSellScrollPane = new JScrollPane();
		itemsToSellScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		DefaultTableModel itemsToSellModel = new DefaultTableModel(itemTableHeaders, 0) {
			/**
			 * A method that prevents the editing of the itemsToSellTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
	    
		itemsToSellTable = new JTable(itemsToSellModel);
		itemsToSellTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemsToSellScrollPane.setViewportView(itemsToSellTable);
		itemsToSellPanel.setLayout(gl_itemsToSellPanel);
		
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
		itemsToBuyScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_itemsToBuyPanel = new GroupLayout(itemsToBuyPanel);
		gl_itemsToBuyPanel.setHorizontalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsToBuyPanel.setVerticalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel itemsToBuyModel = new DefaultTableModel(itemTableHeaders, 0) {
			/**
			 * A method that prevents the editing of the itemsToBuyTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		itemsToBuyTable = new JTable(itemsToBuyModel);
		itemsToBuyTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		btnBuyWeapon.setBounds(674, 337, 130, 40);
		btnBuyWeapon.setEnabled(false);
		frmStoreWindow.getContentPane().add(btnBuyWeapon);
		
		// Create a button to sell the selected item
		btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(189, 647, 120, 40);
		btnSellItem.setEnabled(false);
		frmStoreWindow.getContentPane().add(btnSellItem);
		
		// Create a button to sell the selected weapon
		btnSellWeapon = new JButton("Sell Weapon");
		btnSellWeapon.setBounds(674, 648, 130, 40);
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
		
		JTextArea lblWelcomeMessage = new JTextArea("Welcome to the " + store.getStoreName() + ".\nSelect an item or weapon to buy or sell");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomeMessage.setBackground(UIManager.getColor("Button.background"));
		lblWelcomeMessage.setBounds(24, 11, 376, 59);
		frmStoreWindow.getContentPane().add(lblWelcomeMessage);
		
		JButton btnExitStore = new JButton("Exit Store");
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
				
				purchaseCheck = false;
				
				try {
					purchaseCheck = player.checkItemPurchase(item, store.getPurchasePrice(item));
					
				} catch (InsufficientCoinsException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to buy a(n) " + item.getName() + ". Sell some items or weapons to get more");
					
				} catch (InsufficientInventorySpaceException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough inventory space to buy a(n) " + item.getName() + ". Sell some items or weapons to free some up");
				}
				
				if (purchaseCheck) {
					player.buyItem(item, store.getPurchasePrice(item));
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
				
				
				purchaseCheck = false;
				
				try {
					purchaseCheck = player.checkWeaponPurchase(weapon, store.getPurchasePrice(weapon));
					
				} catch (InsufficientCoinsException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough coins to buy a(n) " + weapon.getName() + ". Sell some items or weapons to get more");
					
				} catch (InsufficientInventorySpaceException e) {
					JOptionPane.showMessageDialog(popup, "Error: You don't have enough inventory space to buy a(n) " + weapon.getName() + ". Sell some items or weapons to free some up");
				} catch (AttackMultiplierTooHighException e) {
					JOptionPane.showMessageDialog(popup, "Error: Your attack multiplier is too high to purchase " + weapon.getName() + ". Current: " + player.getAttackMultiplier() + ". Max: 30.");
				} catch (WeaponAlreadyOwnedException e) {
					JOptionPane.showMessageDialog(popup, "Error: You already own " + weapon.getName() + ". You can only have one of each weapon.");
				}
				
				if (purchaseCheck) {
					player.buyWeapon(weapon, store.getPurchasePrice(weapon));
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
				
				int selectedRow = itemsToSellTable.getSelectedRow();
				// Fetch the selected item from the table of items to sell
				Item item = itemsToSellArray.get(itemsToSellTable.getSelectedRow());
		
				player.sellItem(item, store.getSalePrice(item));
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
				if (!(selectedRow >= itemsToSellTable.getRowCount())) {
					itemsToSellTable.setRowSelectionInterval(selectedRow, selectedRow);
				} else {
					btnSellItem.setEnabled(false);
				}
			}
		});
		
		btnSellWeapon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = weaponsToSellTable.getSelectedRow();
				// Fetch the selected weapon from the table of weapons to sell
				Weapon weapon = weaponsToSellArray.get(weaponsToSellTable.getSelectedRow());
					
				player.sellWeapon(weapon, store.getSalePrice(weapon));
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
				if (!(selectedRow >= weaponsToSellTable.getRowCount())) {
					weaponsToSellTable.setRowSelectionInterval(selectedRow, selectedRow);
				} else {
					btnSellWeapon.setEnabled(false);
				}

			}
		});
		
	}
	
}
