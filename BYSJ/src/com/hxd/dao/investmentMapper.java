package com.hxd.dao;

import java.util.HashMap;
import java.util.List;

import com.hxd.model.Investment;

public interface investmentMapper {
	
	
	
	public List<Investment> queryInvestmentInfos(int fromNo);//查询所有投资信息
	
	public int addUserInvestmentInfos(int uid, int iid, String thisTime);//添加用户的理财信息
	
	public Investment queryInvestmentinfoByIId(int investmentId);
	
	public List<Integer> queryUserInvestment_tableByuid(int uid);//通过uid查询iid
	public List<String>    queryUserInvestment_tableTimeByuid(int uid);//通过uid查询投资时间
	public List<Investment> queryUserInvestmentInfosByUid(int uid);//查询用户投资信息
	
	public int deleateUserInvestmentInfo(int uid,int iid);//用户撤销投资
	
	public int getInvestmentInfoConutNumber();//获取投资信息的总数

}
