package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 317, 366);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(95, 158, 160));
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBounds(10, 11, 281, 305);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\businessman.png"));
		lblNewLabel.setBounds(31, 66, 66, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\lock.png"));
		lblPassword.setBounds(31, 104, 77, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(146, 63, 106, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\question-mark.png"));
		lblSecurityQuestion.setBounds(31, 181, 105, 14);
		panel.add(lblSecurityQuestion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 101, 106, 20);
		panel.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("0\r\n1\r\n2\r\n3");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose one Question", "Your Nick Name", "Your School Name", "Your Pet Name"}));
		comboBox.setBounds(146, 178, 106, 20);
		panel.add(comboBox);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\scared (1).png"));
		lblAnswer.setBounds(42, 221, 66, 14);
		panel.add(lblAnswer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 218, 106, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(205, 92, 92));
		panel_1.setBounds(0, 0, 281, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register Here");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(70, 11, 120, 17);
		panel_1.add(lblNewLabel_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				String contact = textField_2.getText();
				String ans = textField_1.getText();
				String ques = comboBox.getSelectedItem().toString();
				int i = DBMain.save(name,pass,contact,ques,ans);
				if(i > 0)
				{
					JOptionPane.showMessageDialog(btnRegister,"Librarian added successfully!","", i);
					textField.setText("");
					passwordField.setText("");
					textField_2.setText("" );
					textField_1.setText("");
					comboBox.setSelectedIndex(0);
				}
			}
		});
		btnRegister.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnRegister.setBounds(35, 260, 101, 23);
		panel.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnBack.setBounds(146, 260, 101, 23);
		panel.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ram\\Downloads\\call-answer.png"));
		lblNewLabel_2.setBounds(35, 145, 73, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 142, 106, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
	}
}
