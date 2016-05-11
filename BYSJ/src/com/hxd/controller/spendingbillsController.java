package com.hxd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.Page;
import com.hxd.model.RevenueBills;
import com.hxd.model.SpendingBills;
import com.hxd.service.spendingBillsService;
import com.hxd.service.spendingBillsServiceImpl;
import com.hxd.util.PageUtil;




@Controller
@RequestMapping("/spendingbills")
public class spendingbillsController {
	
/*	private ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	spendingBillsServiceImpl sbsi = (spendingBillsServiceImpl) ctx.getBean("spendingbillsservice");
	*/
	
	@Autowired
	private spendingBillsService sbsi;
	ModelAndView modelAndView = new ModelAndView();
	/**
	 * 用户添加支出账单
	 * @param spending
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addUserSpendingBills")
	public ModelAndView addUserSpendingBills(SpendingBills spending , HttpServletRequest request){
		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			String ds = dateFormat.format(now);
			spending.setSpendingBillschangeTime(ds);
			spending.setSpendingBillsCreateTime(ds);
			boolean result = sbsi.isAddUserSpendingBillsinfo(spending);
			if(result){
				modelAndView.setViewName("redirect:/spendingbills/queryUserSpendingBillsInfos?uid="+spending.getSpendingBills_User());
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("");
			request.setAttribute("", "");
			return modelAndView;
		}
		
	}
	/**
	 * 分页查询用户支出账单的全部内容
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryUserSpendingBillsInfos")
	public ModelAndView queryUserSpendingBillsInfos(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");				
			 int number = sbsi.getUserSpendingBillsNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsLists = sbsi.queryUserSpendingBills(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsLists", spendingBillsLists);
			 modelAndView.setViewName("/user/mysoendingbillsinfo");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	/**
	 * 删除用户对应的支出账单
	 * @param sid
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleateUserSpendingBills", method=RequestMethod.GET)
	public ModelAndView deleateUserSpendingBills(int sid ,int uid ,HttpServletRequest request){
		System.out.println("############删除支出账单功能开始执行###############");
		SpendingBills deleateBills = sbsi.queryUserSpendingBillsbyID(sid);//要删除的支出账单
		System.out.println(sid);
		System.out.println(uid);
		try {
			boolean result = sbsi.isDeleateUserSpendingBillsinfo(sid, uid);
			System.out.println(result);
			if(result){
				modelAndView.setViewName("redirect:/spendingbills/queryUserSpendingBillsInfos?uid="+uid);
				request.getSession().setAttribute("deleateUserRevenuebillsInfo", "您成功删除"+deleateBills.getSpendingBillsName()+"支出账单");
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/spendingbills/queryUserSpendingBillsInfos?uid="+uid);
			request.getSession().setAttribute("deleateUserRevenuebillsInfo", "您删除"+deleateBills.getSpendingBillsName()+"收入账单失败");
			return modelAndView;
		} 
	}
	/**
	 * 编辑用户的某一条支出账单信息
	 * @param spending
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateUserSpendingBills")
	public ModelAndView updateUserSpendingBills(SpendingBills spending , int uid , HttpServletRequest request){
		try {
			SpendingBills updateSendingbills = sbsi.queryUserSpendingBillsbyID(spending.getSpendingBillsId());//要编辑的账单信息
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			String changeTime = dateFormat.format(now);
			
			updateSendingbills.setSpendingBillsName(spending.getSpendingBillsName());
			updateSendingbills.setSpendingBillsBody(spending.getSpendingBillsBody());
			updateSendingbills.setSpendingBillschangeTime(changeTime);
			updateSendingbills.setSpendingBillsMoney(spending.getSpendingBillsMoney());
			updateSendingbills.setSpendingBillsState(spending.getSpendingBillsState());
			
			boolean result = sbsi.isAddUserSpendingBillsinfo(updateSendingbills);
			if(result){
				modelAndView.setViewName("redirect:/spendingbills/queryUserSpendingBillsInfos?uid="+uid);
				request.getSession().setAttribute("updateUserspendingbillsInfo", spending.getSpendingBillsName()+"支出账单编辑成功");
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/spendingbills/queryUserRevenusBillsinfoByid?rid="+spending.getSpendingBillsId());
			request.getSession().setAttribute("updateUserRevenuebillsInfo", spending.getSpendingBillsName()+"编辑失败");
			return modelAndView;
		}
		
	}
	/**
	 * 具体查询用户的某一条账单信息
	 * @param sid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserSpendIngBillsByid")
	public ModelAndView queryUserSpendIngBillsByid(int sid ,HttpServletRequest request){
		try {
			SpendingBills querySpendingBills = sbsi.queryUserSpendingBillsbyID(sid);
			modelAndView.addObject("querySpendingBills", querySpendingBills);
			modelAndView.setViewName("/user/updatemyzhichu");
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
		
	}
	/**
	 * 
	 *按类型的集合
	 * 
	 * **/
	
	@RequestMapping(value="queryUserSpendingBillsInfosChifan")
	public ModelAndView queryUserSpendingBillsInfosChifan(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToChiFanNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsChifanLists = sbsi.queryUserSpendingBillsToChiFan(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsChifanLists", spendingBillsChifanLists);
			 modelAndView.setViewName("/user/mysoendingbillsinfochifan");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosLvYou")
	public ModelAndView queryUserSpendingBillsInfosLvYou(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToLvYouNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListslvyou = sbsi.queryUserSpendingBillsToLvYou(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListslvyou", spendingBillsListslvyou);
			 modelAndView.setViewName("/user/mysoendingbillsinfolvyou");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosGuangjie")
	public ModelAndView queryUserSpendingBillsInfosGuangjie(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
			 int number = sbsi.getUserSpendingBillsToGuangJNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsguangj = sbsi.queryUserSpendingBillsToGuangJ(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsguangj", spendingBillsListsguangj);
			 modelAndView.setViewName("/user/mysoendingbillsinfoguangj");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosQiTa")
	public ModelAndView queryUserSpendingBillsInfosQiTa(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToQiTaNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsqita = sbsi.queryUserSpendingBillsToQiTa(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsqita", spendingBillsListsqita);
			 modelAndView.setViewName("/user/mysoendingbillsinfoqita");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	/**
	 * 
	 * 按时间
	 * 
	 * **/
	@RequestMapping(value="queryUserSpendingBillsInfosWeek")
	public ModelAndView queryUserSpendingBillsInfosWeek(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToThisWeekNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsweek = sbsi.queryUserSpendingBillsToThisWeek(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsweek", spendingBillsListsweek);
			 modelAndView.setViewName("/user/mysoendingbillsinfoweek");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosDay")
	public ModelAndView queryUserSpendingBillsInfosDay(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToThisDayNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsday = sbsi.queryUserSpendingBillsToThisDay(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsday", spendingBillsListsday);
			 modelAndView.setViewName("/user/mysoendingbillsinfoyiday");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosMonth")
	public ModelAndView queryUserSpendingBillsInfosMonth(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToThisMonthNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsmonth = sbsi.queryUserSpendingBillsToThisMonth(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsmonth", spendingBillsListsmonth);
			 modelAndView.setViewName("/user/mysoendingbillsinfomonth");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	/**
	 * 
	 * 
	 * 按金额
	 * **/
	@RequestMapping(value="queryUserSpendingBillsInfosWuQian")
	public ModelAndView queryUserSpendingBillsInfosWuQian(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToWuQianSNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListswuqian = sbsi.queryUserSpendingBillsToWuQianS(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListswuqian", spendingBillsListswuqian);
			 modelAndView.setViewName("/user/mysoendingbillsinfowuqian");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosWuQiandaoyiqian")
	public ModelAndView queryUserSpendingBillsInfosWuQiandaoyiqian(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToYiQDWuQiNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListswuqiandaoyiqian = sbsi.queryUserSpendingBillsToYiQDWuQi(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListswuqiandaoyiqian", spendingBillsListswuqiandaoyiqian);
			 modelAndView.setViewName("/user/mysoendingbillsinfowuqiandaoyiqian");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
	@RequestMapping(value="queryUserSpendingBillsInfosyiqianxia")
	public ModelAndView queryUserSpendingBillsInfosyiqianxia(int uid ,HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = sbsi.getUserSpendingBillsToYiQXNumber(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<SpendingBills> spendingBillsListsyiqian = sbsi.queryUserSpendingBillsToYiQX(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("spendingBillsListsyiqian", spendingBillsListsyiqian);
			 modelAndView.setViewName("/user/mysoendingbillsinfoyiqian");			
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return modelAndView;
		}
	}
}
