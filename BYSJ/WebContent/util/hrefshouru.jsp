<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shouru的href</title>
</head>
<body>
<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按类型:</font>	&nbsp;&nbsp;&nbsp;&nbsp;
			
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisGongZhi?uid=${user.userID}">工资</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisWaiKuai?uid=${user.userID}">外快</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisLiCai?uid=${user.userID}">理财</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisHeli?uid=${user.userID}">贺礼</a></font>				
			</p>
			<br>
			<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按金额:</font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisYiWShang?uid=${user.userID}">1万以上</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisWuQian_YiW?uid=${user.userID}">5000千-1万</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisWuQian?uid=${user.userID}">5000以下</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;				
			</p>
				<br>
			<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按时间:</font>	
			<font color="#fd8238" size="2px"></font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisDay?uid=${user.userID}">近一天</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisWeek?uid=${user.userID}">一周之内</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenuebillsThisMonth?uid=${user.userID}">近30天</a></font>				
			</p>
</body>
</html>