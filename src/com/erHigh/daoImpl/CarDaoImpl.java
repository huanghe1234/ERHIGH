package com.erHigh.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erHigh.bean.Car;
import com.erHigh.bean.Client;
import com.erHigh.bean.LendRecord;
import com.erHigh.dao.CarDao;
import com.erHigh.tools.DBHelper;

public class CarDaoImpl implements CarDao{
	
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	private DBHelper mDB;
	//private int rInt;
	
	public CarDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	
	
	
	//������п��������ķ���
	public ArrayList<Car> getOkCar() {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "select * from CAR where carStatus = '����' and CARISGROUDING = '�ϼ�'";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	
		
		return list;
			
	}
	
	


	@Override
	//�⳵�ķ���,��״̬��Ϊ'�����'
	public Car getLendCar(int inPutCarId,String clientName) {
		CallableStatement cstmt = null;
		Car ca = new Car();	
		ResultSet rSet1;
		Client cl = new Client();
		try {
/*			String sql0 = "update CAR set CARSTATUS = '�����' , CARLENDDATE = SYSDATE , CARRETURNDATE = SYSDATE+1 where CARID = ? and CARSTATUS = '����'";	
			mStatement = mConnection.prepareStatement(sql0);
			mStatement.setLong(1, inPutCarId);	
			rInt = mStatement.executeUpdate();
*/			
			//���û�����Ϊ��¼ʱ������ʱ,ȡ�������е��ֶ�,Ȼ���ڰ���Щ�ֶθ�ֵ��clientʵ����
			String sql = "select * from CLIENT where CLIENTNAME = ?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, clientName);
			rSet1 = mStatement.executeQuery() ;		
			while(rSet1.next()) {
				cl.setClientId(rSet1.getInt("CLIENTID"));
				cl.setClientName(rSet1.getString("CLIENTNAME"));
				cl.setClientPwd(rSet1.getString("CLIENTPWD"));
				cl.setClientStatus(rSet1.getInt("CLIENTSTATUS"));
			}
			

					
			//������IdΪ��ѡ��ı��ʱ,ȡ�����е��ֶ�,Ȼ�����Щ�ֶθ�ֵ��Carʵ����
			String sql2 = "select *  from CAR where CARID = ?";
			mStatement = mConnection.prepareStatement(sql2);
			mStatement.setLong(1, inPutCarId);
			rSet = mStatement.executeQuery();		
			while(rSet.next()) {
				ca.setCarId(rSet.getInt("CARID"));
				ca.setCarName(rSet.getString("CARNAME"));
				ca.setCarBrand(rSet.getString("CARBRAND"));
				ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				ca.setCarType(rSet.getString("CARTYPE"));
				ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				ca.setCarPrice(rSet.getInt("CARPRICE"));
				ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				ca.setCarStatus(rSet.getString("CARSTATUS"));
				ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
				ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				ca.setIsGrouding(rSet.getString("CARISGROUDING"));
				ca.setCarRemark(rSet.getString("CARRAMARK"));			
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}		
		/**
		 * ��������������,�Ͳ�ѯ�����ı�����Ա�,�����ͬ�򷵻�Ϊnull,����������Ų�����
		 * ��ѯ������״̬,������������,�򷵻�null,�������������ѱ����
		 * ������������,��ִ����������
		 */
		if(inPutCarId != ca.getCarId()) {
			System.out.println("�����Id������,������ѡ��");
			return null;
		}else if (ca.getCarStatus().equals("�����")) {
			System.out.println("�ó������,������ѡ��");
			return null;
		}else {
		
		
		
			try {
			//��clientʵ�����carʵ���������ȡ����,��ֵ�����µ��ʺ�
			cstmt = mConnection.prepareCall("{call LEND_CAR(?,?,?,?,?,?,?,?,?)}");		
			cstmt.setInt(1, ca.getCarId());
			cstmt.setString(2, ca.getCarName());
			cstmt.setInt(3, cl.getClientId());
			cstmt.setString(4, cl.getClientName());
			cstmt.setInt(5, ca.getCarPrice());
			cstmt.setInt(6, ca.getCarTotalPrice());
			cstmt.setString(7, ca.getCarBrand());
			cstmt.setString(8,ca.getCarType());
			cstmt.setString(9, "�����");
			cstmt.execute();
			cstmt.close();
			
			//���޸ĺ�֮�������,����ȡ����������ʾ
			String sql3 = "select *  from CAR where CARID = ?";
			mStatement = mConnection.prepareStatement(sql3);
			mStatement.setLong(1, inPutCarId);
			rSet = mStatement.executeQuery();
			
			while(rSet.next()) {
				ca.setCarId(rSet.getInt("CARID"));
				ca.setCarName(rSet.getString("CARNAME"));
				ca.setCarBrand(rSet.getString("CARBRAND"));
				ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				ca.setCarType(rSet.getString("CARTYPE"));
				ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				ca.setCarPrice(rSet.getInt("CARPRICE"));
				ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				ca.setCarStatus(rSet.getString("CARSTATUS"));
				ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
				ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				ca.setIsGrouding(rSet.getString("CARISGROUDING"));
				ca.setCarRemark(rSet.getString("CARRAMARK"));	
			}
					
		} catch (SQLException e) {
			//e.printStackTrace();
		}	
		return ca;
		}
			
	}



	@Override
	//�⳵�б�ķ���
	public ArrayList<Car> getAscending() {

		ArrayList<Car> list = new ArrayList<>();
		String sql = "SELECT * FROM CAR ORDER BY CARPRICE";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		
		return list;
		
	}


	@Override
	//���ݳ���������ʾ�����б�
	public ArrayList<Car> getCarByType(int inPutCarType) {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "SELECT * FROM CAR where CARTYPENUMBER = ?";
			
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setLong(1, inPutCarType);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		
		return list;
	}

	
	
	@Override
	//���ݳ���Ʒ������ó����б�
	public ArrayList<Car> getCarByBrand(int inPutCarBrand) {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "SELECT * FROM CAR where CARBRANDNUMBER =?";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setLong(1, inPutCarBrand);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		
		return list;
	}
	
	
	
	
	
	@Override
	//�۸�������
	public ArrayList<Car> getDescending() {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "SELECT * FROM CAR ORDER BY CARPRICE DESC";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		
		return list;
	}






	@Override
	//�鿴�ҵ��⳵��¼
	public ArrayList<LendRecord> getCarByClient(String clientName) {
		ArrayList<LendRecord> list = new ArrayList<>();
		String sql = "SELECT * FROM LENDRECORDCAR where CLIENTNAME =?";
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, clientName);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				LendRecord l = new LendRecord();
				l.setLrId(rSet.getString("LRID"));
				l.setCarId(rSet.getInt("CARID"));
				l.setCarName(rSet.getString("CARNAME"));
				l.setClientId(rSet.getInt("CLIENTID"));
				l.setClientName(rSet.getString("CLIENTNAME"));
				l.setCarPrice(rSet.getInt("CARPRICE"));
				l.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				l.setCarBrand(rSet.getString("CARBRAND"));
				l.setCarType(rSet.getString("CARTYPE"));
				l.setCarLendDate(rSet.getDate("CARLENDDATE"));
				l.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				list.add(l);
			
			}		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		

		
		return list;
	}



	@Override
	//����ʱ��õ�����
	public Car getReturnCar(int inPutCarId2, String clientName) {
		CallableStatement cstmt = null;
		Car ca = new Car();	
		
		try {
			String sql = "select *  from CAR where CARID = ?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setLong(1, inPutCarId2);
			rSet = mStatement.executeQuery();		
			while(rSet.next()) {
				ca.setCarId(rSet.getInt("CARID"));
				ca.setCarName(rSet.getString("CARNAME"));
				ca.setCarBrand(rSet.getString("CARBRAND"));
				ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				ca.setCarType(rSet.getString("CARTYPE"));
				ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				ca.setCarPrice(rSet.getInt("CARPRICE"));
				ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				ca.setCarStatus(rSet.getString("CARSTATUS"));
				ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
				ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				ca.setIsGrouding(rSet.getString("CARISGROUDING"));
				ca.setCarRemark(rSet.getString("CARRAMARK"));			
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		/**
		 * ��������������,�Ͳ�ѯ�����ı�����Ա�,�����ͬ�򷵻�Ϊnull,����������Ų�����
		 * ��ѯ������״̬,����ǿ����,�򷵻�null,�������������Ѿ��黹
		 * ������������,��ִ����������
		 */
		if(inPutCarId2 != ca.getCarId()) {
			System.out.println("�����Id������,������ѡ��");
			return null;
		}else if (ca.getCarStatus().equals("����")) {
			System.out.println("�ó��ѹ黹,������ѡ��");
			return null;
		}else {
		
		
		try {			
			cstmt = mConnection.prepareCall("{call R_CAR(?,?,?)}");		
			cstmt.setInt(1, inPutCarId2);		
			cstmt.setString(2, clientName);
			cstmt.setString(3, "����");
			cstmt.execute();
			cstmt.close();
			
				
			String sql2 = "select *  from CAR where CARID = ?";
			mStatement = mConnection.prepareStatement(sql2);
			mStatement.setLong(1, inPutCarId2);
			rSet = mStatement.executeQuery();
			
			while(rSet.next()) {
				ca.setCarId(rSet.getInt("CARID"));
				ca.setCarName(rSet.getString("CARNAME"));
				ca.setCarBrand(rSet.getString("CARBRAND"));
				ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				ca.setCarType(rSet.getString("CARTYPE"));
				ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				ca.setCarPrice(rSet.getInt("CARPRICE"));
				ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				ca.setCarStatus(rSet.getString("CARSTATUS"));
				ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
				ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				ca.setIsGrouding(rSet.getString("CARISGROUDING"));
				ca.setCarRemark(rSet.getString("CARRAMARK"));
				
			}
		
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		return ca;
		}
	}



	@Override
	//ģ����ѯ����
	public ArrayList<Car> getCarByType(String inPutVague) {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "SELECT * FROM CAR where CARNAME like ?";
				
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, "%"+inPutVague+"%");
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				Car c = new Car();
				c.setCarId(rSet.getInt("CARID"));
				c.setCarName(rSet.getString("CARNAME"));
				c.setCarBrand(rSet.getString("CARBRAND"));
				c.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
				c.setCarType(rSet.getString("CARTYPE"));
				c.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
				c.setCarPrice(rSet.getInt("CARPRICE"));
				c.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
				c.setCarStatus(rSet.getString("CARSTATUS"));
				c.setCarLendDate(rSet.getDate("CARLENDDATE"));
				c.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
				c.setIsGrouding(rSet.getString("CARISGROUDING"));
				c.setCarRemark(rSet.getString("CARRAMARK"));
				c.setIsOrder(rSet.getString("CARISORDER"));
				list.add(c);
			
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return list;
	}



	@Override
	//ԤԼ����
	public Car getOrder(int inPutCarId3, int inPutCarDate,String clientName) {
		
		CallableStatement cstmt = null;	
		Car ca = new Car();		
		ResultSet rSet1;
		Client cl = new Client();
			try {
		
				String sql = "select * from CLIENT where CLIENTNAME = ?";
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setString(1, clientName);
				rSet1 = mStatement.executeQuery() ;		
				while(rSet1.next()) {
					cl.setClientId(rSet1.getInt("CLIENTID"));
					cl.setClientName(rSet1.getString("CLIENTNAME"));
					cl.setClientPwd(rSet1.getString("CLIENTPWD"));
					cl.setClientStatus(rSet1.getInt("CLIENTSTATUS"));
				}
						
				//������IdΪ��ѡ��ı��ʱ,ȥ�����е��ֶ�,Ȼ�����Щ�ֶθ�ֵ��Carʵ����
				String sql2 = "select *  from CAR where CARID = ?";
				mStatement = mConnection.prepareStatement(sql2);
				mStatement.setLong(1, inPutCarId3);
				rSet = mStatement.executeQuery();		
				while(rSet.next()) {
					ca.setCarId(rSet.getInt("CARID"));
					ca.setCarName(rSet.getString("CARNAME"));
					ca.setCarBrand(rSet.getString("CARBRAND"));
					ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
					ca.setCarType(rSet.getString("CARTYPE"));
					ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
					ca.setCarPrice(rSet.getInt("CARPRICE"));
					ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
					ca.setCarStatus(rSet.getString("CARSTATUS"));
					ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
					ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
					ca.setIsGrouding(rSet.getString("CARISGROUDING"));
					ca.setCarRemark(rSet.getString("CARRAMARK"));			
				}
			
	
			cstmt = mConnection.prepareCall("{call ORDER_CAR(?,?,?,?,?,?,?,?,?,?)}");		
			cstmt.setInt(1, inPutCarId3);
			cstmt.setInt(2, inPutCarDate);
			cstmt.setString(3, ca.getCarName());
			cstmt.setInt(4, cl.getClientId());
			cstmt.setString(5, cl.getClientName());
			cstmt.setInt(6, ca.getCarPrice());
			cstmt.setInt(7, ca.getCarTotalPrice());
			cstmt.setString(8, ca.getCarBrand());
			cstmt.setString(9,ca.getCarType());		
			cstmt.setString(10, "��ԤԼ");
			cstmt.execute();
			cstmt.close();
				
				String sql3 = "select *  from CAR where CARID = ?";
				mStatement = mConnection.prepareStatement(sql3);
				mStatement.setLong(1, inPutCarId3);
				rSet = mStatement.executeQuery();		
				while(rSet.next()) {
					ca.setCarId(rSet.getInt("CARID"));
					ca.setCarName(rSet.getString("CARNAME"));
					ca.setCarBrand(rSet.getString("CARBRAND"));
					ca.setCarBrandNumber(rSet.getInt("CARBRANDNUMBER"));
					ca.setCarType(rSet.getString("CARTYPE"));
					ca.setCarTypeNumber(rSet.getInt("CARTYPENUMBER"));
					ca.setCarPrice(rSet.getInt("CARPRICE"));
					ca.setCarTotalPrice(rSet.getInt("CARTOTALPRICE"));
					ca.setCarStatus(rSet.getString("CARSTATUS"));
					ca.setCarLendDate(rSet.getDate("CARLENDDATE"));
					ca.setCarReturnDate(rSet.getDate("CARRETURNDATE"));
					ca.setIsGrouding(rSet.getString("CARISGROUDING"));
					ca.setCarRemark(rSet.getString("CARRAMARK"));			
				}	
				
					
				
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		
		
		return ca;
	}

	




	

	
	
	
	
	
	
	
	
	
	
}
