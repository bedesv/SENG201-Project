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

public class InventoryWindow {

	private JFrame frmInventoryWindow;
	
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
//					window.frmInventoryWindow.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InventoryWindow() {
	
	}
	
	public void close() {
		frmInventoryWindow.setVisible(false);
	}
	
	public void open(Game game) {
		initialize(game);
		frmInventoryWindow.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frmInventoryWindow.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("serial")
	private void initialize(Game game) {
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
		itemsBoughtArray = playersShip.getItemsBought();
		itemsSoldArray = playersShip.getItemsSold();
		weaponsBoughtArray = playersShip.getWeaponsBought();
		weaponsSoldArray = playersShip.getWeaponsSold();
		
		
		weaponsSoldPanel = new JPanel();
		weaponsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsSoldPanel.setBounds(509, 387, 450, 250);
		frmInventoryWindow.getContentPane().add(weaponsSoldPanel);
		
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
		
		DefaultTableModel weaponsSoldModel = new DefaultTableModel(weaponsSoldTableHeader, 0) {
			/**
			 * A method that prevents the editing of the table. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
	    
		weaponsSoldTable = new JTable(weaponsSoldModel);
		weaponsSoldScrollPane.setViewportView(weaponsSoldTable);
		weaponsSoldPanel.setLayout(gl_weaponsSoldPanel);
		
		// Add weapons sold to the table
		for (Weapon weapon: weaponsSoldArray) {
			String location = weapon.getIslandSoldOn().getName();
			Object[] temp = {weapon.getName(), weapon.getPurchasedPrice(), weapon.getSoldPrice(), location};
			weaponsSoldModel.addRow(temp);
		}
		
		weaponsBoughtPanel = new JPanel();
		weaponsBoughtPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Bought", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsBoughtPanel.setBounds(509, 76, 450, 250);
		frmInventoryWindow.getContentPane().add(weaponsBoughtPanel);
		
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
		
		DefaultTableModel weaponsBoughtModel = new DefaultTableModel(weaponsBoughtTableHeader, 0) {
			/**
			 * A method that prevents the editing of the table. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		weaponsBoughtTable = new JTable(weaponsBoughtModel);
		weaponsBoughtScrollPane.setViewportView(weaponsBoughtTable);
		weaponsBoughtPanel.setLayout(gl_weaponsBoughtPanel);
		
		// Add weapons bought to the table
		for (Weapon weapon: weaponsBoughtArray) {
			Object[] temp = {weapon.getName(), weapon.getPrice()};
			weaponsBoughtModel.addRow(temp);
		}
		
		itemsSoldPanel = new JPanel();
		itemsSoldPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Sold", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsSoldPanel.setBounds(24, 387, 450, 250);
		frmInventoryWindow.getContentPane().add(itemsSoldPanel);
		
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
		DefaultTableModel itemsSoldModel = new DefaultTableModel(itemsSoldTableHeader, 0) {
			/**
			 * A method that prevents the editing of the table. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		itemsSoldTable = new JTable(itemsSoldModel);
		itemsSoldScrollPane.setViewportView(itemsSoldTable);
		itemsSoldPanel.setLayout(gl_itemsSoldPanel);
		
		// Add items sold to the table
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
			 * A method that prevents the editing of the table. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
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
		frmInventoryWindow.getContentPane().add(lblCoins);
		
		lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacity.setBounds(509, 30, 285, 35);
		frmInventoryWindow.getContentPane().add(lblCapacity);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(434, 710, 120, 40);
		frmInventoryWindow.getContentPane().add(btnMainMenu);
		
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitInventory();
			}
		});
		
		itemsBoughtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the itemsToBuyTable
		        if (itemsBoughtTable.getSelectedRow() > -1) {
		        	
		        	// Clear selection in all other tables
		        	itemsSoldTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});
		
		weaponsBoughtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the weaponsToBuyTable
		        if (weaponsBoughtTable.getSelectedRow() > -1) {
		        	
		        	// Clear selection in all other tables
		        	itemsBoughtTable.clearSelection();
		        	itemsSoldTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});
		
		itemsSoldTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	// Check if a valid row is selected in the itemsToSellTable
		        if (itemsSoldTable.getSelectedRow() > -1) {
		        	
		        	// Clear selection in all other tables
		        	itemsBoughtTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	weaponsSoldTable.clearSelection();
		        }
		    }
		});
		
		weaponsSoldTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	
		    	// Check if a valid row is selected in the weaponsToSellTable
		        if (weaponsSoldTable.getSelectedRow() > -1) {
		        	
		        	// Clear selection in all other tables
		        	itemsBoughtTable.clearSelection();
		        	weaponsBoughtTable.clearSelection();
		        	itemsSoldTable.clearSelection();
		        }
		    }
		});
		
	}

}
