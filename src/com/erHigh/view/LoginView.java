package com.erHigh.view;

import java.util.Scanner;

import com.erHigh.biz.CarBiz;
import com.erHigh.biz.ClientBiz;
import com.erHigh.bizImp.CarBizImpl;
import com.erHigh.bizImp.ClientBizImpl;

public class LoginView extends View {
	ClientBiz cb = new ClientBizImpl();
	CarBiz cab = new CarBizImpl();
	View lv = new RegistView();
	UserView uv = new UserView();
	int i = 1;
	
	@Override
	public View showView() {
		for(int i= 1 ; i <= 3 ; i ++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�������û���:");
			String clientName = scan.next();
			System.out.println("����������:");
			String clientPwd = scan.next();
			
				//��biz�����clientlogin�����Ա�,���biz�������û�ע��ķ�������Ϊtrue�Ļ�,��break
				if (cb.clientLogin(clientName, clientPwd)) {
					//�˴���¼�ɹ����Զ���ת���û�������ѯ����
					cab.getCar();
					uv.showUserView(clientName);
					break;
				
				}else if (3-i >0 ){
					System.out.println("��¼ʧ��,ʣ��"+(3-i)+"�λ���");
					
				}else {
					System.out.println("������󳬹�3��.�Զ���ת��ע�����");
					lv.showView();					
				}
					
				}
			
			
			
		
			return null;
		}	
			



}
