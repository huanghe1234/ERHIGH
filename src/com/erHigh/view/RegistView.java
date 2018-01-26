package com.erHigh.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.erHigh.biz.ClientBiz;
import com.erHigh.bizImp.ClientBizImpl;
import com.erHigh.daoImpl.ClientDaoImpl;

public class RegistView extends View{

	String inPutName;
	String inPutPwd1;
	String inPutPwd2;
	boolean flg = true;
	
	ClientDaoImpl cd = new ClientDaoImpl();
	ClientBiz cu = new ClientBizImpl();
	Scanner scan = new Scanner(System.in);
	UserView us = new UserView();
	
	@Override
	public View showView() {
		while(true) {
			System.out.println("请输入注册账户");
			inPutName = scan.next();
			
			//检测账户是否符合正则	
			Pattern p = Pattern.compile("^[A-Z]{1}[a-zA-Z0-9_.]{6,16}");	
			Matcher m = p.matcher(inPutName);	
			flg = m.matches();
			 if(flg) {
				 System.out.println("正则输入没问题");			 
				 if(cd.checkClient(inPutName) == true) {
					 System.out.println("账户也不重复");
					 break;
				 }else {
					 System.out.println("账户重复");
				 }
			 }else {
				 System.out.println("用户名填写不规范");
			 }
		
		} 
		
		
		while(true) {
			System.out.println("请输入注册密码");
			inPutPwd1 = scan.next();
			
			Pattern p = Pattern.compile("^[A-Z]{1}[a-zA-Z0-9_.]{6,16}");	
			Matcher m = p.matcher(inPutPwd1);	
			flg = m.matches();
			 if(flg) {
				 System.out.println("正则输入没问题");
				 if(cu.clientRegist(inPutName, inPutPwd1)) {
					 System.out.println("注册成功");
					 break;
				 }
			 }else {
				 System.out.println("输入密码不符合正则规范");
			 }
			
		
			
		}
		return null;
	
		
		
	

		

	}

	
}
