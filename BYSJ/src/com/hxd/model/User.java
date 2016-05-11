	package com.hxd.model;

import java.io.Serializable;
import java.util.List;

/*
 * 用户实体类
 * 
 * 
 * 
 * */

/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:27:03  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.7.0_21  
* 文件名称：User.java  
* 类说明：
 */
public class User  implements Serializable{
	
	
/*	private static  User user;
	public User(){}
	
	public static User getUser(){
		if(user ==null){
			user = new User();
		}
		return user;
	}*/
	private int userID;// 用户id，自增
	private String userName;// 姓名
	private String userNickName;// 昵称
	private String userPassword;// 用户密码7
	private String userPhone;// 手机号7
	private String userSex;// 性别
	private int userAge;// 年龄
	private String userEmil;// 邮箱
	private String userIdcard;// 身份证号码
	private String userText;// 用户简介
	private String userCreateTime;// 创建时间
	private String userState;
	

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmil() {
		return userEmil;
	}

	public void setUserEmil(String userEmil) {
		this.userEmil = userEmil;
	}

	public String getUserIdcard() {
		return userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}

	public String getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getUserChangeTime() {
		return userChangeTime;
	}

	public void setUserChangeTime(String userChangeTime) {
		this.userChangeTime = userChangeTime;
	}

	public List<BankCard> getUser_BankCardList() {
		return user_BankCardList;
	}

	public void setUser_BankCardList(List<BankCard> user_BankCardList) {
		this.user_BankCardList = user_BankCardList;
	}

	public List<MyLife> getUser_MyLifeList() {
		return user_MyLifeList;
	}

	public void setUser_MyLifeList(List<MyLife> user_MyLifeList) {
		this.user_MyLifeList = user_MyLifeList;
	}

	public List<Investment> getUser_InvestmentList() {
		return user_InvestmentList;
	}

	public void setUser_InvestmentList(List<Investment> user_InvestmentList) {
		this.user_InvestmentList = user_InvestmentList;
	}

	public List<SpendingBills> getUser_SpendingBillsList() {
		return user_SpendingBillsList;
	}

	public void setUser_SpendingBillsList(List<SpendingBills> user_SpendingBillsList) {
		this.user_SpendingBillsList = user_SpendingBillsList;
	}

	public List<RevenueBills> getUser_RevenueBillsList() {
		return user_RevenueBillsList;
	}

	public void setUser_RevenueBillsList(List<RevenueBills> user_RevenueBillsList) {
		this.user_RevenueBillsList = user_RevenueBillsList;
	}

	private String userChangeTime;// 最后修改时间
	private List<BankCard> user_BankCardList;// 用户的银行卡
	private List<MyLife> user_MyLifeList;// 用户的日记
	private List<Investment> user_InvestmentList;// 用户的投资信心集合
	private List<SpendingBills> user_SpendingBillsList;// 用户的支出账单
	private List<RevenueBills> user_RevenueBillsList;// 用户的收入账单
	
	/*
	 *
	 * 
	 * 
	 * 
	 * */


	
}
