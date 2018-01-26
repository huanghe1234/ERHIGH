package com.erHigh.bean;

import java.io.Serializable;
import java.sql.Date;

public class LendRecord implements Serializable{

	
	private static final long serialVersionUID = 6335048215494735845L;
	
	private String lrId; 
	private int carId;
	private String carName;
	private int clientId;
	private String clientName;
	private int carPrice;
	private int carTotalPrice;
	private String carBrand;
	private String carType;
	private Date carLendDate;
	private Date carReturnDate;
	public String getLrId() {
		return lrId;
	}
	public void setLrId(String lrId) {
		this.lrId = lrId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getCarTotalPrice() {
		return carTotalPrice;
	}
	public void setCarTotalPrice(int carTotalPrice) {
		this.carTotalPrice = carTotalPrice;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Date getCarLendDate() {
		return carLendDate;
	}
	public void setCarLendDate(Date carLendDate) {
		this.carLendDate = carLendDate;
	}
	public Date getCarReturnDate() {
		return carReturnDate;
	}
	public void setCarReturnDate(Date carReturnDate) {
		this.carReturnDate = carReturnDate;
	}
	public LendRecord(int carId, String carName, int clientId, String clientName, int carPrice, int carTotalPrice,
			String carBrand, String carType, Date carLendDate, Date carReturnDate) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.clientId = clientId;
		this.clientName = clientName;
		this.carPrice = carPrice;
		this.carTotalPrice = carTotalPrice;
		this.carBrand = carBrand;
		this.carType = carType;
		this.carLendDate = carLendDate;
		this.carReturnDate = carReturnDate;
	}
	
	public LendRecord() {
		
	}
	@Override
	public String toString() {
		return "LendRecord [lrId=" + lrId + ", carId=" + carId + ", carName=" + carName + ", clientId=" + clientId
				+ ", clientName=" + clientName + ", carPrice=" + carPrice + ", carTotalPrice=" + carTotalPrice
				+ ", carBrand=" + carBrand + ", carType=" + carType + ", carLendDate=" + carLendDate
				+ ", carReturnDate=" + carReturnDate + "]";
	}
	
	

}
