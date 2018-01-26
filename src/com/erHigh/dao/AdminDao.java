package com.erHigh.dao;

import java.util.ArrayList;
import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;

public interface AdminDao {
	//��ѯ���е�����
	public ArrayList<Car> getAllCar();
	
	//�鿴ָ������
	public Car getSpecifyCar(int inPutCarId);
	
	//�������
	public Car AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber,
			String inPutCarRemark, String inPutCarColor,  int inPutCarWorth, int inPutCarPrice,
			String inPutCarStatus, String inPutCarGroud);
	
	//�޸�������Ϣ
	public Car getCarById(int inPutCarId2);

	public Car changePrice(int inPutPrice,int inPutCarId2);

	public Car changeGroud(String inPutNewGroud,int inPutCarId2);
	
	public ArrayList<LendRecord> getAllRecord();

	public ArrayList<LendRecord> getspecifyClient(int specifyClientId);

	public ArrayList<LendRecord> getspecifyCar(int specifyCarId);
	
}
