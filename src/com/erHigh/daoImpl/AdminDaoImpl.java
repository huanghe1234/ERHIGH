package com.erHigh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.pmw.tinylog.Logger;

import com.erHigh.bean.Car;
import com.erHigh.bean.LendRecord;
import com.erHigh.dao.AdminDao;
import com.erHigh.tools.DBHelper;

public class AdminDaoImpl implements AdminDao{
	
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	private DBHelper mDB;
	private int rInt;
	
	public AdminDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	
	

	@Override
	public ArrayList<Car> getAllCar() {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "select * from CAR";
		
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
			Logger.info("数据库出错误");
		}
			
		
		return list;
	}



	@Override
	//查看指定编号汽车的信息
	public Car getSpecifyCar(int inPutCarId) {
			
		String sql = "select * from CAR where CARID = ?";
		Car c = new Car();
		
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, inPutCarId);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
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

			return c;
			}		
			
		} catch (SQLException e) {
			//e.printStackTrace();
			Logger.info("数据库出错误");
		}
		
		
		
		return c;
	}





	@Override
	public Car AddCar(int inPutBrandId, String brandCar, int inPutTypeId, String typeCar,String inPutCarName, String inPutCarNumber,
			String inPutCarRemark, String inPutCarColor,  int inPutCarWorth, int inPutCarPrice,
			String inPutCarStatus, String inPutCarGroud) {
		Car ca = new Car();
		String sql= "insert into CAR values (car_seq.nextval,?,?,?,?,?,?,?,null,?,null,null,?,?,?,?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, inPutCarName);
			mStatement.setString(2, inPutCarRemark);
			mStatement.setString(3, brandCar);
			mStatement.setInt(4, inPutBrandId);
			mStatement.setString(5, typeCar);
			mStatement.setInt(6, inPutTypeId);
			mStatement.setInt(7, inPutCarPrice);
			mStatement.setString(8, inPutCarStatus);
			mStatement.setString(9, inPutCarGroud);
			mStatement.setString(10, inPutCarNumber);
			mStatement.setString(11, inPutCarColor);
			mStatement.setInt(12, inPutCarWorth);
			mStatement.setString(13, "可预约");
			rInt = mStatement.executeUpdate();
			
						
			String sql2 = "SELECT * FROM CAR WHERE CARNUMER = ?";	
				mStatement = mConnection.prepareStatement(sql2);
				mStatement.setString(1, inPutCarNumber);
				rSet = mStatement.executeQuery();
				while(rSet.next()) {
					ca.setCarId(rSet.getInt("CARID"));
					ca.setCarName(rSet.getString("CARNAME"));
					ca.setCarRemark(rSet.getString("CARRAMARK"));
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
					ca.setCarNumber(rSet.getString("CARNUMER"));
					ca.setCarColor(rSet.getString("CARCOLOR"));
					ca.setCarWorth(rSet.getInt("CARWORTH"));
					ca.setIsOrder(rSet.getString("CARISORDER"));
				}
				
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			Logger.info("数据库出错误");
		}
		
		if(rInt>0) {
			return ca;
		}
		return ca;
	}



	@Override
	//修改指定编号的汽车信息
	
	public Car getCarById(int inPutCarId2) {
		Car ca = new Car();
			
		try {
			String sql = "SELECT * FROM CAR WHERE CARID = ? ";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setLong(1, inPutCarId2);
			rSet = mStatement.executeQuery();
			while(rSet.next()) {
				ca.setCarId(rSet.getInt("CARID"));
				ca.setCarName(rSet.getString("CARNAME"));
				ca.setCarRemark(rSet.getString("CARRAMARK"));
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
				ca.setCarNumber(rSet.getString("CARNUMER"));
				ca.setCarColor(rSet.getString("CARCOLOR"));
				ca.setCarWorth(rSet.getInt("CARWORTH"));
				ca.setIsOrder(rSet.getString("CARISORDER"));
			}
		
		} catch (SQLException e) {
			Logger.info("数据库出错误");
			//e.printStackTrace();
		}

		return ca;
	}



	@Override
	public Car changePrice(int inPutPrice,int inPutCarId2) {
		Car ca = new Car();
		String sql = "update CAR SET CARPRICE = ? WHERE CARID = ?";	
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, inPutPrice);
			mStatement.setInt(2, inPutCarId2);
			rInt = mStatement.executeUpdate();
			
			String sql2 = "SELECT * FROM CAR WHERE CARID = ? ";
			mStatement = mConnection.prepareStatement(sql2);
			mStatement.setLong(1, inPutCarId2);
			rSet = mStatement.executeQuery();
			
			while(rSet.next()) {
				ca.setCarPrice(rSet.getInt("CARPRICE"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ca;
		
	}


	@Override
	public Car changeGroud(String inPutNewGroud,int inPutCarId2) {
		Car ca = new Car();
		String sql = "update CAR SET CARISGROUDING = ? WHERE CARID = ?";	
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, inPutNewGroud);
			mStatement.setInt(2, inPutCarId2);
			rInt = mStatement.executeUpdate();
			
			String sql2 = "SELECT * FROM CAR WHERE CARID = ? ";
			mStatement = mConnection.prepareStatement(sql2);
			mStatement.setLong(1, inPutCarId2);
			rSet = mStatement.executeQuery();
			
			while(rSet.next()) {
				ca.setIsGrouding(rSet.getString("CARISGROUDING"));		
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ca;

	}



	@Override
	public ArrayList<LendRecord> getAllRecord() {
		ArrayList<LendRecord> list = new ArrayList<>();

		
		String sql = "SELECT * FROM LENDRECORDCAR";	
		try {
			mStatement = mConnection.prepareStatement(sql);
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
	public ArrayList<LendRecord> getspecifyClient(int specifyClientId) {
		ArrayList<LendRecord> list = new ArrayList<>();

		
		String sql = "SELECT * FROM LENDRECORDCAR WHERE CLIENTID = ? ";	
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, specifyClientId);
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
	public ArrayList<LendRecord> getspecifyCar(int specifyCarId) {
		ArrayList<LendRecord> list = new ArrayList<>();
	
		String sql = "SELECT * FROM LENDRECORDCAR WHERE CARID = ? ";	
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, specifyCarId);
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
	
}
