package com.shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author patel
 *
 */
public class DBUtil {
	static Connection connection = null;
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String DRIVER_URL = "jdbc:mysql://localhost/jdbcdemo";
	private static String DB_USER = "root";
	private static String DB_PASS = "root";

	/**
	 * @return Connection
	 */
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(DRIVER_CLASS);
				connection = DriverManager.getConnection(DRIVER_URL, DB_USER, DB_PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
