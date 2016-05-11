<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
               <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<base href="<%= basePath%>"></base>
    <meta charset="UTF-8">
    <title>E(-｡-;)理财，我的银行卡</title>
    
   
    <link rel="stylesheet" href="./resouse/css/reset.css"/>
    <link rel="stylesheet" href="./resouse/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./resouse/css/header.css"/>
    <link rel="stylesheet" href="./resouse/css/lieBiao.css"/>
    <link rel="stylesheet" href="./resouse/css/footer.css"/>
    
 
</head>
<body>

<!-- -------------------头部开始-------------------- -->
<div id="header">
    <!-- 顶部导航（固定） -->
    <div class="top-nav navbar-fixed-top">
        <ul class="tn-ul">
            <li class="tn-li"><a href="http://localhost:8080/BYSJ/investment/queryInvestmentInfos" target="_blank">E理财</a></li>
            <li class="tn-li"><a href="http://localhost:8080/BYSJ/investment/queryUserInvesmentByUid?uid=${user.userID}" target="_blank">投资信息</a></li>
            <li class="tn-li"><a href="http://localhost:8080/BYSJ/revenuebills/queryUserRevenueBillsInfos?uid=${user.userID}"target="_blank">我的收入</a></li>
      
            <li>|</li>
            <li class="tn-li"><a href="http://localhost:8080/BYSJ/spendingbills/queryUserSpendingBillsInfos?uid=${user.userID}"target="_blank">我的支出</a></li>
            <li class="tn-li"><a href="http://localhost:8080/BYSJ/mylife/queryUserMylifInfo?uid=${user.userID}"target="_blank">MYStyle信息</a></li>

            <li>|</li>
      
            <li class="tn-li pitch-on"><a href="http://localhost:8080/BYSJ/bankcard/queryUserBankCardInfo?uid=${user.userID}">我的银行卡</a></li>
              </ul>
    
        <div class="tn-login">
            <p><font color="red">您好：${user.userName }</font></p>
            
        </div>
    </div>



   
  
</div>
				<c:choose>
<c:when test="${empty bankCardList}">
<p align="center" >
<a style="color: orange; " href="http://localhost:8080/BYSJ/user/addmybankcard.jsp" target="_blank"><font size="5px">您还没有添加银行卡，请添加</font></a></p>
</c:when>

</c:choose> 
<div id="section">
    <div class="content">
     <p align="center"><a title="添加银行卡信息" href="http://localhost:8080/BYSJ/user/addmybankcard.jsp" target="_blank">我的银行卡信息</a></p>
        <div class="quanBuShangPing">
            <div class="biaoTi">
                <div class="biaoTi_left">
                   
                    我的银行卡信息
                        
                </div>
           
            </div>
      <p align="center"><font size="5px" color="red"> ${ delsuccess}</font></p>

            <!-- ------------------------列表------------------------------ -->
            <div class="books lieBiao_books" style="display: block">
             <c:forEach items="${bankCardList}" var="bankcard" > 
                <div class="book">
               
                        <div class="book_left">
                       
                            <img  height="270px" width="500px" src="./upload/${bankcard.bankCardName } " class="yuLanTu"/>
                    
                        </div>
                 
                    <div class="book_right">
                        <p class="shuMing"><a >${bankcard.backCardState }</a></p>
                         <p class="shuMing"><a >卡号：${bankcard.backCardNumber }</a></p>
                          <p class="shuMing"><a >添加时间：${bankcard.bankCardCreateTime }</a></p>
                        <div class="book_right_bottom">
                            <div class="price_2">
                                
                              
                                <div class="gongNeng">
                                    
                                    <a href="http://localhost:8080/BYSJ/bankcard/deleateUserBankCard?bid=${bankcard.backCardId }&&uid=${user.userID}">
                                    <img src=".\resouse\image\add_cart_r.png"/>
                                    	删除${bankcard.backCardState }银行卡
                                    </a>
                                </div>
                            </div>
                        </div>
                       
                       
                    </div>
                </div>
              </c:forEach>  
              
               
          
        
            <!-- --------------------页数---------------------------- -->
            <div class="page">
                <div class="yeShu">
                   
		<c:choose>
 
      	<c:when test="${pb.pageNo == 1}">
      		首页&nbsp;
    		上一页&nbsp;
      	</c:when>
      	<c:otherwise>
      		<a  style="color: orange;" href="/BYSJ/bankcard/queryUserBankCardInfo?pageNo=1&&uid=${user.userID}">首页</a>&nbsp;
      		<a   style="color: orange;"href="/BYSJ/bankcard/queryUserBankCardInfo?pageNo=${pb.pageNo-1}&&uid=${user.userID}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a  style="color: orange;" href="/BYSJ/bankcard/queryUserBankCardInfo?pageNo=${pb.pageNo+1}&&uid=${user.userID}">下一页</a>&nbsp;
    			<a   style="color: orange;" href="/BYSJ/bankcard/queryUserBankCardInfo?pageNo=${pb.totalPage}&&uid=${user.userID}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    	<font color="orange">	第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页</font></div>
               
            </div>
        </div>

      
        <div class="caiNi">
       
        </div>
    </div>
</div>

<div id="footer">
   
   
    <!-- === [ 超链接菜单 ] ==== -->
    <div class="footer-menu">
        <div>
           
            <ul class="fm-list fm-3">
                <li><a href="http://localhost:8080/BYSJ/resouse/guwm.html" target="_blank">关于我们</a></li>
                
            </ul>
            <ul class="fm-list fm-4">
                <li><a href="http://localhost:8080/BYSJ/resouse/bqsy.html" target="_blank">版权所有</a></li>
               
            </ul>
            <ul class="fm-list fm-5">
                <li><a href="http://localhost:8080/BYSJ/resouse/xtjj.html" target="_blank">系统简介</a></li>
               
            </ul>
            <ul class="fm-list fm-5">
                <li><a href="http://localhost:8080/BYSJ/user/addusermessageback.jsp" target="_blank">意见反馈</a></li>
                
            </ul>
             <ul class="fm-list fm-5">
                <li><a href="http://localhost:8080/BYSJ/resouse/jrwm.html" target="_blank">加入我们</a></li>
                
            </ul>
             <ul class="fm-list fm-5">
                <li><a href="http://localhost:8080/BYSJ/resouse/lxwm.html" target="_blank">联系我们</a></li>
                
            </ul>
        </div>
    </div>
    <!-- === [ 版权与地址 ] ==== -->
    <div class="footer-content">
        <div>
            <p class="fp footer-copyright">E(-｡-;)理财家庭理财网， 2015-2016 </p>
            <p class="fp footer-address">地址：呼和浩特新城区&nbsp;&nbsp;&nbsp;&nbsp;157-5471-2018</p>
        </div>
    </div>
</div>



</body>
</html>