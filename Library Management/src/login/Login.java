package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import homepage.Home;

import javax.swing.JPasswordField;

public class Login {

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
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 278, 283);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 262, 39);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblLoginPage.setBounds(75, 11, 104, 17);
		panel.add(lblLoginPage);
		
		JLabel lblUserId = new JLabel("User Name");
		lblUserId.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\businessman (1).png"));
		lblUserId.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblUserId.setBounds(28, 60, 89, 16);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\lock.png"));
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblPassword.setBounds(28, 94, 77, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				if(DBMain.login(name,pass))
				{
					
					//Home.main(new String[]{});
				//	Home.logout(name);
					//btnLogin.setText("Welocome "+name);
					frame.dispose();
					//return true;
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnLogin, "User Not Registered", "Registration Failed!", 1);
					textField.setText("");
					passwordField.setText("");
				}
				
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\lock.png"));
		btnLogin.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnLogin.setBounds(28, 146, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register.main(new String[] {});
			}
		});
		btnRegister.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\ship-rudder.png"));
		btnRegister.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnRegister.setBounds(129, 146, 107, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnBack.setBounds(28, 190, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setHorizontalAlignment(SwingConstants.LEFT);
		btnForgotPassword.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\info-round-button.png"));
		btnForgotPassword.setFont(new Font("Sitka Text", Font.ITALIC, 10));
		btnForgotPassword.setBounds(129, 190, 123, 23);
		frame.getContentPane().add(btnForgotPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setBounds(127, 57, 109, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		passwordField.setBounds(129, 94, 107, 20);
		frame.getContentPane().add(passwordField);
	}

}
