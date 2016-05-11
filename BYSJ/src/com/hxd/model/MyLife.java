package com.hxd.model;

import java.io.Serializable;

/*
 * 生活信息管理
 * 
 * */
/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:29:23  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：MyLife.java  
* 类说明：
 */
public class MyLife implements Serializable{
	
	public int getMylifeID() {
		return mylifeID;
	}
	public void setMylifeID(int mylifeID) {
		this.mylifeID = mylifeID;
	}
	public String getMylifeLog() {
		return mylifeLog;
	}
	public void setMylifeLog(String mylifeLog) {
		this.mylifeLog = mylifeLog;
	}
	public String getMylifeCreateTime() {
		return mylifeCreateTime;
	}
	public void setMylifeCreateTime(String mylifeCreateTime) {
		this.mylifeCreateTime = mylifeCreateTime;
	}
	public String getMylifeCreateCity() {
		return mylifeCreateCity;
	}
	public void setMylifeCreateCity(String mylifeCreateCity) {
		this.mylifeCreateCity = mylifeCreateCity;
	}
	public String getMylifeState() {
		return mylifeState;
	}
	public void setMylifeState(String mylifeState) {
		this.mylifeState = mylifeState;
	}
	public int getMylife_User() {
		return Mylife_User;
	}
	public void setMylife_User(int mylife_User) {
		Mylife_User = mylife_User;
	}
	public String getMylifeTitle() {
		return mylifeTitle;
	}
	public void setMylifeTitle(String mylifeTitle) {
		this.mylifeTitle = mylifeTitle;
	}
	private int mylifeID;//id	
	private String mylifeTitle;
	private String mylifeLog;//日记内容 
	private String mylifeCreateTime;//日记时间
	private String mylifeCreateCity;//地点
	private String mylifeState;//心情
	private int Mylife_User;//日记所在的用户
	

}
