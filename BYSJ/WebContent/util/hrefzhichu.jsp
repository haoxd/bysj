<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支出账单的头</title>
</head>
<body>
<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按类型:</font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosChifan?uid=${user.userID}">吃饭</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosLvYou?uid=${user.userID}">旅游</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosGuangjie?uid=${user.userID}">逛街</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosQiTa?uid=${user.userID}">其他</a></font>				
			</p>
			<br>
			<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按金额:</font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosWuQian?uid=${user.userID}">5000以上</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosWuQiandaoyiqian?uid=${user.userID}">5000千-1千</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosyiqianxia?uid=${user.userID}">1000以下</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;				
			</p>
				<br>
			<p style="text-align:left; width:1130px; margin:0 auto;">
			<font size="2px">按时间:</font>	
			<font color="#fd8238" size="2px"></font>	&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosDay?uid=${user.userID}">近一天</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosWeek?uid=${user.userID}">一周之内</a></font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#fd8238" size="2px"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfosMonth?uid=${user.userID}">近30天</a></font>				
			</p> 
</body>
</html>