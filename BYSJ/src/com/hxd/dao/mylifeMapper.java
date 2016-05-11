package com.hxd.dao;

import java.util.List;

import com.hxd.model.MyLife;

public interface mylifeMapper {
	public int addMylifeInfo(MyLife mylife);//添加日记
	public List<MyLife> queryUserMylifeInfos(int uid,int fromNo);//用户查询全部日记
	public int getUserMyLifeNumber(int uid);//获取用户的日记总数
	
	
	public int deleateUserMylifeInfo(int mid,int uid);//删除用户的惹急
	public int updateUserMylifeInfo(MyLife mylife);//编辑某一条日记
	public MyLife queryUserMylifeByid(int mid);//查询某一条用户对于的信息

}
