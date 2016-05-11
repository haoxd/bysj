package com.hxd.util;


import com.hxd.model.Page;



public class PageUtil {
/*
	private ApplicationContext ctx =null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    investmentServiceImpl isi = (investmentServiceImpl) ctx.getBean("investmentservice");
	*/
	public   static Page getPage(String pageNoStr,int number)
	{
		int pageNo = 1;
		
		// 获取到了当前页面的编号
		if (null != pageNoStr && !pageNoStr.equals(""))
		{
			pageNo = Integer.valueOf(pageNoStr);
		}
		
		Page pb = new Page();
		pb.setPageNo(pageNo);
		
		// 获取到了用户的总数
		int totalNum = number;
		
		
		// 通过用户的总数计算出总页面
		int totalPage = (totalNum % pb.getNumberPerPage() == 0) ? 
				(totalNum / pb.getNumberPerPage()) : (totalNum / pb.getNumberPerPage() + 1);
				
		pb.setTotalPage(totalPage);		
		
		return pb;
	}
	
	
}
