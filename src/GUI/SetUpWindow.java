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
	private JTextField textChooseName;
	private JTextField textChooseDays;
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetUp = new JFrame();
		frmSetUp.setTitle("Set Up");
		frmSetUp.setBounds(100, 100, 450, 300);
		frmSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GameEnvironment.initGame();
		
		JRadioButton rdbtnShip1 = new JRadioButton("Delight");
		rdbtnShip1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(1);
			}
		});
		
		JRadioButton rdbtnShip2 = new JRadioButton("Defender");
		rdbtnShip2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(2);
			}
		});
		
		JRadioButton rdbtnShip3 = new JRadioButton("Mantis");
		rdbtnShip3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(3);
			}
		});
		
		JRadioButton rdbtnShip4 = new JRadioButton("Pioneer");
		rdbtnShip4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(4);
			}
		});
		
		JButton btnViewShip = new JButton("View Ship");
		btnViewShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ship ship = GameEnvironment.ships.get(0);
				JOptionPane.showMessageDialog(null, ship, ship.getName() + "'s property", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JLabel lblShipSelected = new JLabel("You have not selected a ship.");
		
		JButton btnSelectShip = new JButton("Select Ship");
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
		
		JRadioButton rdbtnHomeIsland1 = new JRadioButton("Arborland Islet");
		rdbtnHomeIsland1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.selectStartingIsland(1);
				Island island = GameEnvironment.islands.get(0);
				JOptionPane.showMessageDialog(null, island, island.getName() + "'s property", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JRadioButton rdbtnHomeIsland2 = new JRadioButton("Crosser Peninsula");
		
		JRadioButton rdbtnHomeIsland3 = new JRadioButton("Raining Archipelago");
		
		JRadioButton rdbtnHomeIsland4 = new JRadioButton("Remote Refuge");
		
		JRadioButton rdbtnHomeIsland5 = new JRadioButton("Brightwich Island");
		
		JLabel lblChooseHomeIsland = new JLabel("Choose your Home Island below");
		
		JButton btnToMain = new JButton("Play Game");
		
		JLabel lblYourName = new JLabel("Your Name:");
		
		textYourName = new JTextField();
		textYourName.setColumns(10);
		
		JLabel lblDays = new JLabel("Days:");
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(10);
		
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmSetUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addComponent(btnSelectShip, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblShipSelected, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnShip1)
												.addComponent(rdbtnShip3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(rdbtnShip4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(rdbtnShip2, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(34))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(btnViewShip)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnHomeIsland1)
						.addComponent(rdbtnHomeIsland2)
						.addComponent(rdbtnHomeIsland3)
						.addComponent(rdbtnHomeIsland4)
						.addComponent(rdbtnHomeIsland5)
						.addComponent(lblChooseHomeIsland))
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYourName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textYourName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDays)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addComponent(btnToMain)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblYourName)
							.addComponent(textYourName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDays))
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnShip1)
						.addComponent(rdbtnShip2)
						.addComponent(lblChooseHomeIsland))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnShip3)
						.addComponent(rdbtnShip4)
						.addComponent(rdbtnHomeIsland1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnHomeIsland2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHomeIsland3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHomeIsland4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHomeIsland5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnViewShip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSelectShip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblShipSelected, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnToMain)
					.addGap(5))
		);
		frmSetUp.getContentPane().setLayout(groupLayout);
	}
}