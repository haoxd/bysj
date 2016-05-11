package com.hxd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.dao.revenuebillsMapper;
import com.hxd.model.Page;
import com.hxd.model.RevenueBills;
@Service("revenuebillsservice")
public class revenueBillsServiceImpl implements revenueBillsService {
	
	@Autowired
	private  revenuebillsMapper revenuebillsmapper;

	/* 判断用户添加账单是否成功
	 * @see com.hxd.service.revenueBillsService#isAddUserRevenueBillsInfo(com.hxd.model.RevenueBills)
	 */
	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	@Override
	public boolean isAddUserRevenueBillsInfo(RevenueBills revenueBills) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+revenueBills.getRevenueBills_UserID()+"】添加了："+revenueBills.getRevenueBillsName()+"收入账单";
		log.info(UserLoginlog);
	int result = revenuebillsmapper.addUserRevenueBills(revenueBills);
		if(result>0){
			return true;
		}else{
		return false;
		}
	}

	/* 用户查询自己的账单信息
	 * @see com.hxd.service.revenueBillsService#queryUserRevenueBillsInfo(int, com.hxd.model.Page)
	 */
	@Override
	public List<RevenueBills> queryUserRevenueBillsInfo(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenueBillsInfo(uid, fromNo);
	}

	/* (用户获取账单总数
	 * @see com.hxd.service.revenueBillsService#getUserRevenueBillsInfoCountNumber(int)
	 */
	@Override
	public int getUserRevenueBillsInfoCountNumber(int uid) {
	
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumber(uid);
	}

	/* 判断用户删除自己的账单信息是否成功
	 * @see com.hxd.service.revenueBillsService#deleateUserRevenueBillsInfoByid(int, int)
	 */
	@Override
	public boolean deleateUserRevenueBillsInfoByid(int rid, int uid) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+uid+"】删除了："+revenuebillsmapper.queryUserRevenueBillsInfoBuid(rid).getRevenueBillsName()+"收入账单";
		log.info(UserLoginlog);
		int  result = revenuebillsmapper.deleateUserRevenueBillsInfoByid(rid, uid);
		if(result>0){
			return  true;
			
		}else{
		return false;
	}
		}

	/* (查询某一条账单信息
	 * @see com.hxd.service.revenueBillsService#queryUserRevenueBills(int)
	 */
	@Override
	public RevenueBills queryUserRevenueBills(int rid) {
		
		return revenuebillsmapper.queryUserRevenueBillsInfoBuid(rid);
	}

	/* 用户编辑收入账单信息
	 * @see com.hxd.service.revenueBillsService#isUpdateUserRevenuebillsInfo(com.hxd.model.RevenueBills)
	 */
	@Override
	public boolean isUpdateUserRevenuebillsInfo(RevenueBills revenueBills) {
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id：【"+revenueBills.getRevenueBills_UserID()+"】:进行了更新收入操作";
		log.info(UserLoginlog);
		int i = revenuebillsmapper.updateUserRevenueBillsInfo(revenueBills);
		if(i>0){
			return true;
		}else{
		return false;
	}
		}

	/* (当天账单
	 * @see com.hxd.service.revenueBillsService#queryUserRevenuebillsThisDay(int, com.hxd.model.Page)
	 */
	@Override
	public List<RevenueBills> queryUserRevenuebillsThisDay(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisDay(uid, fromNo);
	}

	/* (一周以内的账单
	 * @see com.hxd.service.revenueBillsService#queryUserRevenuebillsThisWeek(int, com.hxd.model.Page)
	 */
	@Override
	public List<RevenueBills> queryUserRevenuebillsThisWeek(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisWeek(uid, fromNo);
	}

	/* (近30天的账单
	 * @see com.hxd.service.revenueBillsService#queryUserRevenuebillsThisMonth(int, com.hxd.model.Page)
	 */
	@Override
	public List<RevenueBills> queryUserRevenuebillsThisMonth(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		
		return revenuebillsmapper.queryUserRevenuebillsThisMonth(uid, fromNo);
	}

	
	
	@Override
	public int getUserRevenueBillsInfoCountNumberDay(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberDay(uid);
	}

	@Override
	public int getUserRevenueBillsInfoCountNumberWeek(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberWeek(uid);
	}

	@Override
	public int getUserRevenueBillsInfoCountNumberMonth(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberMonth(uid);
	}

	@Override
	public int getUserRevenueBillsInfoCountNumberWuQian(int uid) {
		
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberWuQian(uid);
	}

	@Override
	public int getUserRevenueBillsInfoCountNumberWuqian_YiW(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberWuQianYiW(uid);
	}

	@Override
	public int getUserRevenueBillsInfoCountNumberYiWShang(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberYiWShang(uid);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisWuQian(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisWuQian(uid, fromNo);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisWuQian_YiW(int uid,Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisWuQianYiW(uid, fromNo);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisYiWShang(int uid,Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisYiWShang(uid, fromNo);
	}

	@Override
	public int getUserRevenusBillsInfoCountNumberGongZ(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberGongZ(uid);
	}

	@Override
	public int getUserRevenusBillsInfoCountNumberWaiK(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberWaiK(uid);
	}

	@Override
	public int getUserRevenusBillsInfoCountNumberLiCai(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberLiCai(uid);
	}

	@Override
	public int getUserRevenusBillsInfoCountNumberHeL(int uid) {
		return revenuebillsmapper.getUserRevenusBillsInfoCountNumberHeL(uid);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisGongZ(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisGongZ(uid, fromNo);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisWaiK(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisWaiK(uid, fromNo);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisLiCai(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisLiCai(uid, fromNo);
	}

	@Override
	public List<RevenueBills> queryUserRevenuebillsThisHeLi(int uid, Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return revenuebillsmapper.queryUserRevenuebillsThisHeLi(uid, fromNo);
	}

}
