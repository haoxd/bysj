package com.hxd.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.dao.investmentMapper;
import com.hxd.model.Investment;
import com.hxd.model.Page;
@Service("investmentservice")
public class investmentServiceImpl implements investmentService{
	@Autowired
	private investmentMapper investmentMapper;

	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	
	/* 查询所有投资信心
	 * @see com.hxd.service.investmentService#queryInvestmentInfos()
	 */
	/* (non-Javadoc)
	 * @see com.hxd.service.investmentService#queryInvestmentInfos()
	 */
	@Override
	public List<Investment> queryInvestmentInfos(Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		
		return investmentMapper.queryInvestmentInfos(fromNo);
	}

	/*判断添加用户投资信息
	 * (non-Javadoc)
	 * 
	 * @see com.hxd.service.investmentService#isAddUserInvestmentInfos(int, int)
	 */
	@Override
	public boolean isAddUserInvestmentInfos(int uid, int iid,String thisTime) {

		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id为i：["+uid+"]对产品id为：["+iid+"]进行了投资";
		log.info(UserLoginlog);
		int result = investmentMapper.addUserInvestmentInfos(uid, iid,thisTime);
		if(result>0){
			return true;
		}else{
			return false;			
		}
	

	}

	/*
	 * 通过investmentId 查询对应的investment对象
	 *  (non-Javadoc)
	 * @see com.hxd.service.investmentService#queryInvestmentInfoByIid(int)
	 */
	@Override
	public Investment queryInvestmentInfoByIid(int investmentId) {
		
		return investmentMapper.queryInvestmentinfoByIId(investmentId);
	}

	/* 在queryUserInvestment_tableByiid表当中能否通过iid查询到uid
	 * @see com.hxd.service.investmentService#queryUserInvestment_tableByiid(int)
	 */
	

	/* (查询投资内容
	 * @see com.hxd.service.investmentService#queryUserInvestmentInfosByUid(int)
	 */
	@Override
	public List<Investment> queryUserInvestmentInfosByUid(int uid) {
		return investmentMapper.queryUserInvestmentInfosByUid(uid);
	}

	/* 通过uid查询iid
	 * @see com.hxd.service.investmentService#queryUserInvestment_tableByuid(int)
	 */
	@Override
	public List<Integer> queryUserInvestment_tableByuid(int uid) {
		
		return investmentMapper.queryUserInvestment_tableByuid(uid);
	}

	/* (查询用户投资时间
	 * @see com.hxd.service.investmentService#queryUserInvestment_tableThisTimeByuid(int)
	 */
	@Override
	public List<String> queryUserInvestment_tableThisTimeByuid(int uid) {
		
		return investmentMapper.queryUserInvestment_tableTimeByuid(uid);
	}

	/* 用户撤销投资是否成功
	 * @see com.hxd.service.investmentService#isDeleateUserInvestmentInfo(int, int)
	 */
	@Override
	public boolean isDeleateUserInvestmentInfo(int uid, int iid) {

		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = "用户id为i：["+uid+"]撤销了对产品id为：["+iid+"]的投资";
		log.info(UserLoginlog);
		int result = investmentMapper.deleateUserInvestmentInfo(uid, iid);
		
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	/* 获取投资总数
	 * @see com.hxd.service.investmentService#getInvestmentsCountNumber()
	 */
	@Override
	public int getInvestmentsCountNumber() {
		return  investmentMapper.getInvestmentInfoConutNumber();
	}

	

}
