package com.hxd.model;

import java.io.Serializable;

/*
 * 
 * 支出账单信息
 * 
 * */
/**
 * @author acer11
 *  作者：郝旭东
* 创建时间：2016-1-4 下午6:27:43  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.7
* 文件名称：SpendingBills.java  
* 类说明：
 */
public class SpendingBills implements Serializable {
	private int  spendingBillsId;//支出账单信息id
	private String spendingBillsName;//支出账单信息名称
	private String spendingBillsState;//支出账单信息类型
	private String spendingBillsCreateTime;//支出账单信息创建时间
	private String spendingBillschangeTime;//支出账单信息改变时间
	private String spendingBillsBody;//支出账单内容
	private int spendingBillsMoney;//支出账单金额
	private int spendingBills_User;//支出账单所属的用户
	public int getSpendingBillsId() {
		return spendingBillsId;
	}
	public void setSpendingBillsId(int spendingBillsId) {
		this.spendingBillsId = spendingBillsId;
	}
	public String getSpendingBillsName() {
		return spendingBillsName;
	}
	public void setSpendingBillsName(String spendingBillsName) {
		this.spendingBillsName = spendingBillsName;
	}
	public String getSpendingBillsState() {
		return spendingBillsState;
	}
	public void setSpendingBillsState(String spendingBillsState) {
		this.spendingBillsState = spendingBillsState;
	}
	public String getSpendingBillsCreateTime() {
		return spendingBillsCreateTime;
	}
	public void setSpendingBillsCreateTime(String spendingBillsCreateTime) {
		this.spendingBillsCreateTime = spendingBillsCreateTime;
	}
	public String getSpendingBillschangeTime() {
		return spendingBillschangeTime;
	}
	public void setSpendingBillschangeTime(String spendingBillschangeTime) {
		this.spendingBillschangeTime = spendingBillschangeTime;
	}
	public String getSpendingBillsBody() {
		return spendingBillsBody;
	}
	public void setSpendingBillsBody(String spendingBillsBody) {
		this.spendingBillsBody = spendingBillsBody;
	}
	public int getSpendingBillsMoney() {
		return spendingBillsMoney;
	}
	public void setSpendingBillsMoney(int spendingBillsMoney) {
		this.spendingBillsMoney = spendingBillsMoney;
	}
	public int getSpendingBills_User() {
		return spendingBills_User;
	}
	public void setSpendingBills_User(int spendingBills_User) {
		this.spendingBills_User = spendingBills_User;
	}
	
	

	
}
