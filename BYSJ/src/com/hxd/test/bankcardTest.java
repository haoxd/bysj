package com.hxd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.backcardMapper;
import com.hxd.model.BankCard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class bankcardTest {
	@Autowired
	private  backcardMapper bmapper;
	@Test
	public void queryTest(){
		List<BankCard> s = bmapper.queryUserBankCardInfo(4, 0);
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i).getBankCardSrc()+s.get(i).getBankCardName());
			
		}
	}

}
