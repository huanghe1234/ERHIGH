package com.erHigh.bizImp;

import java.util.ArrayList;
import java.util.Scanner;

import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;
import com.erHigh.biz.AdminBiz;
import com.erHigh.dao.AdminDao;
import com.erHigh.daoImpl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz{
	
	AdminDao ad = new AdminDaoImpl();

	@Override
	public void checkAllCar() {
	
		ArrayList<Car> list = new ArrayList<>();
		
		list= ad.getAllCar();
		System.out.println("============================================================");
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t是否可租\t是否上架\t预约状态");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarStatus());
			System.out.print("\t"+car.getIsGrouding());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}

	@Override
	//查看指定汽车的信息
	public Car checkSpecifyCar(int inPutCarId) {
		Car ca = new Car();
		ca = ad.getSpecifyCar(inPutCarId);
		
		if(inPutCarId != ca.getCarId()) {
			System.out.println("汽车编号不存在!");
			return null;
		} else {
		System.out.println("============================================================");
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t是否可租\t是否上架\t预约状态");
		System.out.print(ca.getCarId());
		System.out.print("\t"+ca.getCarName());
		System.out.print("\t"+ca.getCarRemark());
		System.out.print("\t"+ca.getCarBrand());
		System.out.print("("+ca.getCarBrandNumber()+")");
		System.out.print("\t"+ca.getCarType());
		System.out.print("("+ca.getCarTypeNumber()+")");
		System.out.print("\t"+ca.getCarPrice()+"元/天");
		System.out.print("\t"+ca.getCarStatus());
		System.out.print("\t"+ca.getIsGrouding());
		System.out.println("\t"+ca.getIsOrder());
		return ca;
		}
		
	}

	@Override
	public void AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber,
			String inPutCarRemark, String inPutCarColor,int inPutCarWorth, int inPutCarPrice,
			String inPutCarStatus, String inPutCarGroud) {
		Car ca = new Car();
		
		ca = ad.AddCar(inPutBrandId, brandCar, inPutTypeId, typeCar,inPutCarName, inPutCarNumber, inPutCarRemark, inPutCarColor, inPutCarWorth, inPutCarPrice, inPutCarStatus, inPutCarGroud);
		System.out.println("添加成功!");
		System.out.println(ca);
	}

	@Override
	public Car updateCarInfo(int inPutCarId2) {
		Scanner scan = new Scanner(System.in);
		Car ca = new Car();
		ca = ad.getCarById(inPutCarId2);
		
		if(inPutCarId2 != ca.getCarId()) {
			System.out.println("汽车编号不存在");
			return null;
		}else {
			System.out.println("============================================================");
			System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t总价值\t是否可租\t是否上架");
			System.out.print(ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"元/天");
			System.out.print("\t"+ca.getCarWorth()+"元");
			System.out.print("\t"+ca.getCarStatus());
			System.out.println("\t"+ca.getIsGrouding());
				
			
			System.out.println("请输入要修改的内容的编号");
			System.out.println("1.租赁价格         2.上架下架");
			int choose = scan.nextInt();
			switch (choose) {
			case 1:
				Car c = new Car();
				System.out.println("输入新的租赁价格");
				int inPutPrice = scan.nextInt();
				c = ad.changePrice(inPutPrice,inPutCarId2);
				System.out.println("修改价格完成!");
				System.out.println("============================================================");
				System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t总价值\t是否可租\t是否上架");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+c.getCarPrice()+"元/天");
				System.out.print("\t"+ca.getCarWorth()+"元");
				System.out.print("\t"+ca.getCarStatus());
				System.out.println("\t"+ca.getIsGrouding());			
				break;
			case 2:
				System.out.println("输入上架  或者下架");
				String inPutchoose = scan.next();
				String inPutNewGroud = null;
				
				Car c2 = new Car();
				if(inPutchoose.equals("上架")) {
					inPutNewGroud = "上架";
				}else if(inPutchoose.equals("下架")){
					
						if (ca.getCarStatus().equals("已租出") || ca.getIsOrder().equals("已预约")) {
							System.out.println("该车已租车或者已预约,不能修改下架");
							break;
						}else {
							inPutNewGroud = "下架";
						}
				}else {
					System.out.println("输入有误!");
				}
				c2 = ad.changeGroud(inPutNewGroud,inPutCarId2);
				System.out.println("修改上下架完成");		
				System.out.println("============================================================");
				System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t总价值\t是否可租\t是否上架");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+ca.getCarPrice()+"元/天");
				System.out.print("\t"+ca.getCarWorth()+"元");
				System.out.print("\t"+ca.getCarStatus());
				System.out.println("\t"+c2.getIsGrouding());				
				break;
			default:
				System.out.println("输入有误,请输入1或者2");
				break;
			}
			return ca;
		}
	}

	@Override
	public void getLendRecord() {		
	
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getAllRecord();
		
	
		System.out.println("============================================================");
		System.out.println("订单编号\t\t用户编号\t用户名\t\t汽车编号\t汽车名称\t汽车类型\t汽车品牌\t每日租金\t总租金\t借出时间\t\t归还时间 ");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
			System.out.print("\t"+lr.getCarId());
			System.out.print("\t"+lr.getCarName());
			System.out.print("\t"+lr.getCarType());
			System.out.print("\t"+lr.getCarBrand());
			System.out.print("\t"+lr.getCarPrice());
			System.out.print("\t"+lr.getCarTotalPrice());
			System.out.print("\t"+ lr.getCarLendDate());
			System.out.println("\t"+ lr.getCarReturnDate());
		}
		
				
		
	}

	@Override
	public void checkCarByClientId(int specifyClientId) {
		
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getspecifyClient(specifyClientId);
			
		System.out.println("============================================================");
		System.out.println("订单编号\t\t用户编号\t用户名\t\t汽车编号\t汽车名称\t汽车类型\t汽车品牌\t每日租金\t总租金\t借出时间\t\t归还时间");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
			System.out.print("\t"+lr.getCarId());
			System.out.print("\t"+lr.getCarName());
			System.out.print("\t"+lr.getCarType());
			System.out.print("\t"+lr.getCarBrand());
			System.out.print("\t"+lr.getCarPrice());
			System.out.print("\t"+lr.getCarTotalPrice());
			System.out.print("\t"+ lr.getCarLendDate());
			System.out.println("\t"+ lr.getCarReturnDate());
		}
			
		
	}

	@Override
	public void checkCarByCarId(int specifyCarId) {
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getspecifyCar(specifyCarId);
			
		System.out.println("============================================================");
		System.out.println("订单编号\t\t用户编号\t用户名\t\t汽车编号\t汽车名称\t汽车类型\t汽车品牌\t每日租金\t总租金\t借出时间\t\t归还时间 ");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
			System.out.print("\t"+lr.getCarId());
			System.out.print("\t"+lr.getCarName());
			System.out.print("\t"+lr.getCarType());
			System.out.print("\t"+lr.getCarBrand());
			System.out.print("\t"+lr.getCarPrice());
			System.out.print("\t"+lr.getCarTotalPrice());
			System.out.print("\t"+ lr.getCarLendDate());
			System.out.println("\t"+ lr.getCarReturnDate());
		}
		
				
	}

}
