package com.hxd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.MyLife;
import com.hxd.model.Page;
import com.hxd.service.mylifeService;
import com.hxd.service.mylifeServiceImpl;
import com.hxd.util.PageUtil;


@Controller
@RequestMapping("mylife")
public class mylifeController {
	/*private ApplicationContext ctx = null;{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	mylifeServiceImpl mlsi = (mylifeServiceImpl) ctx.getBean("mylifeservice");*/
	@Autowired
	private mylifeService mlsi;
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value="addUserMyLifeInfo")
	public ModelAndView  addUserMyLifeInfo(MyLife mylife,HttpServletRequest request){
		
		try {
			boolean result = mlsi.isAddUserMyLifeInfo(mylife);
			if(result){
				modelAndView.setViewName("redirect:/mylife/queryUserMylifInfo?uid="+mylife.getMylife_User());
				
			}
			
			return modelAndView;
		} catch (Exception e) {
			System.out.println("mylife:"+mylife.getMylifeID());
			modelAndView.setViewName("/user/addmylife");
			request.setAttribute("backaddmylife", "添加失败");
			return null;
		}
	}
	/**
	 * 分页查询获取用户日记
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMylifInfo")
	public  ModelAndView  queryUserMylifInfo(int uid,HttpServletRequest request){
						  
		try {
			 String pageNoStr = request.getParameter("pageNo");				
			
			 int number = mlsi.getUserMylifeNumber(uid);
			 Page pb =PageUtil.getPage(pageNoStr, number);
			 List<MyLife> lifeList = mlsi.queryUserMylifeInfos(uid, pb);
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/user/mylifeinfo");
			  modelAndView.addObject("lifeList", lifeList);
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 删除
	 * @param mid
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleateUserMylifeInfo",method=RequestMethod.GET)
	public ModelAndView deleateUserMylifeInfo(int mid,int uid,HttpServletRequest request){
		
		MyLife deleateMylife = mlsi.queryUserMylifeinfo(mid);//要删除的日记信息
		System.out.println("mid"+mid +"uid"+uid);
		try {
			boolean result = mlsi.idDeleateuserMylife(mid, uid);
			if(result ){
				
				modelAndView.setViewName("redirect:/mylife/queryUserMylifInfo?uid="+uid);
				request.getSession().setAttribute("delsuccessinfo", "您删除"+deleateMylife.getMylifeTitle()+"成功");
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/mylife/queryUserMylifInfo?uid="+uid);
			request.getSession().setAttribute("delsuccessinfo", "删除失败");
			return modelAndView;

		}
		
	}
	/**
	 * 查询单个
	 * @param mid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMylifeinfobymid")
	public ModelAndView queryUserMylifeinfobymid(int mid,HttpServletRequest request){
		MyLife queryMylife=mlsi.queryUserMylifeinfo(mid);
		try {
			modelAndView.addObject("queryMylife", queryMylife);
			modelAndView.setViewName("/user/updatemylife");
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("/user/updatemylife");
			return modelAndView;
		}
		
	}
	/**
	 * update
	 * @param mylife
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="updateUserMylifeInfo")
	public ModelAndView updateUserMylifeInfo(MyLife mylife, int uid ,HttpServletRequest request){
		System.out.println("uid"+uid);
		System.out.println(mylife.getMylifeID()+"dddddddddd");
		try {
			MyLife updateMylife = mlsi.queryUserMylifeinfo(mylife.getMylifeID());
			
			updateMylife.setMylifeCreateCity(mylife.getMylifeCreateCity());
			updateMylife.setMylifeCreateTime(mylife.getMylifeCreateTime());
			updateMylife.setMylifeLog(mylife.getMylifeLog());
			updateMylife.setMylifeState(mylife.getMylifeState());
			updateMylife.setMylifeTitle(mylife.getMylifeTitle());
			boolean result = mlsi.isUpdateuserMylife(updateMylife);
			if(result){
				modelAndView.setViewName("redirect:/mylife/queryUserMylifInfo?uid="+uid);
				request.getSession().setAttribute("updateuserMylifeinfo", mylife.getMylifeTitle()+"日记编辑成功");
				
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/mylife/queryUserMylifeinfobymid?mid="+mylife.getMylifeID());
			request.getSession().setAttribute("updateuserMylifeinfo","编辑信息有误请重新输入");
			return modelAndView;
					 
		}
		
	}
}
