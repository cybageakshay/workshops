package com.cybage.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnectivity {
		private static Connection con=null;
		
		public static Connection getCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				   JDBCconnectivity.con =DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementsystem","root","Akshay@123@cybage");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			};
			return JDBCconnectivity.con;
		}
}
