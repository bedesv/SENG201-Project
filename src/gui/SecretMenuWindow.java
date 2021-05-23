package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SecretMenuWindow {

	private JFrame frmSecretMenuWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretMenuWindow window = new SecretMenuWindow();
					window.frmSecretMenuWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecretMenuWindow() {
	}
	
	public void open(Game game) {
		initialize(game);
		frmSecretMenuWindow.setVisible(true);
	}
	
	public void close() {
		frmSecretMenuWindow.setVisible(false);
	}

	/**
	 * Initialize the contents of the frmSecretMenuWindow.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Game game) {
		Player player = game.getPlayer();
		frmSecretMenuWindow = new JFrame();
		frmSecretMenuWindow.setBounds(100, 100, 385, 519);
		frmSecretMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecretMenuWindow.getContentPane().setLayout(null);
		frmSecretMenuWindow.setLocationRelativeTo(null);
		
		JPanel panelInformation = new JPanel();
		panelInformation.setBounds(66, 11, 252, 161);
		frmSecretMenuWindow.getContentPane().add(panelInformation);
		panelInformation.setLayout(null);
		
		JLabel lblCoins = new JLabel("Coins: " + player.getCoins());
		lblCoins.setBounds(0, 35, 142, 35);
		panelInformation.add(lblCoins);
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCapacity = new JLabel("Ship Capacity: " + player.getShipCapacity());
		lblCapacity.setBounds(0, 62, 285, 35);
		panelInformation.add(lblCapacity);
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAttack = new JLabel("Attack Multiplier:\t" + player.getSelectedShip().getDefenceMultiplier());
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAttack.setBounds(0, 97, 285, 35);
		panelInformation.add(lblAttack);
		
		JLabel lblDefence = new JLabel("Defence Multiplier:\t" + player.getSelectedShip().getDefenceMultiplier());
		lblDefence.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDefence.setBounds(0, 126, 285, 35);
		panelInformation.add(lblDefence);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(66, 183, 213, 286);
		frmSecretMenuWindow.getContentPane().add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnMainMenu = new JButton("Return to Main Menu");
		btnMainMenu.setBounds(0, 235, 213, 43);
		panelButtons.add(btnMainMenu);
		
		JButton btnAddCoins = new JButton("Plus 1000 Coins");
		btnAddCoins.setBounds(0, 175, 213, 43);
		panelButtons.add(btnAddCoins);
		
		JButton btnAddInventory = new JButton("Plus 10 Inventory Space");
		btnAddInventory.setBounds(0, 117, 213, 43);
		panelButtons.add(btnAddInventory);
		
		JButton btnAddDefenceMult = new JButton("Plus 1 Defence Multiplier");
		btnAddDefenceMult.setBounds(0, 59, 213, 43);
		panelButtons.add(btnAddDefenceMult);
		
		JButton btnAddAttackMult = new JButton("Plus 1 Attack Multiplier");
		btnAddAttackMult.setBounds(0, 1, 213, 43);
		panelButtons.add(btnAddAttackMult);
		
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					game.exitSecretMenu();
			}
		});

		btnAddDefenceMult.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				player.getSelectedShip().increaseDefenceMult();
				lblDefence.setText("Defence Multiplier:\t" + player.getSelectedShip().getDefenceMultiplier());
				if (player.getSelectedShip().getDefenceMultiplier() == 30) {
					btnAddDefenceMult.setEnabled(false);
				}
			}
		});

		btnAddAttackMult.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				player.getSelectedShip().increaseAttackMult();
				lblAttack.setText("Attack Multiplier:\t" + player.getSelectedShip().getAttackMultiplier());
				if (player.getSelectedShip().getAttackMultiplier() == 30) {
					btnAddAttackMult.setEnabled(false);
				}
			}
		});
		
		btnAddCoins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					player.getSelectedShip().addCoins(1000);
					lblCoins.setText("Coins:\t" + player.getCoins());
			}
		});
		
		btnAddInventory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					player.getSelectedShip().increaseInventoryCapacity();
					lblCapacity.setText("Ship Capacity:\t" + player.getShipCapacity());
			}
		});
	}

}
