package com.hxd.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.revenuebillsMapper;
import com.hxd.model.RevenueBills;

/**
 * @author acer11
 *  作者：
* 创建时间：2016-5-5 上午9:30:17  
* 项目名称：BYSJ  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：revenueBillsTest.java  
* 类说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class revenueBillsTest {
	@Autowired
	private revenuebillsMapper revenuebillsmapper;
	/**
	 * @param qweqweqw
	 */
	public static void main(String[] qweqweqw) {
		System.out.println("搞清楚java main函数背后jvm运行原理了吗？没有搞清楚就赶紧学习去吧");
	}
	/*@Test
	public void deleate(){
		int i = revenuebillsmapper.deleateUserRevenueBillsInfoByid(1, 4);
		System.out.println(i);
	}
*/
	@Test
	public void update(){
	
		/*
		 * public Object get(int i)
        {
            rangeCheck(i);
            checkForComodification();
            return elementData(offset + i);
        }

		 * 
		 * 
		 * **/
		
		List a = new ArrayList<>();
		/**
		 * 
		 * 
    		public Object get(int i)
    			{
        			checkElementIndex(i);
        		return node(i).item;
    							}
		 * */
		List b = new LinkedList<>();
	
		
		Map c = new HashMap<>();
		Map d = new Hashtable<>();
		Map e = new TreeMap<>();
	
		RevenueBills ss = new RevenueBills();
	
		ss.setRevenueBillsName("eee");
		ss.setRevenueBillsState("ww");
		ss.setRevenueBillsBody("aaaaaaa");	
		ss.setRevenueBillsMoney(123);
		ss.setRevenueBillsChangeTime("ad");
	
		int i = revenuebillsmapper.updateUserRevenueBillsInfo(ss);
		String s = "aa".toString();
		System.out.println(i);
		
		String str = "1";
		Integer nt = 4;
		String abc = String.valueOf(nt);
		String bac = nt.toString();
		String bbn = nt+"";
		int aaa = Integer.parseInt(str);
		System.out.println(aaa);
		aaa = Integer.valueOf(str).intValue();
		
				
		
	}
}
