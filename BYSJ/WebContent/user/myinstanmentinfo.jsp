<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>E理财MY【投资信息】</title>



<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo.css">
<link rel="stylesheet" href="../resouse/css/touzhiinfo02.css">
<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo03.css">
<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo04.css">
<link rel="stylesheet" type="text/css" href="../resouse/css/touzhiinfo05.css">
<link rel="stylesheet" type="text/css" href="../resouse/css/touzhiinfo06.css">

<script>

function confirmDel(str){ 
	return confirm(str);
}
</script>
</head>
<body>


	<div class="lufax-header" id="lufax-header">
		<div class="top-wrap">
			<!--引头部jsp  -->
<jsp:include page="/util/head.jsp"></jsp:include>
		</div>
		<div class="head-body-wrap">
			<div class="head-body clearfix">
				<div class="fund-logo-wrap">
					<div class="fund-logo"></div>
					<div class="fund-slogan">E理财家庭理财网 [我的投资]</div>
				</div>
				<div class="back-lufax">
					<a href="http://localhost:8080/BYSJ/out.jsp" target="_blank">安全退出</a>
				</div>
			</div>
			
			
	
				
				<c:choose>
<c:when test="${empty userInvestmentsList}">
<p align="center" ><a style="color: orange; " href="http://localhost:8080/BYSJ/investment/queryInvestmentInfos" target="_blank"><font size="5px">您还没有进行任何投资请前往首页进行理财投资</font></a></p>
</c:when>

</c:choose>
			<p align="center"><font color="#fd8238" size="4px">${deleateinvInvestment }</font>	</p>
		</div>
	</div>
	
	
	
	<div class="main-wide-wrap" data-sk-area="FundList-ska">

		<div class="productContent">



			<div class="tabContents smartTab">
				<ul class="main-list">

		<li  class="product-list clearfix  " >
		  <dl class="product-info is-2col">
		  	
		<dd>

		<c:forEach items="${userInvestmentsList}" var="investment" >
			
				<ul class="clearfix">
					<li class="invest-increase">
					<span class="product-property-name">投资名称</span>
						<p class="">
						<span class="increase-number">${investment.investmentName }</span>
						</p>
					</li>
					
					<li class="invest-increase">
					<span class="product-property-name">周收益/月收益/年收益</span>
						<p class="">
						<span class="increase-number">${investment.weekEarnings }/${investment.monthEarnings }/${investment.yearEarnings }</span>
						</p>
					</li>
					
					<li class="invest-increase">
					<span class="product-property-name">投资内容</span>
						<p class="" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;" title="${investment.investmentBody }">
						<span class="increase-number">${investment.investmentBody }</span>
						</p>
				   </li>
									
					<li>
					<span class="product-property-name">类型</span>
						<p class="fund-style">${investment.investmentState }</p>
					</li>
			   </ul>
			
			   	</c:forEach>
			</dd>
				</dl>
	<!--  ##################################################-->	
		<dl  class="product-info is-2col">
		<dd>
		<c:forEach items="${userInvestmentsTimeList}" var="thisTime" >
		<ul>
		
			    	<li >
					<span class="product-property-name" style="padding-top: 3px">投资时间</span>
				
				
						<p >
						<span >${thisTime }</span>
					
						</p>
					</li>
		
			   	</ul>
			   	<hr width="5" />
			   	  	</c:forEach>
			</dd>
			</dl>
	<!--###############################################  -->	
	
	<!--  ##################################################-->	
		<dl  class="product-info is-2col">
		<dd>
	<c:forEach items="${userInvestmentsIdList}" var="ints" >
		<ul>
		
			    	<li >	
			    	<span >
				<div align="center" style="border-top: 5px">
				<br>
				    <a href="http://localhost:8080/BYSJ/investment/deleateUserInvestmentInfo?uid=${user.userID }&&iid=${ints}"  style="color: white;"
					class="list-btn"  onclick="return confirmDel('确定要撤销投资吗?');">撤销投资
					</a>
					  
			</div></span>
					
					</li>
		
			   	</ul>
			   		<hr width="5" />
			   	  	</c:forEach>
			</dd>
			</dl>
	<!--###############################################  -->	
	
			
		</li>
			
		
		
		<!--@@@@@@@@@@@@@@@@@@  -->
		
		
		<div class="pagination ui_complex_pagination">
			<!-- <div class="pagination-inner">


				<span class="btns disabled btn_page btn_small first">首页</span> <span
					class="btns disabled btn_page btn_small prev"><span
					class="caret">&lt;</span> 上一页</span>

				<p class="pageNum">第1页/共33页</p>

				<a class="btns btn_page btn_small next" href="javascript:void(0)"
					data-identity="pages" data-val="2">下一页<span class="caret">&gt;</span></a>
				<a class="btns btn_page btn_small last" href="javascript:void(0)"
					data-identity="pages" data-val="33">尾页</a>
			</div> -->
		</div>
	</div>
	</div>
	</div>
	



<!--引入底部jsp  -->
<jsp:include page="/util/load.jsp"></jsp:include>

	<script type="text/javascript" async="" src="../resouse/js/touzhiinfojs01.js"></script>
	<script type="text/javascript">
		var Global = {};
		Global.basePath = "/list/";
		Global.rarvAppPath = "http://rsrv.lufax.app/rsrv-app/";
	</script>

	
	<div style="display: none">
		<script type="text/javascript">
			/*           */
			var google_conversion_id = 1005340584;
			var google_custom_params = window.google_tag_params;
			var google_remarketing_only = true;
			/*     */
		</script>
		<script type="text/javascript" src="../resouse/js/touzhiinfojs09.js">
			
		</script>
		
		
	</div>
	<script type="text/javascript" src="../resouse/js/touzhiinfojs10.js"></script>


	
</body>

</body>
</html>