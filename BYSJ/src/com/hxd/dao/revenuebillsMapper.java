package com.hxd.dao;

import java.util.List;

import com.hxd.model.RevenueBills;

public interface revenuebillsMapper {
	public int addUserRevenueBills(RevenueBills revenueBills);// 用户添加账单

	public List<RevenueBills> queryUserRevenueBillsInfo(int uid, int fromNo);// 查询用户的收入账单

	public int deleateUserRevenueBillsInfoByid(int rid, int uid);// 用户删除某一条账单

	public int updateUserRevenueBillsInfo(RevenueBills revenueBills);// 用户编辑某一条账单信息

	public RevenueBills queryUserRevenueBillsInfoBuid(int rid);// 查询某一条账单信息

	public int getUserRevenusBillsInfoCountNumber(int uid);// 获取用户投资的总数

	public int getUserRevenusBillsInfoCountNumberDay(int uid);// 获取用户一天投资的总数

	public int getUserRevenusBillsInfoCountNumberWeek(int uid);// 获取用户一周投资的总数

	public int getUserRevenusBillsInfoCountNumberMonth(int uid);// 获取用一月户投资的总数

	public int getUserRevenusBillsInfoCountNumberWuQian(int uid);// 获取用户5000一下的总数

	public int getUserRevenusBillsInfoCountNumberWuQianYiW(int uid);// 获取用户5000-10000投资的总数

	public int getUserRevenusBillsInfoCountNumberYiWShang(int uid);// 获取用10000+户投资的总数
	
	public int getUserRevenusBillsInfoCountNumberGongZ(int uid);// 获取用户工资收入的总数
	public int getUserRevenusBillsInfoCountNumberWaiK(int uid);//  获取用户外快收入的总数
	public int getUserRevenusBillsInfoCountNumberLiCai(int uid);//  获取用户理财收入的总数
	public int getUserRevenusBillsInfoCountNumberHeL(int uid);//  获取用户贺礼收入的总数
	
	
	
	public List<RevenueBills> queryUserRevenuebillsThisDay(int uid, int fromNo);// 查询用户今天收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWeek(int uid, int fromNo);// 查询用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisMonth(int uid, int fromNo);// 查询用户一月的

	public List<RevenueBills> queryUserRevenuebillsThisWuQian(int uid,int fromNo);// 查询用户5000一下收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWuQianYiW(int uid,int fromNo);// 查询5000-100用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisYiWShang(int uid,int fromNo);// 查询用户10000+的

	
	
	public List<RevenueBills> queryUserRevenuebillsThisGongZ(int uid,int fromNo);// 查询用户工资收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWaiK(int uid,int fromNo);// 查询外快用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisLiCai(int uid,int fromNo);// 查询用户理财的
	public List<RevenueBills> queryUserRevenuebillsThisHeLi(int uid,int fromNo);// 查询用户贺礼的

}
