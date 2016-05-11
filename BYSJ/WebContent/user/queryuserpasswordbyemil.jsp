<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <meta name="data-spm" content="a1z5k">
    <title> 账户中心【找回密码】</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="https://h.alipayobjects.com/static/images/uc/favicon.ico?v=0.1.8" type="image/x-icon">
    <link rel="stylesheet" href="../resouse/css/ucenter.css">
    <script async="" src="../resouse/js/cj.js"></script>
    <script type="text/javascript" src="../resouse/js/um.js">
	</script><script type="text/javascript" src="../resouse/js/uab.js"></script>
	<script type="text/javascript" src="../resouse/saved_resource"></script>
    <script>
        (function(){
            seajs.config({
                alias: {
                    '$': 'jquery/jquery/1.9.1/jquery'       
                }
            });
        })();
  	</script>
</head>
<body data-spm="7633538" class="taobao">
<!--头部 start-->
	
<div id="header">
	<div class="header-layout">
	   <style>
			.aliexpress #logo {  background: url("../resouse/image/logo.png") no-repeat;}
			.aliexpress #logo a {  width: 250px;}
	   </style>
       <h1 class="logo" id="logo"><a href="#">家庭理财网</a></h1>
       <h2 class="logo-title">找回密码</h2>
       <ul class="header-nav">
		    											<li class="nav-first"><a href="http://localhost:8080/BYSJ/userreg.jsp" target="_blank">注册</a></li>
					<li><a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_blank">登录</a></li>
				    		    			    								    			<li><a href="#" target="_blank">首页</a></li>
										        		               <li><a href="http://service.taobao.com/support/main/service_center.htm" target="_blank"></a></li>
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
                            请输入你需要找回登录密码的邮箱
                        </p>
                         
                    </div>
                  
     <form class="ui-form"  method="post" action="/BYSJ/user/queryUserPasswordByUserEmil" >
	<div class="ui-form-item  ">
        <label class="ui-label">邮箱:</label>
        <input id="UserEmil" name="UserEmil" class="ui-input" type="text" placeholder="邮箱" value="" data-explain="" data-widget-cid="widget-1">
                       <span class="ui-form-other"><a href="http://localhost:8080/BYSJ/user/queryuserpassword.jsp" target="_blank">也可以通过身份证找回密码</a></span>
         </div>

 
	<div id="_umfp" style="display:inline;width:1px;height:1px;overflow:hidden"><object type="application/x-shockwave-flash" data="https://g.alicdn.com/security/umflash/fp.swf?v1=1&f=umx" width="1" height="1" id="umFlash" class="umidWrapper"><param name="movie" value="https://g.alicdn.com/security/umflash/fp.swf?v1=1&amp;f=umx"><param name="allowScriptAccess" value="always"></object><embed height="1" width="1" id="umDcp" type="application/alidcp" class="umidWrapper">
	<!-- 	<img src="../resouse/image/clear.png">   -->
	<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	&nbsp; &nbsp; <font color="red" size="3">${UserPassword }</font></p>
	
	</div>

	<div class="ui-form-item ui-form-item-last">
    <input type="submit" value="确定" class="ui-button ui-button-lorange" id="submitBtn" >
</div>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	&nbsp; &nbsp;  <span class="required-tips" style="color: #ff0000;font-size: 14px;" id="message">*</span></p>
</form>


                </div>
				            </div>
        </div>
    </div>
    <script type="text/javascript" charset="utf-8" src="../resouse/js/nc.js"></script>

	
    <div id="umid"><object type="application/x-shockwave-flash" data="https://s.tbcdn.cn/g/security/umflash/fp.swf?v1=1" width="1" height="1" id="umFlash" class="umidWrapper"><param name="movie" value="https://s.tbcdn.cn/g/security/umflash/fp.swf?v1=1"><param name="allowScriptAccess" value="always"><param name="flashVars" value="proxyUrl=https://img.alipay.com/common/um/lsa.swf"></object><embed height="1" width="1" id="umDcp" type="application/alidcp" class="umidWrapper"></div>
    <script src="./resouse/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf-8" src="./resouse/js/um(1).js"></script>
     
  
  
    

    

<!--foot start-->
<div id="footer">
	<div class="footer-layout">
	    <div class="copyright">
			E理财版权所有2015-2016	    </div>
  	</div>
</div>
<!-- host: tbmpc010178016118.n.et2  -->

<div style="height: 0px; width: 0px; overflow: hidden;">
<object width="0" height="0" tabindex="-1" style="height:0;width:0;overflow:hidden;" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" id="JSocket"><param name="allowScriptAccess" value="always"><param name="movie" value="https://acjs.aliyun.com/flash/JSocket.swf">
 <embed src="https://acjs.aliyun.com/flash/JSocket.swf" name="JSocket" allowscriptaccess="always" type="application/x-shockwave-flash" pluginspage="https://www.adobe.com/go/getflashplayer_cn" width="0" height="0"></object>
 </div>
 </body>
</html>