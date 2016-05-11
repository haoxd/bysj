<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>【家庭会员登录】-家庭理财官网</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="https://www.hurbao.com/favicon.ico" rel="shortcut icon">
<link href="./resouse/css/base.css" rel="stylesheet">
<link href="./resouse/css/member.css" rel="stylesheet">

<link href="./resouse/js/password.css" rel="stylesheet">
<link href="./resouse/css/register.css" rel="stylesheet">
</head>
<body>

<script type="text/javascript">
var rootPath = "";
</script>
<div id="header">
	<div class="header_contain">
        <div class="header_top">
            <ul class="sub_nav fn14">
            	<li><i class="i_licairexian">157-5471-2018</i></li>
                <li class="QQ">
                	<span>QQ</span>
	                
				</li>
                <li class="weixin">
                	<span>微信</span>
                	
                </li>
                <li class="phone">
                	<span>手机客户端</span>
                	
                </li>
            </ul>
           
           <div class="header_t_r">            	
                <div class="hot-line fn14">
                   	<div class="header_t_r_r"><a href="http://localhost:8080/BYSJ/userreg.jsp" target="_blank">注册</a>&nbsp;&nbsp;
                   	<a href="http://localhost:8080/BYSJ/userlogin.jsp">登录</a></div>
                  
                </div>
            </div>
        </div>
	</div>
</div>
<div class="logo_nav_contain">
    <div class="logo_nav">
        <div class="top_logo">
            <div class="fl"><a title="E(-｡-;)理财，家庭理财网"><img src="./resouse/image/logo.png"></a></div>
            <img src="./resouse/image/hlw.png" width="174" height="56" border="0">
        </div>
        <div class="nav fr">
       		<ul class="fn16">
           		<li class="navli"><a class="nava"  >E理财</a></li>
               <li class="navli"><a class="nava" >个人信息</a></li>
                <li class="navli"><a class="nava" >我的收入</a></li>
                <li class="navli"><a class="nava" >我的支出</a></li>
                <li class="navli"><a class="nava" >MY信息</a></li>
                <li class="navli"><a class="nava" style="margin-right: -6px;">银行卡</a></li>
           	</ul>
	    </div>
    </div>         
</div>
<form class="form-signin" action="/BYSJ/user/queryUserLoginSystem" method="post" name="queryUserLoginSystem"   onsubmit="return expertSent()">
		<div class="register-inner">
			<div class="layout">    	
		        <div class="fl">
		            <img src="./resouse/image/login_l.png">
		        </div>
		        <div class="fr login_info">
		        	<div class="login_lt">
		           	   <h2>用户登录</h2>
		           	   <span  style="color: #ff0000;font-size: 14px;" id="message"></span>
		               <input id="UserPhone"  type="text" placeholder="手机号" name="UserPhone" class="user_name" >
		               <input id="UserPassword"  type="password" placeholder="登录密码"  name="UserPassword" class="user_mima"> 
		        	   <div class="select_text">
		                   <div class="fr">
		                  
		                	  <a href="http://localhost:8080/BYSJ/user/queryuserpassword.jsp" target="_blank"><span class="yellow">忘记密码？</span></a>&nbsp;&nbsp;<a href="http://localhost:8080/BYSJ/userreg.jsp" target="_blank"><span class="red">免费注册</span></a>
		                   </div>
		               </div>
		               <div class="info_submit">
		                <p style="color: red;">${InfoMessage}</p>
		                   <input type="submit" value="立即登录"><br>
		                   <p style="color: red;">${loginFailInfoMessage }</p>
		               </div>
		             
		               <p>E(-｡-;)理财QQ交流群②：<a href="#" target="_blank">786436534</a></p>
		            </div>            
		         </div>
			 </div>
		 </div>
	 </form>

<%--  <% 
int userID= null;
 userID= (int)request.getSession().getAttribute("userID");
if(userID!=null){
	response.sendRedirect("http://localhost:8080/BYSJ/investment/queryInvestmentInfos");	
}

%>  --%>
	<div class="footer">
	<div class="content">
    	<ul class="footer_l1">
            <li><a href="http://localhost:8080/BYSJ/resouse/guwm.html" title="关于我们"target="_blank">关于我们</a></li>
		    <li><a href="http://localhost:8080/BYSJ/resouse/bqsy.html" title="版权所有"target="_blank">版权所有</a></li>
		    <li><a href="http://localhost:8080/BYSJ/resouse/xtjj.html" title="系统简介" target="_blank">系统简介</a></li>
		    <li><a href="http://localhost:8080/BYSJ/user/addusermessageback.jsp" title="意见反馈">意见反馈</a></li>

		   
        </ul>
        <div class="footer_l2">
            <ul class="fl footer_lef">
                <li class="xinlang_weibo"><a href="http://localhost:8080/BYSJ/resouse/jrwm.html" target="_blank"><i></i>加入我们</a></li>
                
                <li class="xinlang_weibo"><a href="http://localhost:8080/BYSJ/resouse/lxwm.html" target="_blank"><i></i>联系我们</a></li>
              
               
            </ul>
            <ul class="fr footer_r">
            	<li>理财热线</li>
                <li class="lcrx">157-5471-2018</li>
                <li>工作日:9:00-19:00</li>
            </ul>
        </div>  
        <script>
			var _hmt = _hmt || [];
			(function() {
			  var hm = document.createElement("script");
			  hm.src = "//hm.baidu.com/hm.js?882c6030c593d55041ed09f68cf0e01b";
			  var s = document.getElementsByTagName("script")[0]; 
			  s.parentNode.insertBefore(hm, s);
			})();
		</script>
        <p>E(-｡-;)；理财  版权所有  &nbsp;&nbsp;&nbsp;ICP证号：<a>蒙B-20160000</a> &nbsp;&nbsp;&nbsp;网站备案号：<a >内蒙ICP备15754712018号</a> </p>
        <p>Copyright 2015 - 2016  E(-｡-;)理财</p>
        <div class="foot-pic">
            <a class="img_01" href="https://sealinfo.verisign.com/splash?form_file=fdf/splash.fdf&dn=www.hurbao.com&lang=zh_cn" target="_blank"></a>
            <a class="img_02" href="https://www.hurbao.com/ym/iso" target="_blank"></a>
            <a class="img_03" href="http://www.anquan.org/authenticate/cert/?site=www.hurbao.com&at=business" target="_blank"></a>	
            <a class="img_09" href="http://webscan.360.cn/index/checkwebsite/url/www.hurbao.com" target="_blank"></a>       
            <a class="img_04" href="https://ss.knet.cn/verifyseal.dll?sn=e14041632010048097xdyy000000&ct=df&a=1&pa=0.7695766348662965" target="_blank"></a>
            <!-- <a class="img_041" href="http://webscan.360.cn/index/checkwebsite/url/www.hurbao.com" target="_blank"></a> -->
            <a class="img_05" href="https://www.hurbao.com/ym/ym" target="_blank"></a>
            <a class="img_06" href="https://www.hurbao.com/ym/zz" target="_blank"></a>
            <a class="img_07" href="https://www.hurbao.com/ym/zzq" target="_blank"></a>
            <a class="img_08" href="https://www.hurbao.com/ym/ICP" target="_blank"></a>
            <a class="img_10" href="http://www.itrust.org.cn/Home/Index/itrust_certifi?wm=1686727676" target="_blank"></a>
        </div>
    </div>
</div>

<script src="./resouse/js/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript" >
function expertSent() {
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号码正则
    var UserPhone = $("#UserPhone").val();
    var UserPassword = $("#UserPassword").val();
   
 
    if(! isMobile.test(UserPhone)) {
        $("#message").html('请输入正确手机号！');
        $("#UserPhone").addClass("yxj_error");
        $("#UserPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!UserPassword) {
        $("#message").html('请输入您的密码！');
        $("#UserPassword").addClass("yxj_error");
        $("#UserPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
 
}
</script>


</body>
</html>