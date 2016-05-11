package com.hxd.service;

import java.util.List;

import com.hxd.model.User;



public interface userService {
	public boolean isAddUser(User user);//添加用户是否成功
	public boolean queryUserLoginSystem(String UserPhone,String UserPassword );
	public User queryUserByUserPhoneAndUserPassword(String userPhone,String userPassword );
	public boolean queryUserPasswordByUserIdcard(String UserIdcard,String UserPhone,String UserEmil,String UserPassword);//找回密码通过身份证号码
	public User queryUserPasswordByUserEmil(String UserEmil);//找回密码通过身份证号码
	public boolean isUpdateUserInfoByUserId(User user);//完善用户信息
	public User queryUserInfoByUserID(int UserId);//通过用户id查询用户信息
	public boolean updateUserPassword(User user);
	
	
	public List<String> queryAllUserPhone();
	public List<String> queryAllUseremil();
	public List<String> queryAllUseridcard();
	
}
