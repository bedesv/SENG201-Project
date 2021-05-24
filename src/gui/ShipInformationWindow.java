package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class ShipInformationWindow {

	private JFrame frmShipInformationWindow;


	/**
	 * Create the application.
	 */
	public ShipInformationWindow() {
		
	}
	
	public void open(Game game) {
		initialize(game);
		frmShipInformationWindow.setVisible(true);
	}
	
	public void close() {
		frmShipInformationWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frmShipInformationWindow.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		Player player = game.getPlayer();
		frmShipInformationWindow = new JFrame();
		frmShipInformationWindow.setBounds(100, 100, 489, 380);
		frmShipInformationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShipInformationWindow.setLocationRelativeTo(null);
		frmShipInformationWindow.getContentPane().setLayout(null);
		
		JPanel weaponsOwnedPanel = new JPanel();
		weaponsOwnedPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Owned", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsOwnedPanel.setBounds(24, 152, 428, 119);
		frmShipInformationWindow.getContentPane().add(weaponsOwnedPanel);
		
		String[] weaponTableHeader = {"Weapon", "Description", "Size"};
		ArrayList<Weapon> weaponsOwnedArray = player.getSelectedShip().getWeaponsBought();
		
		JScrollPane weaponsToSellScrollPane = new JScrollPane();
		GroupLayout gl_weaponsOwnedPanel = new GroupLayout(weaponsOwnedPanel);
		gl_weaponsOwnedPanel.setHorizontalGroup(
			gl_weaponsOwnedPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addComponent(weaponsToSellScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
		);
		gl_weaponsOwnedPanel.setVerticalGroup(
			gl_weaponsOwnedPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addComponent(weaponsToSellScrollPane, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsOwnedModel = new DefaultTableModel(weaponTableHeader, 0);
		JTable weaponsOwnedTable = new JTable(weaponsOwnedModel);
		weaponsToSellScrollPane.setViewportView(weaponsOwnedTable);
		weaponsOwnedPanel.setLayout(gl_weaponsOwnedPanel);
		
		// Set column widths for the weapons to sell table
		weaponsOwnedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JPanel panelMainMenuButton = new JPanel();
		panelMainMenuButton.setBounds(10, 282, 453, 47);
		frmShipInformationWindow.getContentPane().add(panelMainMenuButton);
		panelMainMenuButton.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(130, 0, 193, 47);
		panelMainMenuButton.add(btnMainMenu);
		
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitShipInformation();
			}
		});
		
		JTextArea textAreaShipInfo = new JTextArea();
		textAreaShipInfo.setBackground(SystemColor.menu);
		textAreaShipInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAreaShipInfo.setBounds(85, 22, 306, 119);
		frmShipInformationWindow.getContentPane().add(textAreaShipInfo);
		Ship ship = player.getSelectedShip();
		String shipName = ship.getName();
		int shipCrew = ship.getCrew();
		int sailCost = ship.getCostToSail(1);
		int currCapacity = ship.getCurrCapacity();
		int maxCapacity = ship.getMaxCapacity();
		int shipDamage = ship.getCurrentDamage();
		int repairCost = ship.getRepairCost();
		String shipInfo = String.format("Ship Name:\t\t%s\n"
									  + "Total Crew:\t\t%d\n"
									  + "Cost/Day Sailing\t%d coins\n"
									  + "Ship Capacity\t\t%d\\%d\n"
									  + "Ship Damage\t\t%d\n"
									  + "Cost to Repair Ship\t%d coins", shipName, shipCrew, sailCost, currCapacity, maxCapacity, shipDamage, repairCost);
		
		textAreaShipInfo.setText(shipInfo);
		
		
		weaponsOwnedTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		weaponsOwnedTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsOwnedPanel.getWidth() - (90 + 35 + 20));
		weaponsOwnedTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		
		// Add weapons to sell to the table
		for (Weapon weapon: weaponsOwnedArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize()};
			weaponsOwnedModel.addRow(temp);
		}
	}

}
