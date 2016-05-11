package com.hxd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.Investment;
import com.hxd.model.Page;
import com.hxd.service.investmentService;
import com.hxd.service.investmentServiceImpl;
import com.hxd.util.PageUtil;


@Controller
@RequestMapping("/investment")
public class investmentController {
	
	
	/*private ApplicationContext ctx =null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    investmentServiceImpl isi = (investmentServiceImpl) ctx.getBean("investmentservice");
*/
		@Autowired
		private investmentService isi;
         
         /**
          * 
          * 查询所有投资信息
         * @param request
         * @return
         */
        @RequestMapping("queryInvestmentInfos")
         public String queryInvestmentInfos(HttpServletRequest request){
        	 try {
        		 String pageNoStr = request.getParameter("pageNo");
        		 System.out.println("pageNoStr"+pageNoStr);
        		int number = isi.getInvestmentsCountNumber();
        		 Page pb = PageUtil.getPage(pageNoStr,number);
        		 List<Investment> investmentList = isi.queryInvestmentInfos(pb);
        		 request.setAttribute("pb", pb);
        		 request.setAttribute("userInfoSave", "如果您是");
        		 request.setAttribute("investmentList", investmentList);
        	return "/user/userinstantateinfo";
        		// return "/success";
			} catch (Exception e) {
				 return null;
			}
 
         }
        
        /**
         * 通过在数据库表当中加联合唯一索引达到用户不能投资同一个理财产品
         * 添加用户理财信息
         * @param uid
         * @param iid
         * @param request
         * @return
         */
        @RequestMapping(value="/addUserInvestmentsInfo",method=RequestMethod.GET) 
        public ModelAndView addUserInvestmentsInfo(int uid,int iid ,HttpServletRequest request){
        	System.out.println("aaaaaaaaaaaaa");
        	
        	ModelAndView modelAndView = new ModelAndView();//创建modelandView
        	Investment userInvestment = isi.queryInvestmentInfoByIid(iid);//通过传入查询理财信息
        
        
        	try {
        		Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				String thisTime = dateFormat.format(now);
        	 boolean result = isi.isAddUserInvestmentInfos(uid, iid,thisTime);//执行service层的判断添加用户理财是否成功
             if(result){
             request.getSession().setAttribute("addUserInvestmentsInfo", "您投资"+userInvestment.getInvestmentName()+"成功");
             modelAndView.setViewName("redirect:/investment/queryInvestmentInfos");
                          	
              return modelAndView;
            	}else{
            		request.getSession().setAttribute("addUserInvestmentsInfo", "您已经投资过"+userInvestment.getInvestmentName()+"请重新选择新的理财产品");
                    		//modelAndView.addObject("addUserInvestmentsInfo", "您已经投资过"+userInvestment.getInvestmentName()+"请重新选择新的理财产品");
                   modelAndView.setViewName("redirect:/investment/queryInvestmentInfos");
                        	
                  return modelAndView;
            			}	
        	}catch (Exception e) {
        		request.getSession().setAttribute("addUserInvestmentsInfo", "您已经投资过"+userInvestment.getInvestmentName()+"请重新选择新的理财产品");
        		//modelAndView.addObject("addUserInvestmentsInfo", "您已经投资过"+userInvestment.getInvestmentName()+"请重新选择新的理财产品");
            	modelAndView.setViewName("redirect:/investment/queryInvestmentInfos");
            	
            	return modelAndView;
			}
        
        		
        }  
        
        /**
         * 查询用户投资的理财信息
         * @param uid
         * @return
         */
        @RequestMapping(value="/queryUserInvesmentByUid", method=RequestMethod.GET)
        public ModelAndView queryUserInvesmentByUid(int uid){
        	ModelAndView modelAndView = new  ModelAndView();
        	try {
        		List<Investment> userInvestmentsList= isi.queryUserInvestmentInfosByUid(uid);
            	List<Integer> userInvestmentsIdList = isi.queryUserInvestment_tableByuid(uid);
            	List<String> userInvestmentsTimeList = isi.queryUserInvestment_tableThisTimeByuid(uid);
            	System.out.println("AAAAAAAAAA");
            	modelAndView.addObject("userInvestmentsList", userInvestmentsList);
            	modelAndView.addObject("userInvestmentsIdList", userInvestmentsIdList);
            	modelAndView.addObject("userInvestmentsTimeList", userInvestmentsTimeList);
            	
            	modelAndView.setViewName("/user/myinstanmentinfo");
            	return modelAndView;
			} catch (Exception e) {
				System.out.println("queryUserInvesmentByUid+++++uid:"+uid);
				return modelAndView;
			}
        	
        }
        
        /**
         * 用户撤销投资
         * @param uid
         * @param iid
         * @return
         */
        @RequestMapping(value="/deleateUserInvestmentInfo",method=RequestMethod.GET)
        public ModelAndView deleateUserInvestmentInfo(int uid,Integer iid,HttpServletRequest request){
        	ModelAndView modelAndView  = new ModelAndView();
        	Investment deleateinvInvestment  = isi.queryInvestmentInfoByIid(iid);//用户要撤销的投资信息
        	try {
				boolean result = isi.isDeleateUserInvestmentInfo(uid, iid);				
				if(result){
					modelAndView.setViewName("redirect:/investment/queryUserInvesmentByUid?uid="+uid);
					request.getSession().setAttribute("deleateinvInvestment", "您已经停止对"+deleateinvInvestment.getInvestmentName()+"的投资");
					return modelAndView;
				}else{
					System.out.println("撤销失败");
					return modelAndView;
				}
			} catch (Exception e) {
				modelAndView.setViewName("/user/myinstanmentinfo");
				modelAndView.addObject("deleateinvInvestment","撤销失败");
				return modelAndView;
			}
        	
        }
}
