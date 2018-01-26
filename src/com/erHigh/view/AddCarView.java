package com.erHigh.view;

import java.util.Scanner;

import com.erHigh.biz.AdminBiz;
import com.erHigh.bizImp.AdminBizImpl;

public class AddCarView {
	
	AdminBiz ab = new AdminBizImpl();
	
	public void CarView() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("===================");
		System.out.println("请分别输入以下信息");
		System.out.println("-------------------");
		System.out.println("品牌如下:");
		System.out.println("品牌编号\t品牌名");
		System.out.println("1\t标致");
		System.out.println("2\t大众");
		System.out.println("3\t奥迪");
		System.out.println("4\t奔驰");
		System.out.println("5\t宝马");
		System.out.println("请选择品牌编号:");
		int inPutBrandId = scan.nextInt();
		
		String brandCar= null;
		if (inPutBrandId ==1) {
			brandCar = "标致";
		}else if (inPutBrandId ==2) {
			brandCar = "大众";
		}else if (inPutBrandId ==3) {
			brandCar = "奥迪";
		}else if (inPutBrandId ==4) {
			brandCar = "奔驰";
		}else if (inPutBrandId ==5) {
			brandCar = "宝马";
		}else {
			System.out.println("输入有误!");
		}
		
		
			
			String typeCar = null;
			System.out.println("-------------------");
			System.out.println("类型如下:");
			System.out.println("类型编号\t类型名");
			System.out.println("1\t紧凑型");
			System.out.println("2\t舒适型");
			System.out.println("3\tSUV");
			System.out.println("4\t精英型");
			System.out.println("请选择品牌编号:");
			int inPutTypeId = scan.nextInt();
			if (inPutTypeId == 1 ) {
				typeCar= "紧凑型";
				
			}else if (inPutTypeId == 2) {
				typeCar= "舒适型";
			
			}else if (inPutTypeId == 3) {
				typeCar= "SUV";
				
			}else if (inPutTypeId == 4) {
				typeCar= "精英型";
			
			}else {
				System.out.println("输入有误");
			}
		
		
		System.out.println("-------------------");
		System.out.println("请输入汽车名称");
		String inPutCarName = scan.next();
		
		System.out.println("-------------------");
		System.out.println("请输入车牌号");
		String inPutCarNumber = scan.next();
		
		System.out.println("-------------------");
		System.out.println("请输入概要");
		String inPutCarRemark = scan.next();
		
		System.out.println("-------------------");
		System.out.println("请输入颜色");
		String inPutCarColor = scan.next();
		
		System.out.println("-------------------");
		System.out.println("请输入汽车价格");
		int inPutCarWorth = scan.nextInt();
		
		System.out.println("-------------------");
		System.out.println("请输入每日租金");
		int inPutCarPrice = scan.nextInt();
		
		String inPutCarStatus=null;	
		while(true) {
			System.out.println("-------------------");
			System.out.println("是否可借(0.可租;1.已租出)");
			int inPutCarStatusNum = scan.nextInt();
			
				if (inPutCarStatusNum == 0) {
					inPutCarStatus = "可租";
					break;
				}else if (inPutCarStatusNum == 1){
					inPutCarStatus = "已租出";
					break;
				}else {
					System.out.println("输入的号码有误");
				}
		}	
			
		String inPutCarGroud = null;
		while(true) {
			System.out.println("-------------------");
			System.out.println("是否可借(0.上架;1.下架)");
			int inPutCarGroudNum = scan.nextInt();
			
				if (inPutCarGroudNum == 0) {
					inPutCarGroud = "上架";
					break;
				}else if (inPutCarGroudNum == 1){
					inPutCarGroud = "下架";
					break;
				}else {
					System.out.println("输入的号码有误");
				}
		}
		
		ab.AddCar(inPutBrandId,brandCar,inPutTypeId,typeCar,inPutCarName,inPutCarNumber,inPutCarRemark,
				inPutCarColor,inPutCarWorth,inPutCarPrice,inPutCarStatus,inPutCarGroud);

				
	}
	
	
}
