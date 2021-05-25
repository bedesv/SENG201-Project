package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backEnd.Game;
import backEnd.Player;
import backEnd.Ship;
import backEnd.Weapon;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;

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
	@SuppressWarnings("serial")
	private void initialize(Game game) {
		
		Player player = game.getPlayer();
		Ship ship = player.getSelectedShip();
		frmShipInformationWindow = new JFrame();
		frmShipInformationWindow.setBounds(100, 100, 489, 575);
		frmShipInformationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShipInformationWindow.setLocationRelativeTo(null);
		frmShipInformationWindow.getContentPane().setLayout(null);
		frmShipInformationWindow.setTitle(ship.getName());
		
		
		JPanel weaponsOwnedPanel = new JPanel();
		weaponsOwnedPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Owned", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsOwnedPanel.setBounds(33, 353, 428, 119);
		frmShipInformationWindow.getContentPane().add(weaponsOwnedPanel);
		
		String[] weaponTableHeader = {"Weapon", "Description", "Size"};
		ArrayList<Weapon> weaponsOwnedArray = player.getSelectedShip().getWeaponsBought();
		
		JScrollPane weaponsOwnedScrollPane = new JScrollPane();
		GroupLayout gl_weaponsOwnedPanel = new GroupLayout(weaponsOwnedPanel);
		gl_weaponsOwnedPanel.setHorizontalGroup(
			gl_weaponsOwnedPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addComponent(weaponsOwnedScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
		);
		gl_weaponsOwnedPanel.setVerticalGroup(
			gl_weaponsOwnedPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addComponent(weaponsOwnedScrollPane, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		
		DefaultTableModel weaponsOwnedModel = new DefaultTableModel(weaponTableHeader, 0) {
			/**
			 * A method that prevents the editing of the table. 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	    };
		JTable weaponsOwnedTable = new JTable(weaponsOwnedModel);
		weaponsOwnedTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		weaponsOwnedScrollPane.setViewportView(weaponsOwnedTable);
		weaponsOwnedPanel.setLayout(gl_weaponsOwnedPanel);
		
		JPanel panelMainMenuButton = new JPanel();
		panelMainMenuButton.setBounds(19, 483, 453, 47);
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
		textAreaShipInfo.setBackground(UIManager.getColor("Button.background"));
		textAreaShipInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAreaShipInfo.setBounds(94, 223, 306, 119);
		frmShipInformationWindow.getContentPane().add(textAreaShipInfo);
		
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
		
		JLabel lblShipImage = new JLabel("");
		lblShipImage.setBounds(94, 11, 300, 200);
		frmShipInformationWindow.getContentPane().add(lblShipImage);
		lblShipImage.setIcon(new ImageIcon(SetupWindow.class.getResource("/Images/Delight.jpg")));
		//lblShipImage.setIcon(new ImageIcon(SetupWindow.class.getResource(ship.getImgString())));
		
		
		
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
