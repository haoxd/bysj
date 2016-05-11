package com.hxd.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.investmentMapper;
import com.hxd.model.Investment;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class investmentTest {
	@Autowired
	private investmentMapper investmentmapper;
	
	@Test
	public void queryInvestmentinfos(){
		List<Investment> lists =investmentmapper.queryInvestmentInfos(1);
		
		for (int i = 0; i < lists.size(); i++) {
			System.out.println("理财名称"+lists.get(i).getInvestmentName()+";内容："+lists.get(i).getInvestmentBody());
		}
	}
	
	
	/*@Test
	public void addUserInvestmentsinfos(){
		int i = investmentmapper.addUserInvestmentInfos(2, 2);
		System.out.println(i);
	}*/
	/*@Test
	public void queryInvestmentinfoByid(){
		Investment inverstment = investmentmapper.queryInvestmentinfoByIId(1);
		System.out.println(inverstment.getInvestmentBody());
	}*/
  /* @Test
	public void queryUserInvestment_tableByiid(){
	List<Integer> list = investmentmapper.queryUserInvestment_tableByuid(4);
	 for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	}*/
	
/*@Test
	public void queryUserInvestment_tableByiid(){
	List<String> list = investmentmapper.queryUserInvestment_tableTimeByuid(4);
	 for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	}*/
	/*@Test
	public void deleateUserInvestmentinfo(){
		int i  =  investmentmapper.deleateUserInvestmentInfo(4, 4);
		System.out.println(i);
	}*/
	/*@Test
	public void getcountNumber(){
		int countNumber = investmentmapper.getInvestmentInfoConutNumber();
		System.out.println(countNumber);
	}*/
	

}
