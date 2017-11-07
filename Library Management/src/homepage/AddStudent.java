package homepage;
//package login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import login.DBMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
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
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 309, 46);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblAddStudent.setBounds(99, 11, 103, 24);
		panel.add(lblAddStudent);
		
		JLabel lblName = new JLabel("Student Name");
		lblName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblName.setBounds(30, 68, 95, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblFatherName.setBounds(30, 101, 95, 14);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblCoursebranch = new JLabel("Course/Branch");
		lblCoursebranch.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblCoursebranch.setBounds(30, 137, 95, 14);
		frame.getContentPane().add(lblCoursebranch);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblStudentId.setBounds(30, 173, 95, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblDob.setBounds(30, 205, 76, 14);
		frame.getContentPane().add(lblDob);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(164, 66, 108, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(164, 99, 108, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(164, 135, 108, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(164, 171, 108, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(164, 203, 108, 20);
		frame.getContentPane().add(textField_4);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String fname = textField_1.getText();
				String course = textField_2.getText();
				String id = String.valueOf(textField_3.getText());
				String dob = textField_4.getText();
				String contact = String.valueOf(textField_5.getText());
				int i = DBMain.saveStudent(name, fname, course, id, dob,contact);
				if(i > 0)
				{
					JOptionPane.showMessageDialog(btnSubmit_1, "Student Added Succesfully !", "Success", 1);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
			}
		});
		btnSubmit_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnSubmit_1.setBounds(30, 276, 95, 23);
		frame.getContentPane().add(btnSubmit_1);
		
		JButton btnSubmit = new JButton("Cancel");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSubmit.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnSubmit.setBounds(165, 276, 95, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblContact.setBounds(30, 235, 76, 14);
		frame.getContentPane().add(lblContact);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(164, 234, 108, 20);
		frame.getContentPane().add(textField_5);
		frame.setBounds(100, 100, 325, 363);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

}
