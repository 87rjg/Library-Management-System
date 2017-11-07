package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import login.DBMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
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
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 305, 45);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblReturnBook.setBounds(94, 11, 101, 23);
		panel.add(lblReturnBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String student_id = textField.getText();
				String book_id = textField_1.getText();
				int i= DBMain.returnBook(student_id,book_id);
				if(i > 0)	
				{
					JOptionPane.showMessageDialog(lblReturnBook, "Book Return Succesfully !");
				}
			}
		});
		btnReturnBook.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnReturnBook.setBounds(39, 186, 113, 23);
		frame.getContentPane().add(btnReturnBook);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnCancel.setBounds(162, 186, 95, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel label = new JLabel("Student ID");
		label.setFont(new Font("Sitka Text", Font.BOLD, 13));
		label.setBounds(39, 72, 95, 14);
		frame.getContentPane().add(label);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblBookId.setBounds(39, 111, 95, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblDate.setBounds(39, 143, 95, 14);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(149, 69, 108, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(149, 109, 108, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(149, 140, 108, 20);
		frame.getContentPane().add(textField_2);
		frame.setBounds(100, 100, 321, 287);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
