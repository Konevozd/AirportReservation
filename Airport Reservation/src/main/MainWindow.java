package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private JPanel panelCenter;
	private JLabel lblBackgroundPicture;
	private JLabel lblInsert;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnLogIn;
	
//	private List<String> destinations = Utility.findDestinations("destinations.txt");
	private HashMap<String, String> users;
	private String smth;
	MainWindow main = this;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setTitle("Destinations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 432);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);

//		Collections.sort(destinations);
//		for(String s : destinations) {
//			comboBox.addItem(s);
//		}
		
	}

	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getBtnLogIn());
		}
		return panelSouth;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(null);
			panelCenter.add(getLblBackgroundPicture());
			panelCenter.add(getLblInsert());
			panelCenter.add(getLblNewLabel());
			panelCenter.add(getTextUsername());
			panelCenter.add(getTextPassword());
			panelCenter.add(getLblNewLabel_1());
			panelCenter.add(getBtnNewButton());
		}
		return panelCenter;
	}
	private JLabel getLblBackgroundPicture() {
		if (lblBackgroundPicture == null) {
			lblBackgroundPicture = new JLabel("");
			lblBackgroundPicture.setBounds(87, 46, 413, 192);
			ImageIcon bcg = new ImageIcon("resources\\backgroundResize.jpg");
			lblBackgroundPicture.setIcon(bcg);;
		}
		return lblBackgroundPicture;
	}
	private JLabel getLblInsert() {
		if (lblInsert == null) {
			lblInsert = new JLabel("Molimo unesite Vase korisnicko ime i lozinku:");
			lblInsert.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblInsert.setBounds(10, 249, 228, 56);
		}
		return lblInsert;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Dobrodosli");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBounds(242, 11, 128, 24);
		}
		return lblNewLabel;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("About");
		}
		return mnNewMenu_1;
	}
	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setBounds(244, 254, 111, 20);
			textUsername.setColumns(10);
		}
		return textUsername;
	}
	private JTextField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextField();
			textPassword.setBounds(242, 285, 111, 20);
			textPassword.setColumns(10);
		}
		return textPassword;
	}
	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = textUsername.getText();
					String password = textPassword.getText();
					users = Utility.loadHashMap("users.txt");
					for(Map.Entry<String, String> map : users.entrySet()) {
						if(map.getKey().equals(username) && map.getValue().equals(password)) {
							main.setVisible(false);
							main.dispose();
							smth = (new ShowCountryDestinations(main, true)).showDialog();
							
						}
					}
					textUsername.setText("");
					textPassword.setText("");
				}
			});
		}
		return btnLogIn;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Sign in");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean made = (new SignIn(main, true)).showDialog();
					
				}
			});
			btnNewButton.setBounds(436, 284, 63, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Don't have an account?");
			lblNewLabel_1.setBounds(412, 249, 162, 14);
		}
		return lblNewLabel_1;
	}
}
