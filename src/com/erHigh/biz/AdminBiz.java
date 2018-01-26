package com.erHigh.biz;

import com.erHigh.bean.Car;

public interface AdminBiz {
	//查看所有的汽车
	public void checkAllCar();
	//查看指定汽车
	public Car checkSpecifyCar(int inPutCarId);
	//添加汽车
	public void AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber, String inPutCarRemark, String inPutCarColor, int inPutCarWorth, int inPutCarPrice, String inPutCarStatus, String inPutCarGroud);
	//修改汽车信息
	public Car updateCarInfo(int inPutCarId2);
	//查看所有的汽车记录
	public void getLendRecord();
	//根据指定用户查看租赁记录
	public void checkCarByClientId(int specifyClientId);
	//根据指定汽车编号查看租赁记录
	public void checkCarByCarId(int specifyCarId);
}
