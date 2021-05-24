package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;

public class SelectRouteWindow {

	private JFrame frmSelectRouteWindow;
	private final ButtonGroup buttonGroupRouteSelection = new ButtonGroup();
	private int daysToTravel;
	private int costToTravel;
	private SelectRouteWindow selectRouteWindow = this;
	private JFrame popup;
	
	private Route safeRoute;
	private Route dangerousRoute;


	/**
	 * Create the application.
	 */
	public SelectRouteWindow() {
	}
	
	public void close() {
		frmSelectRouteWindow.setVisible(false);
	}
	
	public void open(Game game, Island destination) {
		initialize(game, destination);
		frmSelectRouteWindow.setVisible(true);
		
	}
	

	/**
	 * Initialize the contents of the frmSelectRouteWindow.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game, Island destination) {
		Player player = game.getPlayer();
		frmSelectRouteWindow = new JFrame();
		frmSelectRouteWindow.setBounds(100, 100, 905, 732);
		frmSelectRouteWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectRouteWindow.getContentPane().setLayout(null);
		frmSelectRouteWindow.setLocationRelativeTo(null);
		
		JPanel panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(0, 0, 600, 633);
		frmSelectRouteWindow.getContentPane().add(panelSelectIsland);
		
		JLabel lblChooseAnIsland = new JLabel("Choose a route to use");
		lblChooseAnIsland.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnIsland.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseAnIsland.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseAnIsland);
		
		JPanel panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		
		JLabel lblMap = new JLabel("");
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		
		String imageString = "";
		Island currentLocation = player.getCurrLocation();
		ArrayList<Route> routes = currentLocation.getRoutes(destination);
		
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
		
		lblMap.setIcon(new ImageIcon(SelectDestinationWindow.class.getResource(imageString)));
		
		JButton btnSelectDestination = new JButton("Return to Select Destination");
		btnSelectDestination.setBounds(28, 648, 343, 23);
		frmSelectRouteWindow.getContentPane().add(btnSelectDestination);
		
		JPanel panelDangerousRoute = new JPanel();
		panelDangerousRoute.setBounds(610, 97, 269, 79);
		frmSelectRouteWindow.getContentPane().add(panelDangerousRoute);
		panelDangerousRoute.setLayout(null);
		
		JPanel panelDangerousRouteLegend = new JPanel();
		panelDangerousRouteLegend.setBounds(0, 6, 20, 20);
		panelDangerousRoute.add(panelDangerousRouteLegend);
		panelDangerousRouteLegend.setBackground(new Color(255, 0, 0));
		panelDangerousRouteLegend.setLayout(null);
		
		JRadioButton rdbtnDangerousRoute = new JRadioButton("");
		buttonGroupRouteSelection.add(rdbtnDangerousRoute);
		rdbtnDangerousRoute.setBounds(0, 0, 20, 20);
		panelDangerousRouteLegend.add(rdbtnDangerousRoute);
		rdbtnDangerousRoute.setOpaque(false);
		
		JTextArea textAreaDangerousRoute = new JTextArea();
		textAreaDangerousRoute.setBounds(26, 0, 243, 79);
		panelDangerousRoute.add(textAreaDangerousRoute);
		textAreaDangerousRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDangerousRoute.setBackground(SystemColor.menu);
		daysToTravel = dangerousRoute.getDaysToTravel(player.getSelectedShip());
		costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
		textAreaDangerousRoute.setText("Route Name:\t" + dangerousRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + dangerousRoute.getMultiplier() +"%");
		JPanel panelSafeRoute = new JPanel();
		panelSafeRoute.setBounds(610, 210, 269, 85);
		frmSelectRouteWindow.getContentPane().add(panelSafeRoute);
		panelSafeRoute.setLayout(null);
		textAreaDangerousRoute.setEditable(false);
		
		JPanel panelSafeRouteLegend = new JPanel();
		panelSafeRouteLegend.setBounds(0, 6, 20, 20);
		panelSafeRoute.add(panelSafeRouteLegend);
		panelSafeRouteLegend.setLayout(null);
		panelSafeRouteLegend.setBackground(new Color(0, 100, 0));
		
		JRadioButton rdbtnSafeRoute = new JRadioButton("");
		buttonGroupRouteSelection.add(rdbtnSafeRoute);
		rdbtnSafeRoute.setBounds(0, 0, 20, 20);
		panelSafeRouteLegend.add(rdbtnSafeRoute);
		rdbtnSafeRoute.setOpaque(false);
		
		JTextArea textAreaSafeRoute = new JTextArea();
		textAreaSafeRoute.setBounds(26, 0, 243, 85);
		panelSafeRoute.add(textAreaSafeRoute);
		textAreaSafeRoute.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaSafeRoute.setBackground(SystemColor.menu);
		daysToTravel = safeRoute.getDaysToTravel(player.getSelectedShip());
		costToTravel = player.getSelectedShip().getCostToSail(daysToTravel);
		textAreaSafeRoute.setText("Route Name:\t" + safeRoute.getName() + "\nDays to Sail:\t" + daysToTravel + " Days\nCost to Sail:\t" + costToTravel + " Coins\nProbability of Random Event:\t" + safeRoute.getMultiplier() +"%");
		textAreaSafeRoute.setEditable(false);
		JButton btnSetSail = new JButton("Set Sail");
		btnSetSail.setBounds(711, 648, 151, 23);
		frmSelectRouteWindow.getContentPane().add(btnSetSail);
		
		btnSelectDestination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.exitSelectRoute();
			}
		});
		
		btnSetSail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				Route selectedRoute = routes.get(1);
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
					if (checkRoute) {
						EventInfo eventInfo = player.setSail(selectedRoute, destination);
						int eventType = eventInfo.getEventType();
						setSailSuccess = eventInfo.getSailSuccess();
						ArrayList<String> messages = eventInfo.getMessages();
						if (eventType == 1) {
							
							selectRouteWindow.rollDice(messages.get(0));
							for (int i=1; i < messages.size(); i++) {
								selectRouteWindow.showMessage(messages.get(i));
							}
						} else {
							for (int i=0; i < messages.size(); i++) {
								selectRouteWindow.showMessage(messages.get(i));
							}
						}
					}
					
					
					if (setSailSuccess == 0) {
						game.setSail();
						showMessage("Successfully sailed to " + destination.getName());
					} else if (setSailSuccess == 1 || setSailSuccess == 2) {
						game.gameOver(selectRouteWindow, setSailSuccess); 
					}
				}
			}
		});
		
	}
	
	public boolean confirmSailing(String destination, String route, int cost) {
		int choice = JOptionPane.showConfirmDialog(popup, "Are you sure you want to sail to " + destination + " along " + route + " for " + cost + " coins?", "Sailing Confirmation",JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(popup, message);
	}
	
	public void rollDice(String string) {
		String[] options = {"Roll Dice"};
		JOptionPane.showOptionDialog(popup, string, "Pirates!", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, options, "");
	}
}
