package com.erHigh.biz;

import com.erHigh.bean.Car;

public interface AdminBiz {
	//�鿴���е�����
	public void checkAllCar();
	//�鿴ָ������
	public Car checkSpecifyCar(int inPutCarId);
	//�������
	public void AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber, String inPutCarRemark, String inPutCarColor, int inPutCarWorth, int inPutCarPrice, String inPutCarStatus, String inPutCarGroud);
	//�޸�������Ϣ
	public Car updateCarInfo(int inPutCarId2);
	//�鿴���е�������¼
	public void getLendRecord();
	//����ָ���û��鿴���޼�¼
	public void checkCarByClientId(int specifyClientId);
	//����ָ��������Ų鿴���޼�¼
	public void checkCarByCarId(int specifyCarId);
}
