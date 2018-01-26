package com.erHigh.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER = "huanghe";
	public static final String PWD = "123456";
	
	
	Connection mConnection;
	
	public Connection getConnection() {
		
		if(mConnection==null) {
			try {
				Class.forName(DRIVER);
				mConnection = DriverManager.getConnection(URL,USER,PWD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			
		
		return mConnection;		
	}
	
	
	
	
	
	
	
	
	
	
}
