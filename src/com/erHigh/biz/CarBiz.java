package com.erHigh.biz;

import com.erHigh.bean.Car;

public interface CarBiz {
	//�������������ѯ����
	public void getCar();
	//��������ID�����⳵
	public Car lendCarById (int inPutCarId, String clientName);
	
	//��ü۸���������
	public void getCarByPrice();
	
	//��ü۸�������
	public void getCarByPrice1();
	
	//�����������ͽ�������
	public void getCarType(int inPutCarType);
	
	//��������Ʒ�ƽ�������
	public void getCarBrand(int inPutCarBrand);
	
	//��ѯ�ͻ����⳵��¼
	public void getCarClient(String clientName);
		
	//��������ID���л���
	public Car returnCarById(int inPutCarId2, String clientName);
	//ģ����ѯ
	public void getCarVague(String inPutVague);
	//ԤԼ��
	public Car getOrderCar(int inPutCarId3,int inPutCarDate,String clientName);
	
	
}
