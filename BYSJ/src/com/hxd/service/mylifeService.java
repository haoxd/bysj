package com.hxd.service;

import java.util.List;

import com.hxd.model.MyLife;
import com.hxd.model.Page;

public interface mylifeService {
	
	public boolean isAddUserMyLifeInfo(MyLife mylife);//添加信息是否成功
	public List<MyLife> queryUserMylifeInfos(int uid,Page page);//分页查询获取用户日记
	public int getUserMylifeNumber(int uid);
	
	public  boolean isUpdateuserMylife(MyLife mylife);
	public boolean idDeleateuserMylife(int mid,int uid);
	public MyLife queryUserMylifeinfo(int mid);

}
