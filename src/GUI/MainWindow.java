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

public class MainWindow {

	private JFrame frame;
	private JTextField textChooseName;
	private JTextField textChooseDays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GameEnvironment.initGame();
		JButton btnship1 = new JButton("Delight");
		btnship1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(1);
			}
		});
		
		JButton btnship2 = new JButton("Defender");
		btnship2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(2);
			}
		});
		
		JButton btnship3 = new JButton("Mantis");
		btnship3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(3);
			}
		});
		
		JButton btnship4 = new JButton("Pioneer");
		btnship4.addActionListener(new ActionListener() {
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
		
		JButton btnIsland1 = new JButton("Arborland Islet");
		btnIsland1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnIsland1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.selectStartingIsland(1);
				Island island = GameEnvironment.islands.get(0);
				JOptionPane.showMessageDialog(null, island, island.getName() + "'s property", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton btnIsland2 = new JButton("Crosser Peninsula");
		btnIsland2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JButton btnIsland3 = new JButton("Raining Archipelago");
		btnIsland3.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JButton btnIsland4 = new JButton("Remote Refuge");
		btnIsland4.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JButton btnIsland5 = new JButton("Remote Refuge");
		btnIsland5.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnship1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(btnship3, Alignment.LEADING))
									.addGap(49)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnship2, 0, 0, Short.MAX_VALUE)
										.addComponent(btnship4, GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSelectShip, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnViewShip))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblShipSelected, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(38)))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnIsland2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIsland1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIsland4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIsland5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIsland3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addGap(41))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnship1)
						.addComponent(btnship2))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnship3)
								.addComponent(btnship4))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
							.addComponent(btnIsland1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIsland2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnViewShip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSelectShip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblShipSelected, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnIsland3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(52))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(btnIsland4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIsland5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}