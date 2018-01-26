package com.erHigh.bean;

import java.io.Serializable;
import java.sql.Date;

public class Car implements Serializable{

	private static final long serialVersionUID = 6389944221217338857L;

	private int carId;
	private String carName;
	private String carRemark;
	private String carBrand;
	private int carBrandNumber;
	private String carType; 
	private int carTypeNumber;
	private int carPrice;
	private int carTotalPrice;
	private String carStatus; //ÊÇ·ñ¿É×â
	private Date carLendDate;
	private Date carReturnDate;
	private String IsGrouding;
	private String carNumber;
	private String carColor;
	private int carWorth;
	private String IsOrder;
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
	
	
	public String getCarRemark() {
		return carRemark;
	}
	public void setCarRemark(String carRemark) {
		this.carRemark = carRemark;
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
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
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
	
	public int getCarBrandNumber() {
		return carBrandNumber;
	}
	public void setCarBrandNumber(int carBrandNumber) {
		this.carBrandNumber = carBrandNumber;
	}
	public int getCarTypeNumber() {
		return carTypeNumber;
	}
	public void setCarTypeNumber(int carTypeNumber) {
		this.carTypeNumber = carTypeNumber;
	}
	public int getCarTotalPrice() {
		return carTotalPrice;
	}
	public void setCarTotalPrice(int carTotalPrice) {
		this.carTotalPrice = carTotalPrice;
	}
	
	
	public String getIsGrouding() {
		return IsGrouding;
	}
	public void setIsGrouding(String isGrouding) {
		IsGrouding = isGrouding;
	}
	
	
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getCarWorth() {
		return carWorth;
	}
	public void setCarWorth(int carWorth) {
		this.carWorth = carWorth;
	}
	
	
	public String getIsOrder() {
		return IsOrder;
	}
	public void setIsOrder(String isOrder) {
		IsOrder = isOrder;
	}
	public Car(String carName, String carRemark, String carBrand, int carBrandNumber, String carType, int carTypeNumber, int carPrice,
			int carTotalPrice, String carStatus, Date carLendDate, Date carReturnDate,String IsGrouding) {
		super();
		this.carName = carName;
		this.carRemark = carRemark;
		this.carBrand = carBrand;
		this.carBrandNumber = carBrandNumber;
		this.carType = carType;
		this.carTypeNumber = carTypeNumber;
		this.carPrice = carPrice;
		this.carTotalPrice = carTotalPrice;
		this.carStatus = carStatus;
		this.carLendDate = carLendDate;
		this.carReturnDate = carReturnDate;
		this.IsGrouding = IsGrouding;
	}
	
	
	public Car(int carId, String carName, String carRemark, String carBrand, int carBrandNumber, String carType,
			int carTypeNumber, int carPrice, int carTotalPrice, String carStatus, Date carLendDate, Date carReturnDate,
			String isGrouding, String carNumber, String carColor, int carWorth) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carRemark = carRemark;
		this.carBrand = carBrand;
		this.carBrandNumber = carBrandNumber;
		this.carType = carType;
		this.carTypeNumber = carTypeNumber;
		this.carPrice = carPrice;
		this.carTotalPrice = carTotalPrice;
		this.carStatus = carStatus;
		this.carLendDate = carLendDate;
		this.carReturnDate = carReturnDate;
		this.IsGrouding = isGrouding;
		this.carNumber = carNumber;
		this.carColor = carColor;
		this.carWorth = carWorth;
	}
	public Car() {
		
	}
	
	public Car(int carId, String carName, String carRemark, String carBrand, int carBrandNumber, String carType,
			int carTypeNumber, int carPrice, int carTotalPrice, String carStatus, Date carLendDate, Date carReturnDate,
			String isGrouding, String carNumber, String carColor, int carWorth, String isOrder) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carRemark = carRemark;
		this.carBrand = carBrand;
		this.carBrandNumber = carBrandNumber;
		this.carType = carType;
		this.carTypeNumber = carTypeNumber;
		this.carPrice = carPrice;
		this.carTotalPrice = carTotalPrice;
		this.carStatus = carStatus;
		this.carLendDate = carLendDate;
		this.carReturnDate = carReturnDate;
		this.IsGrouding = isGrouding;
		this.carNumber = carNumber;
		this.carColor = carColor;
		this.carWorth = carWorth;
		this.IsOrder = isOrder;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carRemark=" + carRemark + ", carBrand=" + carBrand
				+ ", carBrandNumber=" + carBrandNumber + ", carType=" + carType + ", carTypeNumber=" + carTypeNumber
				+ ", carPrice=" + carPrice + ", carTotalPrice=" + carTotalPrice + ", carStatus=" + carStatus
				+ ", carLendDate=" + carLendDate + ", carReturnDate=" + carReturnDate + ", IsGrouding=" + IsGrouding
				+ ", carNumber=" + carNumber + ", carColor=" + carColor + ", carWorth=" + carWorth + ", IsOrder="
				+ IsOrder + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
