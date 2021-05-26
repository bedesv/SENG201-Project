package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import backEnd.Game;
import backEnd.Island;
import backEnd.Item;
import backEnd.MapRoute;
import backEnd.Player;
import backEnd.Route;
import backEnd.Store;
import backEnd.Weapon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

/**
 * The GUI window for the island information. 
 * Shows the items and weapons available to buy and sell 
 * on other islands and the routes to other islands
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 */
public class IslandInformationWindow {

	private IslandInformationWindow islandInformationWindow = this;
	private JFrame frmIslandInformationWindow;
	
	private JTable itemsToBuyTable;
	private JTable itemsToSellTable;
	private JTable weaponsToBuyTable;
	private JTable weaponsToSellTable;
	
	private JPanel panelItemsToBuy;
	private JPanel panelItemsToSell;
	private JPanel panelWeaponsToBuy;
	private JPanel panelWeaponsToSell;
	private JPanel panelSafeRoute;
	private JPanel panelDangerousRoute;
	
	private JButton btnViewItems;
	private JButton btnViewWeapons;
	private JButton btnViewRoutes;
	
	private final ButtonGroup buttonGroupIslandRadioButtons = new ButtonGroup();
	
	private DefaultTableModel itemsToBuyModel;
	private DefaultTableModel itemsToSellModel;
	private DefaultTableModel weaponsToBuyModel;
	private DefaultTableModel weaponsToSellModel;
	
	private JTextArea textAreaDangerousRoute;
	private JTextArea textAreaSafeRoute;
	
	private JLabel lblMap;
	private JLabel lblSelectedIsland;
	
	private Store store;
	private Island island;
	private Route safeRoute;
	private Route dangerousRoute;
	
	private int daysToTravel;
	private int costToTravel;
	
	private ArrayList<Item> itemsToBuyArray = new ArrayList<Item>();
	private ArrayList<Item> itemsToSellArray = new ArrayList<Item>();
	private ArrayList<Weapon> weaponsToBuyArray = new ArrayList<Weapon>();
	private ArrayList<Weapon> weaponsToSellArray = new ArrayList<Weapon>();

	/**
	 * Creates the window object.
	 */
	public IslandInformationWindow() {
		
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		initialize(game);
		frmIslandInformationWindow.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmIslandInformationWindow.setVisible(false);
	}

	/**
	 * Initializes the contents of the island information window.
	 * Prompts the player to select an island to view information about it
	 * Creates lists of the items available to buy and sell at the selected island and displays them in tables
	 * The items available to buy and sell are shown by default but when the player selects a new island,
	 * the screen they had displayed previously is updated to the new islands details
	 * Finds the routes the player can use to get to the selected island from their current location
	 * and changes the map to show these
	 * @param game The current game
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("serial")
	private void initialize(Game game) {
		frmIslandInformationWindow = new JFrame();
		frmIslandInformationWindow.setBounds(100, 100, 625, 800);
		frmIslandInformationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIslandInformationWindow.getContentPane().setLayout(null);
		frmIslandInformationWindow.setLocationRelativeTo(null);
		
		Player player = game.getPlayer();
		ArrayList<Island> islands = game.getIslands();
		store = new Store();
		island = new Island();
		
		String[] itemTableHeaders = {"Item", "Description", "Size", "Price"};
		String[] weaponTableHeaders = {"Weapon", "Description", "Size", "Price"};
		
		panelWeaponsToSell = new JPanel();
		panelWeaponsToSell.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelWeaponsToSell.setBounds(624, 341, 450, 250);
		frmIslandInformationWindow.getContentPane().add(panelWeaponsToSell);
		
		JScrollPane weaponsToSellScrollPane = new JScrollPane();
		weaponsToSellScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_weaponsToSellPanel = new GroupLayout(panelWeaponsToSell);
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
		
		weaponsToSellModel = new DefaultTableModel(weaponTableHeaders, 0) {
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
		panelWeaponsToSell.setLayout(gl_weaponsToSellPanel);
		
		weaponsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsToSellTable.getColumnModel().getColumn(1).setPreferredWidth(panelWeaponsToSell.getWidth() - (90 + 35 + 40 + 15));
		weaponsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		panelWeaponsToBuy = new JPanel();
		panelWeaponsToBuy.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelWeaponsToBuy.setBounds(624, 79, 450, 250);
		frmIslandInformationWindow.getContentPane().add(panelWeaponsToBuy);
		
		JScrollPane weaponsToBuyScrollPane = new JScrollPane();
		weaponsToBuyScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_weaponsToBuyPanel = new GroupLayout(panelWeaponsToBuy);
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
		
		weaponsToBuyModel = new DefaultTableModel(weaponTableHeaders, 0) {
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
		panelWeaponsToBuy.setLayout(gl_weaponsToBuyPanel);
		
		weaponsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(panelWeaponsToBuy.getWidth() - (90 + 35 + 40 + 20));
		weaponsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		panelItemsToSell = new JPanel();
		panelItemsToSell.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelItemsToSell.setBounds(624, 341, 450, 250);
		frmIslandInformationWindow.getContentPane().add(panelItemsToSell);
		
		JScrollPane itemsToSellScrollPane = new JScrollPane();
		itemsToSellScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_itemsToSellPanel = new GroupLayout(panelItemsToSell);
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
		
		itemsToSellModel = new DefaultTableModel(itemTableHeaders, 0) {
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
		panelItemsToSell.setLayout(gl_itemsToSellPanel);
		
		itemsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		itemsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToSellTable.getColumnModel().getColumn(1).setPreferredWidth((int)panelItemsToSell.getWidth() - (50 + 35 + 40 + 15));
		itemsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		panelItemsToBuy = new JPanel();
		panelItemsToBuy.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelItemsToBuy.setBounds(624, 79, 450, 250);
		frmIslandInformationWindow.getContentPane().add(panelItemsToBuy);
		
		JScrollPane itemsToBuyScrollPane = new JScrollPane();
		itemsToBuyScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_itemsToBuyPanel = new GroupLayout(panelItemsToBuy);
		gl_itemsToBuyPanel.setHorizontalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		
		gl_itemsToBuyPanel.setVerticalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		itemsToBuyModel = new DefaultTableModel(itemTableHeaders, 0) {
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
		panelItemsToBuy.setLayout(gl_itemsToBuyPanel);
		itemsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
		itemsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(panelItemsToBuy.getWidth() - (50 + 35 + 40 + 15));
		itemsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		JPanel panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(12, 48, 600, 633);
		frmIslandInformationWindow.getContentPane().add(panelSelectIsland);
		
		JLabel lblChooseIslandText = new JLabel("Select an island to view information about it");
		lblChooseIslandText.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseIslandText.setFont(new Font("Dialog", Font.BOLD, 15));
		lblChooseIslandText.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseIslandText);
		
		JPanel panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 33, 605, 600);
		panelSelectIsland.add(panelMap);
		
		JRadioButton rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		buttonGroupIslandRadioButtons.add(rdbtnArborlandIslet);
		rdbtnArborlandIslet.setToolTipText("Items are cheap here");
		rdbtnArborlandIslet.setOpaque(false);
		rdbtnArborlandIslet.setForeground(Color.WHITE);
		rdbtnArborlandIslet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnArborlandIslet.setBounds(124, 395, 125, 23);
		panelMap.add(rdbtnArborlandIslet);
		
		JRadioButton rdbtnCrosserPeninsula = new JRadioButton("Crosser Peninsula");
		buttonGroupIslandRadioButtons.add(rdbtnCrosserPeninsula);
		rdbtnCrosserPeninsula.setToolTipText("Items are expensive here");
		rdbtnCrosserPeninsula.setOpaque(false);
		rdbtnCrosserPeninsula.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCrosserPeninsula.setForeground(Color.WHITE);
		rdbtnCrosserPeninsula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCrosserPeninsula.setBounds(473, 570, 144, 23);
		panelMap.add(rdbtnCrosserPeninsula);
		
		JRadioButton rdbtnRainingArchipelago = new JRadioButton("Raining Archipelago");
		buttonGroupIslandRadioButtons.add(rdbtnRainingArchipelago);
		rdbtnRainingArchipelago.setToolTipText("Items are reasonably priced here");
		rdbtnRainingArchipelago.setOpaque(false);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		
		JRadioButton rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		buttonGroupIslandRadioButtons.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setToolTipText("Items are cheapest here");
		rdbtnRemoteRefuge.setOpaque(false);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		
		JRadioButton rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		buttonGroupIslandRadioButtons.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setToolTipText("Items are most expensive here");
		rdbtnBrightwichIsland.setOpaque(false);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		
		lblMap = new JLabel("");
		lblMap.setHorizontalTextPosition(SwingConstants.LEFT);
		lblMap.setHorizontalAlignment(SwingConstants.LEFT);
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
		
		// Create buttons
		btnViewItems = new JButton("View Items To Buy/Sell");
		btnViewItems.setBounds(626, 614, 220, 25);
		frmIslandInformationWindow.getContentPane().add(btnViewItems);
		
		btnViewWeapons = new JButton("View Weapons To Buy/Sell");
		btnViewWeapons.setBounds(854, 614, 220, 25);
		frmIslandInformationWindow.getContentPane().add(btnViewWeapons);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(182, 693, 241, 52);
		frmIslandInformationWindow.getContentPane().add(btnMainMenu);
		
		btnViewRoutes = new JButton("View Routes to the Selected Island");
		btnViewRoutes.setBounds(711, 651, 291, 25);
		frmIslandInformationWindow.getContentPane().add(btnViewRoutes);
		
		panelDangerousRoute = new JPanel();
		panelDangerousRoute.setBounds(632, 86, 269, 79);
		frmIslandInformationWindow.getContentPane().add(panelDangerousRoute);
		panelDangerousRoute.setLayout(null);
		
		JPanel panelDangerousRouteLegend = new JPanel();
		panelDangerousRouteLegend.setLayout(null);
		panelDangerousRouteLegend.setBackground(Color.RED);
		panelDangerousRouteLegend.setBounds(0, 3, 20, 20);
		panelDangerousRoute.add(panelDangerousRouteLegend);
		
		textAreaDangerousRoute = new JTextArea();
		textAreaDangerousRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDangerousRoute.setEditable(false);
		textAreaDangerousRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaDangerousRoute.setBounds(26, 0, 243, 79);
		panelDangerousRoute.add(textAreaDangerousRoute);
		
		panelSafeRoute = new JPanel();
		panelSafeRoute.setBounds(632, 199, 269, 85);
		frmIslandInformationWindow.getContentPane().add(panelSafeRoute);
		panelSafeRoute.setLayout(null);
		
		JPanel panelSafeRouteLegend = new JPanel();
		panelSafeRouteLegend.setLayout(null);
		panelSafeRouteLegend.setBackground(new Color(0, 100, 0));
		panelSafeRouteLegend.setBounds(0, 3, 20, 20);
		panelSafeRoute.add(panelSafeRouteLegend);
		
		textAreaSafeRoute = new JTextArea();
		textAreaSafeRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaSafeRoute.setEditable(false);
		textAreaSafeRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaSafeRoute.setBounds(26, 0, 243, 85);
		panelSafeRoute.add(textAreaSafeRoute);
		
		JLabel lblCurrLocation = new JLabel("Current Location: " + player.getCurrLocation().getName());
		lblCurrLocation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrLocation.setBounds(12, 12, 600, 31);
		frmIslandInformationWindow.getContentPane().add(lblCurrLocation);
		
		lblSelectedIsland = new JLabel("");
		lblSelectedIsland.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectedIsland.setBounds(632, 12, 490, 31);
		frmIslandInformationWindow.getContentPane().add(lblSelectedIsland);
		
		// Sets all the panels and buttons to invisible initially
		panelItemsToBuy.setVisible(false);
		panelWeaponsToBuy.setVisible(false);
		panelWeaponsToSell.setVisible(false);
		panelItemsToSell.setVisible(false);
		panelSafeRoute.setVisible(false);
		panelDangerousRoute.setVisible(false);
		
		btnViewItems.setVisible(false);
		btnViewWeapons.setVisible(false);
		btnViewRoutes.setVisible(false);
		
		// Return to the main menu on the button click
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.exitIslandInformation();
			}
		});

		/*
		 * Radio button selected events that set the island variable to the correct island 
		 * and updates the window with the relevant information
		 */
		rdbtnArborlandIslet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Arborland Islet") {
						island = i;
					}
				}
				store = island.getStore();
				islandInformationWindow.updateItems(store);
				islandInformationWindow.updateWindow(player, island);
			}
		}); 
		
		rdbtnRemoteRefuge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Remote Refuge") {
						island = i;
					}
				}
				store = island.getStore();
				islandInformationWindow.updateItems(store);
				islandInformationWindow.updateWindow(player, island);
			}
		}); 
		
		rdbtnBrightwichIsland.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Brightwich Island") {
						island = i;
					}
				}
				store = island.getStore();
				islandInformationWindow.updateItems(store);
				islandInformationWindow.updateWindow(player, island);
			}
		}); 
		
		rdbtnRainingArchipelago.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Raining Archipelago") {
						island = i;
					}
				}
				store = island.getStore();
				islandInformationWindow.updateItems(store);
				islandInformationWindow.updateWindow(player, island);
			}
		}); 
		
		rdbtnCrosserPeninsula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Crosser Peninsula") {
						island = i;
					}
				}
				store = island.getStore();
				islandInformationWindow.updateItems(store);
				islandInformationWindow.updateWindow(player, island);
			}
		}); 
		
		/*
		 * Button clicked events to update the window with the relevant information
		 */
		btnViewItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
				btnViewItems.setEnabled(false);
				btnViewWeapons.setEnabled(true);
				btnViewRoutes.setEnabled(true);
				panelItemsToBuy.setVisible(true);
				panelItemsToSell.setVisible(true);
				panelWeaponsToBuy.setVisible(false);
				panelWeaponsToSell.setVisible(false);
				panelSafeRoute.setVisible(false);
				panelDangerousRoute.setVisible(false);
			}
		});
		
		btnViewWeapons.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
				btnViewItems.setEnabled(true);
				btnViewWeapons.setEnabled(false);
				btnViewRoutes.setEnabled(true);
				panelItemsToBuy.setVisible(false);
				panelItemsToSell.setVisible(false);
				panelWeaponsToBuy.setVisible(true);
				panelWeaponsToSell.setVisible(true);
				panelSafeRoute.setVisible(false);
				panelDangerousRoute.setVisible(false);
			}
		});
		
		btnViewRoutes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnViewItems.setEnabled(true);
				btnViewWeapons.setEnabled(true);
				btnViewRoutes.setEnabled(false);
				panelItemsToBuy.setVisible(false);
				panelItemsToSell.setVisible(false);
				panelWeaponsToBuy.setVisible(false);
				panelWeaponsToSell.setVisible(false);
				panelSafeRoute.setVisible(true);
				panelDangerousRoute.setVisible(true);
				updateRoutes(player, island);
			}
		});
		
		/*
		 * Clear selection in other tables if an item is selected in one of them
		 */
		itemsToBuyTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (itemsToBuyTable.getSelectedRow() > -1) {
		        	itemsToSellTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		weaponsToBuyTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (weaponsToBuyTable.getSelectedRow() > -1) {
		        	itemsToBuyTable.clearSelection();
		        	itemsToSellTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		itemsToSellTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (itemsToSellTable.getSelectedRow() > -1) {
		        	itemsToBuyTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	weaponsToSellTable.clearSelection();
		        }
		    }
		});
		
		weaponsToSellTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (weaponsToSellTable.getSelectedRow() > -1) {
		        	itemsToBuyTable.clearSelection();
		        	weaponsToBuyTable.clearSelection();
		        	itemsToSellTable.clearSelection();
		        }
		    }
		});
	}
	
	/**
	 * Updates the window to show information relevant to the selected island
	 * @param player The current player of the game
	 * @param island The selected island 
	 */
	private void updateWindow(Player player, Island island) {
		if (!panelItemsToBuy.isVisible() && !panelWeaponsToSell.isVisible() && !btnViewRoutes.isVisible()) {
			frmIslandInformationWindow.setBounds(100, 100, 1085, 800);
			frmIslandInformationWindow.setLocationRelativeTo(null);
			panelItemsToBuy.setVisible(true);
			panelItemsToSell.setVisible(true);
			btnViewItems.setEnabled(false);
			
		} else if (player.getCurrLocation() == island) {
			if (panelSafeRoute.isVisible()) {
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
				btnViewRoutes.setVisible(false);
				btnViewItems.setEnabled(false);
				btnViewWeapons.setEnabled(true);
				panelItemsToBuy.setVisible(true);
				panelItemsToSell.setVisible(true);
				panelWeaponsToBuy.setVisible(false);
				panelWeaponsToSell.setVisible(false);
			}
			btnViewRoutes.setVisible(false);
			panelSafeRoute.setVisible(false);
			panelDangerousRoute.setVisible(false);
			
		} else if (panelSafeRoute.isVisible()) {
			updateRoutes(player, island);
			
		} else {
			btnViewRoutes.setEnabled(true);
		}
		
		btnViewItems.setVisible(true);
		btnViewWeapons.setVisible(true);
		if (player.getCurrLocation() == island) {
			btnViewRoutes.setVisible(false);
		} else {
			btnViewRoutes.setVisible(true);
		}
		
		updateItems(island.getStore());
		
		lblSelectedIsland.setText("Selected Island: " + island.getName());
	}
	
	/**
	 * Updates the item and weapon tables to display the items available at the newly selected island
	 * @param store The store on the selected island
	 */
	private void updateItems(Store store) {
		itemsToBuyArray = store.getItemsSold();
		itemsToSellArray = store.getItemsBought();
		weaponsToBuyArray = store.getWeaponsSold();
		weaponsToSellArray = store.getWeaponsBought();
		
		itemsToBuyModel.setRowCount(0);
		itemsToSellModel.setRowCount(0);
		weaponsToBuyModel.setRowCount(0);
		weaponsToSellModel.setRowCount(0);
		
		for (Item item: itemsToBuyArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), item.getPrice()};
			itemsToBuyModel.addRow(temp);
		}
		
		for (Item item: itemsToSellArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), store.getSalePrice(item)};
			itemsToSellModel.addRow(temp);
		}
		
		for (Weapon weapon: weaponsToBuyArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), weapon.getPrice()};
			weaponsToBuyModel.addRow(temp);
		}
		
		for (Weapon weapon: weaponsToSellArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), store.getSalePrice(weapon)};
			weaponsToSellModel.addRow(temp);
		}
	}
	
	/**
	 * Updates the routes with the routes to the currently selected island and displays the relevant map image
	 * @param player The current player of the game
	 * @param island The selected island 
	 */
	private void updateRoutes(Player player, Island island) {
		MapRoute mapRoute = new MapRoute();
		mapRoute.findMapImage(island, player, safeRoute, dangerousRoute);
		String imageString = mapRoute.getImgString();
		lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource(imageString)));
		safeRoute = mapRoute.getSafeRoute();
		dangerousRoute = mapRoute.getDangerousRoute();
		daysToTravel = safeRoute.getDaysToTravel(player.getSelectedShip());
		costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
		textAreaSafeRoute.setText("Route Name:\t" + safeRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + safeRoute.getMultiplier() +"%");
		daysToTravel = dangerousRoute.getDaysToTravel(player.getSelectedShip());
		costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
		textAreaDangerousRoute.setText("Route Name:\t" + dangerousRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + dangerousRoute.getMultiplier() +"%");
	}
}
