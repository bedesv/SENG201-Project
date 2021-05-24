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
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

public class IslandInformationWindow {

	private JFrame frmIslandInformationWindow;
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
	private JButton btnViewItems;
	private JButton btnViewWeapons;
	private JPanel itemsToBuyPanel;
	private JPanel panelSafeRoute;
	private JPanel panelDangerousRoute;
	private IslandInformationWindow islandInformationWindow = this;
	private DefaultTableModel itemsToBuyModel;
	private DefaultTableModel itemsToSellModel;
	private DefaultTableModel weaponsToBuyModel;
	private DefaultTableModel weaponsToSellModel;
	
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
	private final ButtonGroup buttonGroupIslandRadioButtons = new ButtonGroup();
	private JButton btnMainMenu;
	private JButton btnViewRoutes;
	private JLabel lblSelectedIsland;

	/**
	 * Create the application.
	 */
	public IslandInformationWindow() {
		
	}
	
	public void open(Game game) {
		initialize(game);
		frmIslandInformationWindow.setVisible(true);
	}
	
	public void close() {
		frmIslandInformationWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frmIslandInformationWindow.
	 * @wbp.parser.entryPoint
	 */
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
		
		
		
		weaponsToSellPanel = new JPanel();
		weaponsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToSellPanel.setBounds(624, 341, 450, 250);
		frmIslandInformationWindow.getContentPane().add(weaponsToSellPanel);
		
		weaponsToSellScrollPane = new JScrollPane();
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
		
		weaponsToSellModel = new DefaultTableModel(weaponTableHeaders, 0);
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
		

		
		weaponsToBuyPanel = new JPanel();
		weaponsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToBuyPanel.setBounds(624, 79, 450, 250);
		frmIslandInformationWindow.getContentPane().add(weaponsToBuyPanel);
		
		weaponsToBuyScrollPane = new JScrollPane();
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
		
		weaponsToBuyModel = new DefaultTableModel(weaponTableHeaders, 0);
		weaponsToBuyTable = new JTable(weaponsToBuyModel);
		weaponsToBuyTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		weaponsToBuyScrollPane.setViewportView(weaponsToBuyTable);
		weaponsToBuyPanel.setLayout(gl_weaponsToBuyPanel);
		
		// Set column widths for the weapons to buy table
		weaponsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToBuyPanel.getWidth() - (90 + 35 + 40 + 20));
		weaponsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		

		
		itemsToSellPanel = new JPanel();
		itemsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToSellPanel.setBounds(624, 341, 450, 250);
		frmIslandInformationWindow.getContentPane().add(itemsToSellPanel);
		
		itemsToSellScrollPane = new JScrollPane();
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
		itemsToSellModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToSellTable = new JTable(itemsToSellModel);
		itemsToSellTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemsToSellScrollPane.setViewportView(itemsToSellTable);
		itemsToSellPanel.setLayout(gl_itemsToSellPanel);
		
		// Set column widths for the items to sell table
		itemsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		itemsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToSellTable.getColumnModel().getColumn(1).setPreferredWidth((int)itemsToSellPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		

		
		itemsToBuyPanel = new JPanel();
		itemsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToBuyPanel.setBounds(624, 79, 450, 250);
		frmIslandInformationWindow.getContentPane().add(itemsToBuyPanel);
		
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
		
		itemsToBuyModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToBuyTable = new JTable(itemsToBuyModel);
		itemsToBuyTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemsToBuyScrollPane.setViewportView(itemsToBuyTable);
		itemsToBuyPanel.setLayout(gl_itemsToBuyPanel);
		itemsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
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
		rdbtnRainingArchipelago.setOpaque(false);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		
		JRadioButton rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		buttonGroupIslandRadioButtons.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setOpaque(false);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		
		JRadioButton rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		buttonGroupIslandRadioButtons.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setOpaque(false);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		
		JLabel lblMap = new JLabel("");
		lblMap.setHorizontalTextPosition(SwingConstants.LEFT);
		lblMap.setHorizontalAlignment(SwingConstants.LEFT);
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
		
		btnViewItems = new JButton("View Items To Buy/Sell");
		btnViewItems.setBounds(626, 614, 220, 25);
		frmIslandInformationWindow.getContentPane().add(btnViewItems);
		
		btnViewWeapons = new JButton("View Weapons To Buy/Sell");
		btnViewWeapons.setBounds(854, 614, 220, 25);
		frmIslandInformationWindow.getContentPane().add(btnViewWeapons);
		
		btnMainMenu = new JButton("Main Menu");
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
		
		JRadioButton rdbtnDangerousRoute = new JRadioButton("");
		rdbtnDangerousRoute.setOpaque(false);
		rdbtnDangerousRoute.setBounds(0, 0, 20, 20);
		panelDangerousRouteLegend.add(rdbtnDangerousRoute);
		
		JTextArea textAreaDangerousRoute = new JTextArea();
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
		
		JRadioButton rdbtnSafeRoute = new JRadioButton("");
		rdbtnSafeRoute.setOpaque(false);
		rdbtnSafeRoute.setBounds(0, 0, 20, 20);
		panelSafeRouteLegend.add(rdbtnSafeRoute);
		
		JTextArea textAreaSafeRoute = new JTextArea();
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
		
		itemsToBuyPanel.setVisible(false);
		weaponsToBuyPanel.setVisible(false);
		weaponsToSellPanel.setVisible(false);
		itemsToSellPanel.setVisible(false);
		btnViewItems.setVisible(false);
		btnViewWeapons.setVisible(false);
		btnViewRoutes.setVisible(false);
		panelSafeRoute.setVisible(false);
		panelDangerousRoute.setVisible(false);
		
		// Set column widths for the items to buy table
		itemsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(itemsToBuyPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.exitIslandInformation();
			}
		});

		
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
				islandInformationWindow.expandWindow(island, player);
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
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
				islandInformationWindow.expandWindow(island, player);
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
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
				islandInformationWindow.expandWindow(island, player);
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
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
				islandInformationWindow.expandWindow(island, player);
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
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
				islandInformationWindow.expandWindow(island, player);
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
			}
		}); 
		
		btnViewItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource("/Images/Base Map.png")));
				btnViewItems.setEnabled(false);
				btnViewWeapons.setEnabled(true);
				btnViewRoutes.setEnabled(true);
				itemsToBuyPanel.setVisible(true);
				itemsToSellPanel.setVisible(true);
				weaponsToBuyPanel.setVisible(false);
				weaponsToSellPanel.setVisible(false);
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
				itemsToBuyPanel.setVisible(false);
				itemsToSellPanel.setVisible(false);
				weaponsToBuyPanel.setVisible(true);
				weaponsToSellPanel.setVisible(true);
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
				itemsToBuyPanel.setVisible(false);
				itemsToSellPanel.setVisible(false);
				weaponsToBuyPanel.setVisible(false);
				weaponsToSellPanel.setVisible(false);
				panelSafeRoute.setVisible(true);
				panelDangerousRoute.setVisible(true);
				MapRoute mapRoute = findMapImage(island, player, safeRoute, dangerousRoute);
				String imageString = mapRoute.getImgString();
				safeRoute = mapRoute.getSafeRoute();
				dangerousRoute = mapRoute.getDangerousRoute();
				lblMap.setIcon(new ImageIcon(IslandInformationWindow.class.getResource(imageString)));
				daysToTravel = safeRoute.getDaysToTravel(player.getSelectedShip());
				costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
				textAreaSafeRoute.setText("Route Name:\t" + safeRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + safeRoute.getMultiplier() +"%");
				daysToTravel = dangerousRoute.getDaysToTravel(player.getSelectedShip());
				costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
				textAreaDangerousRoute.setText("Route Name:\t" + dangerousRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + dangerousRoute.getMultiplier() +"%");
				
			
			}
		});
	}
	
	
	private void expandWindow(Island island, Player player) {
		if (!itemsToBuyPanel.isVisible() && !weaponsToSellPanel.isVisible() && !btnViewRoutes.isVisible()) {
			frmIslandInformationWindow.setBounds(100, 100, 1146, 800);
			frmIslandInformationWindow.setLocationRelativeTo(null);
		}
		btnViewItems.setVisible(true);
		btnViewWeapons.setVisible(true);
		if (player.getCurrLocation() == island) {
			btnViewRoutes.setVisible(false);
		} else {
			btnViewRoutes.setVisible(true);
		}
		lblSelectedIsland.setText("Selected Island: " + island.getName());
		
		
		btnViewItems.setEnabled(false);
		btnViewWeapons.setEnabled(true);
		btnViewRoutes.setEnabled(true);
		
		itemsToBuyPanel.setVisible(true);
		itemsToSellPanel.setVisible(true);
		weaponsToBuyPanel.setVisible(false);
		weaponsToSellPanel.setVisible(false);
	}
	
	private void updateItems(Store store) {
		
		itemsToBuyArray = store.getItemsSold();
		itemsToSellArray = store.getItemsBought();
		weaponsToBuyArray = store.getWeaponsSold();
		weaponsToSellArray = store.getWeaponsBought();
		
		itemsToBuyModel.setRowCount(0);
		itemsToSellModel.setRowCount(0);
		weaponsToBuyModel.setRowCount(0);
		weaponsToSellModel.setRowCount(0);
		
		// Add items to buy to the table
		for (Item item: itemsToBuyArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), item.getPrice()};
			itemsToBuyModel.addRow(temp);
		}
		
		// Add items to sell to the table
		for (Item item: itemsToSellArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), store.getSalePrice(item)};
			itemsToSellModel.addRow(temp);
		}
		
		// Add weapons to buy to the table
		for (Weapon weapon: weaponsToBuyArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), weapon.getPrice()};
			weaponsToBuyModel.addRow(temp);
		}
		
		// Add weapons to sell to the table
		for (Weapon weapon: weaponsToSellArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), store.getSalePrice(weapon)};
			weaponsToSellModel.addRow(temp);
		}
	}
	
	private MapRoute findMapImage(Island selectedIsland, Player player, Route safeRoute, Route dangerousRoute) {
		String imageString = "";
		Island currentLocation = player.getCurrLocation();
		ArrayList<Route> routes = currentLocation.getRoutes(selectedIsland);
		
		safeRoute = routes.get(0);
		dangerousRoute = routes.get(1);
		
		switch(routes.get(0).getName()) {
		case "Arid Trail":
			imageString = "/Images/Remote Refuge and Raining Archipelago.png";
			break;
			
		case "Dragonfire Route":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Raining Archipelago.png";
			break;
			
		case "Trepidation Pass":
			imageString = "/Images/Remote Refuge and Brightwich Island.png";
			break;
			
		case "The Glistening Deep":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Brightwich Island.png";
			break;
		
		case "Salfil Waters":
			imageString = "/Images/Remote Refuge and Crosser Peninsula.png";
			break;
			
		case "Terrenronto Waters":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Crosser Peninsula.png";
			break;
			
		case "The Empty Bay":
			imageString = "/Images/Remote Refuge and Arborland Islet.png";
			break;
			
		case "The Bursting Waves":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Arborland Islet.png";
			break;
			
		case "Chillwater Sea":
			imageString = "/Images/Raining Archipelago and Brightwich Island.png";
			break;
			
		case "The Darkest Depths":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Raining Archipelago and Brightwich Island.png";
			break;
			
		case "Cartvons Bay":
			imageString = "/Images/Raining Archipelago and Crosser Peninsula.png";
			break;
			
		case "The Troubled Ocean":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Raining Archipelago and Crosser Peninsula.png";
			break;
			
		case "The Narrow Gulf":
			imageString = "/Images/Arborland Islet and Raining Archipelago.png";
			break;
			
		case "The Ocean of Woodbourg":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Raining Archipelago.png";
			break;
			
		case "The Sunny Domain":
			imageString = "/Images/Brightwich Island and Crosser Peninsula.png";
			break;
			
		case "The Dark Ocean":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Brightwich Island and Crosser Peninsula.png";
			break;
			
		case "The Coral Ocean":
			imageString = "/Images/Arborland Islet and Brightwich Island.png";
			break;
			
		case "The Hungry Depths":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Brightwich Island.png";
			break;
			
		case "The Wasting Bay":
			imageString = "/Images/Arborland Islet and Crosser Peninsula.png";
			break;
			
		case "The Grave Sea":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Crosser Peninsula.png";
			break;

			
		}
		MapRoute result = new MapRoute(imageString, safeRoute, dangerousRoute);
		return result;
	}
}
