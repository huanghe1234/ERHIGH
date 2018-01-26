package com.erHigh.bizImp;

import java.util.ArrayList;

import com.erHigh.bean.Car;

import com.erHigh.bean.LendRecord;
import com.erHigh.biz.CarBiz;
import com.erHigh.dao.CarDao;
import com.erHigh.dao.ClientDao;
import com.erHigh.daoImpl.CarDaoImpl;
import com.erHigh.daoImpl.ClientDaoImpl;

public class CarBizImpl implements CarBiz{
	
	CarDao cd = new CarDaoImpl();
	ClientDao cld = new ClientDaoImpl();

	String clientName;
	String clientPwd;
	@Override
	//获得所有可借汽车信息
	public void getCar() {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getOkCar();
		System.out.println("============================================================");
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t是否可租\t是否可预约 ");
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
			System.out.println("\t"+car.getIsOrder());
			
		}
				
	}
	


	@Override
	//借车时的借车信息和用户信息 
	public Car lendCarById(int inPutCarId,String clientName) {
			
	
		Car ca = new Car();
		ca = cd.getLendCar(inPutCarId,clientName);
	 	
			if(!(ca==null)) {
				System.out.println("租车信息如下:");
				System.out.println("============================================================");
				System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t借出时间");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+ca.getCarPrice()+"元/天");
				System.out.println("\t"+ca.getCarLendDate());
			}
				
			return ca;
				
	}


	
	
	@Override
	public void getCarByPrice() {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getAscending();
		System.out.println("============================================================");
		System.out.println("编号\t价格\t汽车名称\t备注\t品牌\t类型\t是否可租\t是否可预约 ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}
	
	
	@Override
	public void getCarByPrice1() {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getDescending();
		System.out.println("============================================================");
		System.out.println("编号\t价格\t汽车名称\t备注\t品牌\t类型\t是否可租\t是否可预约 ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}
	
	
	@Override
	public void getCarType(int inPutCarType) {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getCarByType(inPutCarType);
		System.out.println("============================================================");
		System.out.println("编号\t类型\t价格\t汽车名称\t备注\t品牌\t是否可租\t是否可预约 ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}
	
	
	
	
	@Override
	public void getCarBrand(int inPutCarBrand) {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getCarByBrand(inPutCarBrand);
		System.out.println("============================================================");
		System.out.println("编号\t品牌\t类型\t价格\t汽车名称\t备注\t是否可租\t是否可预约 ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}
	
	
	@Override
	public void getCarClient(String clientName) {
		ArrayList<LendRecord> list = new ArrayList<>();
		list = cd.getCarByClient(clientName);
		
		System.out.println("租车列表如下:");
		System.out.println("============================================================");
		System.out.println("用户名\t\t汽车编号\t汽车名称\t汽车类型\t汽车品牌\t每日租金\t总租金\t借出时间\t\t归还时间 ");
		for(LendRecord lr :list) {
			System.out.print(lr.getClientName());
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
	public Car returnCarById(int inPutCarId2, String clientName) {
		
		Car ca = new Car();
		ca = cd.getReturnCar(inPutCarId2,clientName);
		
		if (!(ca==null)) {
			 	
			System.out.println("还车信息如下:");	
			System.out.println("============================================================");
			System.out.println("编号\t汽车名称\t备注\t品牌\t类型     \t价格\t总租金\t归还时间");
			System.out.print(ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"元/天");
			System.out.print("\t"+ca.getCarTotalPrice());
			System.out.println("\t"+ca.getCarReturnDate());
		}
		return ca;
	}



	@Override
	public void getCarVague(String inPutVague) {
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getCarByType(inPutVague);
		System.out.println("============================================================");
		System.out.println("编号\t类型\t价格\t汽车名称\t备注\t品牌\t是否可租\t是否可预约 ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"元/天");
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}



	@Override
	public Car getOrderCar(int inPutCarId3,int inPutCarDate,String clientName) {
		Car ca = new Car();
		ca = cd.getOrder(inPutCarId3,inPutCarDate,clientName);	
		
		if (inPutCarId3 != ca.getCarId()) {
			System.out.println("汽车编号不存在!");
			return null;
		}else {
			System.out.println("预约车车信息如下:");
			System.out.println("(注意:如果借出时间为空,说明预约失败,该车已预约或者已出租)");
			System.out.println("============================================================");
			System.out.println("预约人姓名\t\t编号\t汽车名称\t备注\t品牌\t类型     \t价格\t取车时间");
			System.out.print(clientName);
			System.out.print("\t"+ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"元/天");
			System.out.println("\t"+ca.getCarLendDate());
			return ca;
		}
		
	}
		
		
		
		
	
	
	
}
