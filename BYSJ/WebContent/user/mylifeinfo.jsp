<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>E理财MY【MyLifeStyle】</title>



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
					<div class="fund-slogan">E理财家庭理财网 <a href="http://localhost:8080/BYSJ/user/addmylife.jsp" target="_blank" title="新增我的个人生活信息" style="color: orange;">[我的个人生活信息]</a></div>
				</div>
				<div class="back-lufax">
				<a href="http://localhost:8080/BYSJ/out.jsp" target="_blank">安全退出</a>
				</div>
			</div>
			
			
	
			
				<c:choose>
<c:when test="${empty lifeList}">
<p align="center" >
<a style="color: orange; " href="http://localhost:8080/BYSJ/user/addmylife.jsp" target="_blank"><font size="5px">没有您任何生活信息记录，请添加</font></a></p>
</c:when>

</c:choose> 
		<p align="center"><font color="#fd8238" size="4px">${delsuccessinfo }</font>	</p>		
		
	</div>
	</div>
	
	
	
	<div class="main-wide-wrap" data-sk-area="FundList-ska">

		<div class="productContent">



			<div class="tabContents smartTab">
				<ul class="main-list">

		<li  class="product-list clearfix  " >
		  <dl class="product-info is-2col">
		  	
		<dd>

	 <c:forEach items="${lifeList}" var="lifeList" > 
			
				<ul class="clearfix">
				<li class="invest-increase">
					<span class="product-property-name">日记标题</span>
						<p class="">
						<span class="increase-number">
						<a href=" http://localhost:8080/BYSJ/mylife/queryUserMylifeinfobymid?mid=${lifeList.mylifeID }" title="编辑该篇日记" target="_blank">
						${lifeList.mylifeTitle}
						</a>
						</span>
						</p>
					</li>
					<li class="invest-increase">
					<span class="product-property-name">日记心情</span>
						<p class="">
						<span class="increase-number">
						${lifeList.mylifeState}
						</span>
						</p>
					</li>
					
				
				  				
					<li>
					<span class="product-property-name">日记地点</span>
						<p class="fund-style">${lifeList.mylifeCreateCity}</p>
					</li>
				   
				   <li class="invest-increase">
					<span class="product-property-name">日记时间</span>
						<p  class="" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;" title="${userToRevenueBills.revenueBillsBody }">
						<span class="increase-number">${lifeList.mylifeCreateTime}</span>
						</p>
				   </li>
				  
				   
				   <li class="invest-increase">
					<span class="product-property-name">日记内容</span>
						<p class="" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;"  title="${lifeList.mylifeLog}">
						<span class="increase-number">${lifeList.mylifeLog}</span>
						</p>
				   </li>
				   	<li >	
			    	<span >
				<div align="center" style="border-top: 5px">
				<br>
				    <a href=" http://localhost:8080/BYSJ/mylife/deleateUserMylifeInfo?mid=${lifeList.mylifeID }&&uid=${user.userID } "  style="color: white;"
					class="list-btn"  onclick="return confirmDel('确定要删除吗?');">删除日记
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
      		<a  style="color: orange;" href="/BYSJ/mylife/queryUserMylifInfo?pageNo=1&&uid=${user.userID}">首页</a>&nbsp;
      		<a   style="color: orange;"href="/BYSJ/mylife/queryUserMylifInfo?pageNo=${pb.pageNo-1}&&uid=${user.userID}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a  style="color: orange;" href="/BYSJ/mylife/queryUserMylifInfo?pageNo=${pb.pageNo+1}&&uid=${user.userID}">下一页</a>&nbsp;
    			<a   style="color: orange;" href="/BYSJ/mylife/queryUserMylifInfo?pageNo=${pb.totalPage}&&uid=${user.userID}">尾页</a>&nbsp;
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