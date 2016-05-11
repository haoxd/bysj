package com.hxd.service;

import java.util.List;

import com.hxd.model.Page;
import com.hxd.model.RevenueBills;

public interface revenueBillsService {

	public boolean isAddUserRevenueBillsInfo(RevenueBills revenueBills);// 用户添加账单

	public List<RevenueBills> queryUserRevenueBillsInfo(int uid, Page page);// 查询用户账单

	public int getUserRevenueBillsInfoCountNumber(int uid);// 获取用户对应的账单总数

	public int getUserRevenueBillsInfoCountNumberDay(int uid);// 获取用户对应天的账单总数

	public int getUserRevenueBillsInfoCountNumberWeek(int uid);// 获取用户对应周的账单总数

	public int getUserRevenueBillsInfoCountNumberMonth(int uid);// 获取用户对应月的账单总数

	public int getUserRevenueBillsInfoCountNumberWuQian(int uid);// 获取用户5000-

	public int getUserRevenueBillsInfoCountNumberWuqian_YiW(int uid);// 获取用户5000-10000

	public int getUserRevenueBillsInfoCountNumberYiWShang(int uid);// 获取用户>=10000

	public int getUserRevenusBillsInfoCountNumberGongZ(int uid);// 获取用户工资收入的总数

	public int getUserRevenusBillsInfoCountNumberWaiK(int uid);// 获取用户外快收入的总数

	public int getUserRevenusBillsInfoCountNumberLiCai(int uid);// 获取用户理财收入的总数

	public int getUserRevenusBillsInfoCountNumberHeL(int uid);// 获取用户贺礼收入的总数

	public boolean deleateUserRevenueBillsInfoByid(int rid, int uid);// 用户删除自己的账单信息

	public RevenueBills queryUserRevenueBills(int rid);// 查询某一条账单信息

	public boolean isUpdateUserRevenuebillsInfo(RevenueBills revenueBills);// 编辑收入账单信息

	public List<RevenueBills> queryUserRevenuebillsThisDay(int uid, Page page);// 查询用户今天收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWeek(int uid, Page page);// 查询用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisMonth(int uid, Page page);// 查询用户一月的

	public List<RevenueBills> queryUserRevenuebillsThisWuQian(int uid, Page page);// 查询用户今天收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWuQian_YiW(int uid,Page page);// 查询用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisYiWShang(int uid,Page page);// 查询用户一月的

	public List<RevenueBills> queryUserRevenuebillsThisGongZ(int uid, Page page);// 查询用户工资收入账单

	public List<RevenueBills> queryUserRevenuebillsThisWaiK(int uid, Page page);// 查询外快用户一周的

	public List<RevenueBills> queryUserRevenuebillsThisLiCai(int uid, Page page);// 查询用户理财的

	public List<RevenueBills> queryUserRevenuebillsThisHeLi(int uid, Page page);// 查询用户贺礼的

}
