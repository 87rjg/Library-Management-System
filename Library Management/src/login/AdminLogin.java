package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import homepage.Home;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 302, 253);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 291, 39);
		frame.getContentPane().add(panel);
		
		JLabel lblAdminCentralLibrary = new JLabel("Admin Central Library");
		lblAdminCentralLibrary.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblAdminCentralLibrary.setBounds(57, 11, 177, 28);
		panel.add(lblAdminCentralLibrary);
		
		JLabel lblAdminId = new JLabel("Admin ID");
		lblAdminId.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblAdminId.setBounds(34, 66, 89, 16);
		frame.getContentPane().add(lblAdminId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblPassword.setBounds(34, 107, 89, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(133, 64, 109, 20);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		passwordField.setEchoChar('*');
		passwordField.setBounds(133, 105, 107, 20);
		frame.getContentPane().add(passwordField);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String admin_id = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				
				if(textField.getText().equalsIgnoreCase("admin"))
					{
					   if(pass.equals("admin123"))
					   {
						   Home.getPost("Admin");
						   frame.dispose();
						   
					   }
					   else
						   JOptionPane.showMessageDialog(button, "Wrong User Name & Password! Try Again");
					}
				else
				{
					JOptionPane.showMessageDialog(button, "Wrong User Name! Try Again");
				}
				
			}
		});
		button.setFont(new Font("Sitka Text", Font.BOLD, 15));
		button.setBounds(34, 147, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnCancel.setBounds(133, 147, 109, 23);
		frame.getContentPane().add(btnCancel);
	}
}
