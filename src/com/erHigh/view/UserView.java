package com.erHigh.view;

import java.util.Scanner;
import org.pmw.tinylog.Logger;
import com.erHigh.biz.CarBiz;
import com.erHigh.bizImp.CarBizImpl;
import com.erHigh.test.Test;

public class UserView {

	CarBiz cab = new CarBizImpl();
	Test test = new Test();
	String[] args;
	
	public View showUserView(String clientName) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("输入0退出");
			System.out.println("输入1+汽车编号,进入租车界面");
			System.out.println("输入2+1,按照价格升序排列");
			System.out.println("输入2+2,按照价格降序排列");
			System.out.println("输入3+类型编号,按照类型搜索");
			System.out.println("输入4+品牌编号,按照品牌搜索");
			System.out.println("输入5,查看全部汽车");
			System.out.println("输入6,查看我的租车/预约车记录");
			System.out.println("输入7+汽车编号,还车");
			System.out.println("输入8,模糊查询");
			System.out.println("输入9+汽车编号,预约车");
			
			System.out.println("输入选项:");
			
			String choose = scan.next();
			String one = choose.substring(0,1);
			int a = Integer.parseInt(one);
			
			/**此处需添加参数异常检测,  确保客户输入的是整数类型的,并且确保是10以内的数字
			 * 暂不知道如何进行参数检查
			 */
			
			switch (a) {
			case 1:
				Logger.info("进入租车界面");
				String a1 = choose.substring(2);
				int inPutCarId = Integer.parseInt(a1);
				cab.lendCarById(inPutCarId,clientName);
				break;
			case 2:
				Logger.info("按照价格升序排列");
				String a2 = choose.substring(2);
				int rent = Integer.parseInt(a2);
				if(rent == 1) {
					System.out.println("价格按照升序排列");		
					cab.getCarByPrice();
				}else if (rent == 2) {
					System.out.println("价格按照降序排列");
					cab.getCarByPrice1();
				}else {
					System.out.println("输入不正确");
				}
				break;
			case 3:
				Logger.info("按照类型搜索");
				System.out.println("1紧凑型 //2舒适型 //3SUV//4精英型");
				String a3 = choose.substring(2);
				int inPutCarType = Integer.parseInt(a3);			
				cab.getCarType(inPutCarType);
				break;			
			case 4 :
				Logger.info("按照品牌搜索");
				System.out.println("1标致//2大众//3奥迪//4奔驰//5宝马");
				String a4 = choose.substring(2);
				int inPutCarBrand = Integer.parseInt(a4);
				cab.getCarBrand(inPutCarBrand);
				break;
			case 5:
				Logger.info("查看全部汽车");
				//String a5 = choose.substring(2);
				cab.getCar();
				break;
			case 6:	
				Logger.info("查看我的租车/预约车记录");
				cab.getCarClient(clientName);
				break;
			case 7:
				Logger.info("进入还车界面");
				String a7 = choose.substring(2);
				int inPutCarId2 = Integer.parseInt(a7);
				cab.returnCarById(inPutCarId2,clientName);
				break; 		
			case 8:
				Logger.info("模糊搜索");
				System.out.println("请输入要查询的名称:");
				String inPutVague = scan.next();
				//String inPutVague = choose.substring(2);			
				cab.getCarVague(inPutVague);
				break;
			case 9:
				Logger.info("进入预约车界面");
				System.out.println("请输入多少天后来取车:");
				int inPutCatDate = scan.nextInt();
				String a9 = choose.substring(2);
				int inPutCarId3 = Integer.parseInt(a9);
				cab.getOrderCar(inPutCarId3,inPutCatDate,clientName);
				break;
			case 0 :
				test.main(args);
				break;
			default:
				Logger.info("错误输入");
				System.out.println("输入错误!");
				break;
			}
		
	
		}
		
		

		
	}

}
