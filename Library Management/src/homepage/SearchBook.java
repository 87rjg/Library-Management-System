package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import login.DataBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook window = new SearchBook();
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
	public SearchBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 319, 261);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 305, 45);
		frame.getContentPane().add(panel);
		
		JLabel lblSearchBook = new JLabel("Search Book");
		lblSearchBook.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblSearchBook.setBounds(94, 11, 101, 23);
		panel.add(lblSearchBook);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblBookId.setBounds(35, 67, 95, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblBookName.setBounds(35, 103, 95, 14);
		frame.getContentPane().add(lblBookName);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(140, 64, 141, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(140, 97, 141, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book_id = textField.getText();
				String book_name  = textField_1.getText();
				
				try
				{
					Connection con = DataBase.getConnection();
					PreparedStatement pst = con.prepareStatement("select * from bookshelf where book_id=? and book_name=?");
					pst.setString(1, book_id);
					pst.setString(2, book_name);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						//JOptionPane.showMessageDialog(btnFind , "Book Available at shelf no: "+rs.getInt(3)+" and quantity :"+rs.getInt(1));
						JOptionPane.showMessageDialog(btnFind, "Book Available at shelf no: "+rs.getInt(3)+" and quantity :"+rs.getInt(4));
						textField.setText("");
						textField_1.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(lblSearchBook, "Sorry Book Currently not available !");
						
					}
					
					con.close();
					rs.close();
					pst.close();
				}catch(Exception e1)
				{
					System.err.println(e);
				}
				
				
			}
		});
		btnFind.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnFind.setBounds(56, 146, 74, 23);
		frame.getContentPane().add(btnFind);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnCancel.setBounds(193, 146, 88, 23);
		frame.getContentPane().add(btnCancel);
	}
}
