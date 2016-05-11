package com.hxd.model;

import java.io.Serializable;

/*
 * 银行卡
 * 
 * */
/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:29:03  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：BankCard.java  
* 类说明：
 */
public class BankCard  implements Serializable{
	  private int backCardId;//编号
	  private String backCardNumber;//卡号
	  private String  backCardState;//卡号类型	 
	  private String bankCardCreateTime;//开户时间
	  private int  bankCard_User;//银行卡对应的用户
	  private String  bankCardName;//图片的名称
	  private String bankCardSrc;//鱼片路径
	  public int getBackCardId() {
		return backCardId;
	}
	public void setBackCardId(int backCardId) {
		this.backCardId = backCardId;
	}
	public String getBackCardNumber() {
		return backCardNumber;
	}
	public void setBackCardNumber(String backCardNumber) {
		this.backCardNumber = backCardNumber;
	}
	public String getBackCardState() {
		return backCardState;
	}
	public void setBackCardState(String backCardState) {
		this.backCardState = backCardState;
	}
	
	
	public String getBankCardCreateTime() {
		return bankCardCreateTime;
	}
	public void setBankCardCreateTime(String bankCardCreateTime) {
		this.bankCardCreateTime = bankCardCreateTime;
	}
	public int getBankCard_User() {
		return bankCard_User;
	}
	public void setBankCard_User(int bankCard_User) {
		this.bankCard_User = bankCard_User;
	}
	public String getBankCardSrc() {
		return bankCardSrc;
	}
	public void setBankCardSrc(String bankCardSrc) {
		this.bankCardSrc = bankCardSrc;
	}
	public String getBankCardName() {
		return bankCardName;
	}
	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}
	

}
