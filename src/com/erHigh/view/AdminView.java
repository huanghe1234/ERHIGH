package com.erHigh.view;

import java.util.Scanner;
import org.pmw.tinylog.Logger;
import com.erHigh.biz.AdminBiz;
import com.erHigh.bizImp.AdminBizImpl;

public class AdminView extends View {
	//管理员账号密码如下:
	String admin = "admin";
	String pwd = "admin";	
	
	
	AdminBiz ab = new AdminBizImpl();
	AddCarView ac = new AddCarView();

	@Override
	//显示
	public View showView() {
		Scanner scan = new Scanner(System.in);		
		System.out.println("=================================");
		System.out.println("	欢迎访问二海租车管理员系统");
		System.out.println("=================================");
		System.out.println("1.登录\t2.退出");
		
		int choose = scan.nextInt();
		switch (choose) {
		case 1:
			while(true) {
				System.out.println("请输入账户:");
				String inPutAdmin = scan.next();
				System.out.println("请输入密码:");
				String inPutPwd = scan.next();
					if(inPutAdmin.equals(admin) && inPutPwd.equals(pwd)) {
						System.out.println("登录成功!欢迎" + inPutAdmin + "回来");
						Logger.info("登录成功");
						showManagerView();
						break;
					}else {
						Logger.info("输入有误");
						System.out.println("输入的账户或者密码有误!");
					}
			}
			break;
		case 2:
			System.out.println("返回上级菜单");
			break;	
		default:
			Logger.info("输入有误");
			System.out.println("输入有误,请选择1或者2");
			break;
		}

		return null;
	}
	
	
	
	public View showManagerView() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("输入0退出");
			System.out.println("输入1+汽车编号 查看指定汽车");
			System.out.println("输入2 查看全部汽车");
			System.out.println("输入3 添加汽车");
			System.out.println("输入4+汽车编号 修改汽车信息");
			System.out.println("输入5 查看全部租赁记录");
			System.out.println("输入6+用户编号,查看指定用户的租赁记录");
			System.out.println("输入7+汽车编号,查看指定汽车的租赁记录");
			
			System.out.println("输入选项:");
			String choose = scan.next();
			String one = choose.substring(0,1);
			int a = Integer.parseInt(one);
		
			switch (a) {
			case 1:
				Logger.info("查看指定汽车");
				String a1 = choose.substring(2);
				int inPutCarId = Integer.parseInt(a1);
				ab.checkSpecifyCar(inPutCarId);
				break;
			case 2:
				Logger.info("查看全部汽车");
				ab.checkAllCar();			
				break;	
			case 3:
				Logger.info("添加汽车");
				ac.CarView();	
				break;		
			case 4:
				Logger.info("修改汽车信息");
				String a4 = choose.substring(2);
				int inPutCarId2 = Integer.parseInt(a4);
				ab.updateCarInfo(inPutCarId2);
				break;
			case 5:
				Logger.info("查看全部租赁记录");
				ab.getLendRecord();
				break;
			case 6:
				Logger.info("查看指定用户的租赁记录");
				String a6 = choose.substring(2);
				int specifyClientId = Integer.parseInt(a6);
				ab.checkCarByClientId(specifyClientId);	
				break;	
			case 7:
				Logger.info("查看指定汽车的租赁记录");
				String a7 = choose.substring(2);
				int specifyCarId = Integer.parseInt(a7);
				ab.checkCarByCarId(specifyCarId);
				break;	
			case 0 :
				
				break;	
			default:
				System.out.println("输入有误,请在1-7之中选择数字");
				break;
			}
			
		
		}
		
	
	}
	
	
}
