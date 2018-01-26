package com.erHigh.dao;

import java.util.ArrayList;

import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;

public interface CarDao {

	//������п��������ķ���
	public ArrayList<Car> getOkCar();
	
	//�⳵�ķ���,��״̬��Ϊ'�����',���ʱ��Ϊ��ǰϵͳʱ��
	public Car getLendCar(int inPutCarId, String clientName);
	
	//���ռ۸���������
	public ArrayList<Car> getAscending();
	
	//���ռ۸�������
	public ArrayList<Car> getDescending();
	
	//�������ͽ�������
	public ArrayList<Car> getCarByType(int inPutCarType);
	
	//����Ʒ�ƽ�������
	public ArrayList<Car> getCarByBrand(int inPutCarBrand);
	
	//����⳵�б�
	public ArrayList<LendRecord> getCarByClient(String clientName);
	
	//�����ķ���
	public Car getReturnCar(int inPutCarId2, String clientName);
	
	//ģ����ѯ
	public ArrayList<Car> getCarByType(String inPutVague);
	
	//ԤԼ��
	public Car getOrder(int inPutCarId3, int inPutCarDate,String clientName);
	
	
}
