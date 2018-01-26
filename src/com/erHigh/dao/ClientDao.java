package com.erHigh.dao;

import com.erHigh.bean.Client;

public interface ClientDao {
	
	public Client getClient(String clientName,String clientPwd);
	public Client setClient(String inPutName, String inPutPwd1);

}
