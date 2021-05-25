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

public class SetSailWindow {

	private JFrame frmSetSail;
	private JRadioButton rdbtnCrosserPeninsula;
	private JPanel panelSelectIsland;
	private JLabel lblChooseAnIsland;
	private JPanel panelMap;
	private JRadioButton rdbtnArborlandIslet;
	private JRadioButton rdbtnRainingArchipelago;
	private JRadioButton rdbtnRemoteRefuge;
	private JRadioButton rdbtnBrightwichIsland;
	private JLabel lblMap;
	private final ButtonGroup islandButtonGroup = new ButtonGroup();
	private JFrame popup;
	private JPanel panelSafeRoute;
	private JPanel panelDangerousRoute;
	private Island island;
	private Route safeRoute;
	private Route dangerousRoute;
	private int daysToTravel;
	private int costToTravel;
	private JTextArea textAreaDangerousRoute;
	private JTextArea textAreaSafeRoute;
	private SetSailWindow setSailWindow = this;
	private JLabel lblSelectedIsland;
	private final ButtonGroup routeButtonGroup = new ButtonGroup();
	private JRadioButton rdbtnDangerousRoute;
	private JRadioButton rdbtnSafeRoute;
	private JButton btnSetSail;

	/**
	 * Create the application.
	 * 
	 */
	public SetSailWindow() {
	}
	
	public void close() {
		frmSetSail.setVisible(false);
	}
	
	public void open(Game game) {
		initialize(game);
		frmSetSail.setVisible(true);
	}

	/**
	 * Initialize the contents of the frmSetSail.
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
		
		panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(5, 73, 600, 633);
		frmSetSail.getContentPane().add(panelSelectIsland);
		
		lblChooseAnIsland = new JLabel("Select an island to sail to");
		lblChooseAnIsland.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnIsland.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseAnIsland.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseAnIsland);
		
		JLabel lblCurrLocation = new JLabel("Current Location: " + player.getCurrLocation().getName());
		lblCurrLocation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrLocation.setBounds(12, 12, 600, 31);
		frmSetSail.getContentPane().add(lblCurrLocation);
		
		lblSelectedIsland = new JLabel("");
		lblSelectedIsland.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectedIsland.setBounds(632, 12, 490, 31);
		frmSetSail.getContentPane().add(lblSelectedIsland);
		
		panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		
		rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		islandButtonGroup.add(rdbtnArborlandIslet);
		rdbtnArborlandIslet.setToolTipText("Items are cheap here");
		rdbtnArborlandIslet.setOpaque(false);
		rdbtnArborlandIslet.setForeground(Color.WHITE);
		rdbtnArborlandIslet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnArborlandIslet.setBounds(124, 394, 125, 23);
		panelMap.add(rdbtnArborlandIslet);
		
		rdbtnCrosserPeninsula = new JRadioButton("Crosser Peninsula");
		islandButtonGroup.add(rdbtnCrosserPeninsula);
		rdbtnCrosserPeninsula.setToolTipText("Items are expensive here");
		rdbtnCrosserPeninsula.setOpaque(false);
		rdbtnCrosserPeninsula.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCrosserPeninsula.setForeground(Color.WHITE);
		rdbtnCrosserPeninsula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCrosserPeninsula.setBounds(473, 570, 144, 23);
		panelMap.add(rdbtnCrosserPeninsula);
		
		rdbtnRainingArchipelago = new JRadioButton("Raining Archipelago");
		islandButtonGroup.add(rdbtnRainingArchipelago);
		rdbtnRainingArchipelago.setToolTipText("Items are reasonably priced here");
		rdbtnRainingArchipelago.setOpaque(false);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		
		rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		islandButtonGroup.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setToolTipText("Items are cheapest here");
		rdbtnRemoteRefuge.setOpaque(false);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		
		rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		islandButtonGroup.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setToolTipText("Items are most expensive here");
		rdbtnBrightwichIsland.setOpaque(false);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		
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
		
		lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(SetSailWindow.class.getResource("/Images/Base Map.png")));
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		
		panelDangerousRoute = new JPanel();
		panelDangerousRoute.setBounds(710, 105, 235, 79);
		frmSetSail.getContentPane().add(panelDangerousRoute);
		panelDangerousRoute.setLayout(null);
		
		JPanel panelDangerousRouteLegend = new JPanel();
		panelDangerousRouteLegend.setLayout(null);
		panelDangerousRouteLegend.setBackground(Color.RED);
		panelDangerousRouteLegend.setBounds(0, 3, 20, 20);
		panelDangerousRoute.add(panelDangerousRouteLegend);
		
		rdbtnDangerousRoute = new JRadioButton("");
		routeButtonGroup.add(rdbtnDangerousRoute);
		rdbtnDangerousRoute.setOpaque(false);
		rdbtnDangerousRoute.setBounds(0, 0, 20, 20);
		panelDangerousRouteLegend.add(rdbtnDangerousRoute);
		
		textAreaDangerousRoute = new JTextArea();
		textAreaDangerousRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDangerousRoute.setEditable(false);
		textAreaDangerousRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaDangerousRoute.setBounds(26, 0, 209, 79);
		panelDangerousRoute.add(textAreaDangerousRoute);
		
		panelSafeRoute = new JPanel();
		panelSafeRoute.setBounds(710, 218, 235, 85);
		frmSetSail.getContentPane().add(panelSafeRoute);
		panelSafeRoute.setLayout(null);
		
		JPanel panelSafeRouteLegend = new JPanel();
		panelSafeRouteLegend.setLayout(null);
		panelSafeRouteLegend.setBackground(new Color(0, 100, 0));
		panelSafeRouteLegend.setBounds(0, 3, 20, 20);
		panelSafeRoute.add(panelSafeRouteLegend);
		
		rdbtnSafeRoute = new JRadioButton("");
		routeButtonGroup.add(rdbtnSafeRoute);
		rdbtnSafeRoute.setOpaque(false);
		rdbtnSafeRoute.setBounds(0, 0, 20, 20);
		panelSafeRouteLegend.add(rdbtnSafeRoute);
		
		textAreaSafeRoute = new JTextArea();
		textAreaSafeRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaSafeRoute.setEditable(false);
		textAreaSafeRoute.setBackground(UIManager.getColor("Button.background"));
		textAreaSafeRoute.setBounds(26, 0, 209, 85);
		panelSafeRoute.add(textAreaSafeRoute);
		
		panelSafeRoute.setVisible(false);
		panelDangerousRoute.setVisible(false);
		
		JButton btnMainMenu = new JButton("Return to the Main Menu");
		btnMainMenu.setBounds(10, 711, 248, 43);
		frmSetSail.getContentPane().add(btnMainMenu);
		
		btnSetSail = new JButton("Set Sail");
		btnSetSail.setBounds(710, 711, 235, 43);
		frmSetSail.getContentPane().add(btnSetSail);
		
		JLabel lblChooseRoute = new JLabel("Select a route to use");
		lblChooseRoute.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseRoute.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseRoute.setBounds(710, 72, 235, 34);
		frmSetSail.getContentPane().add(lblChooseRoute);
		
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitSetSail();
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
				setSailWindow.updatePage(player);
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
				setSailWindow.updatePage(player);
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
				setSailWindow.updatePage(player);
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
				setSailWindow.updatePage(player);
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
				setSailWindow.updatePage(player);
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
		
		
		
	private boolean confirmSailing(String island, String route, int cost) {
		int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to sail to " + island + " along " + route + " for " + cost + " coins?", "Sailing Confirmation",JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(popup, message);
	}
	
	private void rollDice(String string) {
		String[] options = {"Roll Dice"};
		JOptionPane.showOptionDialog(popup, string, "Pirates!", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, options, "");
	}
	
	private void updatePage(Player player) {
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
		mapRoute = mapRoute.findMapImage(island, player, safeRoute, dangerousRoute);
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
