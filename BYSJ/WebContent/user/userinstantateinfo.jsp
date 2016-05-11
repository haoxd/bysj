<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>E理财【投资信息】</title>



<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo.css">
<link rel="stylesheet" href="../resouse/css/touzhiinfo02.css">
<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo03.css">
<link type="text/css" rel="stylesheet" href="../resouse/css/touzhiinfo04.css">
<link rel="stylesheet" type="text/css" href="../resouse/css/touzhiinfo05.css">
<link rel="stylesheet" type="text/css" href="../resouse/css/touzhiinfo06.css">

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
					<div class="fund-logo">  </div>
					<div class="fund-slogan">E理财家庭理财网<a  style="color: orange;" href="http://localhost:8080/BYSJ/investment/queryInvestmentInfos">【最新投资信息】</a></div>
				</div>
				
				<div class="back-lufax">
					<a href="http://localhost:8080/BYSJ/out.jsp" target="_blank">安全退出</a>
				</div>
			</div>
			
			
	
				
				<p align="center"><font color="#fd8238" size="5px">${addUserInvestmentsInfo }</font>	</p>
			
				<p align="center"><font color="#fd8238" size="3px"> <a href="http://localhost:8080/BYSJ/user/queryUserInfoByUserId?id=${user.userID}" target="_blank"><font color="#fd8238" size="3px"> 如果您还没有完善个人信息请先去完善后在进行投资</font></a>	</p>
		</div>
	</div>
	<c:forEach items="${investmentList}" var="investment" begin="0" end="5">
	<div class="main-wide-wrap" data-sk-area="FundList-ska">

		<div class="productContent">



			<div class="tabContents smartTab">
				<ul class="main-list">

		<li data-sk="SmartFundList-2" class="product-list clearfix  ">
		  <dl class="product-info is-2col">
			<dt class="product-name">
			   <a
				title="${investment.investmentName }" target="_blank">${investment.investmentName }
			   </a>
			</dt>
			<dd>
				<ul class="clearfix">
					<li class="invest-increase">
					<span class="product-property-name">周收益</span>
						<p class="">
						<span class="increase-number">${investment.weekEarnings }</span>
						</p>
					</li>
					
					<li class="invest-increase">
					<span class="product-property-name">月收益</span>
						<p class="">
						<span class="increase-number">${investment.monthEarnings }</span>
						</p>
					</li>
					
					<li class="invest-increase">
					<span class="product-property-name">年收益</span>
						<p class="">
						<span class="increase-number">${investment.yearEarnings }</span>
						</p>
				   </li>
									
					<li>
					<span class="product-property-name">类型</span>
						<p class="fund-style">${investment.investmentState }</p>
					</li>
			   </ul>
			</dd>
		</dl>
	
				<div class="invest-fee">
					<span class="product-property-name" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:10em;" title="${investment.investmentBody }">${investment.investmentBody }</span>							
						</div>
			<div class="product-status is-padding-top">
				<a href="http://localhost:8080/BYSJ/investment/addUserInvestmentsInfo?uid=${user.userID }&&iid=${investment.investmentId}"
					class="list-btn" >立即投资
					</a>
			</div>
		</li>
			</c:forEach>
		
		<!--@@@@@@@@@@@@@@@@@@  -->
		
		
		<div class="pagination ui_complex_pagination">
			<div class="pagination-inner">
				
<!-- 
				<span class="btns disabled btn_page btn_small first">首页</span> <span
					class="btns disabled btn_page btn_small prev"><span
					class="caret">&lt;</span> 上一页</span>

				<p class="pageNum">第1页/共33页</p>

				<a class="btns btn_page btn_small next" href="javascript:void(0)"
					data-identity="pages" data-val="2">下一页<span class="caret">&gt;</span></a>
				<a class="btns btn_page btn_small last" href="javascript:void(0)"
					data-identity="pages" data-val="33">尾页</a> -->
					<c:choose>
 
      	<c:when test="${pb.pageNo == 1}">
      		首页&nbsp;
    		上一页&nbsp;
      	</c:when>
      	<c:otherwise>
      		<a  style="color: orange;" href="/BYSJ/investment/queryInvestmentInfos?pageNo=1">首页</a>&nbsp;
      		<a   style="color: orange;"href="/BYSJ/investment/queryInvestmentInfos?pageNo=${pb.pageNo-1}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a  style="color: orange;" href="/BYSJ/investment/queryInvestmentInfos?pageNo=${pb.pageNo+1}">下一页</a>&nbsp;
    			<a   style="color: orange;" href="/BYSJ/investment/queryInvestmentInfos?pageNo=${pb.totalPage}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    	<font color="orange">	第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页</font>
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
		
			
	
		
		
	</div>
	


	
</body>

</body>
</html>