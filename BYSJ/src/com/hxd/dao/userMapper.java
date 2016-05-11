package com.hxd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxd.model.User;



public interface userMapper {
	public int addUser(User user);//添加理财用户
	public User queryUserLoginSystem(String userPhone,String userPassword);//登陆系统
	public User queryUserByuserPhone(String userPhone,String userPassword);//通过手机号和密码查询用户
	public int queryUserPasswordByIdcard(@Param("UserIdcard")String UserIdcard,@Param("UserPhone")String UserPhone,@Param("UserEmil")String UserEmil,@Param("UserPassword")String UserPassword);//通过身份证号码找回密码
	public User queryUserPasswordByEmil(String userEmil);//通过邮箱找回密码
	public int  updateUserInfoByUserId(User user);//完善用户信息
	public User queryUserInfoByUserId(int userId);//通过UserId查询学生信息
	public int updateUserPassword(User user);//修改密码
	
	
	public List<String> queryAllPhone();
	public List<String> queryAllEmil();
	public List<String> queryAllIdcard();
}
