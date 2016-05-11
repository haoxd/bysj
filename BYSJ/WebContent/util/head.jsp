<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>head</title>
</head>
<body>
<div class="top-body clearfix">
				<ul class="top-login-status clearfix top-noLog" id="top-noLog">
					<li class="top-noLog">您好：<font color="red">${user.userName }</font>，欢迎进入E理财 家庭理财网
                    
			
			   <span class="seperator">|
			   <a href="http://localhost:8080/BYSJ/user/updatemypassword.jsp" style="color: orange;">修改密码</a>
			   </span>
			  
				</ul>
				<ul class="media-link clearfix">
				<li><a id="header-lumi"
			
						href="http://localhost:8080/BYSJ/user/queryUserInfoByUserId?id=${user.userID }" target="_blank"
						data-sk="头部-会员俱乐部">个人信息</a></li>
					<li><a id="header-lumi"
						href="http://localhost:8080/BYSJ/investment/queryUserInvesmentByUid?uid=${user.userID }" target="_blank"
						data-sk="头部-会员俱乐部">投资信息</a></li>
					<li class="lumi-link"><a id="header-vip"
						href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenueBillsInfos?uid=${user.userID }" target="_blank"
						data-sk="头部-VIP非凡会">我的收入</a></li>
					<li><a id="header-twhkmo"
						href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfos?uid=${user.userID}"
						target="_blank" data-sk="头部-港澳台">我的支出</a></li>
					<li><a id="header-help-center"
						href="http://localhost:8080/BYSJ/mylife/queryUserMylifInfo?uid=${user.userID}" target="_blank"
						data-sk="头部-帮助中心">MyStery信息</a></li>
				 <li id="header-mobile-panel" class="mobile-link"><a
						id="header-mobile"
						href="http://localhost:8080/BYSJ/bankcard/queryUserBankCardInfo?uid=${user.userID}"
						target="_blank" data-sk="头部-手机版"><i class="icon-mobile">
						</i>我的银行卡</a></li> 
						 
					
						
				
				</ul>
			</div>
</body>
</html>