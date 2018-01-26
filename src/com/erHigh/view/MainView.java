package com.erHigh.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pmw.tinylog.Logger;

public class MainView extends View {
	

	View lv = new LoginView();
	View rv = new RegistView();
	View va = new AdminView();
	@Override
	public View showView() {
		
		System.out.println("=========================");
		System.out.println("	欢迎访问二海租车");
		System.out.println("=========================");
		
		System.out.print("1.用户登录     ");
		System.out.print("2.用户注册     ");
		System.out.print("3.管理员登陆     ");
		System.out.print("0.退出");
		
		System.out.println("\n请输入选项:");
		Scanner scan = new Scanner(System.in);
		Logger.info("进入二海租车系统");
		int choose = scan.nextInt();
		
		/**此处需添加参数异常检测,  确保客户输入的是整数类型的
		 * 暂不知道如何进行参数检查
		 */
			switch (choose) {
			case 0:
				Logger.info("退出二海租车系统");
				System.out.println("感谢使用二嗨租车系统");
				System.exit(0);
				break;
			case 1:
				Logger.info("登录二海租车系统");
				System.out.println("=======登陆=====>>>>");
				lv.showView();
				break;
			case 2:
				Logger.info("注册二海租车系统");
				System.out.println("=======注册=====>>>>");
				rv.showView();
				break;	
			case 3:
				Logger.info("管理员登录租车系统");
				va.showView();
				break;		
				
			default:
				System.out.println("输入有误!");
				break;
				
			}
			return null;
		
		
	}
	

	
}
