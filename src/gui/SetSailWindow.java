package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import backEnd.EventInfo;
import backEnd.Game;
import backEnd.Island;
import backEnd.MapRoute;
import backEnd.Player;
import backEnd.Route;
import exceptions.InsufficientCoinsException;
import exceptions.InsufficientDaysException;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

/**
 * The GUI window for setting sail. 
 * Shows the islands the player can sail to and then the routes they can use
 * The player must select a destination and a route before setting sail
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 */
public class SetSailWindow {
	
	private SetSailWindow setSailWindow = this;
	
	private JFrame frmSetSail;
	private JFrame popup;
	
	private JLabel lblMap;
	private JLabel lblSelectedIsland;
	
	private JPanel panelSafeRoute;
	private JPanel panelDangerousRoute;
	
	private JTextArea textAreaDangerousRoute;
	private JTextArea textAreaSafeRoute;
	
	private JButton btnSetSail;
	
	private final ButtonGroup islandButtonGroup = new ButtonGroup();
	private final ButtonGroup routeButtonGroup = new ButtonGroup();
	
	private Island island;
	private Route safeRoute;
	private Route dangerousRoute;
	
	private int daysToTravel;
	private int costToTravel;
	
	
	/**
	 * Creates the window object.
	 */
	public SetSailWindow() {
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		initialize(game);
		frmSetSail.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmSetSail.setVisible(false);
	}

	/**
	 * Initialize the set sail window
	 * Shows the islands the player can sail to
	 * Shows the routes the player can use once an island is selected
	 * Allows the player to set sail once a destination and route have been selected
	 * @param game The current game
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		String currentLocation = player.getSelectedShip().getLocation().getName();
		ArrayList<Island> islands = game.getIslands();
		frmSetSail = new JFrame();
		frmSetSail.setTitle("Select Destination");
		frmSetSail.setBounds(100, 100, 625, 800);
		frmSetSail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetSail.getContentPane().setLayout(null);
		frmSetSail.setLocationRelativeTo(null);
		
		JPanel panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(5, 73, 600, 633);
		frmSetSail.getContentPane().add(panelSelectIsland);
		
		JPanel panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		
		panelDangerousRoute = new JPanel();
		panelDangerousRoute.setBounds(710, 105, 235, 79);
		frmSetSail.getContentPane().add(panelDangerousRoute);
		panelDangerousRoute.setLayout(null);
		
		panelSafeRoute = new JPanel();
		panelSafeRoute.setBounds(710, 218, 235, 85);
		frmSetSail.getContentPane().add(panelSafeRoute);
		panelSafeRoute.setLayout(null);
		
		JPanel panelDangerousRouteLegend = new JPanel();
		panelDangerousRouteLegend.setLayout(null);
		panelDangerousRouteLegend.setBackground(Color.RED);
		panelDangerousRouteLegend.setBounds(0, 3, 20, 20);
		panelDangerousRoute.add(panelDangerousRouteLegend);
		
		JPanel panelSafeRouteLegend = new JPanel();
		panelSafeRouteLegend.setLayout(null);
		panelSafeRouteLegend.setBackground(new Color(0, 100, 0));
		panelSafeRouteLegend.setBounds(0, 3, 20, 20);
		panelSafeRoute.add(panelSafeRouteLegend);
		
		JLabel lblChooseAnIsland = new JLabel("Select an island to sail to");
		lblChooseAnIsland.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnIsland.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseAnIsland.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseAnIsland);
		
		JLabel lblCurrLocation = new JLabel("Current Location: " + player.getCurrLocation().getName());
		lblCurrLocation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrLocation.setBounds(12, 12, 600, 31);
		frmSetSail.getContentPane().add(lblCurrLocation);
		
		JLabel lblChooseRoute = new JLabel("Select a route to use");
		lblChooseRoute.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseRoute.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseRoute.setBounds(710, 72, 235, 34);
		frmSetSail.getContentPane().add(lblChooseRoute);
		
		lblSelectedIsland = new JLabel("");
		lblSelectedIsland.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectedIsland.setBounds(632, 12, 490, 31);
		frmSetSail.getContentPane().add(lblSelectedIsland);
		
		textAreaSafeRoute = new JTextArea();
		textAreaSafeRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaSafeRoute.setEditable(false);
		textAreaSafeRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaSafeRoute.setBounds(26, 0, 209, 85);
		panelSafeRoute.add(textAreaSafeRoute);
		
		textAreaDangerousRoute = new JTextArea();
		textAreaDangerousRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDangerousRoute.setEditable(false);
		textAreaDangerousRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaDangerousRoute.setBounds(26, 0, 209, 79);
		panelDangerousRoute.add(textAreaDangerousRoute);
		
		JButton btnMainMenu = new JButton("Return to the Main Menu");
		btnMainMenu.setBounds(10, 711, 248, 43);
		frmSetSail.getContentPane().add(btnMainMenu);
		
		btnSetSail = new JButton("Set Sail");
		btnSetSail.setBounds(710, 711, 235, 43);
		frmSetSail.getContentPane().add(btnSetSail);
		
		JRadioButton rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		islandButtonGroup.add(rdbtnArborlandIslet);
		rdbtnArborlandIslet.setToolTipText("Items are cheap here");
		rdbtnArborlandIslet.setOpaque(false);
		rdbtnArborlandIslet.setForeground(Color.WHITE);
		rdbtnArborlandIslet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnArborlandIslet.setBounds(124, 394, 125, 23);
		panelMap.add(rdbtnArborlandIslet);
		
		JRadioButton rdbtnCrosserPeninsula = new JRadioButton("Crosser Peninsula");
		islandButtonGroup.add(rdbtnCrosserPeninsula);
		rdbtnCrosserPeninsula.setToolTipText("Items are expensive here");
		rdbtnCrosserPeninsula.setOpaque(false);
		rdbtnCrosserPeninsula.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCrosserPeninsula.setForeground(Color.WHITE);
		rdbtnCrosserPeninsula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCrosserPeninsula.setBounds(473, 570, 144, 23);
		panelMap.add(rdbtnCrosserPeninsula);
		
		JRadioButton rdbtnRainingArchipelago = new JRadioButton("Raining Archipelago");
		islandButtonGroup.add(rdbtnRainingArchipelago);
		rdbtnRainingArchipelago.setToolTipText("Items are reasonably priced here");
		rdbtnRainingArchipelago.setOpaque(false);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		
		JRadioButton rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		islandButtonGroup.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setToolTipText("Items are cheapest here");
		rdbtnRemoteRefuge.setOpaque(false);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		
		JRadioButton rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		islandButtonGroup.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setToolTipText("Items are most expensive here");
		rdbtnBrightwichIsland.setOpaque(false);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		
		rdbtnBrightwichIsland.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Island i: islands) {
					if (i.getName() == "Brightwich Island") {
						island = i;
					}
				}
				setSailWindow.updatePage(player, island);
			}
		}); 
		
		lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(SetSailWindow.class.getResource("/Images/Base Map.png")));
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		
		JRadioButton rdbtnDangerousRoute = new JRadioButton("");
		routeButtonGroup.add(rdbtnDangerousRoute);
		rdbtnDangerousRoute.setOpaque(false);
		rdbtnDangerousRoute.setBounds(0, 0, 20, 20);
		panelDangerousRouteLegend.add(rdbtnDangerousRoute);
		
		JRadioButton rdbtnSafeRoute = new JRadioButton("");
		routeButtonGroup.add(rdbtnSafeRoute);
		rdbtnSafeRoute.setOpaque(false);
		rdbtnSafeRoute.setBounds(0, 0, 20, 20);
		panelSafeRouteLegend.add(rdbtnSafeRoute);
		
		switch (currentLocation) {
		case "Arborland Islet":
			rdbtnArborlandIslet.setEnabled(false);
			rdbtnArborlandIslet.setToolTipText("You are currently on this island");
			break;
		case "Crosser Peninsula":
			rdbtnCrosserPeninsula.setEnabled(false);
			rdbtnCrosserPeninsula.setToolTipText("You are currently on this island");
			break;
		case "Raining Archipelago":
			rdbtnRainingArchipelago.setEnabled(false);
			rdbtnRainingArchipelago.setToolTipText("You are currently on this island");
			break;
		case "Remote Refuge":
			rdbtnRemoteRefuge.setEnabled(false);
			rdbtnRemoteRefuge.setToolTipText("You are currently on this island");
			break;
		case "Brightwich Island":
			rdbtnBrightwichIsland.setEnabled(false);
			rdbtnBrightwichIsland.setToolTipText("You are currently on this island");
			break;
		}
		// Sets the route panels to invisible initially
		panelSafeRoute.setVisible(false);
		panelDangerousRoute.setVisible(false);
		
		// Return to the main menu on the button click
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitSetSail();
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
				setSailWindow.updatePage(player, island);
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
				setSailWindow.updatePage(player, island);
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
				setSailWindow.updatePage(player, island);
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
				setSailWindow.updatePage(player, island);
			}
		}); 
		
		rdbtnDangerousRoute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSetSail.setEnabled(true);
			}
		}); 
		
		rdbtnSafeRoute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSetSail.setEnabled(true);
			}
		}); 
		
		/*
		 * Checks if the player has selected a route
		 * Checks if the player can use the selected route
		 * Confirms the route with the player and sets sail if the player says yes
		 */
		btnSetSail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				Route selectedRoute = new Route();
				boolean routeSelectSuccess = true;
				boolean checkRoute = false;
				int setSailSuccess = 0;
				
				if (rdbtnSafeRoute.isSelected()) {
					selectedRoute = safeRoute;
					
				} else if (rdbtnDangerousRoute.isSelected()) {
					selectedRoute = dangerousRoute;
					
				} else {
					showMessage("Please select a route to use");
					routeSelectSuccess = false;
				}
				
				
				if (routeSelectSuccess) {
					try {
						checkRoute = player.checkRoute(selectedRoute);
						
					} catch (InsufficientCoinsException e) {
						showMessage("Error: You don't have enough coins to use this route. Sell some items or weapons to get more");
						setSailSuccess = -1;
						
					} catch (InsufficientDaysException e) {
						showMessage("Error: You don't have enough days left to use this route. Try another or start a new game with unlimited days");
						setSailSuccess = -1;
					}
					boolean confirmSailing = confirmSailing(island.getName(), selectedRoute.getName(), selectedRoute.getCost(player.getSelectedShip()));
					
					if (checkRoute && confirmSailing) {
						EventInfo eventInfo = player.setSail(selectedRoute, island);
						int eventType = eventInfo.getEventType();
						setSailSuccess = eventInfo.getSailSuccess();
						ArrayList<String> messages = eventInfo.getMessages();
						if (eventType == 1) {
							setSailWindow.rollDice(messages.get(0));
							for (int i=1; i < messages.size(); i++) {
								setSailWindow.showMessage(messages.get(i));
							}
						} else {
							for (int i=0; i < messages.size(); i++) {
								setSailWindow.showMessage(messages.get(i));
							}
						}
					}
					if (confirmSailing && setSailSuccess == 0) {
						game.exitSetSail();
						showMessage("Successfully sailed to " + island.getName());
						
					} else if (setSailSuccess == 1 || setSailSuccess == 2) {
						showMessage(game.gameOver(setSailSuccess)); 
					}
				}
			}
		});
		
	}
		
		
	/**
	 * Prompts the player to confirm if they want to sail to the selected island along the selected route
	 * @param island The island the player has selected
	 * @param route The route the player has selected
	 * @param cost The cost for the player to travel along that route
	 * @return true (if the player clicks yes) or false (if the player clicks no)
	 */
	private boolean confirmSailing(String island, String route, int cost) {
		int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to sail to " + island + " along " + route + " for " + cost + " coins?", "Sailing Confirmation",JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Shows the player the given message in a popup box
	 * @param message The message to show the player
	 */
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(popup, message);
	}
	
	/**
	 * Prompts the player to roll the dice in a pirate battle
	 * @param message A string containing the information about the pirate battle, including the number they have to beat
	 */
	private void rollDice(String message) {
		String[] options = {"Roll Dice"};
		JOptionPane.showOptionDialog(popup, message, "Pirates!", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, options, "");
	}
	
	/**
	 * Updates the page when a new island is selected
	 * Shows the routes between the players current island and the selected island
	 * @param player The player
	 * @param island The island the player wants to sail to
	 */
	private void updatePage(Player player, Island island) {
		if (!panelSafeRoute.isVisible() && !panelDangerousRoute.isVisible()) {
			frmSetSail.setBounds(100, 100, 1050, 800);
			frmSetSail.setLocationRelativeTo(null);
		}
		lblSelectedIsland.setText("Selected Island: " + island.getName());
		panelSafeRoute.setVisible(true);
		panelDangerousRoute.setVisible(true);
		routeButtonGroup.clearSelection();
		btnSetSail.setEnabled(false);
		MapRoute mapRoute = new MapRoute();
		mapRoute.findMapImage(island, player, safeRoute, dangerousRoute);
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
}
