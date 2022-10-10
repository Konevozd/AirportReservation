package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class ShowCountryDestinations extends JDialog {

	private String smth = "";
	private ShowCountryDestinations showCD = this;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton kapricoza;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ShowCountryDestinations dialog = new ShowCountryDestinations();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShowCountryDestinations(JFrame owner, boolean modal) {
		super(owner, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setLayout(new FlowLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton okButton = new JButton("OK");
//				okButton.setActionCommand("OK");
//				buttonPane.add(okButton);
//				getRootPane().setDefaultButton(okButton);
//			}
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
//		}
	}
	
	public String showDialog() {
		showCD.setVisible(true);
		dispose();
		return smth;
	}
	
	public ShowCountryDestinations() {
		setResizable(false);
		setTitle("Our destinations");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_2(), BorderLayout.CENTER);
		this.addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	            e.getWindow().dispose();
	        }
	    });
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getLblNewLabel_1());
			panel_2.add(getLblNewLabel());
		}
		return panel_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(163, 36, 129, 86);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(30, 24, 90, 110);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pizza");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_2.removeAll();
					
					panel_2.add(getKapricoza());
					panel_2.add(getSerbiana());
					
					panel_2.revalidate();
					panel_2.repaint();
//					showCD.pack();
				}
			});
		}
		return btnNewButton;
	}
	public JButton getKapricoza() {
		if(kapricoza == null) {
			kapricoza = new JButton("Kapricoza");
			kapricoza.setFont(new Font("Times New Roman", Font.BOLD, 10));
			kapricoza.setBounds(50, 30, 90, 30);
		}
		return kapricoza;
	}
	private JButton serbiana;
	private JButton getSerbiana() {
		if(serbiana == null) {
			serbiana = new JButton("Serbiana");
			serbiana.setFont(new Font("Times New Roman", Font.BOLD, 10));
			serbiana.setBounds(150, 30, 90, 30);
		}
		return serbiana;
	}
}
