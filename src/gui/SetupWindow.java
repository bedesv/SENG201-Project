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
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JCheckBox;

public class SetupWindow {

	private JFrame frmSetupWindow;
	private JTextField textYourName;
	private final ButtonGroup shipRadioButtonGroup = new ButtonGroup();
	private final ButtonGroup IslandRadioButtonGroup = new ButtonGroup();
	private JSlider sliderDays;
	private JLabel lblDaysMessage;
	
	private JPanel panelSelectShip;
	private JLabel lblChooseShipText;
	private JPanel panelShips;
	
	private JPanel panelMantis;
	private JPanel panelDelight;
	private JPanel panelPioneer;
	private JPanel panelDefender;
	
	private JRadioButton rdbtnMantis;
	private JRadioButton rdbtnDelight;
	private JRadioButton rdbtnPioneer;
	private JRadioButton rdbtnDefender;
	
	private JLabel lblMantisImage;
	private JLabel lblDelightImage;
	private JLabel lblPioneerImage;
	private JLabel lblDefenderImage;
	
	private JTextArea lblMantisProperties;
	private JTextArea lblDelightProperties;
	private JTextArea lblPioneerProperties;
	private JTextArea lblDefenderProperties;
	
	private JPanel panelSelectIsland;
	private JLabel lblChooseStartingIslandText;
	private JPanel panelMap;
	
	private JRadioButton rdbtnArborlandIslet;
	private JRadioButton rdbtnCrosserPeninsula;
	private JRadioButton rdbtnRainingArchipelago;
	private JRadioButton rdbtnRemoteRefuge;
	private JRadioButton rdbtnBrightwichIsland;
	
	private JLabel lblMap;
	private JPanel panelEnterName;
	private JLabel lblYourName;
	private JPanel panelSelectDays;
	private JCheckBox chckbxUnlimitedDays;

	
	
	private JButton btnPlayGame;
	
	private JPanel panelWelcomeMessage;
	private JLabel lblWelcomeMessage;
	private JLabel lblInstructions;
	
	private JFrame popup;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetupWindow window = new SetupWindow();
//					window.frmSetupWindow.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SetupWindow() {
	}
	
	public void open(Game game) {
		initialize(game);
		frmSetupWindow.setVisible(true);
	}
	
	public void close() {
		frmSetupWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		frmSetupWindow = new JFrame();
		frmSetupWindow.setTitle("Set Up");
		frmSetupWindow.setBounds(6, -31, 1326, 1036);
		frmSetupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		frmSetupWindow.getContentPane().setLayout(null);
		
		panelSelectIsland = new JPanel();
		panelSelectIsland.setBounds(685, 275, 600, 633);
		frmSetupWindow.getContentPane().add(panelSelectIsland);
		panelSelectIsland.setLayout(null);
		frmSetupWindow.setLocationRelativeTo(null);
		
		lblChooseStartingIslandText = new JLabel("Choose an island to start on");
		lblChooseStartingIslandText.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseStartingIslandText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseStartingIslandText.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseStartingIslandText);
		
		panelMap = new JPanel();
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		panelMap.setLayout(null);
		
		// Islands
		
		rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		rdbtnArborlandIslet.setBounds(124, 394, 125, 23);
		panelMap.add(rdbtnArborlandIslet);
		rdbtnArborlandIslet.setForeground(Color.WHITE);
		rdbtnArborlandIslet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnArborlandIslet.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnArborlandIslet);
		
		rdbtnCrosserPeninsula = new JRadioButton("Crosser Peninsula");
		rdbtnCrosserPeninsula.setBounds(473, 570, 144, 23);
		panelMap.add(rdbtnCrosserPeninsula);
		rdbtnCrosserPeninsula.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCrosserPeninsula.setToolTipText("Items are expensive here");
		rdbtnCrosserPeninsula.setForeground(Color.WHITE);
		rdbtnCrosserPeninsula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCrosserPeninsula.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnCrosserPeninsula);
		
		rdbtnRainingArchipelago = new JRadioButton("Raining Archipelago");
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnRainingArchipelago);
		
		rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnRemoteRefuge);
		
		rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setOpaque(false);
		IslandRadioButtonGroup.add(rdbtnBrightwichIsland);
		
		lblMap = new JLabel("");
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		lblMap.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Base Map.png")));
		
		panelEnterName = new JPanel();
		panelEnterName.setBounds(241, 146, 209, 63);
		frmSetupWindow.getContentPane().add(panelEnterName);
		panelEnterName.setLayout(null);
		
		
		lblYourName = new JLabel("Enter your name:");
		lblYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourName.setBounds(0, 0, 209, 21);
		panelEnterName.add(lblYourName);
		
		textYourName = new JTextField();
		textYourName.setBounds(10, 28, 189, 26);
		panelEnterName.add(textYourName);
		textYourName.setColumns(10);
		
		panelSelectDays = new JPanel();
		panelSelectDays.setBounds(775, 147, 420, 61);
		frmSetupWindow.getContentPane().add(panelSelectDays);
		panelSelectDays.setLayout(null);
		
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
		
		
		sliderDays = new JSlider();
		sliderDays.setBounds(10, 23, 316, 38);
		panelSelectDays.add(sliderDays);
		sliderDays.setPaintLabels(true);
		sliderDays.setMajorTickSpacing(10);
		sliderDays.setPaintTicks(true);
		sliderDays.setSnapToTicks(true);
		sliderDays.setMinorTickSpacing(1);
		sliderDays.setMinimum(10);
		
		lblDaysMessage = new JLabel("How many days do you want to play for?");
		lblDaysMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaysMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysMessage.setBounds(0, -2, 336, 27);
		panelSelectDays.add(lblDaysMessage);
		
		panelSelectShip = new JPanel();
		panelSelectShip.setBounds(30, 275, 632, 633);
		frmSetupWindow.getContentPane().add(panelSelectShip);
		panelSelectShip.setLayout(null);
		
		panelShips = new JPanel();
		panelShips.setBounds(0, 38, 630, 595);
		panelSelectShip.add(panelShips);
		panelShips.setLayout(null);
		
		panelMantis = new JPanel();
		panelMantis.setBounds(0, 308, 300, 287);
		panelShips.add(panelMantis);
		panelMantis.setLayout(null);
		
		rdbtnMantis = new JRadioButton("Mantis");
		rdbtnMantis.setBounds(115, 207, 69, 23);
		panelMantis.add(rdbtnMantis);
		rdbtnMantis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnMantis);
		
		lblMantisImage = new JLabel("");
		lblMantisImage.setBounds(0, 0, 300, 200);
		panelMantis.add(lblMantisImage);
		lblMantisImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Mantis.jpg")));
		
		lblMantisProperties = new JTextArea("Crew: 12\t\tCargo Capacity: 110\nAttack Level:17\t\tDefense Level: 5\nSpeed: 4");
		lblMantisProperties.setBounds(0, 235, 300, 52);
		panelMantis.add(lblMantisProperties);
		lblMantisProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMantisProperties.setBackground(SystemColor.menu);
		lblMantisProperties.setEditable(false);
		
		panelDelight = new JPanel();
		panelDelight.setBounds(0, 0, 300, 290);
		panelShips.add(panelDelight);
		panelDelight.setLayout(null);
		
		rdbtnDelight = new JRadioButton("Delight");
		rdbtnDelight.setBounds(115, 207, 69, 23);
		panelDelight.add(rdbtnDelight);
		rdbtnDelight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnDelight);
		
		lblDelightImage = new JLabel("");
		lblDelightImage.setBounds(0, 0, 300, 200);
		panelDelight.add(lblDelightImage);
		lblDelightImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Delight.jpg")));
		
		lblDelightProperties = new JTextArea("Crew: 8\t\tCargo Capacity: 100\nAttack Level: 12\tDefense Level: 8\nSpeed: 4");
		lblDelightProperties.setBounds(0, 235, 300, 52);
		panelDelight.add(lblDelightProperties);
		lblDelightProperties.setBackground(SystemColor.menu);
		lblDelightProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDelightProperties.setEditable(false);
		
		panelPioneer = new JPanel();
		panelPioneer.setBounds(330, 308, 300, 287);
		panelShips.add(panelPioneer);
		panelPioneer.setLayout(null);
		
		rdbtnPioneer = new JRadioButton("Pioneer");
		rdbtnPioneer.setBounds(112, 204, 73, 23);
		panelPioneer.add(rdbtnPioneer);
		rdbtnPioneer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnPioneer);
		
		lblPioneerImage = new JLabel("");
		lblPioneerImage.setBounds(0, 0, 300, 200);
		panelPioneer.add(lblPioneerImage);
		lblPioneerImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Pioneer.jpg")));
		
		lblPioneerProperties = new JTextArea("Crew: 12\t\tCargo Capacity: 80\nAttack Level: 10\tDefense Level: 10\nSpeed: 5");
		lblPioneerProperties.setBounds(0, 235, 300, 52);
		panelPioneer.add(lblPioneerProperties);
		lblPioneerProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPioneerProperties.setBackground(SystemColor.menu);
		lblPioneerProperties.setEditable(false);
		
		panelDefender = new JPanel();
		panelDefender.setBounds(330, 0, 300, 289);
		panelShips.add(panelDefender);
		panelDefender.setLayout(null);
		
		rdbtnDefender = new JRadioButton("Defender");
		rdbtnDefender.setBounds(107, 207, 85, 23);
		panelDefender.add(rdbtnDefender);
		rdbtnDefender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shipRadioButtonGroup.add(rdbtnDefender);
		
		lblDefenderImage = new JLabel("");
		lblDefenderImage.setBounds(0, 0, 300, 200);
		panelDefender.add(lblDefenderImage);
		lblDefenderImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Defender.jpg")));
		
		lblDefenderProperties = new JTextArea("Crew: 13\t\tCargo Capacity: 130\nAttack Level: 6\t\tDefense Level: 18\nSpeed: 3");
		lblDefenderProperties.setBounds(0, 235, 300, 52);
		panelDefender.add(lblDefenderProperties);
		lblDefenderProperties.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDefenderProperties.setBackground(SystemColor.menu);
		lblDefenderProperties.setEditable(false);
		
		lblChooseShipText = new JLabel("Choose a ship to use");
		lblChooseShipText.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseShipText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseShipText.setBounds(0, 0, 632, 39);
		panelSelectShip.add(lblChooseShipText);
		
		btnPlayGame = new JButton("Play Game");
		btnPlayGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlayGame.setBounds(574, 932, 200, 40);
		frmSetupWindow.getContentPane().add(btnPlayGame);
		
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
				if (name.length() < 3) {
					JOptionPane.showMessageDialog(popup, "Your name must be at least 3 characters long");
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
		
		panelWelcomeMessage = new JPanel();
		panelWelcomeMessage.setBounds(0, 0, 1310, 80);
		frmSetupWindow.getContentPane().add(panelWelcomeMessage);
		panelWelcomeMessage.setLayout(null);
		
		lblWelcomeMessage = new JLabel("Welcome to Island Trader");
		lblWelcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeMessage.setBounds(0, 5, 1310, 53);
		panelWelcomeMessage.add(lblWelcomeMessage);
		
		lblInstructions = new JLabel("Please enter your name, the number of days you want to play for and choose your ship and starting island");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInstructions.setBounds(0, 33, 1310, 67);
		panelWelcomeMessage.add(lblInstructions);
	}
}