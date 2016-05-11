<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>E理财MY【收入信息/工资】</title>



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
					<div class="fund-slogan">E理财家庭理财网 <a href="http://localhost:8080/BYSJ/user/addmyshouru.jsp" target="_blank" title="新增收入账单" style="color: orange;">[我的收入/工资账单]</a></div>
				</div>
				<div class="back-lufax">
					<a href="http://localhost:8080/BYSJ/out.jsp" target="_blank">安全退出</a>
				</div>
			</div>
			
			
	
			
				<c:choose>
<c:when test="${empty userToRevenueBillsGongzhi}">
<p align="center" ><a style="color: orange; " href="http://localhost:8080/BYSJ/user/addmyshouru.jsp" target="_blank"><font size="5px">没有任何关于您的工资账单，请添加</font></a></p>
</c:when>

</c:choose> 
			
		<jsp:include page="/util/hrefshouru.jsp"></jsp:include>
	</div>
	</div>
	
	
	
	<div class="main-wide-wrap" data-sk-area="FundList-ska">

		<div class="productContent">



			<div class="tabContents smartTab">
				<ul class="main-list">

		<li  class="product-list clearfix  " >
		  <dl class="product-info is-2col">
		  	
		<dd>

	 <c:forEach items="${userToRevenueBillsGongzhi}" var="userToRevenueBills" > 
			
				<ul class="clearfix">
					<li class="invest-increase">
					<span class="product-property-name">账单名称</span>
						<p class="">
						<span class="increase-number">
						<a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenusBillsinfo?rid=${userToRevenueBills.revenueBillsID }" title="编辑账单信息" target="_blank">${userToRevenueBills.revenueBillsName }</a>
						</span>
						</p>
					</li>
					
				
				  				
					<li>
					<span class="product-property-name">类型|金额</span>
						<p class="fund-style">${userToRevenueBills.revenueBillsState }|${userToRevenueBills.revenueBillsMoney }RMB</p>
					</li>
				   
				   <li class="invest-increase">
					<span class="product-property-name">账单内容</span>
						<p  class="" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;" title="${userToRevenueBills.revenueBillsBody }">
						<span class="increase-number">${userToRevenueBills.revenueBillsBody }</span>
						</p>
				   </li>
				  
				   <li class="invest-increase">
					<span class="product-property-name">创建时间</span>
						<p class=""  title="${investment.investmentBody }">
						<span class="increase-number">${userToRevenueBills.revenueBillsCreateTime }</span>
						</p>
				   </li>
				   <li class="invest-increase">
					<span class="product-property-name">最后修改时间</span>
						<p class=""  title="${investment.investmentBody }">
						<span class="increase-number">${userToRevenueBills.revenueBillsChangeTime }</span>
						</p>
				   </li>
				   	<li >	
			    	<span >
				<div align="center" style="border-top: 5px">
				<br>
				    <a href="http://localhost:8080/BYSJ/revenuebills/deleateUserRevenuebillsInfo?rid=${userToRevenueBills.revenueBillsID }&&uid=${user.userID } "  style="color: white;"
					class="list-btn"  onclick="return confirmDel('确定要删除${userToRevenueBills.revenueBillsName }账单吗?');">删除账单
					</a>
					  
			    </div>
			
			
			</span>
			
					</li>
					
									
					
			   </ul>
		</c:forEach> 
			</dd>
				</dl>
	
	<!--###############################################  -->	
	
	<!--  ##################################################-->	
	
	<!--###############################################  -->	
	
			
		</li>
			
		
		
		<!--@@@@@@@@@@@@@@@@@@  -->
		
		
		<div class="pagination ui_complex_pagination">
			<div class="pagination-inner">


		<c:choose>
 
      	<c:when test="${pb.pageNo == 1}">
      		首页&nbsp;
    		上一页&nbsp;
      	</c:when>
      	<c:otherwise>
      		<a  style="color: orange;" href="/BYSJ/revenuebills/queryUserRevenuebillsThisGongZhi?pageNo=1&&uid=${user.userID}">首页</a>&nbsp;
      		<a   style="color: orange;"href="/BYSJ/revenuebills/queryUserRevenuebillsThisGongZhi?pageNo=${pb.pageNo-1}&&uid=${user.userID}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a  style="color: orange;" href="/BYSJ/revenuebills/queryUserRevenuebillsThisGongZhi?pageNo=${pb.pageNo+1}&&uid=${user.userID}">下一页</a>&nbsp;
    			<a   style="color: orange;" href="/BYSJ/revenuebills/queryUserRevenuebillsThisGongZhi?pageNo=${pb.totalPage}&&uid=${user.userID}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    	<font color="orange">	第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页</font>
			</div>
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