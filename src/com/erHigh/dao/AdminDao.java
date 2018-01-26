package com.erHigh.dao;

import java.util.ArrayList;
import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;

public interface AdminDao {
	//查询所有的汽车
	public ArrayList<Car> getAllCar();
	
	//查看指定汽车
	public Car getSpecifyCar(int inPutCarId);
	
	//添加汽车
	public Car AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber,
			String inPutCarRemark, String inPutCarColor,  int inPutCarWorth, int inPutCarPrice,
			String inPutCarStatus, String inPutCarGroud);
	
	//修改汽车信息
	public Car getCarById(int inPutCarId2);

	public Car changePrice(int inPutPrice,int inPutCarId2);

	public Car changeGroud(String inPutNewGroud,int inPutCarId2);
	
	public ArrayList<LendRecord> getAllRecord();

	public ArrayList<LendRecord> getspecifyClient(int specifyClientId);

	public ArrayList<LendRecord> getspecifyCar(int specifyCarId);
	
}
