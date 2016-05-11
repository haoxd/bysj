<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>您访问的页面不存在...500</title>
<link type="text/css" href="http://js.3conline.com/ue/404.css" rel="stylesheet"  />
</head>
<body class="pcol">



<div class="tt">

	<div class="ttin">

		<div><span class="hotSites">
		<i class="t">E(-｡-;)理财家庭理财网：</i>
		<a >E理财</a> 
		<a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenueBillsInfos?uid=${user.userID }" target="_blank">我的收入</a> 
		<a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfos?uid=${user.userID}">我的支出</a> 
		<a href="http://localhost:8080/BYSJ/mylife/queryUserMylifInfo?uid=${user.userID}">MYStyle信息</a> 
		<a href="http://localhost:8080/BYSJ/bankcard/queryUserBankCardInfo?uid=${user.userID}">我的银行卡</a>
		 <a href="http://localhost:8080/BYSJ/user/queryUserInfoByUserId?id=${user.userID }">个人信息</a>
		 </span></div>

		<div class="ttext">

			<h1><font  style="color: orange;">抱歉，您浏览的页面暂时不能访问哦！</font></h1>

			<p><strong id="time" class="time">10</strong><i>秒后将自动跳转到</i>
			<a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_self" id="newUrl" class="newUrl">E(-｡-;)理财登录页</a></p>

			<div class="dother">

				<p>您也可以：</p>

				<p>1、直接访问<a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_blank">E理财登录页</a></p>

				<p>2、直接访问<a href="http://localhost:8080/BYSJ/userreg.jsp" target="_blank">E理财注册页面</a>
				</div>

			<div style="display: none;"></div>

		</div>

	</div>

</div>

<div class="footer">



</div>

<script>

(function(){

	var time = document.getElementById("time");

	var i = parseInt(time.innerHTML);

	var newUrl = document.getElementById("newUrl");

	(function(i){    

		var fn = arguments.callee;

		if ( i>=0 ){

			setTimeout(function(){

				time.innerHTML = i;

				fn(--i);

			},1000);   

		}

		else {

			window.location.href = newUrl.href;

		}

	})(i);

})();

</script>

</html>
