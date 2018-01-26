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
			System.out.println("������ע���˻�");
			inPutName = scan.next();
			
			//����˻��Ƿ��������	
			Pattern p = Pattern.compile("^[A-Z]{1}[a-zA-Z0-9_.]{6,16}");	
			Matcher m = p.matcher(inPutName);	
			flg = m.matches();
			 if(flg) {
				 System.out.println("��������û����");			 
				 if(cd.checkClient(inPutName) == true) {
					 System.out.println("�˻�Ҳ���ظ�");
					 break;
				 }else {
					 System.out.println("�˻��ظ�");
				 }
			 }else {
				 System.out.println("�û�����д���淶");
			 }
		
		} 
		
		
		while(true) {
			System.out.println("������ע������");
			inPutPwd1 = scan.next();
			
			Pattern p = Pattern.compile("^[A-Z]{1}[a-zA-Z0-9_.]{6,16}");	
			Matcher m = p.matcher(inPutPwd1);	
			flg = m.matches();
			 if(flg) {
				 System.out.println("��������û����");
				 if(cu.clientRegist(inPutName, inPutPwd1)) {
					 System.out.println("ע��ɹ�");
					 break;
				 }
			 }else {
				 System.out.println("�������벻��������淶");
			 }
			
		
			
		}
		return null;
	
		
		
	

		

	}

	
}
