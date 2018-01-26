package com.erHigh.view;

import java.util.Scanner;
import org.pmw.tinylog.Logger;
import com.erHigh.biz.CarBiz;
import com.erHigh.bizImp.CarBizImpl;
import com.erHigh.test.Test;

public class UserView {

	CarBiz cab = new CarBizImpl();
	Test test = new Test();
	String[] args;
	
	public View showUserView(String clientName) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("����0�˳�");
			System.out.println("����1+�������,�����⳵����");
			System.out.println("����2+1,���ռ۸���������");
			System.out.println("����2+2,���ռ۸�������");
			System.out.println("����3+���ͱ��,������������");
			System.out.println("����4+Ʒ�Ʊ��,����Ʒ������");
			System.out.println("����5,�鿴ȫ������");
			System.out.println("����6,�鿴�ҵ��⳵/ԤԼ����¼");
			System.out.println("����7+�������,����");
			System.out.println("����8,ģ����ѯ");
			System.out.println("����9+�������,ԤԼ��");
			
			System.out.println("����ѡ��:");
			
			String choose = scan.next();
			String one = choose.substring(0,1);
			int a = Integer.parseInt(one);
			
			/**�˴�����Ӳ����쳣���,  ȷ���ͻ���������������͵�,����ȷ����10���ڵ�����
			 * �ݲ�֪����ν��в������
			 */
			
			switch (a) {
			case 1:
				Logger.info("�����⳵����");
				String a1 = choose.substring(2);
				int inPutCarId = Integer.parseInt(a1);
				cab.lendCarById(inPutCarId,clientName);
				break;
			case 2:
				Logger.info("���ռ۸���������");
				String a2 = choose.substring(2);
				int rent = Integer.parseInt(a2);
				if(rent == 1) {
					System.out.println("�۸�����������");		
					cab.getCarByPrice();
				}else if (rent == 2) {
					System.out.println("�۸��ս�������");
					cab.getCarByPrice1();
				}else {
					System.out.println("���벻��ȷ");
				}
				break;
			case 3:
				Logger.info("������������");
				System.out.println("1������ //2������ //3SUV//4��Ӣ��");
				String a3 = choose.substring(2);
				int inPutCarType = Integer.parseInt(a3);			
				cab.getCarType(inPutCarType);
				break;			
			case 4 :
				Logger.info("����Ʒ������");
				System.out.println("1����//2����//3�µ�//4����//5����");
				String a4 = choose.substring(2);
				int inPutCarBrand = Integer.parseInt(a4);
				cab.getCarBrand(inPutCarBrand);
				break;
			case 5:
				Logger.info("�鿴ȫ������");
				//String a5 = choose.substring(2);
				cab.getCar();
				break;
			case 6:	
				Logger.info("�鿴�ҵ��⳵/ԤԼ����¼");
				cab.getCarClient(clientName);
				break;
			case 7:
				Logger.info("���뻹������");
				String a7 = choose.substring(2);
				int inPutCarId2 = Integer.parseInt(a7);
				cab.returnCarById(inPutCarId2,clientName);
				break; 		
			case 8:
				Logger.info("ģ������");
				System.out.println("������Ҫ��ѯ������:");
				String inPutVague = scan.next();
				//String inPutVague = choose.substring(2);			
				cab.getCarVague(inPutVague);
				break;
			case 9:
				Logger.info("����ԤԼ������");
				System.out.println("��������������ȡ��:");
				int inPutCatDate = scan.nextInt();
				String a9 = choose.substring(2);
				int inPutCarId3 = Integer.parseInt(a9);
				cab.getOrderCar(inPutCarId3,inPutCatDate,clientName);
				break;
			case 0 :
				test.main(args);
				break;
			default:
				Logger.info("��������");
				System.out.println("�������!");
				break;
			}
		
	
		}
		
		

		
	}

}
