package com.hxd.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.spendingbillsMapper;
import com.hxd.model.SpendingBills;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class spendingTest {
	@Autowired
	private spendingbillsMapper smapper;
	/*@Test
	public void query(){
		List<SpendingBills> s = smapper.queryUserSpendingBillsInfos(4, 0);
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i).getSpendingBillsBody());
		}
	}*/
	/*@Test
	public void deleate (){
		int i = smapper.deleateUserSpendingBillsInfo(1, 4);
		System.out.println(i);
	}*/
	@Test
	public void uuid(){
	String uuid = UUID.randomUUID().toString();
		double i = 303.92+371.85+398.69;
		System.out.println(i);
		System.out.println("uuid===="+uuid);
	}
	

}
