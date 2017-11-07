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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addbook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbook window = new Addbook();
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
	public Addbook() {
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
		panel.setBounds(0, 0, 315, 46);
		panel.setBackground(new Color(205, 92, 92));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblAddBook.setBounds(98, 11, 90, 24);
		panel.add(lblAddBook);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblBookId.setBounds(27, 70, 76, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblBookName.setBounds(27, 107, 76, 14);
		frame.getContentPane().add(lblBookName);
		
		JLabel lblAutherName = new JLabel("Auther Name");
		lblAutherName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblAutherName.setBounds(27, 139, 76, 14);
		frame.getContentPane().add(lblAutherName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblDate.setBounds(27, 173, 76, 14);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(121, 67, 108, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(121, 104, 108, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(121, 136, 108, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(121, 170, 108, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book_id = textField.getText();
				String book_name = textField_1.getText();
				String auther_name = textField_2.getText();
				String Date = textField_3.getText();
				String shelf_no = textField_4.getText();
				int i = DBMain.addBook(book_id,book_name,auther_name,Date,shelf_no);
				if(i > 0)
				{
					JOptionPane.showMessageDialog(btnAddBook, "Book Added Succesfully!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(btnAddBook, "Book is already there! Quantity Updated");
				}
			}
		});
		btnAddBook.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnAddBook.setBounds(29, 239, 95, 23);
		frame.getContentPane().add(btnAddBook);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnCancel.setBounds(144, 239, 86, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblShelfNo = new JLabel("shelf No.");
		lblShelfNo.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblShelfNo.setBounds(27, 203, 76, 14);
		frame.getContentPane().add(lblShelfNo);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(121, 201, 108, 20);
		frame.getContentPane().add(textField_4);
		frame.setBounds(100, 100, 309, 335);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
