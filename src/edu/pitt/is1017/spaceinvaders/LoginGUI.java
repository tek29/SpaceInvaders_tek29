package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class LoginGUI {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JButton btnRegister;
	private JButton btnLogin;
	private JButton btnCancel;

	private final JLabel lblSpaceinvadersLogin = new JLabel("SpaceInvaders - Login");

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("AlienInvaders - Login");
		frame.setBounds(100, 100, 359, 291);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 109, 67, 20);
		frame.getContentPane().add(lblPassword);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(37, 50, 67, 20);
		frame.getContentPane().add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(118, 50, 157, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(118, 109, 157, 20);
		frame.getContentPane().add(textFieldPassword);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(10, 182, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterGUI window = new RegisterGUI(); // new registration
				// window
				frame.dispose(); // close login window

			}
		});

		btnLogin = new JButton("Login");
		btnLogin.setBounds(132, 182, 89, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textFieldEmail.getText();
				String password = textFieldPassword.getText();
				User user = new User(userName, password);
				frame.dispose();
			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(244, 182, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
