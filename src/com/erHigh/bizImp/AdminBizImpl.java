package com.erHigh.bizImp;

import java.util.ArrayList;
import java.util.Scanner;

import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;
import com.erHigh.biz.AdminBiz;
import com.erHigh.dao.AdminDao;
import com.erHigh.daoImpl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz{
	
	AdminDao ad = new AdminDaoImpl();

	@Override
	public void checkAllCar() {
	
		ArrayList<Car> list = new ArrayList<>();
		
		list= ad.getAllCar();
		System.out.println("============================================================");
		System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�Ƿ����\t�Ƿ��ϼ�\tԤԼ״̬");
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
			System.out.print("\t"+car.getIsGrouding());
			System.out.println("\t"+car.getIsOrder());
		}
		
	}

	@Override
	//�鿴ָ����������Ϣ
	public Car checkSpecifyCar(int inPutCarId) {
		Car ca = new Car();
		ca = ad.getSpecifyCar(inPutCarId);
		
		if(inPutCarId != ca.getCarId()) {
			System.out.println("������Ų�����!");
			return null;
		} else {
		System.out.println("============================================================");
		System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�Ƿ����\t�Ƿ��ϼ�\tԤԼ״̬");
		System.out.print(ca.getCarId());
		System.out.print("\t"+ca.getCarName());
		System.out.print("\t"+ca.getCarRemark());
		System.out.print("\t"+ca.getCarBrand());
		System.out.print("("+ca.getCarBrandNumber()+")");
		System.out.print("\t"+ca.getCarType());
		System.out.print("("+ca.getCarTypeNumber()+")");
		System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
		System.out.print("\t"+ca.getCarStatus());
		System.out.print("\t"+ca.getIsGrouding());
		System.out.println("\t"+ca.getIsOrder());
		return ca;
		}
		
	}

	@Override
	public void AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber,
			String inPutCarRemark, String inPutCarColor,int inPutCarWorth, int inPutCarPrice,
			String inPutCarStatus, String inPutCarGroud) {
		Car ca = new Car();
		
		ca = ad.AddCar(inPutBrandId, brandCar, inPutTypeId, typeCar,inPutCarName, inPutCarNumber, inPutCarRemark, inPutCarColor, inPutCarWorth, inPutCarPrice, inPutCarStatus, inPutCarGroud);
		System.out.println("��ӳɹ�!");
		System.out.println(ca);
	}

	@Override
	public Car updateCarInfo(int inPutCarId2) {
		Scanner scan = new Scanner(System.in);
		Car ca = new Car();
		ca = ad.getCarById(inPutCarId2);
		
		if(inPutCarId2 != ca.getCarId()) {
			System.out.println("������Ų�����");
			return null;
		}else {
			System.out.println("============================================================");
			System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�ܼ�ֵ\t�Ƿ����\t�Ƿ��ϼ�");
			System.out.print(ca.getCarId());
			System.out.print("\t"+ca.getCarName());
			System.out.print("\t"+ca.getCarRemark());
			System.out.print("\t"+ca.getCarBrand());
			System.out.print("("+ca.getCarBrandNumber()+")");
			System.out.print("\t"+ca.getCarType());
			System.out.print("("+ca.getCarTypeNumber()+")");
			System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
			System.out.print("\t"+ca.getCarWorth()+"Ԫ");
			System.out.print("\t"+ca.getCarStatus());
			System.out.println("\t"+ca.getIsGrouding());
				
			
			System.out.println("������Ҫ�޸ĵ����ݵı��");
			System.out.println("1.���޼۸�         2.�ϼ��¼�");
			int choose = scan.nextInt();
			switch (choose) {
			case 1:
				Car c = new Car();
				System.out.println("�����µ����޼۸�");
				int inPutPrice = scan.nextInt();
				c = ad.changePrice(inPutPrice,inPutCarId2);
				System.out.println("�޸ļ۸����!");
				System.out.println("============================================================");
				System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�ܼ�ֵ\t�Ƿ����\t�Ƿ��ϼ�");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+c.getCarPrice()+"Ԫ/��");
				System.out.print("\t"+ca.getCarWorth()+"Ԫ");
				System.out.print("\t"+ca.getCarStatus());
				System.out.println("\t"+ca.getIsGrouding());			
				break;
			case 2:
				System.out.println("�����ϼ�  �����¼�");
				String inPutchoose = scan.next();
				String inPutNewGroud = null;
				
				Car c2 = new Car();
				if(inPutchoose.equals("�ϼ�")) {
					inPutNewGroud = "�ϼ�";
				}else if(inPutchoose.equals("�¼�")){
					
						if (ca.getCarStatus().equals("�����") || ca.getIsOrder().equals("��ԤԼ")) {
							System.out.println("�ó����⳵������ԤԼ,�����޸��¼�");
							break;
						}else {
							inPutNewGroud = "�¼�";
						}
				}else {
					System.out.println("��������!");
				}
				c2 = ad.changeGroud(inPutNewGroud,inPutCarId2);
				System.out.println("�޸����¼����");		
				System.out.println("============================================================");
				System.out.println("���\t��������\t��ע\tƷ��\t����     \t�۸�\t�ܼ�ֵ\t�Ƿ����\t�Ƿ��ϼ�");
				System.out.print(ca.getCarId());
				System.out.print("\t"+ca.getCarName());
				System.out.print("\t"+ca.getCarRemark());
				System.out.print("\t"+ca.getCarBrand());
				System.out.print("("+ca.getCarBrandNumber()+")");
				System.out.print("\t"+ca.getCarType());
				System.out.print("("+ca.getCarTypeNumber()+")");
				System.out.print("\t"+ca.getCarPrice()+"Ԫ/��");
				System.out.print("\t"+ca.getCarWorth()+"Ԫ");
				System.out.print("\t"+ca.getCarStatus());
				System.out.println("\t"+c2.getIsGrouding());				
				break;
			default:
				System.out.println("��������,������1����2");
				break;
			}
			return ca;
		}
	}

	@Override
	public void getLendRecord() {		
	
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getAllRecord();
		
	
		System.out.println("============================================================");
		System.out.println("�������\t\t�û����\t�û���\t\t�������\t��������\t��������\t����Ʒ��\tÿ�����\t�����\t���ʱ��\t\t�黹ʱ�� ");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
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
	public void checkCarByClientId(int specifyClientId) {
		
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getspecifyClient(specifyClientId);
			
		System.out.println("============================================================");
		System.out.println("�������\t\t�û����\t�û���\t\t�������\t��������\t��������\t����Ʒ��\tÿ�����\t�����\t���ʱ��\t\t�黹ʱ��");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
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
	public void checkCarByCarId(int specifyCarId) {
		ArrayList<LendRecord> list = new ArrayList<>();
		list = ad.getspecifyCar(specifyCarId);
			
		System.out.println("============================================================");
		System.out.println("�������\t\t�û����\t�û���\t\t�������\t��������\t��������\t����Ʒ��\tÿ�����\t�����\t���ʱ��\t\t�黹ʱ�� ");
		for(LendRecord lr :list) {
			System.out.print(lr.getLrId());
			System.out.print("\t"+lr.getClientId());
			System.out.print("\t"+lr.getClientName());
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

}
