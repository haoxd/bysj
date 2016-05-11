package com.hxd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.dao.spendingbillsMapper;
import com.hxd.model.Page;
import com.hxd.model.SpendingBills;
@Service("spendingbillsservice")
public class spendingBillsServiceImpl implements spendingBillsService {
	@Autowired
	private spendingbillsMapper spendingbillsmapper;
	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	@Override
	public List<SpendingBills> queryUserSpendingBills(int uid, Page page) {
		//int fromNo = (page.getPageNo()-1*0)*5;
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsInfos(uid, fromNo);
	}

	@Override
	public boolean isAddUserSpendingBillsinfo(SpendingBills spenging) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+spenging.getSpendingBills_User()+"】;添加了"+spenging.getSpendingBillsName()+"支出账单";
		log.info(UserLoginlog);
		int result = spendingbillsmapper.addUserSpendingBills(spenging);
		if (result>0) {
			return true;
			
		}else{
		return false;
	}
		}

	@Override
	public boolean isUpdateUserSpendingBillsinfo(SpendingBills spending) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+spending.getSpendingBills_User()+"】进行了更新支出账单操作";
		log.info(UserLoginlog);
		int result = spendingbillsmapper.updateUserSpendingBillsInfo(spending);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isDeleateUserSpendingBillsinfo(int sid, int uid) {
	
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+uid+"】删除了"+spendingbillsmapper.queryUserSpendinginfoByid(sid).getSpendingBillsName()+"支出账单";
		log.info(UserLoginlog);
		int result = spendingbillsmapper.deleateUserSpendingBillsInfo(sid, uid);
		if(result>0){
			return true;
		}else{
		return false;
	}
		}

	@Override
	public SpendingBills queryUserSpendingBillsbyID(int sid) {
		
		return spendingbillsmapper.queryUserSpendinginfoByid(sid);
	}

	@Override
	public int getUserSpendingBillsNumber(int uid) {
		
		return spendingbillsmapper.getUserSpendingBillsInfosNumber(uid);
	}
	
	
	

	@Override
	public List<SpendingBills> queryUserSpendingBillsToChiFan(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToChiFan(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToLvYou(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToLvYou(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToGuangJ(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToGuangJ(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToQiTa(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToQiTa(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToWuQianS(int uid,
			Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToWuQianS(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToYiQDWuQi(int uid,
			Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToYiQDWuQi(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToYiQX(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToYiQX(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToThisDay(int uid,
			Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToThisDay(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToThisWeek(int uid,
			Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToThisWeek(uid, fromNo);
	}

	@Override
	public List<SpendingBills> queryUserSpendingBillsToThisMonth(int uid,
			Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return spendingbillsmapper.queryUserSpendingBillsToThisMonth(uid, fromNo);
	}

	@Override
	public int getUserSpendingBillsToChiFanNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToChiFanNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToLvYouNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToLvYouNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToGuangJNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToGuangJNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToQiTaNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToQiTaNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToWuQianSNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToWuQianSNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToYiQDWuQiNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToYiQDWuQiNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToYiQXNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToYiQXNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToThisDayNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToThisDayNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToThisWeekNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToThisWeekNumber(uid);
	}

	@Override
	public int getUserSpendingBillsToThisMonthNumber(int uid) {
		return spendingbillsmapper.getUserSpendingBillsToThisMonthNumber(uid);
	}

}
