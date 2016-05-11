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
import com.hxd.service.revenueBillsService;
import com.hxd.service.revenueBillsServiceImpl;
import com.hxd.util.PageUtil;

/**
 * @author acer11
 *  作者：
* 创建时间：2016-3-22 上午11:45:51  
* 项目名称：BYSJ  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：revenuebillsController.java  
* 类说明：
 */
@Controller
@RequestMapping("/revenuebills")
public class revenuebillsController {
	
	/*private ApplicationContext ctx  = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	revenueBillsServiceImpl rbsi = (revenueBillsServiceImpl) ctx.getBean("revenuebillsservice");
   */
	@Autowired
	private revenueBillsService rbsi;
	/**
	 * 用户添加收入账单
	 * @param revenueBills
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addUserRevenueBillsInfo")
	public ModelAndView addUserRevenueBillsInfo(RevenueBills revenueBills,HttpServletRequest request){		
	ModelAndView modelAndView  = new ModelAndView();
	
	
	try {
		int userRevenueBillsMoney  =  revenueBills.getRevenueBillsMoney();//给账单金额加单位
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String ds = dateFormat.format(now);
		revenueBills.setRevenueBillsChangeTime(ds);
		revenueBills.setRevenueBillsCreateTime(ds);
		revenueBills.setRevenueBillsMoney(userRevenueBillsMoney);
		boolean result = rbsi.isAddUserRevenueBillsInfo(revenueBills);
		if(result){
			modelAndView.setViewName("redirect:/revenuebills/queryUserRevenueBillsInfos?uid="+revenueBills.getRevenueBills_UserID());
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		return modelAndView;
		
	}
	/**
	 * 用户查询自己的收入账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenueBillsInfos")
	public ModelAndView queryUserRevenueBillsInfos(int uid ,HttpServletRequest request){
		ModelAndView modelAndView = new  ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
			 int number = rbsi.getUserRevenueBillsInfoCountNumber(uid);
			
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBills = rbsi.queryUserRevenueBillsInfo(uid, pb);
			 request.setAttribute("pb", pb);
			// request.setAttribute("userToRevenueBills", userToRevenueBills);
			 modelAndView.addObject("userToRevenueBills", userToRevenueBills);
			 modelAndView.setViewName("/user/myrevenuebillsinfo");
			return modelAndView;
			
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
		
		
	}
	/**
	 * 用户删除自己的收入账单
	 * @param rid
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleateUserRevenuebillsInfo",method=RequestMethod.GET)
	public ModelAndView deleateUserRevenuebillsInfo(int rid , int uid, HttpServletRequest request){
		ModelAndView  modelAndView = new ModelAndView();
		RevenueBills rbillsBackInfo  = rbsi.queryUserRevenueBills(rid);//要删除的账单信息
		try {
			
			boolean result = rbsi.deleateUserRevenueBillsInfoByid(rid, uid);
			if(result){
				modelAndView.setViewName("redirect:/revenuebills/queryUserRevenueBillsInfos?uid="+uid);
				request.getSession().setAttribute("deleateUserRevenuebillsInfo", "您成功删除"+rbillsBackInfo.getRevenueBillsName()+"收入账单");
				return modelAndView;
			}else{
				System.out.println(uid+"删除失败");
				return modelAndView;
			}
			
			
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/revenuebills/queryUserRevenueBillsInfos?uid="+uid);
			request.getSession().setAttribute("deleateUserRevenuebillsInfo", "您删除"+rbillsBackInfo.getRevenueBillsName()+"收入账单失败");
			return modelAndView;
		}
	}
	/**
	 * 用户编辑自己的收入账单
	 * @param revenueBills
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateUserRevenueBillsInfo")
	public ModelAndView updateUserRevenueBillsInfo(RevenueBills revenueBills,int uid,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("qqqqqqqqqq:"+uid);
		try {
			RevenueBills updateRevenueBills = rbsi.queryUserRevenueBills(revenueBills.getRevenueBillsID());//创建要修改的账单对象
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			String changeTime = dateFormat.format(now);
			updateRevenueBills.setRevenueBillsName(revenueBills.getRevenueBillsName());
			updateRevenueBills.setRevenueBillsBody(revenueBills.getRevenueBillsBody());
			updateRevenueBills.setRevenueBillsChangeTime(changeTime);
			updateRevenueBills.setRevenueBillsState(revenueBills.getRevenueBillsState());
			updateRevenueBills.setRevenueBillsMoney(revenueBills.getRevenueBillsMoney());
			System.out.println(updateRevenueBills.getRevenueBillsName()+"aaaaaaaaaaaa");
			boolean result = rbsi.isUpdateUserRevenuebillsInfo(updateRevenueBills);
			System.out.println("result:"+result);
			
			if(result){
				modelAndView.setViewName("redirect:/revenuebills/queryUserRevenueBillsInfos?uid="+uid);
				request.getSession().setAttribute("updateUserRevenuebillsInfo", revenueBills.getRevenueBillsName()+"收入账单编辑成功");
				return modelAndView;
			}else{
				System.out.println("编辑失败");
				return null;
			}
			
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/revenuebills/queryUserRevenusBillsinfoByid?rid="+revenueBills.getRevenueBillsID());
			request.getSession().setAttribute("updateUserRevenuebillsInfo", revenueBills.getRevenueBillsName()+"编辑失败");
			return modelAndView;
		}
		
	}
	/**
	 * 查询用户具体的一条信息
	 * @param rid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryUserRevenusBillsinfo")
	public ModelAndView queryUserRevenusBillsinfoByid(int rid,HttpServletRequest request){
		
		ModelAndView modelAndView  = new ModelAndView();
		RevenueBills queryRevenueBills = rbsi.queryUserRevenueBills(rid);
		
		try {
			modelAndView.addObject("queryRevenueBills", queryRevenueBills);
			modelAndView.setViewName("/user/updatemyshouruinfo");
			return modelAndView;
		} catch (Exception e) {
		return modelAndView;
		}
	}
	/**
	 * 用户的当天账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisDay")
	public ModelAndView  queryUserRevenuebillsThisDay(int uid, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
			
			 int number = rbsi.getUserRevenueBillsInfoCountNumberDay(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsDay = rbsi.queryUserRevenuebillsThisDay(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfoday");
			 modelAndView.addObject("userToRevenueBillsDay", userToRevenueBillsDay);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	/**
	 * 当周的账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisWeek")
	public ModelAndView queryUserRevenuebillsThisWeek(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
			 int number = rbsi.getUserRevenueBillsInfoCountNumberWeek(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsWeek = rbsi.queryUserRevenuebillsThisWeek(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfoweek");
			 modelAndView.addObject("userToRevenueBillsWeek", userToRevenueBillsWeek);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	/**
	 * 当月账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisMonth")
	public ModelAndView queryUserRevenuebillsThisMonth(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenueBillsInfoCountNumberMonth(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsMonth = rbsi.queryUserRevenuebillsThisMonth(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfomonth");
			 modelAndView.addObject("userToRevenueBillsMonth", userToRevenueBillsMonth);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	/**
	 * user 5000- 账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisWuQian")
	public ModelAndView queryUserRevenuebillsThisWuQian(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");				
			 int number = rbsi.getUserRevenueBillsInfoCountNumberWuQian(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsWuQian = rbsi.queryUserRevenuebillsThisWuQian(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfowuqian");
			 modelAndView.addObject("userToRevenueBillsWuQian", userToRevenueBillsWuQian);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	/**
	 * user 5000-10000账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisWuQian_YiW")
	public ModelAndView queryUserRJevenuebillsThisWuQian_YiW(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenueBillsInfoCountNumberWuqian_YiW(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsWuQian_YiWan = rbsi.queryUserRevenuebillsThisWuQian_YiW(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfowuqiandaoyiwan");
			 modelAndView.addObject("userToRevenueBillsWuQian_YiWan", userToRevenueBillsWuQian_YiWan);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	/**
	 * user 10000+ 账单
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisYiWShang")
	public ModelAndView queryUserRevenuebillsThisYiWShang(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenueBillsInfoCountNumberYiWShang(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsYiWan = rbsi.queryUserRevenuebillsThisYiWShang(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfoyiwanshang");
			 modelAndView.addObject("userToRevenueBillsYiWan", userToRevenueBillsYiWan);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	/**
	 * 工资
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisGongZhi")
	public ModelAndView queryUserRevenuebillsThisGongZhi(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenusBillsInfoCountNumberGongZ(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsGongzhi = rbsi.queryUserRevenuebillsThisGongZ(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfogongzhi");
			 modelAndView.addObject("userToRevenueBillsGongzhi", userToRevenueBillsGongzhi);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	/**
	 * 理财
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisLiCai")
	public ModelAndView queryUserRevenuebillsThisLiCai(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenusBillsInfoCountNumberLiCai(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsLicai = rbsi.queryUserRevenuebillsThisLiCai(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfolicai");
			 modelAndView.addObject("userToRevenueBillsLicai", userToRevenueBillsLicai);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	/**
	 * 外快
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisWaiKuai")
	public ModelAndView queryUserRevenuebillsThisWaiKuai(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
				
			 int number = rbsi.getUserRevenusBillsInfoCountNumberWaiK(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsWaikuai = rbsi.queryUserRevenuebillsThisWaiK(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfowaikuai");
			 modelAndView.addObject("userToRevenueBillsWaikuai", userToRevenueBillsWaikuai);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	/**
	 * 贺礼
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserRevenuebillsThisHeli")
	public ModelAndView queryUserRevenuebillsThisHeli(int uid , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		try {
			 String pageNoStr = request.getParameter("pageNo");
			 int number = rbsi.getUserRevenusBillsInfoCountNumberHeL(uid);
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
			 List<RevenueBills> userToRevenueBillsheli = rbsi.queryUserRevenuebillsThisHeLi(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/myrevenuebillsinfoheli");
			 modelAndView.addObject("userToRevenueBillsheli", userToRevenueBillsheli);
			 return modelAndView;
		} catch (Exception e) {
			System.out.println("uid"+uid);
			return null;
		}
	}
	
	
}
