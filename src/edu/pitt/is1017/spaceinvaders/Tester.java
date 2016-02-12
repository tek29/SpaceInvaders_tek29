package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;

public class Tester {

	public static void main(String[] args) {
		DbUtilities db = new DbUtilities();
		String sql = "SELECT * FROM users;";
		ResultSet rs = db.getResultSet(sql);
	}

}
