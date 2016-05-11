package com.hxd.service;

import java.util.List;

import com.hxd.model.Page;
import com.hxd.model.SpendingBills;

public interface spendingBillsService {
	
	public List<SpendingBills> queryUserSpendingBills(int uid ,Page page);//分页查询全部
	public boolean isAddUserSpendingBillsinfo(SpendingBills spenging);//判断添加
	public boolean isUpdateUserSpendingBillsinfo(SpendingBills spending);//判断编辑
	public boolean isDeleateUserSpendingBillsinfo(int sid,int uid);//判断删除
	public SpendingBills queryUserSpendingBillsbyID(int sid);//查询对应的一条
	public int getUserSpendingBillsNumber(int uid);//获取用户支出账单的总数
	
	
	
	public List<SpendingBills> queryUserSpendingBillsToChiFan(int uid,Page page);//关于吃饭的集合
	public List<SpendingBills> queryUserSpendingBillsToLvYou(int uid,Page page);//旅游的全部信息
	public List<SpendingBills> queryUserSpendingBillsToGuangJ(int uid,Page page);//逛街全部信息
	public List<SpendingBills> queryUserSpendingBillsToQiTa(int uid,Page page);//其他的支出全部信息
	
	public List<SpendingBills> queryUserSpendingBillsToWuQianS(int uid,Page page);//5000以上的支出账单
	public List<SpendingBills> queryUserSpendingBillsToYiQDWuQi(int uid,Page page);//1000-5000的支出账单
	public List<SpendingBills> queryUserSpendingBillsToYiQX(int uid,Page page);//1000一下的支出账单
	
	public List<SpendingBills> queryUserSpendingBillsToThisDay(int uid,Page page);//近一天的支出账单
	public List<SpendingBills> queryUserSpendingBillsToThisWeek(int uid,Page page);//近7天的账单
	public List<SpendingBills> queryUserSpendingBillsToThisMonth(int uid,Page page);//近30天
	
	
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
