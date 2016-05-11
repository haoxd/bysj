package com.hxd.service;


import java.util.List;

import com.hxd.model.Investment;
import com.hxd.model.Page;

public interface investmentService {
	
	
	public List<Investment> queryInvestmentInfos(Page page);//查询所有投资信息
	
	public boolean isAddUserInvestmentInfos(int uid,int iid,String thisTime);//用户投资是否成功
	
	public Investment queryInvestmentInfoByIid(int investmentId);
	
	public List<Integer> queryUserInvestment_tableByuid(int uid);//通过iid能否查询到uid
	public List<String> queryUserInvestment_tableThisTimeByuid(int uid);//查询投资时间
	
	public List<Investment>   queryUserInvestmentInfosByUid(int uid);//查询用户的投资信息
	
	public boolean isDeleateUserInvestmentInfo(int uid,int iid);//用户撤销投资是否成功
	
	public int getInvestmentsCountNumber();//获取投资总数

}
