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
	//������пɽ�������Ϣ
	public void getCar() {
		//Car c = new Car();
		ArrayList<Car> list = new ArrayList<>();
		
		list= cd.getOkCar();
		System.out.println("============================================================");
		System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarName());
			System.out.print("\t"+car.getCarRemark());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
			System.out.print("\t"+car.getCarStatus());
			System.out.println("\t"+car.getIsOrder());
			
		}
				
	}
	


	@Override
	//�賵ʱ�Ľ賵��Ϣ���û���Ϣ 
	public Car lendCarById(int inPutCarId,String clientName) {
			
	
		Car ca = new Car();
		ca = cd.getLendCar(inPutCarId,clientName);
	 	
			if(!(ca==null)) {
				System.out.println("�⳵��Ϣ����:");
				System.out.println("============================================================");
				System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t���ʱ��");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
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
		System.out.println("���\t�۸�\t��������\t��ע\tƷ��\t����\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
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
		System.out.println("���\t�۸�\t��������\t��ע\tƷ��\t����\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
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
		System.out.println("���\t����\t�۸�\t��������\t��ע\tƷ��\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
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
		System.out.println("���\tƷ��\t����\t�۸�\t��������\t��ע\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarBrand());
			System.out.print("("+car.getCarBrandNumber()+")");
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
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
		
		System.out.println("�⳵�б�����:");
		System.out.println("============================================================");
		System.out.println("�û���\t\t�������\t��������\t��������\t����Ʒ��\tÿ�����\t�����\t���ʱ��\t\t�黹ʱ�� ");
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
			 	
			System.out.println("������Ϣ����:");	
			System.out.println("============================================================");
			System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�����\t�黹ʱ��");
			System.out.print(ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
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
		System.out.println("���\t����\t�۸�\t��������\t��ע\tƷ��\t�Ƿ����\t�Ƿ��ԤԼ ");
		for(Car car :list) {
			System.out.print(car.getCarId());
			System.out.print("\t"+car.getCarType());
			System.out.print("("+car.getCarTypeNumber()+")");
			System.out.print("\t"+car.getCarPrice()+"Ԫ/��");
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
			System.out.println("������Ų�����!");
			return null;
		}else {
			System.out.println("ԤԼ������Ϣ����:");
			System.out.println("(ע��:������ʱ��Ϊ��,˵��ԤԼʧ��,�ó���ԤԼ�����ѳ���)");
			System.out.println("============================================================");
			System.out.println("ԤԼ������\t\t���\t��������\t��ע\tƷ��\t����     \t�۸�\tȡ��ʱ��");
			System.out.print(clientName);
			System.out.print("\t"+ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
			System.out.println("\t"+ca.getCarLendDate());
			return ca;
		}
		
	}
		
		
		
		
	
	
	
}
