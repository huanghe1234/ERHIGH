package com.erHigh.bizImp;


import com.erHigh.bean.Client;
import com.erHigh.biz.ClientBiz;
import com.erHigh.dao.ClientDao;
import com.erHigh.daoImpl.ClientDaoImpl;

public class ClientBizImpl implements ClientBiz{
	ClientDao cd = new ClientDaoImpl();

	@Override
	public boolean clientLogin(String clientName, String clientPwd) {
		if(clientName == null || clientName.length()==0 || clientPwd == null || clientPwd.length()==0) {
			return false;
		}
		
		//数据库返回过来的数据,赋值给这个c
		Client c =null;
		c = cd.getClient(clientName,clientPwd);
		
		if(c==null) {
			return false;
		}		
		//System.out.println(c);
		
		if(!clientName.equals(c.getClientName()) || !clientPwd.equals(c.getClientPwd())) {
			return false;
		}else {
			System.out.println("欢迎"+c.getClientName()+"回来!");
			return true;
		}
		
	}

	
	@Override
	public boolean clientRegist(String inPutName, String inPutPwd1) {

		if(inPutName == null || inPutName.length()==0 || inPutPwd1 == null || inPutPwd1.length()==0) {
			return false;		}
		
		Client c =null;
		c = cd.setClient(inPutName,inPutPwd1);
		
		System.out.println("注册成功,您的用户名为"+c.getClientName());
		
		return true;
	}
	
	



}
