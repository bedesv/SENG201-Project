package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;

public class StoreWindow {

	private JFrame storeWindowFrame;
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
	private JButton btnSellItem;
	private JButton btnSellWeapon;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StoreWindow window = new StoreWindow();
//					window.storeWindowFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public StoreWindow(Player player) {
		initialize(player);
		storeWindowFrame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player player) {
		storeWindowFrame = new JFrame();
		storeWindowFrame.setBounds(100, 100, 998, 688);
		storeWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storeWindowFrame.getContentPane().setLayout(null);
		Store store = player.selectedShip.getLocation().getStore();
		String[] itemTableHeaders = {"Item", "Description", "Size", "Price"};
		String[] weaponTableHeaders = {"Weapon", "Description", "Size", "Price"};
		ArrayList<Item> itemsToBuyArray = store.getItemsSold();
		ArrayList<Item> itemsToSellArray = new ArrayList<Item>();
		
		ArrayList<Weapon> weaponsToBuyArray = store.getWeaponsSold();
		ArrayList<Weapon> weaponsToSellArray = new ArrayList<Weapon>();
		
		for (Item i:player.selectedShip.getInventory()) {
			if (store.buysItem(i)) {
				itemsToSellArray.add(i);
			}
		}
		
		for (Weapon w:player.selectedShip.getWeapons()) {
			if (store.buysWeapon(w)) {
				weaponsToSellArray.add(w);
			}
		}
		
		weaponsToSellPanel = new JPanel();
		weaponsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToSellPanel.setBounds(509, 335, 450, 250);
		storeWindowFrame.getContentPane().add(weaponsToSellPanel);
		
		weaponsToSellScrollPane = new JScrollPane();
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
		
		DefaultTableModel weaponsToSellModel = new DefaultTableModel(weaponTableHeaders, 0);
		weaponsToSellTable = new JTable(weaponsToSellModel);
		weaponsToSellScrollPane.setViewportView(weaponsToSellTable);
		weaponsToSellPanel.setLayout(gl_weaponsToSellPanel);
		
		weaponsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		weaponsToSellTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToSellPanel.getWidth() - (85 + 35 + 40 + 15));
		weaponsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		for (Weapon weapon: weaponsToSellArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), store.getSalePrice(weapon)};
			weaponsToSellModel.addRow(temp);
		}
		
		weaponsToBuyPanel = new JPanel();
		weaponsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Weapons Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		weaponsToBuyPanel.setBounds(509, 24, 450, 250);
		storeWindowFrame.getContentPane().add(weaponsToBuyPanel);
		
		weaponsToBuyScrollPane = new JScrollPane();
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
		
		DefaultTableModel weaponsToBuyModel = new DefaultTableModel(weaponTableHeaders, 0);
		weaponsToBuyTable = new JTable(weaponsToBuyModel);
		weaponsToBuyScrollPane.setViewportView(weaponsToBuyTable);
		weaponsToBuyPanel.setLayout(gl_weaponsToBuyPanel);
		
		weaponsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		weaponsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		weaponsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(weaponsToBuyPanel.getWidth() - (85 + 35 + 40 + 15));
		weaponsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		weaponsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		for (Weapon weapon: weaponsToBuyArray) {
			Object[] temp = {weapon.getName(), weapon.getDescription(), weapon.getSize(), weapon.getPrice()};
			weaponsToBuyModel.addRow(temp);
		}
		
		itemsToSellPanel = new JPanel();
		itemsToSellPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Sell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToSellPanel.setBounds(24, 335, 450, 250);
		storeWindowFrame.getContentPane().add(itemsToSellPanel);
		
		itemsToSellScrollPane = new JScrollPane();
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
		DefaultTableModel itemsToSellModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToSellTable = new JTable(itemsToSellModel);
		itemsToSellScrollPane.setViewportView(itemsToSellTable);
		itemsToSellPanel.setLayout(gl_itemsToSellPanel);
		
		itemsToSellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		itemsToSellTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToSellTable.getColumnModel().getColumn(1).setPreferredWidth((int)itemsToSellPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToSellTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToSellTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		
		for (Item item: itemsToSellArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), store.getSalePrice(item)};
			itemsToSellModel.addRow(temp);
		}
		
		JPanel itemsToBuyPanel = new JPanel();
		itemsToBuyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Items Available to Buy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemsToBuyPanel.setBounds(24, 24, 450, 250);
		storeWindowFrame.getContentPane().add(itemsToBuyPanel);
		
		JScrollPane itemsToBuyScrollPane = new JScrollPane();
		GroupLayout gl_itemsToBuyPanel = new GroupLayout(itemsToBuyPanel);
		gl_itemsToBuyPanel.setHorizontalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		gl_itemsToBuyPanel.setVerticalGroup(
			gl_itemsToBuyPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemsToBuyScrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
		);
		
		DefaultTableModel itemsToBuyModel = new DefaultTableModel(itemTableHeaders, 0);
		itemsToBuyTable = new JTable(itemsToBuyModel);
		itemsToBuyScrollPane.setViewportView(itemsToBuyTable);
		itemsToBuyPanel.setLayout(gl_itemsToBuyPanel);
		itemsToBuyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnBuyItem = new JButton("Buy Item");
		btnBuyItem.setBounds(199, 284, 100, 40);
		storeWindowFrame.getContentPane().add(btnBuyItem);
		
		JButton btnBuyWeapon = new JButton("Buy Weapon");
		btnBuyWeapon.setBounds(684, 285, 100, 40);
		storeWindowFrame.getContentPane().add(btnBuyWeapon);
		
		btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(199, 595, 100, 40);
		storeWindowFrame.getContentPane().add(btnSellItem);
		
		btnSellWeapon = new JButton("Sell Weapon");
		btnSellWeapon.setBounds(684, 596, 100, 40);
		storeWindowFrame.getContentPane().add(btnSellWeapon);
		itemsToBuyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		itemsToBuyTable.getColumnModel().getColumn(1).setPreferredWidth(itemsToBuyPanel.getWidth() - (50 + 35 + 40 + 15));
		itemsToBuyTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		itemsToBuyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		for (Item item: itemsToBuyArray) {
			Object[] temp = {item.getName(), item.getDescription(), item.getSize(), item.getPrice()};
			itemsToBuyModel.addRow(temp);
		}
		
	}
}
