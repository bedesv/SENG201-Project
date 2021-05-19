package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import main.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class SetUpWindow {

	private JFrame frmSetUp;
	private JTextField textYourName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpWindow window = new SetUpWindow();
					window.frmSetUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetUpWindow() {
		initialize();
	}
	
	private void setShip(int mode) {
		GameEnvironment.initShips(mode);
	}
	
	int island_index = -1;
	private void viewIsland(int mode) {
		//GameEnvironment.selectStartingIsland(island_index);
		Island island = GameEnvironment.islands.get(mode);
		JOptionPane.showMessageDialog(null, island, island.getName() + "'s property", JOptionPane.PLAIN_MESSAGE);
		island_index = mode;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetUp = new JFrame();
		frmSetUp.setTitle("Set Up");
		frmSetUp.setBounds(6, -31, 497, 348);
		frmSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GameEnvironment.initGame();
		
		JLabel lblYourName = new JLabel("Your Name:");
		lblYourName.setBounds(6, 56, 73, 16);
		
		textYourName = new JTextField();
		textYourName.setBounds(85, 51, 130, 26);
		textYourName.setColumns(10);
		
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(233, 56, 35, 16);
		
		
		JSlider sliderDays = new JSlider();
		sliderDays.setBounds(274, 39, 217, 38);
		sliderDays.setMajorTickSpacing(10);
		sliderDays.setPaintTicks(true);
		sliderDays.setSnapToTicks(true);
		sliderDays.setMinorTickSpacing(1);
		sliderDays.setMinimum(10);
		
		JRadioButton rdbtnShip1 = new JRadioButton("Delight");
		rdbtnShip1.setBounds(28, 108, 78, 23);
		rdbtnShip1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShip(1);
			}
		});
		
		JRadioButton rdbtnShip2 = new JRadioButton("Defender");
		rdbtnShip2.setBounds(141, 108, 98, 23);
		rdbtnShip2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShip(2);
			}
		});
		
		JRadioButton rdbtnShip3 = new JRadioButton("Mantis");
		rdbtnShip3.setBounds(28, 143, 78, 23);
		rdbtnShip3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShip(3);
			}
		});
		
		JRadioButton rdbtnShip4 = new JRadioButton("Pioneer");
		rdbtnShip4.setBounds(141, 143, 98, 23);
		rdbtnShip4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShip(4);
			}
		});
		
		JButton btnViewShip = new JButton("View Ship");
		btnViewShip.setBounds(70, 178, 104, 29);
		btnViewShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ship ship = GameEnvironment.ships.get(0);
				JOptionPane.showMessageDialog(null, ship, ship.getName() + "'s property", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JLabel lblShipSelected = new JLabel("You have not selected a ship.");
		lblShipSelected.setBounds(28, 248, 211, 27);
		
		JButton btnSelectShip = new JButton("Select Ship");
		btnSelectShip.setBounds(70, 213, 104, 29);
		btnSelectShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ship ship = GameEnvironment.ships.get(0);
				int selectConfirm = JOptionPane.showInternalConfirmDialog(null, "You've selected " + ship.getName() + ". Is this correct?");
				if (selectConfirm == 0) {
					JOptionPane.showMessageDialog(null, ship.getName() + " is selected.", "", JOptionPane.PLAIN_MESSAGE);
					lblShipSelected.setText("You have selected: " + ship.getName());
				}
				}
				
		});
		
		// Islands
		
		JRadioButton rdbtnHomeIsland1 = new JRadioButton("Arborland Islet");
		rdbtnHomeIsland1.setBounds(273, 143, 125, 23);
		rdbtnHomeIsland1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewIsland(0);
			}
		});
		
		JRadioButton rdbtnHomeIsland2 = new JRadioButton("Crosser Peninsula");
		rdbtnHomeIsland2.setBounds(273, 172, 144, 23);
		rdbtnHomeIsland2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewIsland(1);
			}
		});
		
		JRadioButton rdbtnHomeIsland3 = new JRadioButton("Raining Archipelago");
		rdbtnHomeIsland3.setBounds(273, 201, 158, 23);
		rdbtnHomeIsland3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewIsland(2);
			}
		});
		
		JRadioButton rdbtnHomeIsland4 = new JRadioButton("Remote Refuge");
		rdbtnHomeIsland4.setBounds(273, 230, 126, 23);
		rdbtnHomeIsland4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewIsland(3);
			}
		});
		
		JRadioButton rdbtnHomeIsland5 = new JRadioButton("Brightwich Island");
		rdbtnHomeIsland5.setBounds(273, 259, 140, 23);
		rdbtnHomeIsland5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewIsland(4);
			}
		});
		
		JLabel lblChooseHomeIsland = new JLabel("Choose your Home Island below");
		lblChooseHomeIsland.setBounds(273, 112, 203, 16);
		
		JButton btnToMain = new JButton("Play Game");
		btnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textYourName.getText();
				int days = sliderDays.getValue();
				System.out.println(island_index);
				GameEnvironment.selectStartingIsland(island_index); 
				GameEnvironment.name = name;
				
				MainGame game = new MainGame();
				game.frmMainGame.setVisible(true);
				
				frmSetUp.dispose();
			}
		});
		btnToMain.setBounds(181, 288, 108, 29);
		
		
		
		
		frmSetUp.getContentPane().setLayout(null);
		frmSetUp.getContentPane().add(btnSelectShip);
		frmSetUp.getContentPane().add(btnViewShip);
		frmSetUp.getContentPane().add(lblShipSelected);
		frmSetUp.getContentPane().add(rdbtnShip1);
		frmSetUp.getContentPane().add(rdbtnShip3);
		frmSetUp.getContentPane().add(rdbtnShip4);
		frmSetUp.getContentPane().add(rdbtnShip2);
		frmSetUp.getContentPane().add(rdbtnHomeIsland1);
		frmSetUp.getContentPane().add(rdbtnHomeIsland2);
		frmSetUp.getContentPane().add(rdbtnHomeIsland3);
		frmSetUp.getContentPane().add(rdbtnHomeIsland4);
		frmSetUp.getContentPane().add(rdbtnHomeIsland5);
		frmSetUp.getContentPane().add(lblChooseHomeIsland);
		frmSetUp.getContentPane().add(lblYourName);
		frmSetUp.getContentPane().add(textYourName);
		frmSetUp.getContentPane().add(lblDays);
		frmSetUp.getContentPane().add(sliderDays);
		frmSetUp.getContentPane().add(btnToMain);
	}
}