package com.tajhotel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		
	
		FileInputStream fis = new FileInputStream("src\\com\\tajhotel\\properties\\Application.properties");
		Properties property = new Properties();
		
		property.load(fis);
		
		Connection connection = DriverManager.getConnection(property.getProperty("url"), property.getProperty("user"), property.getProperty("password"));

		return connection;

	}
	
	public static void cleanUp(Connection connection , Statement statement , ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
	
}
