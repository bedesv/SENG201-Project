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

public class MainWindow {

	private JFrame frame;

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
		JButton btnship1 = new JButton("Ship 1");
		btnship1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(1);
			}
		});
		
		JButton btnship2 = new JButton("Ship 2");
		btnship2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(2);
			}
		});
		
		JButton btnship3 = new JButton("Ship 3");
		btnship3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment.initShips(3);
			}
		});
		
		JButton btnship4 = new JButton("Ship 4");
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
					JOptionPane.showMessageDialog(null, ship.getName() + " is selected.", "Title", JOptionPane.PLAIN_MESSAGE);
					lblShipSelected.setText("You have selected: " + ship.getName());
				}
				}
				
		});
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnship1)
										.addComponent(btnship3))
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnship4)
										.addComponent(btnship2)))
								.addComponent(lblShipSelected, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSelectShip, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnViewShip))))
					.addContainerGap(202, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnship1)
						.addComponent(btnship2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnship3)
						.addComponent(btnship4))
					.addGap(18)
					.addComponent(btnViewShip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelectShip)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblShipSelected, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
