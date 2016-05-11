package com.hxd.dao;

import java.util.List;

import com.hxd.model.BankCard;

public interface backcardMapper {
	public int  addUserBankCard(BankCard bankcard);//用户添加银行卡
	public int 	 getUserBankCardNumber(int uid);//获取用户银行卡的总数
	public List<BankCard> queryUserBankCardInfo(int uid,int fromNo);//获取集合 
	public int deleateUserBankCard(int bid,int uid);//删除银行卡
}
