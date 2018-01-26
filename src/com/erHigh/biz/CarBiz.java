package com.erHigh.biz;

import com.erHigh.bean.Car;

public interface CarBiz {
	//获得所有汽车查询界面
	public void getCar();
	//根据汽车ID进行租车
	public Car lendCarById (int inPutCarId, String clientName);
	
	//获得价格升序排列
	public void getCarByPrice();
	
	//获得价格降序排列
	public void getCarByPrice1();
	
	//按照汽车类型进行排列
	public void getCarType(int inPutCarType);
	
	//按照汽车品牌进行排序
	public void getCarBrand(int inPutCarBrand);
	
	//查询客户的租车记录
	public void getCarClient(String clientName);
		
	//根据汽车ID进行还车
	public Car returnCarById(int inPutCarId2, String clientName);
	//模糊查询
	public void getCarVague(String inPutVague);
	//预约车
	public Car getOrderCar(int inPutCarId3,int inPutCarDate,String clientName);
	
	
}
