package main;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SignIn extends JDialog {
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnCreate;
	private JButton btnCancel;

	private String username, password;
	SignIn signIn = this;
	boolean made = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn dialog = new SignIn();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SignIn(JFrame owner, boolean modal) {
		super(owner, modal);
		setResizable(false);
		setTitle("Sign In");
		setBounds(100, 100, 402, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTextUsername());
		getContentPane().add(getTextPassword());
		getContentPane().add(getBtnCreate());
		getContentPane().add(getBtnCancel());

	}
	public boolean showDialog() {
		signIn.setVisible(true);
		dispose();
		return made;
	}
	
	public SignIn() {
		setResizable(false);
		setTitle("Sign In");
		setBounds(300, 200, 402, 300);
		
		getContentPane().setLayout(null);
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTextUsername());
		getContentPane().add(getTextPassword());
		getContentPane().add(getBtnCreate());
		getContentPane().add(getBtnCancel());
		this.addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	            e.getWindow().dispose();
	        }
	    });
	}
	private JLabel getLabel_1() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(62, 59, 64, 14);
		}
		return lblUsername;
	}
	private JLabel getLabel_2() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(62, 111, 64, 14);
		}
		return lblPassword;
	}
	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setBounds(136, 56, 153, 20);
			textUsername.setColumns(10);
		}
		return textUsername;
	}
	private JTextField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextField();
			textPassword.setBounds(136, 108, 153, 20);
			textPassword.setColumns(10);
		}
		return textPassword;
	}
	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton("Create");
			btnCreate.setBounds(62, 184, 89, 23);
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					username = textUsername.getText();
					password = textPassword.getText();
					made = true;
					Utility.addNewUser(username, password);
					JOptionPane.showMessageDialog(signIn, "A simple Swing application inspired by the life and work of John Lennon.");
					signIn.setVisible(false);
					dispose();
				}
			});
		}
		return btnCreate;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					signIn.setVisible(false);
				}
			});
			btnCancel.setBounds(189, 184, 89, 23);
		}
		return btnCancel;
	}
}
