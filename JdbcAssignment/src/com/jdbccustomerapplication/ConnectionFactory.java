package com.jdbccustomerapplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.sql.*;
//factory dp, singleton dp

public class ConnectionFactory {
	private static Connection connection = null;

	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		// load the prop file
		InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("db1.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String driver = properties.getProperty("db.driver");
		String url = properties.getProperty("db.url");
		String username = properties.getProperty("db.username");
		String password = properties.getProperty("db.password");

		// load the driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
