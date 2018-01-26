package com.erHigh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.erHigh.bean.Client;
import com.erHigh.dao.ClientDao;
import com.erHigh.tools.DBHelper;

public class ClientDaoImpl implements ClientDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	private DBHelper mDB;
	private int rInt;
	
	public ClientDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	
	//检查账户是否重复使用的方法
	public boolean checkClient(String inPutName) {
		ArrayList<Client> list = new ArrayList<>();
		String sql = "select * from CLIENT";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Client c = new Client();
				c.setClientId(rSet.getInt("CLIENTID"));
				c.setClientName(rSet.getString("CLIENTNAME"));
				c.setClientPwd(rSet.getString("CLIENTPWD"));
				c.setClientStatus(rSet.getInt("CLIENTSTATUS"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		for(Client client :list) {
			if(inPutName.equals(client.getClientName())) {
				return false;
			}
		}
			
		return true;
		
	}
	
	
	

	@Override
	//登录时使用的方法
	public Client getClient(String clientName, String clientPwd) {
		Client c = new Client();
		try {
			String sql = "select * from CLIENT where CLIENTNAME = ?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, clientName);
			rSet = mStatement.executeQuery();
			if(rSet==null) {
				return null;
			}
			while(rSet.next()) {
				c.setClientId(rSet.getInt("CLIENTID"));
				c.setClientName(rSet.getString("CLIENTNAME"));
				c.setClientPwd(rSet.getString("CLIENTPWD"));
				c.setClientStatus(rSet.getInt("CLIENTSTATUS"));
			}
				return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return c;
	}


	@Override
	
	//注册时使用的方法
	public Client setClient(String inPutName, String inPutPwd1) {
		String sql = "INSERT INTO client VALUES(client_seq.nextval,?,?,1)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, inPutName);
			mStatement.setString(2, inPutPwd1);
			rInt = mStatement.executeUpdate();
			
			if(rInt>0) {
				return getClient(inPutName,inPutPwd1);
			}
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
		
	}
	
	

	
	
	
	
	
	
	

}
