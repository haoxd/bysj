package com.hxd.test;

import java.util.ArrayList;
import java.util.List;

public class someTest {
	public static void main(String[] args) {
		
		listtest();
		    
		
	}
	
	/**
	 * 
	 * 判断元素是否存在集合当中
	 * 
	 */
	public static void listtest(){

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        boolean bo = list.contains("a");
        boolean boo = list.contains("d");
        System.out.println(bo);
        System.out.println(boo);
	}

}
