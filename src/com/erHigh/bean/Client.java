package com.erHigh.bean;

import java.io.Serializable;

public class Client implements Serializable{
	


	private static final long serialVersionUID = 1081887503736215261L;
	
	private int clientId;
	private String clientName;
	private String clientPwd;
	private int clientStatus;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPwd() {
		return clientPwd;
	}
	public void setClientPwd(String clientPwd) {
		this.clientPwd = clientPwd;
	}
	public int getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(int clientStatus) {
		this.clientStatus = clientStatus;
	}
	public Client(int clientId, String clientName, String clientPwd, int clientStatus) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientPwd = clientPwd;
		this.clientStatus = clientStatus;
	}

	public Client () {
		
	}
	
	
	public Client(String clientName, String clientPwd, int clientStatus) {
		super();
		this.clientName = clientName;
		this.clientPwd = clientPwd;
		this.clientStatus = clientStatus;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientPwd=" + clientPwd
				+ ", clientStatus=" + clientStatus + "]";
	}
	
	
	
}
