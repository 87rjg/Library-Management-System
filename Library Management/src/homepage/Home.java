package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import login.AdminLogin;
import login.Login;
import login.Register;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Home {

	private JFrame frame;
	private static JButton btnLoginregister;
	public static  boolean loginFlag = true;
	private static JTextField txtWelcome;
	private static JButton btnLogout;
	private static JButton btnAdminLogin;
	static boolean openRegistration=false;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public static void getPost(String name)
	{
		btnLoginregister.setText(name);
		btnLoginregister.setEnabled(false);
		txtWelcome.setVisible(true);
		btnLogout.setVisible(true);
		loginFlag=false;
		btnAdminLogin.setVisible(true);
		btnAdminLogin.setEnabled(false);
		openRegistration=false;
		if(btnLoginregister.getText().equalsIgnoreCase("admin"))
		{
			btnAdminLogin.setVisible(false);
			openRegistration=true;
		}
	}
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Library Management System");
		Image img10 = new ImageIcon(this.getClass().getResource("/post-it (2).png")).getImage();
		frame.setIconImage(img10);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 575, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 569, 89);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		Image img9 = new ImageIcon(this.getClass().getResource("/books (3).png")).getImage();
		label.setIcon(new ImageIcon(img9));
		label.setBounds(10, 11, 128, 67);
		panel.add(label);
		
		JLabel lblCentralLibrary = new JLabel("Central Library");
		lblCentralLibrary.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblCentralLibrary.setBounds(198, 32, 144, 26);
		panel.add(lblCentralLibrary);
		
		
	    btnLoginregister = new JButton("Login/Register");
	    btnLoginregister.setHorizontalAlignment(SwingConstants.LEFT);
		btnLoginregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
			}
			
		});
		btnLoginregister.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnLoginregister.setBackground(new Color(205, 92, 92));
		btnLoginregister.setBounds(431, 66, 94, 23);
		btnLoginregister.setBorder(null);
		panel.add(btnLoginregister);
		
		txtWelcome = new JTextField();
		txtWelcome.setBackground(new Color(205, 92, 92));
		txtWelcome.setFont(new Font("Sitka Text", Font.BOLD, 13));
		txtWelcome.setEditable(false);
		txtWelcome.setText("Welcome");
		txtWelcome.setVisible(false);
		txtWelcome.setBorder(null);
		txtWelcome.setBounds(363, 67, 65, 20);
		panel.add(txtWelcome);
		txtWelcome.setColumns(10);
		
	    btnLogout = new JButton("");
	    btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFlag=true;
				btnLoginregister.setText("Login/Register");
				btnLoginregister.setEnabled(true);
				txtWelcome.setVisible(false);
				btnLogout.setVisible(false);
				btnAdminLogin.setVisible(true);
				btnAdminLogin.setEnabled(true);
			}
		});
		btnLogout.setBackground(new Color(205, 92, 92));
		Image img8 = new ImageIcon(this.getClass().getResource("/sign-out-option (1).png")).getImage();
		btnLogout.setIcon(new ImageIcon(img8));
		btnLogout.setBounds(528, 66, 27, 23);
		btnLogout.setBorder(null);
		btnLogout.setVisible(false);
		panel.add(btnLogout);
		
	   btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
			}
		});
		btnAdminLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdminLogin.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnAdminLogin.setBorder(null);
		btnAdminLogin.setBackground(new Color(205, 92, 92));
		btnAdminLogin.setBounds(431, 11, 94, 23);
		panel.add(btnAdminLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 205), 2), new LineBorder(new Color(0, 0, 0))));
		panel_1.setBounds(10, 119, 546, 278);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblIssueBook.setBounds(41, 112, 78, 14);
		panel_1.add(lblIssueBook);
		
		JButton btnReturnBook = new JButton("");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginFlag==false)
				{
					issuebook.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(btnReturnBook, "Please Login First");
				}
				
			}
		});
		Image img7 = new ImageIcon(this.getClass().getResource("/books.png")).getImage();
		btnReturnBook.setIcon(new ImageIcon(img7));
		btnReturnBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnReturnBook.setBounds(35, 25, 84, 76);
		panel_1.add(btnReturnBook);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginFlag==false)
				{
					ReturnBook.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(btnReturnBook, "Please Login First");
				}
				
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/books (4).png")).getImage();
		button.setIcon(new ImageIcon(img6));
		button.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button.setBounds(165, 25, 84, 76);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(loginFlag==false)
				{
					Addbook.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(btnReturnBook, "Please Login First");
				}
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/library.png")).getImage();
		button_1.setIcon(new ImageIcon(img5));
		button_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_1.setBounds(289, 25, 84, 76);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(openRegistration == true)
				{
					Register.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(btnAdminLogin, "Warnig! Contact to Admin!");
				}
				
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/add-user.png")).getImage();
		button_2.setIcon(new ImageIcon(img4));
		button_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_2.setBounds(425, 25, 84, 76);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.main(new String[]{});
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/studying.png")).getImage();
		button_3.setIcon(new ImageIcon(img3));
		button_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_3.setBounds(425, 155, 84, 76);
		panel_1.add(button_3);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblReturnBook.setBounds(165, 112, 78, 14);
		panel_1.add(lblReturnBook);
		
		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblAddBook.setBounds(295, 112, 78, 14);
		panel_1.add(lblAddBook);
		
		JLabel lblAddLibrarian = new JLabel("Add Librarian");
		lblAddLibrarian.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblAddLibrarian.setBounds(425, 112, 84, 14);
		panel_1.add(lblAddLibrarian);
		
		JLabel lblIssuedBook = new JLabel("Issued Book");
		lblIssuedBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblIssuedBook.setBounds(165, 242, 78, 14);
		panel_1.add(lblIssuedBook);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginFlag==false)
				{
					AddStudent.main(new String[] {});
				}
				else
				{
					JOptionPane.showMessageDialog(btnReturnBook, "Please Login First");
				}
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/learning.png")).getImage();
		button_4.setIcon(new ImageIcon(img2));
		button_4.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_4.setBounds(35, 155, 84, 76);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
			 if(loginFlag==false)
				{
				    viewBook.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(btnReturnBook, "Please Login First");
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/books (5).png")).getImage();
		button_5.setIcon(new ImageIcon(img));
		button_5.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_5.setBounds(165, 155, 84, 76);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		Image img1 = new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		button_6.setIcon(new ImageIcon(img1));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook.main(new String[]{});
			}
		});
		button_6.setFont(new Font("Sitka Text", Font.BOLD, 12));
		button_6.setBounds(295, 155, 84, 76);
		panel_1.add(button_6);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblAddStudent.setBounds(39, 242, 84, 14);
		panel_1.add(lblAddStudent);
		
		JLabel lblSearchBook = new JLabel("Search Book");
		lblSearchBook.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblSearchBook.setBounds(305, 242, 84, 14);
		panel_1.add(lblSearchBook);
		
		JLabel lblAbout = new JLabel("About ");
		lblAbout.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblAbout.setBounds(452, 242, 56, 14);
		panel_1.add(lblAbout);
	}
}
