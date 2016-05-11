package com.hxd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.dao.backcardMapper;
import com.hxd.model.BankCard;
import com.hxd.model.Page;
@Service("bankcardservice")
public class bankCardServiceImpl implements backcardService {
	@Autowired
	private backcardMapper backcardmapper;
	/* 用户上传英航卡
	 * @see com.hxd.service.backcardService#isAddUserBankCard(com.hxd.model.BankCard)
	 */
	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	
	@Override
	public boolean isAddUserBankCard(BankCard bankcard) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id为：["+bankcard.getBankCard_User()+"]添加了一张"+bankcard.getBankCardName();
		log.info(UserLoginlog);
		int result = backcardmapper.addUserBankCard(bankcard);
		if(result>0){
			return true;
		}else{
		return false;
	}
		}
	@Override
	public int getUserBankCardNumber(int uid) {
		
		return backcardmapper.getUserBankCardNumber(uid);
	}
	@Override
	public List<BankCard> queryUserBankCardInfo(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return backcardmapper.queryUserBankCardInfo(uid, fromNo);
	}
	@Override
	public boolean isDeleateUserBankCard(int bid, int uid) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id为：["+uid+"]删除了一张银行卡";
		log.info(UserLoginlog);
		int result = backcardmapper.deleateUserBankCard(bid, uid);
		if(result>0){
			return  true;
			
		}else{
			return false;
		}
	}

	
	

}
