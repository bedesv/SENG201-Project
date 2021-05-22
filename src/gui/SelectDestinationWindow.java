package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class SelectDestinationWindow {

	private JFrame selectDestinationFrame;
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

	/**
	 * Create the application.
	 */
	public SelectDestinationWindow(Game game) {
		initialize(game);
		selectDestinationFrame.setVisible(true);
	}
	
	public void close() {
		selectDestinationFrame.setVisible(false);
	}

	/**
	 * Initialize the contents of the selectDestinationFrame.
	 */
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		String currentLocation = player.getSelectedShip().getLocation().getName();
		selectDestinationFrame = new JFrame();
		selectDestinationFrame.setBounds(100, 100, 1172, 771);
		selectDestinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectDestinationFrame.getContentPane().setLayout(null);
		
		panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(23, 31, 600, 633);
		selectDestinationFrame.getContentPane().add(panelSelectIsland);
		
		lblChooseAnIsland = new JLabel("Choose an island to sail to");
		lblChooseAnIsland.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnIsland.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseAnIsland.setBounds(0, 0, 600, 34);
		panelSelectIsland.add(lblChooseAnIsland);
		
		panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 33, 600, 600);
		panelSelectIsland.add(panelMap);
		
		rdbtnArborlandIslet = new JRadioButton("Arborland Islet");
		islandButtonGroup.add(rdbtnArborlandIslet);
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
		rdbtnRainingArchipelago.setOpaque(false);
		rdbtnRainingArchipelago.setForeground(Color.WHITE);
		rdbtnRainingArchipelago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRainingArchipelago.setBounds(328, 236, 158, 23);
		panelMap.add(rdbtnRainingArchipelago);
		
		rdbtnRemoteRefuge = new JRadioButton("Remote Refuge");
		islandButtonGroup.add(rdbtnRemoteRefuge);
		rdbtnRemoteRefuge.setOpaque(false);
		rdbtnRemoteRefuge.setForeground(Color.WHITE);
		rdbtnRemoteRefuge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemoteRefuge.setBounds(94, 117, 161, 23);
		panelMap.add(rdbtnRemoteRefuge);
		
		rdbtnBrightwichIsland = new JRadioButton("Brightwich Island");
		islandButtonGroup.add(rdbtnBrightwichIsland);
		rdbtnBrightwichIsland.setOpaque(false);
		rdbtnBrightwichIsland.setForeground(Color.WHITE);
		rdbtnBrightwichIsland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBrightwichIsland.setBounds(438, 125, 140, 23);
		panelMap.add(rdbtnBrightwichIsland);
		
		switch (currentLocation) {
		case "Arborland Islet":
			rdbtnArborlandIslet.setEnabled(false);
			break;
		case "Crosser Peninsula":
			rdbtnCrosserPeninsula.setEnabled(false);
			break;
		case "Raining Archipelago":
			rdbtnRainingArchipelago.setEnabled(false);
			break;
		case "Remote Refuge":
			rdbtnRemoteRefuge.setEnabled(false);
			break;
		case "Brightwich Island":
			rdbtnBrightwichIsland.setEnabled(false);
			break;
		}
		
		lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(SelectDestinationWindow.class.getResource("/Images/Base Map.png")));
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		
		
	}
}
