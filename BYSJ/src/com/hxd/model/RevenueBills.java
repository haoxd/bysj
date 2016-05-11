package com.hxd.model;

import java.io.Serializable;

/*
 * 
 * 收入账单
 * 
 * */
/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:28:53  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.7
* 文件名称：RevenueBills.java  
* 类说明：
 */
public class RevenueBills implements Serializable{
	private int revenueBillsID;//帐单id
	private String revenueBillsName;//收入帐单名称
	private String revenueBillsState;//帐单类型
	private String revenueBillsBody;//帐单内容
	private String revenueBillsCreateTime;//创建时间
	private String revenueBillsChangeTime;//修改时间
	private int revenueBillsMoney;//收入金额
	private int revenueBills_UserID;//收入账单所属的用户
	
	
	public int getRevenueBillsID() {
		return revenueBillsID;
	}
	public void setRevenueBillsID(int revenueBillsID) {
		this.revenueBillsID = revenueBillsID;
	}
	public String getRevenueBillsName() {
		return revenueBillsName;
	}
	public void setRevenueBillsName(String revenueBillsName) {
		this.revenueBillsName = revenueBillsName;
	}
	public String getRevenueBillsState() {
		return revenueBillsState;
	}
	public void setRevenueBillsState(String revenueBillsState) {
		this.revenueBillsState = revenueBillsState;
	}
	public String getRevenueBillsBody() {
		return revenueBillsBody;
	}
	public void setRevenueBillsBody(String revenueBillsBody) {
		this.revenueBillsBody = revenueBillsBody;
	}
	public String getRevenueBillsCreateTime() {
		return revenueBillsCreateTime;
	}
	public void setRevenueBillsCreateTime(String revenueBillsCreateTime) {
		this.revenueBillsCreateTime = revenueBillsCreateTime;
	}
	public String getRevenueBillsChangeTime() {
		return revenueBillsChangeTime;
	}
	public void setRevenueBillsChangeTime(String revenueBillsChangeTime) {
		this.revenueBillsChangeTime = revenueBillsChangeTime;
	}
	
	public int getRevenueBillsMoney() {
		return revenueBillsMoney;
	}
	public void setRevenueBillsMoney(int revenueBillsMoney) {
		this.revenueBillsMoney = revenueBillsMoney;
	}
	public int getRevenueBills_UserID() {
		return revenueBills_UserID;
	}
	public void setRevenueBills_UserID(int revenueBills_UserID) {
		this.revenueBills_UserID = revenueBills_UserID;
	}
	
	
	
	
}
