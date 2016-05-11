package com.hxd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.UserMessageBack;
import com.hxd.service.userMessageBackService;
import com.hxd.service.userMessageBackServiceImpl;

@Controller
@RequestMapping("/usermessageback")
public class usermessagebackController {
	
	/*private ApplicationContext ctx = null;
	{
		ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	userMessageBackServiceImpl umbsi = (userMessageBackServiceImpl) ctx.getBean("usermessagebackservice");
	
	*/
	@Autowired
	private userMessageBackService umbsi;
	ModelAndView modelAndView = new ModelAndView();//创建modelandview对象

	@RequestMapping(value="/addUserMessageBack")
	public ModelAndView addUserMessageBack(UserMessageBack message,HttpServletRequest request){
		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			String ds = dateFormat.format(now);
			message.setUserMessageTime(ds);
			boolean result = umbsi.isAddUserMessageBackInfo(message);
			if(result){
				modelAndView.setViewName("/user/addusermessageback");
				request.setAttribute("addusermessagebackinfo", "您的意见我们已经收到我们会尽快处理");
			}
				return modelAndView;
		} catch (Exception e) {
			System.out.println("usermessagebackadd:"+message.getUserMessageBackId());
			return null;
		}
		
	}

}
