package com.hxd.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hxd.model.User;
import com.hxd.service.userService;
import com.hxd.util.MD5;


@Controller
@RequestMapping("/user")
public class userController {
	
	
	public userController() {
		System.out.println("user Controller");
	}
	
	
	
	
	@Autowired
	private userService usi;
	

	
		/**
		 * 用户注册
		 * @param user
		 * @param request
		 * @return
		 */
		@RequestMapping("/addUser")
		public String addUser(User user, HttpServletRequest request) {
			try {
			
		 	String usermesage=user.getUserPhone();
		   String password = new MD5().getMD5ofStr(user.getUserPassword());//注册密码加密
		
		   user.setUserPassword(password);
			user.setUserText(usermesage);//简介
			user.setUserEmil(usermesage);//邮箱
			user.setUserName(usermesage);
			user.setUserNickName(usermesage);//
			user.setUserSex("0");//性别
			user.setUserAge(0);//年龄
			user.setUserState("正常");
			user.setUser_BankCardList(null);
			user.setUser_InvestmentList(null);
			user.setUser_MyLifeList(null);
			user.setUser_RevenueBillsList(null);
			user.setUser_SpendingBillsList(null);		
			//定义时间		
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				String ds = dateFormat.format(now);
				user.setUserCreateTime(ds);//创建时间
				user.setUserChangeTime(ds);//最后修改时间				
			    boolean result=	usi.isAddUser(user);
			
				if(result){
					request.setAttribute("InfoMessage", "注册账号成功，请记好您的密码和账户名登录本系统");
					
					return "/userlogin";
				}else{
					request.setAttribute("InfoMessage", "已存在用户或者手机号重复");
					System.out.println("vvvv");
					return "/userreg";
				}
				
				//User  thisBackUpdatejspUser = usi.queryUserInfoByUserID(user.getUserID());
				
				
			} catch (Exception e) {
				System.out.println("dddddddddddd");
				request.setAttribute("InfoMessage", "手机号/身份证号已被注册");

				 return "/userreg";
			}
			
		}
		
		/**
		 * 用户登录
		 * @param UserPhone
		 * @param UserPassword
		 * @param request
		 * @return
		 */
		@RequestMapping("/queryUserLoginSystem")
		public String queryUserLoginSystem(String UserPhone,String UserPassword, HttpServletRequest request ){
			try {
				String queryPassword = new MD5().getMD5ofStr(UserPassword);
				System.out.println("queryPassword:"+queryPassword);
				boolean result =usi.queryUserLoginSystem(UserPhone, queryPassword);
				
				if(result){
					
					User user = usi.queryUserByUserPhoneAndUserPassword(UserPhone, queryPassword);
					
					
					//request.setAttribute("user", user);
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("userID", user.getUserID());//将用户的姓名放入到session中
					System.out.println("userphine:"+UserPhone);
					System.out.println("userPassword:"+queryPassword);
					
					 return "redirect:/investment/queryInvestmentInfos";
				}else{
					request.setAttribute("loginFailInfoMessage", "用户名或密码错误，请重新登陆系统!!!");
					
					return "/userlogin";
				}
			} catch (Exception e) {
				request.setAttribute("loginFailInfoMessage", "用户名，密码错误或者没有登录权限!!!");
				
				return "/userlogin";
			}
			
		}
		
		
		/**
		 * 通过用户id查询用户信息
		 * @return
		 */
		@RequestMapping("/queryUserInfoByUserId")
		public String queryUserInfoByUserId(int id,HttpServletRequest request){
		   try {
			User queryUser = usi.queryUserInfoByUserID(id);
			request.setAttribute("updateuserinfo", "您完善后的信息如下：");
			request.setAttribute("queryUser", queryUser);
			return "/user/updateuserinfo";
		} catch (Exception e) {
			return "success";
		}
		}
		
		/**
		 * 找回密码
		 * @param UserIdcard
		 * @param request
		 * @return
		 */
		@RequestMapping("/queryUserPassword")
		public String queryUserPasswordByUserIdcard(String UserIdcard,String UserPhone,String UserEmil,String UserPassword,HttpServletRequest request){
			
			List<String> AllPhoneList = usi.queryAllUserPhone();
			List<String> AllEmilList = usi.queryAllUseremil();
			List<String> AllIdcardList = usi.queryAllUseridcard();
			
		    boolean phoneresule = AllPhoneList.contains(UserPhone);
		    boolean emilresule = AllEmilList.contains(UserEmil);
		    boolean idcardresule = AllIdcardList.contains(UserIdcard);
		    if(phoneresule && emilresule && idcardresule){
		    	request.setAttribute("UserPassword", "密码已重设，请登录");
		    }else{
		    	request.setAttribute("UserPassword", "输入信息不正确");
		    }
			
			try {
				String MD5Password = new MD5().getMD5ofStr(UserPassword);
				System.out.println("md5密码："+MD5Password);
				boolean querPassworduser = usi.queryUserPasswordByUserIdcard(UserIdcard, UserPhone, UserEmil, MD5Password);
				System.out.println(querPassworduser);
				System.out.println("!!!!!!!!!!");
				if(querPassworduser){
					request.setAttribute("UserPassword", "密码已重设，请登录");
					
				}else{
					request.setAttribute("UserPassword", "输入信息有误！");
				}
				
				System.out.println("@@@@@@@@@@@@@@@");
				return "/user/queryuserpassword";
			} catch (Exception e) {
				System.out.println("##############");
				request.setAttribute("UserPassword", "输入信息有误！");
				return "/user/queryuserpassword";
			}
			
			
			}
		/**
		 * 通过emil找回密码
		 * @param UserEmil
		 * @param request
		 * @return
		 */
		@RequestMapping("/queryUserPasswordByUserEmil")
		public String queryUserPasswordByUserEmil(String UserEmil,HttpServletRequest request){
			try {
				User queryPasswordUser = usi.queryUserPasswordByUserEmil(UserEmil);
				request.setAttribute("UserPassword", "您找回的密码如下："+queryPasswordUser.getUserPassword()+"，请牢记！！！");
				return "/user/queryuserpasswordbyemil";
			} catch (Exception e) {
				request.setAttribute("UserPassword", "请输入正确的身份证号码！！！");
				return "/user/queryuserpasswordbyemil";
			}
			
		}
		/**
		 * 完善用户个人信息
		 * @param user
		 * @param request
		 * @return
		 */
		@RequestMapping("/updateUserInfoByUserId")
		public String updateUserInfoByUserId(User user,HttpServletRequest request){
		System.out.println("程序开始");
				User updateUser = usi.queryUserInfoByUserID(user.getUserID());
		System.out.println("updateUser"+ updateUser.getUserPhone());
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				String ds = dateFormat.format(now);
		System.out.println("程序运行中"+user.getUserName());
	
				updateUser.setUserName(user.getUserName());
				updateUser.setUserNickName(user.getUserNickName());
				updateUser.setUserAge(user.getUserAge());
				updateUser.setUserEmil(user.getUserEmil());
				updateUser.setUserSex(user.getUserSex());
				updateUser.setUserText(user.getUserText());
				updateUser.setUserChangeTime(ds);//最后一次的修改时间
				System.out.println("user:"+user.getUserAge()+user.getUserEmil()+":"+user.getUserName());
			try {
				boolean result = usi.isUpdateUserInfoByUserId(updateUser);

				if(result){
					
				
					 return "redirect:/user/queryUserInfoByUserId?id="+user.getUserID();//拼接url查询id；
				}else{
					request.setAttribute("updateuserinfo", "好像失败了");
					System.out.println("aaaaaaaaa");
					return "/user/updateuserinfo";
				}
			} catch (Exception e) {
				request.setAttribute("updateuserinfo", "好像失败了");
			
				return "/user/updateuserinfo";
			}	
				
				
				
				}
		/**
		 * 修改密码
		 * @param ordpassword
		 * @param user
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/updateUserPassword")
			public ModelAndView updateUserPassword(String ordpassword,User user,HttpServletRequest request){
			ModelAndView modeAndView = new ModelAndView();
			User updateUser = usi.queryUserInfoByUserID(user.getUserID());
				String	ordpasswords = new MD5().getMD5ofStr(ordpassword);//获取到旧密码通过MD5加密
			    System.out.println("旧密码经过MD5加密后"+ordpasswords); 
				String password_table =updateUser.getUserPassword() ;
				System.out.println("用户数据库端的密码"+password_table);
				if( !ordpasswords.equalsIgnoreCase(password_table)){
					//throw new CustomException("旧密码错误");
					modeAndView.setViewName("/user/updatemypassword");
					request.setAttribute("loginFailInfoMessage", "旧密码填写错误");
					return modeAndView;
				}	
				
				
			try {
				String savePassword = new MD5().getMD5ofStr(user.getUserPassword());
				updateUser.setUserPassword(savePassword);
				System.out.println("要修改的密码"+savePassword);
				boolean result = usi.updateUserPassword(updateUser);
				
				if(result){
					modeAndView.setViewName("/userlogin");
					request.getSession().setAttribute("loginFailInfoMessage", "密码修改成功，请重新登录");
					System.out.println("aaaaaaaaaaaaaaaaa");
					
				}
				System.out.println("BBBBBBBBBBBBB");
				return modeAndView;
			} catch (Exception e) {
				System.out.println("CCCCCCCCCCCCCC");
				return modeAndView;
			}
	
}

}
