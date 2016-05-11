package com.hxd.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.BankCard;
import com.hxd.model.Page;
import com.hxd.service.backcardService;
import com.hxd.service.bankCardServiceImpl;
import com.hxd.util.PageUtil;


@Controller
@RequestMapping("/bankcard")
public class bankcardController {

	public static final String SRCPATH = "upload/";
	/*
	private ApplicationContext ctx =null;
	{
		ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
	}
	bankCardServiceImpl bcsi = (bankCardServiceImpl) ctx.getBean("bankcardservice");*/
	@Autowired
	private backcardService bcsi;
	ModelAndView modelAndView = new  ModelAndView();
			
	/**
	 * 用户添加自己的银行卡信息
	 * @param bankCard
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addUserBankCard", method=RequestMethod.POST)
	public ModelAndView addUserBankCard(BankCard bankCard,@RequestParam("bankcardfile")MultipartFile file,HttpServletRequest request,HttpServletResponse  response) throws Exception{
	
		
		String path = request.getSession().getServletContext()
		.getRealPath("/")+SRCPATH;

		
		System.out.println(path+"!!path");
		
		try {
	
			//if(!file.isEmpty()){
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				String ds = dateFormat.format(now);
			 bankCard.setBankCardName(file.getOriginalFilename());//将图片的原始名称添加到midel
			 bankCard.setBankCardSrc(path);//添加文件路径
			 bankCard.setBankCardCreateTime(ds);
			 System.out.println(file.getName()+"ssssssssssss");

			file.transferTo(new File(path+file.getOriginalFilename()));//上传图片
		
			boolean result = bcsi.isAddUserBankCard(bankCard);
			System.out.println("result"+result);
			if(result){
				//response.setHeader("refresh", "3;url=redirect:/bankcard/queryUserBankCardInfo?uid="+bankCard.getBankCard_User());
				 // Thread thread = Thread.currentThread();
				//  Thread.sleep(5000);
				modelAndView.setViewName("redirect:/bankcard/queryUserBankCardInfo?uid="+bankCard.getBankCard_User());
				return modelAndView; 
			}			
			//}
			return modelAndView; 
		}  catch (Exception e) {
			  request.setAttribute("backfailinfo", "已经添加过"+bankCard.getBackCardNumber()+"银行卡"+"，or重新选择图片上传");
			  modelAndView.setViewName("/user/addmybankcard");
			  return modelAndView; 
		   }

			     }
	
	/**
	 * 分页查询用户银行卡信息
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserBankCardInfo")
	public ModelAndView queryUserBankCardInfo(int uid ,HttpServletRequest request){
		try {
			//Thread.sleep(3000);
			String pageNoStr = request.getParameter("pageNo");	
		
			
			int number  = bcsi.getUserBankCardNumber(uid);
			Page pb = PageUtil.getPage(pageNoStr, number);
			List<BankCard> bankCardList = bcsi.queryUserBankCardInfo(uid, pb);
			request.setAttribute("pb", pb);
			modelAndView.setViewName("/user/mycardinfo");
			modelAndView.addObject("bankCardList", bankCardList);
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
		
	}
	@RequestMapping(value="/deleateUserBankCard", method=RequestMethod.GET)
	public  ModelAndView deleateUserBankCard(int bid,int uid,HttpServletRequest request){
		try {
			boolean result = bcsi.isDeleateUserBankCard(bid, uid);
			if(result){
				modelAndView.setViewName("redirect:/bankcard/queryUserBankCardInfo?uid="+uid);
				request.getSession().setAttribute("delsuccess", "该银行卡删除成功");
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/bankcard/queryUserBankCardInfo?uid="+uid);
			request.getSession().setAttribute("delsuccess", "该银行卡删除失败");
			return modelAndView;
		}
	}
	
}
