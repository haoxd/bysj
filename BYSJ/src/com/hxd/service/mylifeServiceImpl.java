package com.hxd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hxd.dao.mylifeMapper;
import com.hxd.model.MyLife;
import com.hxd.model.Page;
@Service("mylifeservice")
public class mylifeServiceImpl implements mylifeService {

	@Autowired
	private mylifeMapper mylifemapper;
	/* 用户添加日记
	 * @see com.hxd.dao.mylifeMapper#addMylifeInfo(com.hxd.model.MyLife)
	 */
	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	
	@Override
	public boolean isAddUserMyLifeInfo(MyLife mylife) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog ="用户id为:【"+mylife.getMylife_User()+"】添加了主题为："+mylife.getMylifeTitle()+"的生活信息";
		log.info(UserLoginlog);
		int result = mylifemapper.addMylifeInfo(mylife);
		if(result>0){
			return true;
		}else{
		return false;
	}
		}

	/* 分页查询获取用户日记数
	 * @see com.hxd.service.mylifeService#queryUserMylifeInfos(int, com.hxd.model.Page)
	 */
	@Override
	public List<MyLife> queryUserMylifeInfos(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return mylifemapper.queryUserMylifeInfos(uid, fromNo);
	}

	/* 查询用户日记总数
	 * @see com.hxd.service.mylifeService#getUserMylifeNumber(int)
	 */
	@Override
	public int getUserMylifeNumber(int uid) {
		
		return mylifemapper.getUserMyLifeNumber(uid);
	}

	/* update
	 * @see com.hxd.service.mylifeService#isUpdateuserMylife(com.hxd.model.MyLife)
	 */
	@Override
	public boolean isUpdateuserMylife(MyLife mylife) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog ="用户id为:【"+mylife.getMylife_User()+"】进行了对生活信息的编辑";
		log.info(UserLoginlog);
		int result = mylifemapper.updateUserMylifeInfo(mylife);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean idDeleateuserMylife(int mid, int uid) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog ="用户id为:【"+uid+"】删除了主题为："+mylifemapper.queryUserMylifeByid(mid).getMylifeTitle()+"的生活信息";
		log.info(UserLoginlog);
		int result = mylifemapper.deleateUserMylifeInfo(mid, uid);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public MyLife queryUserMylifeinfo(int mid) {
		return mylifemapper.queryUserMylifeByid(mid);
	}
	

}
