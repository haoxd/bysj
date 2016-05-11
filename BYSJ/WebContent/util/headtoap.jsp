<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>headtoap</title>
</head>
<body>
<div class="yxj_nav">
    <div class="boxcenter" style="margin:0 auto;overflow:visible;">
        <ul>
            <li><a href="http://localhost:8080/BYSJ/investment/queryInvestmentInfos" target="_blank">E理财</a></li>
            <li><a href="http://localhost:8080/BYSJ/investment/queryUserInvesmentByUid?uid=${user.userID}" target="_blank">投资信息</a></li>
			<li><span>|</span></li>
            <li><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenueBillsInfos?uid=${user.userID}" target="_blank">我的收入</a></li>
			<li><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfos?uid=${user.userID}">我的支出</a></li>
            <li><a href="http://localhost:8080/BYSJ/mylife/queryUserMylifInfo?uid=${user.userID}" target="_blank">MyStyle信息</a></li>
			<li><a href="http://localhost:8080/BYSJ/bankcard/queryUserBankCardInfo?uid=${user.userID}" target="_blank">我的银行卡</a></li>
            <li><span>|</span></li>    
        </ul>
       
     

        <div class="yxj_admin">
            
                
                
                    <h1>
                        <span >您好:${user.userName  }</span>
                    </h1>
                    <h1>
                     <span><a href="http://localhost:8080/BYSJ/out.jsp" target="_blank">退出</a></span>
                    </h1>
                
            
            <a href="#"><img src="../resouse/image/yxj_admin.png"></a>
        </div>
    </div>
</div>
</body>
</html>