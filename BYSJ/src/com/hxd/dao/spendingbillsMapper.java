package com.hxd.dao;

import java.util.List;

import com.hxd.model.SpendingBills;

public interface spendingbillsMapper {
	public int addUserSpendingBills(SpendingBills spending);//添加支出账单
	public List<SpendingBills> queryUserSpendingBillsInfos(int uid,int fromNo);//查询用户全部的支出账单信息
	public int deleateUserSpendingBillsInfo(int sid,int uid);//删除用户的某一条支出账单
	public int updateUserSpendingBillsInfo(SpendingBills spending);//编辑支出账单信息

	public SpendingBills queryUserSpendinginfoByid(int sid);//通过id查询某一条信息   
	public int getUserSpendingBillsInfosNumber(int uid); //查询用户投资的总数
	
	public List<SpendingBills> queryUserSpendingBillsToChiFan(int uid,int fromNo);//关于吃饭的集合
	public List<SpendingBills> queryUserSpendingBillsToLvYou(int uid,int fromNo);//旅游的全部信息
	public List<SpendingBills> queryUserSpendingBillsToGuangJ(int uid,int fromNo);//逛街全部信息
	public List<SpendingBills> queryUserSpendingBillsToQiTa(int uid,int fromNo);//其他的支出全部信息
	
	public List<SpendingBills> queryUserSpendingBillsToWuQianS(int uid,int fromNo);//5000以上的支出账单
	public List<SpendingBills> queryUserSpendingBillsToYiQDWuQi(int uid,int fromNo);//1000-5000的支出账单
	public List<SpendingBills> queryUserSpendingBillsToYiQX(int uid,int fromNo);//1000一下的支出账单
	
	public List<SpendingBills> queryUserSpendingBillsToThisDay(int uid,int fromNo);//近一天的支出账单
	public List<SpendingBills> queryUserSpendingBillsToThisWeek(int uid,int fromNo);//近7天的账单
	public List<SpendingBills> queryUserSpendingBillsToThisMonth(int uid,int fromNo);//近30天
	
	
	public int getUserSpendingBillsToChiFanNumber(int uid);//关于吃饭总数
	public int getUserSpendingBillsToLvYouNumber(int uid);//旅游总数
	public int getUserSpendingBillsToGuangJNumber(int uid);//逛街总数
	public int getUserSpendingBillsToQiTaNumber(int uid);//其他的总数
	
	public int getUserSpendingBillsToWuQianSNumber(int uid);//5000以上的总数
	public int getUserSpendingBillsToYiQDWuQiNumber(int uid);//1000-5000的总数
	public int getUserSpendingBillsToYiQXNumber(int uid);//1000一下的总数
	
	public int getUserSpendingBillsToThisDayNumber(int uid);//近一天的总数
	public int getUserSpendingBillsToThisWeekNumber(int uid);//金7天
	public int getUserSpendingBillsToThisMonthNumber(int uid);//近一个月
	
}
