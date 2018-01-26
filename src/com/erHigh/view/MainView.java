package com.erHigh.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pmw.tinylog.Logger;

public class MainView extends View {
	

	View lv = new LoginView();
	View rv = new RegistView();
	View va = new AdminView();
	@Override
	public View showView() {
		
		System.out.println("=========================");
		System.out.println("	��ӭ���ʶ����⳵");
		System.out.println("=========================");
		
		System.out.print("1.�û���¼     ");
		System.out.print("2.�û�ע��     ");
		System.out.print("3.����Ա��½     ");
		System.out.print("0.�˳�");
		
		System.out.println("\n������ѡ��:");
		Scanner scan = new Scanner(System.in);
		Logger.info("��������⳵ϵͳ");
		int choose = scan.nextInt();
		
		/**�˴�����Ӳ����쳣���,  ȷ���ͻ���������������͵�
		 * �ݲ�֪����ν��в������
		 */
			switch (choose) {
			case 0:
				Logger.info("�˳������⳵ϵͳ");
				System.out.println("��лʹ�ö����⳵ϵͳ");
				System.exit(0);
				break;
			case 1:
				Logger.info("��¼�����⳵ϵͳ");
				System.out.println("=======��½=====>>>>");
				lv.showView();
				break;
			case 2:
				Logger.info("ע������⳵ϵͳ");
				System.out.println("=======ע��=====>>>>");
				rv.showView();
				break;	
			case 3:
				Logger.info("����Ա��¼�⳵ϵͳ");
				va.showView();
				break;		
				
			default:
				System.out.println("��������!");
				break;
				
			}
			return null;
		
		
	}
	

	
}
