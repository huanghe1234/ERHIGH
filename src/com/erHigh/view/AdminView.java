package com.erHigh.view;

import java.util.Scanner;
import org.pmw.tinylog.Logger;
import com.erHigh.biz.AdminBiz;
import com.erHigh.bizImp.AdminBizImpl;

public class AdminView extends View {
	//����Ա�˺���������:
	String admin = "admin";
	String pwd = "admin";	
	
	
	AdminBiz ab = new AdminBizImpl();
	AddCarView ac = new AddCarView();

	@Override
	//��ʾ
	public View showView() {
		Scanner scan = new Scanner(System.in);		
		System.out.println("=================================");
		System.out.println("	��ӭ���ʶ����⳵����Աϵͳ");
		System.out.println("=================================");
		System.out.println("1.��¼\t2.�˳�");
		
		int choose = scan.nextInt();
		switch (choose) {
		case 1:
			while(true) {
				System.out.println("�������˻�:");
				String inPutAdmin = scan.next();
				System.out.println("����������:");
				String inPutPwd = scan.next();
					if(inPutAdmin.equals(admin) && inPutPwd.equals(pwd)) {
						System.out.println("��¼�ɹ�!��ӭ" + inPutAdmin + "����");
						Logger.info("��¼�ɹ�");
						showManagerView();
						break;
					}else {
						Logger.info("��������");
						System.out.println("������˻�������������!");
					}
			}
			break;
		case 2:
			System.out.println("�����ϼ��˵�");
			break;	
		default:
			Logger.info("��������");
			System.out.println("��������,��ѡ��1����2");
			break;
		}

		return null;
	}
	
	
	
	public View showManagerView() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("����0�˳�");
			System.out.println("����1+������� �鿴ָ������");
			System.out.println("����2 �鿴ȫ������");
			System.out.println("����3 �������");
			System.out.println("����4+������� �޸�������Ϣ");
			System.out.println("����5 �鿴ȫ�����޼�¼");
			System.out.println("����6+�û����,�鿴ָ���û������޼�¼");
			System.out.println("����7+�������,�鿴ָ�����������޼�¼");
			
			System.out.println("����ѡ��:");
			String choose = scan.next();
			String one = choose.substring(0,1);
			int a = Integer.parseInt(one);
		
			switch (a) {
			case 1:
				Logger.info("�鿴ָ������");
				String a1 = choose.substring(2);
				int inPutCarId = Integer.parseInt(a1);
				ab.checkSpecifyCar(inPutCarId);
				break;
			case 2:
				Logger.info("�鿴ȫ������");
				ab.checkAllCar();			
				break;	
			case 3:
				Logger.info("�������");
				ac.CarView();	
				break;		
			case 4:
				Logger.info("�޸�������Ϣ");
				String a4 = choose.substring(2);
				int inPutCarId2 = Integer.parseInt(a4);
				ab.updateCarInfo(inPutCarId2);
				break;
			case 5:
				Logger.info("�鿴ȫ�����޼�¼");
				ab.getLendRecord();
				break;
			case 6:
				Logger.info("�鿴ָ���û������޼�¼");
				String a6 = choose.substring(2);
				int specifyClientId = Integer.parseInt(a6);
				ab.checkCarByClientId(specifyClientId);	
				break;	
			case 7:
				Logger.info("�鿴ָ�����������޼�¼");
				String a7 = choose.substring(2);
				int specifyCarId = Integer.parseInt(a7);
				ab.checkCarByCarId(specifyCarId);
				break;	
			case 0 :
				
				break;	
			default:
				System.out.println("��������,����1-7֮��ѡ������");
				break;
			}
			
		
		}
		
	
	}
	
	
}
