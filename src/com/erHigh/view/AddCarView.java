package com.erHigh.view;

import java.util.Scanner;

import com.erHigh.biz.AdminBiz;
import com.erHigh.bizImp.AdminBizImpl;

public class AddCarView {
	
	AdminBiz ab = new AdminBizImpl();
	
	public void CarView() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("===================");
		System.out.println("��ֱ�����������Ϣ");
		System.out.println("-------------------");
		System.out.println("Ʒ������:");
		System.out.println("Ʒ�Ʊ��\tƷ����");
		System.out.println("1\t����");
		System.out.println("2\t����");
		System.out.println("3\t�µ�");
		System.out.println("4\t����");
		System.out.println("5\t����");
		System.out.println("��ѡ��Ʒ�Ʊ��:");
		int inPutBrandId = scan.nextInt();
		
		String brandCar= null;
		if (inPutBrandId ==1) {
			brandCar = "����";
		}else if (inPutBrandId ==2) {
			brandCar = "����";
		}else if (inPutBrandId ==3) {
			brandCar = "�µ�";
		}else if (inPutBrandId ==4) {
			brandCar = "����";
		}else if (inPutBrandId ==5) {
			brandCar = "����";
		}else {
			System.out.println("��������!");
		}
		
		
			
			String typeCar = null;
			System.out.println("-------------------");
			System.out.println("��������:");
			System.out.println("���ͱ��\t������");
			System.out.println("1\t������");
			System.out.println("2\t������");
			System.out.println("3\tSUV");
			System.out.println("4\t��Ӣ��");
			System.out.println("��ѡ��Ʒ�Ʊ��:");
			int inPutTypeId = scan.nextInt();
			if (inPutTypeId == 1 ) {
				typeCar= "������";
				
			}else if (inPutTypeId == 2) {
				typeCar= "������";
			
			}else if (inPutTypeId == 3) {
				typeCar= "SUV";
				
			}else if (inPutTypeId == 4) {
				typeCar= "��Ӣ��";
			
			}else {
				System.out.println("��������");
			}
		
		
		System.out.println("-------------------");
		System.out.println("��������������");
		String inPutCarName = scan.next();
		
		System.out.println("-------------------");
		System.out.println("�����복�ƺ�");
		String inPutCarNumber = scan.next();
		
		System.out.println("-------------------");
		System.out.println("�������Ҫ");
		String inPutCarRemark = scan.next();
		
		System.out.println("-------------------");
		System.out.println("��������ɫ");
		String inPutCarColor = scan.next();
		
		System.out.println("-------------------");
		System.out.println("�����������۸�");
		int inPutCarWorth = scan.nextInt();
		
		System.out.println("-------------------");
		System.out.println("������ÿ�����");
		int inPutCarPrice = scan.nextInt();
		
		String inPutCarStatus=null;	
		while(true) {
			System.out.println("-------------------");
			System.out.println("�Ƿ�ɽ�(0.����;1.�����)");
			int inPutCarStatusNum = scan.nextInt();
			
				if (inPutCarStatusNum == 0) {
					inPutCarStatus = "����";
					break;
				}else if (inPutCarStatusNum == 1){
					inPutCarStatus = "�����";
					break;
				}else {
					System.out.println("����ĺ�������");
				}
		}	
			
		String inPutCarGroud = null;
		while(true) {
			System.out.println("-------------------");
			System.out.println("�Ƿ�ɽ�(0.�ϼ�;1.�¼�)");
			int inPutCarGroudNum = scan.nextInt();
			
				if (inPutCarGroudNum == 0) {
					inPutCarGroud = "�ϼ�";
					break;
				}else if (inPutCarGroudNum == 1){
					inPutCarGroud = "�¼�";
					break;
				}else {
					System.out.println("����ĺ�������");
				}
		}
		
		ab.AddCar(inPutBrandId,brandCar,inPutTypeId,typeCar,inPutCarName,inPutCarNumber,inPutCarRemark,
				inPutCarColor,inPutCarWorth,inPutCarPrice,inPutCarStatus,inPutCarGroud);

				
	}
	
	
}
