package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SelectDestinationWindow {

	private JFrame frmSelectDestination;
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

	/**
	 * Create the application.
	 * 
	 */
	public SelectDestinationWindow() {
	}
	
	public void close() {
		frmSelectDestination.setVisible(false);
	}
	
	public void open(Game game) {
		initialize(game);
		frmSelectDestination.setVisible(true);
	}

	/**
	 * Initialize the contents of the frmSelectDestination.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		String currentLocation = player.getSelectedShip().getLocation().getName();
		frmSelectDestination = new JFrame();
		frmSelectDestination.setTitle("Select Destination");
		frmSelectDestination.setBounds(100, 100, 616, 722);
		frmSelectDestination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectDestination.getContentPane().setLayout(null);
		frmSelectDestination.setLocationRelativeTo(null);
		
		panelSelectIsland = new JPanel();
		panelSelectIsland.setLayout(null);
		panelSelectIsland.setBounds(0, 0, 600, 633);
		frmSelectDestination.getContentPane().add(panelSelectIsland);
		
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
		lblMap.setIcon(new ImageIcon(SelectDestinationWindow.class.getResource("/Images/Base Map.png")));
		lblMap.setBounds(0, 0, 600, 600);
		panelMap.add(lblMap);
		
		JButton btnSelectRoute = new JButton("Select a Route");
		btnSelectRoute.setBounds(407, 644, 183, 29);
		frmSelectDestination.getContentPane().add(btnSelectRoute);
		
		JButton btnMainMenu = new JButton("Return to the Main Menu");
		btnMainMenu.setBounds(10, 644, 183, 29);
		frmSelectDestination.getContentPane().add(btnMainMenu);
		
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitSelectDestination();
			}
		});
		
		btnSelectRoute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Island destination = game.getIslands().get(0);
				boolean selectSuccess = true;
				if (rdbtnArborlandIslet.isSelected()) {
					for (Island i:game.getIslands()) {
						if (i.getName() == "Arborland Islet") {
							destination = i;
						}
					}
				} else if (rdbtnCrosserPeninsula.isSelected()) {
					for (Island i:game.getIslands()) {
						if (i.getName() == "Crosser Peninsula") {
							destination = i;
						}
					}
				} else if (rdbtnRainingArchipelago.isSelected()) {
					for (Island i:game.getIslands()) {
						if (i.getName() == "Raining Archipelago") {
							destination = i;
						}
					}
				} else if (rdbtnRemoteRefuge.isSelected()) {
					for (Island i:game.getIslands()) {
						if (i.getName() == "Remote Refuge") {
							destination = i;
						}
					}
				} else if (rdbtnBrightwichIsland.isSelected()) {
					for (Island i:game.getIslands()) {
						if (i.getName() == "Brightwich Island") {
							destination = i;
						}
					}
				} else {
					JOptionPane.showMessageDialog(popup, "Please select a destination");
					selectSuccess = false;
				}
				
				if (selectSuccess) {
					game.openSelectRoute(destination);
				}
			}
		});
		
		
	}
}
