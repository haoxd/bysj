<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <meta name="data-spm" content="a1z5k">
    <title> 账户中心【重设密码】</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="https://h.alipayobjects.com/static/images/uc/favicon.ico?v=0.1.8" type="image/x-icon">
    <link rel="stylesheet" href="../resouse/css/ucenter.css">
  
	
   
</head>
<body data-spm="7633538" class="taobao">
<!--头部 start-->
	
<div id="header">
	<div class="header-layout">
	   
       <h1 class="logo" id="logo"><a href="#">家庭理财网</a></h1>
       <h2 class="logo-title">重设密码</h2>
       <ul class="header-nav">
		    		<li class="nav-first"><a href="http://localhost:8080/BYSJ/userreg.jsp" target="_blank">注册</a></li>
					<li><a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_blank">登录</a></li>
				    		    			    								    		
	        		        		    			       </ul>
   </div>
</div>



<!--CBU-->
<link type="text/css" href="../resouse/css/nc.css" rel="stylesheet">
    <div id="content">
        <div class="content-layout">
            <div class="maincenter">
                <div class="maincenter-box">
                    <div class="maincenter-box-tip">
                        <p class="ui-tiptext ui-tiptext-message ft-14">
                            <i class="ui-tiptext-icon iconfont" title="找回密码"></i>
                            请输入正确合法的信息：
                        </p>
                        
                    </div>
          <p align="center">  <span  style="color: #ff0000;font-size: 14px;" id="message"></span></p>         
     <form class="ui-form" id="J_Form" method="post" action="/BYSJ/user/queryUserPassword"  onsubmit="return expertSent()" >
	<div class="ui-form-item     ">
         <label class="ui-label">身份证号码:</label>
        <input id="UserIdcard" name="UserIdcard" class="ui-input" type="text" placeholder="身份证号码" value="" data-explain="" data-widget-cid="widget-1">
         </div>
         <div class="ui-form-item     ">
        <label class="ui-label">手机号码:</label>
        <input id="UserPhone" name="UserPhone" class="ui-input" type="text" placeholder="手机号码" value="" data-explain="" data-widget-cid="widget-1">
         </div>
         <div class="ui-form-item     ">
        <label class="ui-label">电子邮箱:</label>
        <input id="UserEmil" name="UserEmil" class="ui-input" type="text" placeholder="电子邮箱" value="" data-explain="" data-widget-cid="widget-1">
         </div>
         
           <div class="ui-form-item     ">
        <label class="ui-label">新密码:</label>
        <input id="UserPassword" name="UserPassword" class="ui-input" type="text" placeholder="新密码" value="" data-explain="" data-widget-cid="widget-1">
         </div>
         
           <div class="ui-form-item     ">
        <label class="ui-label">确认密码:</label>
        <input id="quePassword" name="quePassword" class="ui-input" type="text" placeholder="确认密码" value="" data-explain="" data-widget-cid="widget-1">
                
         </div>
         

 
	<div id="_umfp" style="display:inline;width:1px;height:1px;overflow:hidden"><object type="application/x-shockwave-flash" data="https://g.alicdn.com/security/umflash/fp.swf?v1=1&f=umx" width="1" height="1" id="umFlash" class="umidWrapper"><param name="movie" value="https://g.alicdn.com/security/umflash/fp.swf?v1=1&amp;f=umx"><param name="allowScriptAccess" value="always"></object><embed height="1" width="1" id="umDcp" type="application/alidcp" class="umidWrapper">
	<!-- 	<img src="../resouse/image/clear.png">   -->
	<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	&nbsp; &nbsp; <font color="red" size="3">${UserPassword }</font></p>
	</div>

<div class="ui-form-item ui-form-item-last">
    <input type="submit" value="确定" class="ui-button ui-button-lorange" id="submitBtn" >
</div>
</form>


                </div>
			</div>
        </div>
    </div>


	
    

    

<!--foot start-->
<div id="footer">
	<div class="footer-layout">
	    <div class="copyright">
			E理财版权所有2015-2016	    </div>
  	</div>
</div>



 
 <script type="text/javascript" src="../resouse/js/jquery1.42.min.js"></script>

<script type="text/javascript" >
 function expertSent() {
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号码正则
	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/; //身份证
	   
    var UserIdcard = $("#UserIdcard").val();//身份证号码
    var UserPhone = $("#UserPhone").val();//手机号码
    var UserEmil = $("#UserEmil").val();//电子邮箱
    var UserPassword = $("#UserPassword").val();//新密码
    var quePassword = $("#quePassword").val();//确认密码
   
    if(!UserIdcard) {
        $("#message").html('请输入您的身份证号码！');
        $("#UserIdcard").addClass("yxj_error");
        $("#UserIdcard").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

    if(!isIDCard2.test(UserIdcard)) {
        $("#message").html('请输入合法身份证号码！');
        $("#UserIdcard").addClass("yxj_error");
        $("#UserIdcard").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!UserPhone) {
        $("#message").html('请输入您的手机号码！');
        $("#UserPhone").addClass("yxj_error");
        $("#UserPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!isMobile.test(UserPhone)) {
        $("#message").html('请输入合法的手机号码！');
        $("#UserPhone").addClass("yxj_error");
        $("#UserPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!UserEmil) {
        $("#message").html('请输入您的电子邮箱！');
        $("#UserEmil").addClass("yxj_error");
        $("#UserEmil").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!UserPassword) {
        $("#message").html('请输入您的新密码！');
        $("#UserPassword").addClass("yxj_error");
        $("#UserPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    
    if(UserPassword.length<6 ) {
        $("#message").html('密码长度不得小于6位！');
        $("#UserPassword").addClass("yxj_error");
        $("#UserPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(UserPassword.length>16 ) {
        $("#message").html('密码长度不得大于16位！');
        $("#UserPassword").addClass("yxj_error");
        $("#UserPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    
    if(!quePassword) {
        $("#message").html('请输入您的确认密码！');
        $("#quePassword").addClass("yxj_error");
        $("#quePassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    
    if(UserPassword != quePassword) {
           $("#message").html('密码不一致请检查');
           $("#UserPassword").addClass("yxj_error");
           $("#UserPassword").addClass("yxj_error");
           $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
           return false;
       }
    

} 

</script>
 </body>
</html>