package com.hxd.service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.dao.usermessagebackMapper;
import com.hxd.model.UserMessageBack;
@Service("usermessagebackservice")
public class userMessageBackServiceImpl implements userMessageBackService{
	@Autowired
	private usermessagebackMapper usermessagebackmapper;
	/* 添加意见反馈功能
	 * @see com.hxd.service.userMessageBackService#isAddUserMessageBackInfo(com.hxd.model.UserMessageBack)
	 */
	Logger log = Logger.getLogger(userMessageBackServiceImpl.class);//创建log4j实例在这个类当中
	@Override
	public boolean isAddUserMessageBackInfo(UserMessageBack message) {
		
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String UserLoginlog = message.getUserMessageBackName()+"新增了意见反馈内容";
		log.info(UserLoginlog);
		int result = usermessagebackmapper.addUserMessageBack(message);
		if(result>0){
			return true;
			
		}else{
		return false;
	}
		}

}
