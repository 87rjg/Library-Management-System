package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import login.DBMain;
import login.DataBase;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class issuebook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issuebook window = new issuebook();
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
	public issuebook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 340, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 324, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel.setBounds(107, 11, 98, 21);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 42, 324, 319);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel_1.setBounds(39, 11, 76, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setBounds(158, 8, 108, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblStudentName.setBounds(39, 45, 100, 14);
		panel_1.add(lblStudentName);
		
		JLabel lblCoursebranch = new JLabel("Course/Branch");
		lblCoursebranch.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblCoursebranch.setBounds(39, 82, 100, 14);
		panel_1.add(lblCoursebranch);
		
		JLabel lblCollegeName = new JLabel("Contact");
		lblCollegeName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblCollegeName.setBounds(39, 123, 100, 14);
		panel_1.add(lblCollegeName);
		
		JLabel lblIssuedBook = new JLabel("Issued Book");
		lblIssuedBook.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblIssuedBook.setBounds(39, 158, 100, 14);
		panel_1.add(lblIssuedBook);
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		lblEnterBookId.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblEnterBookId.setBounds(39, 195, 100, 14);
		panel_1.add(lblEnterBookId);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(158, 42, 108, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(158, 80, 108, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(158, 121, 108, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(158, 156, 108, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(158, 193, 108, 20);
		panel_1.add(textField_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				String name,course,contact;
				try
				{
					Connection con = DataBase.getConnection();
					PreparedStatement ps = con.prepareStatement("select name,course,contact from student where id=?");
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						name = rs.getString("name");
						textField_1.setText(name);
						course = rs.getString("course");
						textField_2.setText(course);
						contact = rs.getString("contact");
						textField_3.setText(contact);
					}
					con.close();
				}catch(Exception e)
				{
					System.out.println("Exception at access"+e);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\search (1).png"));
		btnNewButton.setBounds(266, 11, 25, 18);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Issue Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
//				String name = textField_1.getText();
//				String course = textField_2.getText();
//				String contact = textField_3.getText();
				
				String book_id = textField_5.getText();
				String issueDate = textField_6.getText();
				int i= DBMain.issueBook(id,book_id,issueDate);
				if(i>0)
				{
					JOptionPane.showMessageDialog(lblIssuedBook, "Book has been Issued");
					  textField.setText("");
					  textField_3.setText("");
					  textField_2.setText("");
					  textField.setText("");
					  textField_4.setText("");
					  textField_5.setText("");
					  textField_6.setText("");

				}
				else
				{
					JOptionPane.showMessageDialog(lblIssuedBook, "Check Book Id Properly !");
					textField_5.setText("");
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnNewButton_1.setBounds(39, 267, 113, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Home.main(new String[]{});
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnCancel.setBounds(166, 267, 100, 23);
		panel_1.add(btnCancel);
		
		JLabel lblIsuueDate = new JLabel("Isuue Date");
		lblIsuueDate.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblIsuueDate.setBounds(39, 228, 100, 14);
		panel_1.add(lblIsuueDate);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_6.setColumns(10);
		
		textField_6.setBounds(158, 222, 108, 20);
		panel_1.add(textField_6);
	}

}
