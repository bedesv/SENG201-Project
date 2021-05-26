package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import backEnd.Weapon;

import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

/**
 * The GUI window for the inventory. 
 * Shows the items and weapons the player has purchased, and 
 * where they sold them, if they've been sold
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 */
public class InventoryWindow {

	private JFrame frmInventoryWindow;
	
	/**
	 * Creates the window object.
	 */
	public InventoryWindow() {
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		openWindow(game);
		frmInventoryWindow.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmInventoryWindow.setVisible(false);
	}

	/**
	 * Initializes the contents of the inventory and displays them in tables
	 * Creates a button to return the main menu
	 * @param game The current game
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("serial")
	private void openWindow(Game game) {
		
		frmInventoryWindow = new JFrame();
		frmInventoryWindow.setBounds(100, 100, 1000, 800);
		frmInventoryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryWindow.getContentPane().setLayout(null);
		frmInventoryWindow.setLocationRelativeTo(null);
		
		Player player = game.getPlayer();
		Ship playersShip = player.getSelectedShip();
		
		frmInventoryWindow.setTitle(playersShip.getName() + " Inventory");
		
		String[] itemsBoughtTableHeader = {"Item", "Purchased For"};
		String[] itemsSoldTableHeader = {"Item", "Purchased For", "Sold For", "Sold At"};
		String[] weaponsBoughtTableHeader = {"Weapon", "Purchased For"};
		String[] weaponsSoldTableHeader = {"Weapon", "Purchased For", "Sold For", "Sold At"};
		
		ArrayList<Item> itemsBoughtArray = playersShip.getItemsBought();
		ArrayList<Item> itemsSoldArray = playersShip.getItemsSold();
		ArrayList<Weapon> weaponsBoughtArray = playersShip.getWeaponsBought();
		ArrayList<Weapon> weaponsSoldArray = playersShip.getWeaponsSold();
		
		JPanel weaponsSoldPanel = new JPanel();
		weaponsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsSoldPanel.setBounds(509, 387, 450, 250);
		frmInventoryWindow.getContentPane().add(weaponsSoldPanel);
		
		JScrollPane weaponsSoldScrollPane = new JScrollPane();
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
		
		DefaultTableModel weaponsSoldModel = new DefaultTableModel(weaponsSoldTableHeader, 0) {
			/**
			 * A method that prevents the editing of the weaponsSoldTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
	    
	    JTable weaponsSoldTable = new JTable(weaponsSoldModel);
		weaponsSoldScrollPane.setViewportView(weaponsSoldTable);
		weaponsSoldPanel.setLayout(gl_weaponsSoldPanel);
		
		for (Weapon weapon: weaponsSoldArray) {
			String location = weapon.getIslandSoldOn().getName();
			Object[] temp = {weapon.getName(), weapon.getPurchasedPrice(), weapon.getSoldPrice(), location};
			weaponsSoldModel.addRow(temp);
		}
		
		JPanel weaponsBoughtPanel = new JPanel();
		weaponsBoughtPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Bought", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsBoughtPanel.setBounds(509, 76, 450, 250);
		frmInventoryWindow.getContentPane().add(weaponsBoughtPanel);
		
		JScrollPane weaponsBoughtScrollPane = new JScrollPane();
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

		DefaultTableModel weaponsBoughtModel = new DefaultTableModel(weaponsBoughtTableHeader, 0) {
			/**
			 * A method that prevents the editing of the weaponsBoughtTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };

	    JTable weaponsBoughtTable = new JTable(weaponsBoughtModel);
		weaponsBoughtScrollPane.setViewportView(weaponsBoughtTable);
		weaponsBoughtPanel.setLayout(gl_weaponsBoughtPanel);

		for (Weapon weapon: weaponsBoughtArray) {
			Object[] temp = {weapon.getName(), weapon.getPrice()};
			weaponsBoughtModel.addRow(temp);
		}
		
		JPanel itemsSoldPanel = new JPanel();
		itemsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsSoldPanel.setBounds(24, 387, 450, 250);
		frmInventoryWindow.getContentPane().add(itemsSoldPanel);

		JScrollPane itemsSoldScrollPane = new JScrollPane();
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

		DefaultTableModel itemsSoldModel = new DefaultTableModel(itemsSoldTableHeader, 0) {
			/**
			 * A method that prevents the editing of the itemsSoldTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };

	    JTable itemsSoldTable = new JTable(itemsSoldModel);
		itemsSoldScrollPane.setViewportView(itemsSoldTable);
		itemsSoldPanel.setLayout(gl_itemsSoldPanel);

		for (Item item: itemsSoldArray) {
			String location = item.getIslandSoldOn().getName();
			Object[] temp = {item.getName(), item.getPurchasedPrice(), item.getSoldPrice(), location};
			itemsSoldModel.addRow(temp);
		}

		JPanel itemsBoughtPanel = new JPanel();
		itemsBoughtPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Bought", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsBoughtPanel.setBounds(24, 76, 450, 250);
		frmInventoryWindow.getContentPane().add(itemsBoughtPanel);

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

		DefaultTableModel itemsBoughtModel = new DefaultTableModel(itemsBoughtTableHeader, 0) {
			/**
			 * A method that prevents the editing of the itemsBoughtTable. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };

	    JTable itemsBoughtTable = new JTable(itemsBoughtModel);
		itemsBoughtScrollPane.setViewportView(itemsBoughtTable);
		itemsBoughtPanel.setLayout(gl_itemsBoughtPanel);

		for (Item item: itemsBoughtArray) {
			Object[] temp = {item.getName(), item.getPrice()};
			itemsBoughtModel.addRow(temp);
		}

		JLabel lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(817, 30, 142, 35);
		frmInventoryWindow.getContentPane().add(lblCoins);

		JLabel lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacity.setBounds(509, 30, 285, 35);
		frmInventoryWindow.getContentPane().add(lblCapacity);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(434, 710, 120, 40);
		frmInventoryWindow.getContentPane().add(btnMainMenu);

		// Return to the main menu on the button click
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitInventory();
			}
		});
		
		/*
		 * Clear selection in other tables if an item is selected in one of them
		 */
		itemsBoughtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (itemsBoughtTable.getSelectedRow() > -1) {
		        	itemsSoldTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});

		weaponsBoughtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (weaponsBoughtTable.getSelectedRow() > -1) {
		        	itemsBoughtTable.clearSelection();
		        	itemsSoldTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});
		
		itemsSoldTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (itemsSoldTable.getSelectedRow() > -1) {
		        	itemsBoughtTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});
		
		weaponsSoldTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (weaponsSoldTable.getSelectedRow() > -1) {
		        	itemsBoughtTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	itemsSoldTable.clearSelection();
		        }
		    }
		});
		
	}

}
