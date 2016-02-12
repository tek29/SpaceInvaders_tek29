package edu.pitt.is1017.spaceinvaders;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {

	private int userID;
	private String lastName, email, password;
	private String firstName;
	private boolean logginIn = false;

	public User(int userID) {
		DbUtilities dbUtil = new DbUtilities();
		String query = "SELECT * FROM users WHERE userID = '" + userID + "' ;";
		ResultSet rs = dbUtil.getResultSet(query);
		try {
			while (rs.next()) {
				int id = rs.getInt("userID");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				this.userID = userID;
				this.lastName = lastName;
				this.firstName = firstName;
				this.email = email;
				this.password = md5(password);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public User(String email, String password) {
		DbUtilities dbUtil = new DbUtilities();
		String query = "SELECT password FROM users WHERE email = '" + email + "';";
		// String query = "SELECT password FROM users WHERE email = '" + email + "' AND password = MD5('" + password + "')";
		String pwDB = "";
		//System.out.println(query);
		ResultSet rs = dbUtil.getResultSet(query);
		try {
			while (rs.next()) {
				pwDB = rs.getString("password");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (pwDB.equals(md5(password))) {
			boolean loggedIn = true;
			JOptionPane.showMessageDialog(null, "You are logged in!");
		} else {
			boolean loggedIn = false;
			JOptionPane.showMessageDialog(null, "Error: Invalid Login Credentials");
		}

	}

	public User(String lastName, String firstName, String email, String password) {
		DbUtilities dbUtil = new DbUtilities();
		String sql = "INSERT INTO users "; // registers user and insert into
		// database
		sql = sql + " (lastName,firstName, email, password) ";
		sql = sql + " VALUES ('" + lastName + "','" + firstName + "','" + email + "', md5('" + password + "'));";
		dbUtil.executeQuery(sql);
		//System.out.println(sql);
	}

	public void saveUserInfo() {
		DbUtilities dbUtil = new DbUtilities();
		String sql = "UPDATE users SET firstName='" + firstName + "' ,'" + lastName + "' = '" + lastName
				+ " , password = md5('" + password + "'), email = '" + email + " WHERE userID = '" + userID + "';'";				
		dbUtil.executeQuery(sql); // update users set in database
		System.out.println(sql);
	}

	// getters and setters are below

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isLogginIn() {
		return logginIn;
	}

	public void setLogginIn(boolean logginIn) {
		this.logginIn = logginIn;
	}

	public int getUserID() {
		return userID;
	}

	// hex encoded md5 hash method
	public static String md5(String s) {
		String result = "";
		try {
			byte[] bytesOfMessage = s.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] theDigest = md.digest(bytesOfMessage);
			result = asHex(theDigest);
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		return result;
	}

	public static String asHex(byte buff[]) {
		StringBuilder strbuff = new StringBuilder(buff.length * 2);
		for (int i = 0; i < buff.length; i++) {
			if (((int) buff[i] & 0xff) < 0x10)
				strbuff.append("0");
			strbuff.append(Long.toString((int) buff[i] & 0xff, 16));
		}
		return strbuff.toString();
	}
}
