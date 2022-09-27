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
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private JPanel panelCenter;
	private JButton btnNewButton;
	private JLabel lblBackgroundPicture;
	private JLabel lblInsert;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	
	List<String> destinations = Utility.findDestinations("destinations.txt");
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	
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

		Collections.sort(destinations);
		for(String s : destinations) {
			comboBox.addItem(s);
		}
		
	}

	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getBtnNewButton());
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
			panelCenter.add(getComboBox());
		}
		return panelCenter;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Search");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return btnNewButton;
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
			lblInsert = new JLabel("Molimo unesite destinaciju koja Vas interesuje:");
			lblInsert.setBounds(177, 253, 286, 14);
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
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(208, 287, 162, 22);
		}
		return comboBox;
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
}
