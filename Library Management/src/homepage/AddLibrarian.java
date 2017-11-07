package homepage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class AddLibrarian {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian window = new AddLibrarian();
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
	public AddLibrarian() {
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
		panel.setBounds(0, 0, 287, 49);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddLiberian = new JLabel("Add Liberian");
		lblAddLiberian.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblAddLiberian.setBounds(91, 11, 108, 27);
		panel.add(lblAddLiberian);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(149, 72, 108, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(149, 112, 108, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(149, 159, 108, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(149, 198, 108, 20);
		frame.getContentPane().add(textField_3);
		frame.setBounds(100, 100, 303, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
