package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class About {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
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
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		//frame.r
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 354);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(0, 0, 434, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAboutLibraryManagement = new JLabel("About Library Management System");
		lblAboutLibraryManagement.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblAboutLibraryManagement.setBounds(75, 11, 291, 25);
		panel.add(lblAboutLibraryManagement);
		
		JTextArea txtrALibraryManagement = new JTextArea();
		txtrALibraryManagement.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		txtrALibraryManagement.setEditable(false);
		txtrALibraryManagement.setBackground(new Color(95, 158, 160));
		txtrALibraryManagement.setText("A Library Management Software is a stand alone \r\napplication aims to make Libraries fully digital to\r\n keep its records, where admin can add/view/delete\r\n librarian and Librarian can add,view, issue,view issued\r\n books & return books. Anyone can search for books\r\n without authentication. ");
		txtrALibraryManagement.setBounds(49, 58, 331, 124);
		
		frame.getContentPane().add(txtrALibraryManagement);
		
		JTextArea txtrDesignDeveloped = new JTextArea();
		txtrDesignDeveloped.setText("Design & Developed by : Ramjee Gupta\r\n                                       MCA, NIT DURGAPUR\r\nTools  & Technology      : Java J2SE, JDBC MySql.\r\nIDE                              : Eclipse     ");
		txtrDesignDeveloped.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		txtrDesignDeveloped.setEditable(false);
		txtrDesignDeveloped.setBackground(new Color(95, 158, 160));
		txtrDesignDeveloped.setBounds(49, 211, 331, 76);
		frame.getContentPane().add(txtrDesignDeveloped);
	}
}
