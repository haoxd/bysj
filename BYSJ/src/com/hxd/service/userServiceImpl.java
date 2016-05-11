package com.hxd.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.hxd.controller.userController;
import com.hxd.dao.userMapper;
import com.hxd.model.User;
@Service("userservice")
public class userServiceImpl implements userService {
	
	
	
	
	public userServiceImpl(){
		System.out.println("user serviceImpl");
	}
	
	@Autowired
	private userMapper usermapper;

	/* 判断添加用户是否成功
	 * @see com.hxd.service.userService#isAddUser(com.hxd.model.User)
	 */
	/* (non-Javadoc)
	 * @see com.hxd.service.userService#isAddUser(com.hxd.model.User)
	 */
	Logger log = Logger.getLogger(userServiceImpl.class);
	
	
	@Override
	
	public boolean isAddUser(User user) {
	
		
		
		int result= usermapper.addUser(user);
		if(result>0){
			return true;
			
		}else{
		return false;
	}
	}

	/* 登陆系统
	 * @see com.hxd.service.userService#queryUserLoginSystem(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean queryUserLoginSystem(String UserPhone, String UserPassword) {
		
		User user = usermapper.queryUserLoginSystem(UserPhone, UserPassword);
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = user.getUserName()+"登陆系统";
		log.info(UserLoginlog);
		if(null !=user){
			return true;
			
		}else{
			return false;
		}
	}

	/* 通过手机号码和密码查询学生信息
	 * @see com.hxd.service.userService#queryUserByUserPhoneAndUserPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User queryUserByUserPhoneAndUserPassword(String UserPhone,
			String UserPassword) {
		
		return usermapper.queryUserByuserPhone(UserPhone, UserPassword);
	}

	/* 重设密码
	 * @see com.hxd.service.userService#queryUserPasswordByUserIdcard(java.lang.String)
	 */
	@Override
	public boolean queryUserPasswordByUserIdcard(String UserIdcard,String UserPhone,String UserEmil,String UserPassword) {
	int i = usermapper.queryUserPasswordByIdcard(UserIdcard, UserPhone, UserEmil, UserPassword);
	if(i>0){
		return true;
	}else{
		return false;
	}
	
	}

	/* 通过emil找回密码
	 * @see com.hxd.service.userService#queryUserPasswordByUserEmil(java.lang.String)
	 */
	@Override
	public User queryUserPasswordByUserEmil(String UserEmil) {
		
		return usermapper.queryUserPasswordByEmil(UserEmil);
	}

	/* 完善用户信息
	 * @see com.hxd.service.userService#updateUserInfoByUserId(com.hxd.model.User)
	 */
	@Override
	public boolean isUpdateUserInfoByUserId(User user) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = user.getUserName()+"编辑了个人信息";
		log.info(UserLoginlog);
		int result = usermapper.updateUserInfoByUserId(user);
		if(result>0){
			return true;
			
		}else{
		return false;
			}
		 }

	/* 通过用户id查询用户信息
	 * @see com.hxd.service.userService#queryUserInfoByUserID(int)
	 */
	@Override
	public User queryUserInfoByUserID(int UserId) {
		
		return usermapper.queryUserInfoByUserId(UserId);
	}

	@Override
	public boolean updateUserPassword(User user) {
		int i = usermapper.updateUserPassword(user);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<String> queryAllUserPhone() {
		
		
		List<String> phonelist= usermapper.queryAllPhone();
		 return phonelist;
				 
		
	}

	@Override
	public List<String> queryAllUseremil() {
		return usermapper.queryAllEmil();
	}

	@Override
	public List<String> queryAllUseridcard() {
		return usermapper.queryAllIdcard();
	}
}
