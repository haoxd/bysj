package com.hxd.service;

import java.util.List;

import com.hxd.model.BankCard;
import com.hxd.model.Page;

public interface backcardService {
	
	public boolean  isAddUserBankCard(BankCard bankcard);//添加银行卡
	
	public int  getUserBankCardNumber(int uid);//查询用户银行卡总数
	
	public	List<BankCard>  queryUserBankCardInfo(int uid, Page page);
	
	public boolean isDeleateUserBankCard(int bid , int uid);

}
