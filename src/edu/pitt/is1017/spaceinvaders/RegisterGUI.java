package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class RegisterGUI {

	private JFrame frame;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmPassword;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JButton btnRegister;
	private JButton btnCancel;

	private final JLabel lblRegistratWindow = new JLabel("SpaceInvaders - Registration");

	public RegisterGUI() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("AlienInvaders - Register");
		frame.setBounds(100, 100, 378, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(26, 38, 79, 14);
		frame.getContentPane().add(lblFirstName);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(26, 77, 79, 14);
		frame.getContentPane().add(lblLastName);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(26, 117, 79, 14);
		frame.getContentPane().add(lblEmail);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(26, 157, 79, 14);
		frame.getContentPane().add(lblPassword);

		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(26, 202, 119, 14);
		frame.getContentPane().add(lblConfirmPassword);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(69, 261, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = textFieldFirstName.getText();
				String lastName = textFieldLastName.getText();
				String email = textFieldEmail.getText();
				String password = textFieldPassword.getText();
				String confirmPassword = textFieldConfirmPassword.getText();
				if (password.equals(confirmPassword)) {
					User u = new User(lastName, firstName, email, password);
					frame.dispose();
				}

			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(214, 261, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(155, 35, 177, 20);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		String firstName = textFieldFirstName.getText();

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(155, 74, 177, 20);
		frame.getContentPane().add(textFieldLastName);
		String lastName = textFieldLastName.getText();

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(155, 114, 177, 20);
		frame.getContentPane().add(textFieldEmail);
		String email = textFieldEmail.getText();

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(155, 154, 177, 20);
		frame.getContentPane().add(textFieldPassword);
		String password = textFieldPassword.getText();

		textFieldConfirmPassword = new JTextField();
		textFieldConfirmPassword.setColumns(10);
		textFieldConfirmPassword.setBounds(155, 199, 177, 20);
		frame.getContentPane().add(textFieldConfirmPassword);
		String confirmPassword = textFieldConfirmPassword.getText();

		frame.setVisible(true);

	}

}
