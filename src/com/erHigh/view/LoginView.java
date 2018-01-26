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
			System.out.println("请输入用户名:");
			String clientName = scan.next();
			System.out.println("请输入密码:");
			String clientPwd = scan.next();
			
				//和biz界面的clientlogin方法对比,如果biz界面中用户注册的方法返回为true的话,就break
				if (cb.clientLogin(clientName, clientPwd)) {
					//此处登录成功后自动跳转到用户汽车查询界面
					cab.getCar();
					uv.showUserView(clientName);
					break;
				
				}else if (3-i >0 ){
					System.out.println("登录失败,剩下"+(3-i)+"次机会");
					
				}else {
					System.out.println("输入错误超过3次.自动跳转到注册界面");
					lv.showView();					
				}
					
				}
			
			
			
		
			return null;
		}	
			



}
