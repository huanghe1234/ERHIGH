package com.erHigh.dao;

import java.util.ArrayList;

import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;

public interface CarDao {

	//获得所有可租汽车的方法
	public ArrayList<Car> getOkCar();
	
	//租车的方法,把状态改为'已租出',租出时间为当前系统时间
	public Car getLendCar(int inPutCarId, String clientName);
	
	//按照价格升序排列
	public ArrayList<Car> getAscending();
	
	//按照价格降序排列
	public ArrayList<Car> getDescending();
	
	//按照类型进行排序
	public ArrayList<Car> getCarByType(int inPutCarType);
	
	//按照品牌进行排序
	public ArrayList<Car> getCarByBrand(int inPutCarBrand);
	
	//获得租车列表
	public ArrayList<LendRecord> getCarByClient(String clientName);
	
	//还车的方法
	public Car getReturnCar(int inPutCarId2, String clientName);
	
	//模糊查询
	public ArrayList<Car> getCarByType(String inPutVague);
	
	//预约车
	public Car getOrder(int inPutCarId3, int inPutCarDate,String clientName);
	
	
}
