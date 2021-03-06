package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;


import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import backEnd.Game;
import backEnd.Island;
import backEnd.Ship;

public class SetupWindow {

	private JFrame frmSetupWindow;
	private JFrame popup;
	
	private JRadioButton rdbtnMantis;
	private JRadioButton rdbtnDelight;
	private JRadioButton rdbtnPioneer;
	private JRadioButton rdbtnDefender;
	
	private JRadioButton rdbtnArborlandIslet;
	private JRadioButton rdbtnCrosserPeninsula;
	private JRadioButton rdbtnRainingArchipelago;
	private JRadioButton rdbtnRemoteRefuge;
	private JRadioButton rdbtnBrightwichIsland;

	private JCheckBox chckbxUnlimitedDays;
	private JSlider sliderDays;
	
	private JTextField textYourName;
	
	private final ButtonGroup shipRadioButtonGroup = new ButtonGroup();
	private final ButtonGroup IslandRadioButtonGroup = new ButtonGroup();

	/**
	 * Creates the window object.
	 */
	public SetupWindow() {
	}
	
	/**
	 * Initializes the window then sets it to visible
	 * @param game The current game
	 */
	public void open(Game game) {
		initialize(game);
		frmSetupWindow.setVisible(true);
	}
	
	/**
	 * Sets the window to invisible
	 */
	public void close() {
		frmSetupWindow.setVisible(false);
	}

	/**
	 * Initialize the setup window
	 * The player must select a ship, a starting island, the number of days to play for and enter their name
	 * They can select unlimited days using the check box
	 * Their name must be between 3 and 15 characters long, only contain letters and spaces, not start or end with a space and not contain two spaces in a row
	 * Once these requirements are met, the player can start the game
	 * @param game The current game
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		frmSetupWindow = new JFrame();
		frmSetupWindow.setTitle("Set Up");
		frmSetupWindow.setBounds(6, -31, 1326, 950);
		frmSetupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupWindow.getContentPane().setLayout(null);
		frmSetupWindow.setLocationRelativeTo(null);
		
		JPanel panelSelectIsland = new JPanel();
		panelSelectIsland.setBounds(688, 185, 600, 633);
		frmSetupWindow.getContentPane().add(panelSelectIsland);
		panelSelectIsland.setLayout(null);
		frmSetupWindow.setLocationRelativeTo(null);
		
		JPanel panelMap = new JPanel();
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		panelMap.setLayout(null);
		
		JPanel panelWelcomeMessage = new JPanel();
		panelWelcomeMessage.setBounds(0, 0, 1310, 80);
		frmSetupWindow.getContentPane().add(panelWelcomeMessage);
		panelWelcomeMessage.setLayout(null);
		
		JPanel panelSelectShip = new JPanel();
		panelSelectShip.setBounds(33, 185, 632, 633);
		frmSetupWindow.getContentPane().add(panelSelectShip);
		panelSelectShip.setLayout(null);
		
		JPanel panelShips = new JPanel();
		panelShips.setBounds(0, 38, 630, 595);
		panelSelectShip.add(panelShips);
		panelShips.setLayout(null);
		
		JPanel panelMantis = new JPanel();
		panelMantis.setBounds(0, 308, 300, 287);
		panelShips.add(panelMantis);
		panelMantis.setLayout(null);
		
		JPanel panelDelight = new JPanel();
		panelDelight.setBounds(0, 0, 300, 290);
		panelShips.add(panelDelight);
		panelDelight.setLayout(null);
		
		JPanel panelPioneer = new JPanel();
		panelPioneer.setBounds(330, 308, 300, 287);
		panelShips.add(panelPioneer);
		panelPioneer.setLayout(null);
		
		JPanel panelDefender = new JPanel();
		panelDefender.setBounds(330, 0, 300, 289);
		panelShips.add(panelDefender);
		panelDefender.setLayout(null);
		
		JPanel panelSelectDays = new JPanel();
		panelSelectDays.setBounds(778, 98, 420, 75);
		frmSetupWindow.getContentPane().add(panelSelectDays);
		panelSelectDays.setLayout(null);
		
		JPanel panelEnterName = new JPanel();
		panelEnterName.setBounds(245, 98, 209, 63);
		frmSetupWindow.getContentPane().add(panelEnterName);
		panelEnterName.setLayout(null);
		
		JLabel lblChooseStartingIslandText = new JLabel("Choose an island to start on");
		lblChooseStartingIslandText.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseStartingIslandText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseStartingIslandText.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseStartingIslandText);
		
		JLabel lblMap = new JLabel("");
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		lblMap.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Base Map.png")));
		
		JLabel lblYourName = new JLabel("Enter your name:");
		lblYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourName.setBounds(0, 0, 209, 21);
		panelEnterName.add(lblYourName);
		
		JLabel lblDaysMessage = new JLabel("How many days do you want to play for?");
		lblDaysMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaysMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysMessage.setBounds(0, -2, 336, 27);
		panelSelectDays.add(lblDaysMessage);
		
		JLabel lblMantisImage = new JLabel("");
		lblMantisImage.setBounds(0, 0, 300, 200);
		panelMantis.add(lblMantisImage);
		lblMantisImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Mantis.jpg")));
		
		JLabel lblDelightImage = new JLabel("");
		lblDelightImage.setBounds(0, 0, 300, 200);
		panelDelight.add(lblDelightImage);
		lblDelightImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Delight.jpg")));
		
		JLabel lblPioneerImage = new JLabel("");
		lblPioneerImage.setBounds(0, 0, 300, 200);
		panelPioneer.add(lblPioneerImage);
		lblPioneerImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Pioneer.jpg")));
		
		JLabel lblDefenderImage = new JLabel("");
		lblDefenderImage.setBorder(BorderFactory.createEmptyBorder());
		lblDefenderImage.setBounds(0, -1, 300, 200);
		panelDefender.add(lblDefenderImage);
		lblDefenderImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Defender.jpg")));
		
		JLabel lblChooseShipText = new JLabel("Choose a ship to use");
		lblChooseShipText.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseShipText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseShipText.setBounds(0, 0, 632, 39);
		panelSelectShip.add(lblChooseShipText);
		
		JLabel lblWelcomeMessage = new JLabel("Welcome to Island Trader");
		lblWelcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeMessage.setBounds(0, 5, 1310, 53);
		panelWelcomeMessage.add(lblWelcomeMessage);
		
		JLabel lblInstructions = new JLabel("Please enter your name, the number of days you want to play for and choose your ship and starting island");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInstructions.setBounds(0, 33, 1310, 67);
		panelWelcomeMessage.add(lblInstructions);
		
		JTextArea lblDelightProperties = new JTextArea("Crew: 8\t\tCargo Capacity:100\nAttack Level:12\t\tDefense Level:8\nSpeed: 4");
		lblDelightProperties.setBounds(0, 235, 300, 52);
		panelDelight.add(lblDelightProperties);
		lblDelightProperties.setBackground(UIManager.getColor("Button.background"));
		lblDelightProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDelightProperties.setEditable(false);
		
		JTextArea lblMantisProperties = new JTextArea("Crew: 12\t\tCargo Capacity: 110\nAttack Level:17\t\tDefense Level: 5\nSpeed: 4");
		lblMantisProperties.setBounds(0, 235, 300, 52);
		panelMantis.add(lblMantisProperties);
		lblMantisProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMantisProperties.setBackground(UIManager.getColor("Button.background"));
		lblMantisProperties.setEditable(false);
		
		JTextArea lblPioneerProperties = new JTextArea("Crew: 12\t\tCargo Capacity: 80\nAttack Level: 10\tDefense Level: 10\nSpeed: 5");
		lblPioneerProperties.setBounds(0, 235, 300, 52);
		panelPioneer.add(lblPioneerProperties);
		lblPioneerProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPioneerProperties.setBackground(UIManager.getColor("Button.background"));
		lblPioneerProperties.setEditable(false);
		
		JTextArea lblDefenderProperties = new JTextArea("Crew: 13\t\tCargo Capacity: 130\nAttack Level: 6\t\tDefense Level: 18\nSpeed: 3");
		lblDefenderProperties.setBounds(0, 235, 300, 52);
		panelDefender.add(lblDefenderProperties);
		lblDefenderProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDefenderProperties.setBackground(UIManager.getColor("Button.background"));
		lblDefenderProperties.setEditable(false);
		
		textYourName = new JTextField();
		textYourName.setBounds(10, 28, 189, 26);
		panelEnterName.add(textYourName);
		textYourName.setColumns(10);
		
		JButton btnPlayGame = new JButton("Play Game");
		btnPlayGame.setBounds(578, 835, 200, 63);
		frmSetupWindow.getContentPane().add(btnPlayGame);
		btnPlayGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		rdbtnArborlandIslet.setBounds(124, 394, 125, 23);
		rdbtnArborlandIslet.setToolTipText("Items are cheap here");
		panelMap.add(rdbtnArborlandIslet);
		rdbtnArborlandIslet.setForeground(Color.WHITE);
		rdbtnArborlandIslet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnArborlandIslet.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnArborlandIslet);
		
		rdbtnCrosserPeninsula = new JRadioButton("Crosser Peninsula");
		rdbtnCrosserPeninsula.setBounds(473, 570, 144, 23);
		rdbtnCrosserPeninsula.setToolTipText("Items are expensive here");
		panelMap.add(rdbtnCrosserPeninsula);
		rdbtnCrosserPeninsula.setForeground(Color.WHITE);
		rdbtnCrosserPeninsula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCrosserPeninsula.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnCrosserPeninsula);
		
		rdbtnRainingArchipelago = new JRadioButton("Raining Archipelago");
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		rdbtnRainingArchipelago.setToolTipText("Items are reasonably priced here");
		panelMap.add(rdbtnRainingArchipelago);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnRainingArchipelago);
		
		rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		rdbtnRemoteRefuge.setToolTipText("Items are cheapest here");
		panelMap.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnRemoteRefuge);
		
		rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		rdbtnBrightwichIsland.setToolTipText("Items are most expensive here");
		panelMap.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnBrightwichIsland);
		
		rdbtnMantis = new JRadioButton("Mantis");
		rdbtnMantis.setBounds(115, 207, 78, 23);
		panelMantis.add(rdbtnMantis);
		rdbtnMantis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnMantis);
		
		rdbtnDelight = new JRadioButton("Delight");
		rdbtnDelight.setBounds(115, 207, 80, 23);
		panelDelight.add(rdbtnDelight);
		rdbtnDelight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnDelight);

		rdbtnPioneer = new JRadioButton("Pioneer");
		rdbtnPioneer.setBounds(112, 204, 79, 23);
		panelPioneer.add(rdbtnPioneer);
		rdbtnPioneer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnPioneer);

		rdbtnDefender = new JRadioButton("Defender");
		rdbtnDefender.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDefender.setBounds(107, 207, 92, 23);
		panelDefender.add(rdbtnDefender);
		rdbtnDefender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnDefender);
		
		sliderDays = new JSlider();
		sliderDays.setValue(35);
		sliderDays.setMaximum(50);
		sliderDays.setBounds(10, 23, 316, 38);
		panelSelectDays.add(sliderDays);
		sliderDays.setPaintLabels(true);
		sliderDays.setMajorTickSpacing(10);
		sliderDays.setPaintTicks(true);
		sliderDays.setSnapToTicks(true);
		sliderDays.setMinorTickSpacing(1);
		sliderDays.setMinimum(20);

		chckbxUnlimitedDays = new JCheckBox("Unlimited");
		chckbxUnlimitedDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxUnlimitedDays.setBounds(324, 23, 97, 23);
		panelSelectDays.add(chckbxUnlimitedDays);
		
		chckbxUnlimitedDays.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxUnlimitedDays.isSelected()) {
					sliderDays.setEnabled(false);
				} else {
					sliderDays.setEnabled(true);
				}
			}
		});

		/*
		 * Checks that the player has met the requirements to start the game
		 * Starts the game if they have
		 */
		btnPlayGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Ship> ships = game.getShips();
				ArrayList<Island> islands = game.getIslands();
				
				Ship ship = ships.get(0);
				Island island = islands.get(0);
				String shipString = "";
				String islandString = "";
				String name = "";
				int numDays = 0;
				boolean setupSuccess = true;
				
				if (rdbtnMantis.isSelected()) {
					shipString = "Mantis";
				} else if (rdbtnDelight.isSelected()) {
					shipString = "Delight";
				} else if (rdbtnPioneer.isSelected()) {
					shipString = "Pioneer";
				} else if (rdbtnDefender.isSelected()) {
					shipString = "Defender";
				} else {
					JOptionPane.showMessageDialog(popup, "Please select a ship");
					setupSuccess = false;
				}
				
				if (rdbtnArborlandIslet.isSelected()) {
					islandString = "Arborland Islet";
				} else if (rdbtnCrosserPeninsula.isSelected()) {
					islandString = "Crosser Peninsula";
				} else if (rdbtnRainingArchipelago.isSelected()) {
					islandString = "Raining Archipelago";
				} else if (rdbtnRemoteRefuge.isSelected()) {
					islandString = "Remote Refuge";
				} else if (rdbtnBrightwichIsland.isSelected()) {
					islandString = "Brightwich Island";
				} else {
					JOptionPane.showMessageDialog(popup, "Please select an island");
					setupSuccess = false;
				}
				
				if (!chckbxUnlimitedDays.isSelected()) {
					numDays = sliderDays.getValue();
				}
				
				name = textYourName.getText();
				if (name.length() < 3 || name.length() > 15) {
					JOptionPane.showMessageDialog(popup, "Your name must be between 3 and 15 characters long");
					setupSuccess = false;
				} else if (!name.matches("^[a-zA-Z ]+$")) {
					JOptionPane.showMessageDialog(popup, "Your name may only contain letters and spaces");
					setupSuccess = false;
				} else if (name.contains("  ")) {
					JOptionPane.showMessageDialog(popup, "Your name may only contain one space in a row");
					setupSuccess = false;
				} else if (name.endsWith(" ") || name.startsWith(" ")) {
					JOptionPane.showMessageDialog(popup, "Your name may not start or end with a space");
					setupSuccess = false;
				}
				
				for (Ship s:ships) {
					if (shipString == s.getName()) {
						ship = s;
					}
				}
				
				for (Island i:islands) {
					if (islandString == i.getName()) {
						island = i;
					}
				}
				
				if (setupSuccess) {
					game.createPlayer(ship, island, name, numDays);
					game.startGame();
				}
			}
		});
	}
}