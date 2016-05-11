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
<title>E理财_安全可靠的互联网投资理财平台</title>

  
    
    
    <link href="./resouse/css/screen.css" media="all" rel="stylesheet" type="text/css">
    <link href="./resouse/css/message.css" media="all" rel="stylesheet" type="text/css">
    <link href="./resouse/css/1188.css" media="screen and (min-width:1224px)" rel="stylesheet" type="text/css">
    <link href="./resouse/css/984.css" media="only screen and (max-width:1223px)" rel="stylesheet" type="text/css">
    <link href="./resouse/css/rotate.css" media="all" rel="stylesheet" type="text/css">
    <link href="./resouse/css/global_icons_sprite.css" media="all" rel="stylesheet" type="text/css">
    

    

    
    <style type="text/css">
        a { star:expression(this.onFocus=this.blur()); }
        a:focus { outline:0; }
    </style>
    
    
    
    
<style type="text/css">.fancybox-margin{margin-right:17px;}</style>
</head>
 <body class="pub_bg_white register-page">

    <div class="nav-wrapper">
        <div id="Zr_TopNavbar" class="top-nav-bar top-info top-nav-bar-reset ">
            <div class="topnavbar-content">

                <div class="top-nav-icon-container">
                    <i class="zr-icon-telephone" data-name="telephone"></i>
                    <i class="zr-icon-weixin" data-name="weixin"></i>
                    <i class="zr-icon-weibo" data-name="weibo"></i>
                    <i class="zr-icon-app" data-name="app"></i>
                    <i class="zr-icon-qq" data-name="qq"></i>
                </div>

                
               
                <a href="http://localhost:8080/BYSJ/userlogin.jsp" class="pub-login-bt1n">登录</a>
                <a href="http://localhost:8080/BYSJ/userreg.jsp">注册</a>
                


                <div class="clearfix"></div>
                <div class="pub-dialog telephone-dialog" data-name="telephone">
                    <div class="hover-bar"></div>
                    <div class="arrow-up" style="top: -14px; left: 98px;">
                        <div class="arrow-inner-up"></div>
                    </div>
                    <div>
                        <p class="dialog-title">客服热线</p>
                        <p class="dialog-body">400-069-6600</p>
                        <p class="dialog-content">服务时间：9:00-21:00</p>
                    </div>
                </div>
                <div class="pub-dialog weixin-dialog" data-name="weixin">
                    <div class="hover-bar"></div>
                    <div class="arrow-up" style="top: -14px; left: 98px;">
                        <div class="arrow-inner-up"></div>
                    </div>
                    
                </div>
                <div class="pub-dialog weibo-dialog" data-name="weibo">
                    <div class="hover-bar"></div>
                    <div class="arrow-up" style="top: -14px; left: 98px;">
                        <div class="arrow-inner-up"></div>
                    </div>
                   
                </div>
                <!-- app -->
                <div class="pub-dialog app-dialog" data-name="app">
                    <div class="hover-bar"></div>
                    <div class="arrow-up" style="top: -14px; left: 98px;">
                        <div class="arrow-inner-up"></div>
                    </div>
                   
                </div>
                <div class="pub-dialog qq-dialog" data-name="qq">
                    <div class="hover-bar"></div>
                    <div class="arrow-up" style="top: -14px; left: 108px;">
                        <div class="arrow-inner-up"></div>
                    </div>
                    <div class="dialog-head">
                        <div class="site-logo">
                            <img src="./resouse/image/site-logo-middle.png">
                        </div>
                       
                    </div>
                 
                   

                </div>
            </div>
        </div>
    </div>

 

    


<script type="text/javascript" async="" src="./resouse/js/mv.js"></script>
<script type="text/javascript" async="" src="./resouse/js/mba.js"></script>
<script type="text/javascript" async="" src="./resouse/js/mvl.js"></script>


<div id="body_register">
<style type="text/css">
    .pub-border-radius {display: none;}
    .register-page .nav-wrapper {height: 32px;}
    #register-ul .form-field .status-field {
      padding: 2px 0 0 0px;
    }
    #register-ul .form-field .required-tips {
      margin-left: 14px;
    }
</style>
<div class="register-wrap">
    <div class="container-12">
        <div class="nop-col-10">
            <div class="logo">
                <a  class="left">
                    <img src="./resouse/image/logo.png">
                </a>
                <span class="caption">注册新账户</span>
          
                <div class="clear"></div>
            </div>
        <div class="logo">
              
                <p >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="5px" color="red">${InfoMessage }</font></p>
              
                <div class="clear"></div>
            </div>
               
<form id="reg-form"  action="/BYSJ/user/addUser" method="POST" name="addUser" onsubmit="return expertSent()">
                
                <div class="register-border pub-border-radius"></div>
<div class="register-sec">
    
    
    <ul id="register-ul">
        <li class="form-field">
            <label for="">手机号：</label>
            <input id="userPhone" name="userPhone" tabindex="1" class="accname_input" type="text" value="" placeholder="请输入手机号码" original-title="输入的手机号码将作&lt;br/&gt;为账户名" require="true">
            <div class="status-field"></div>
             <span class="required-tips" style="color: #ff0000;font-size: 14px;" id="message">*</span>
        </li>
        <li class="form-field">
            <label for="" class="">登录密码：</label>
            <input id="userPassword" name="userPassword" tabindex="2" type="password" value="" placeholder="请输入6-16个字符" original-title="•长度为6-16个字符&lt;br/&gt;•支持数字、大小写&lt;br/&gt;字母及特殊字符&lt;br/&gt;•不允许有空格" require="true">

            <div class="status-field"></div>
            <span class="required-tips" style="color: #ff0000;font-size: 14px;" id="message">*</span>
           


        </li>
        <li class="form-field">
            <label for="" class="">确认密码：</label>
            <input id="password1" name="password1" tabindex="3" type="password" value="" placeholder="请再次输入密码" original-title="请再次输入登录密码" require="true">
            <div class="status-field"></div>
            <span class="required-tips" style="color: #ff0000;font-size: 14px;" id="message">*</span>
        </li>
         <li class="form-field">
            <label for="" class="">身份证号：</label>
            <input id="userIdcard" name="userIdcard" tabindex="3" type="text" value="" placeholder="请输入身份证号码" require="true">
            <div class="status-field"></div>
           <span class="required-tips" style="color: #ff0000;font-size: 14px;" id="message">*</span>
        </li>




      
        
            
               
        
    


        

        <li class="form-field">
            <div class="clear"></div>
            <label for=""></label>
            
            <button type="submit" class="submit pub-large-btn-tmp pub_btn huge-more-width4 huge-more-height2 lineheightnormal pub_noborder" tabindex="4">立即注册</button>


            <div class="line-gradient" style="width:513px;">
                <div class="emp20"></div>
                <div class="pub-line-gradient-right left" style="width:50%"></div>
                <div class="pub-line-gradient-left left" style="width:50%"></div>
                <div class="clear"></div>

            </div>

        </li>
        <li class="form-field" style="height: auto;">
            <div class="emp20"></div>
            <div class="emp5"></div>
            <div class="register-bottom" style="width:512px;">
                
                <div class="to-login">已有账号，<a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_blank">直接登录 </a>
                </div>
            </div>
        </li>

        


    </ul>
    
</div>
</form>
                <div class="clear"></div>
            
        </div>
      
		
    </div>

</div>

</div>




    <div class="clearfix"></div>
<div class="home-wrapper footer-wrapper mt20">
    <div class="footer-nav">
        <a href="http://localhost:8080/BYSJ/resouse/guwm.html" target="_blank">关于我们</a>
        <a href="http://localhost:8080/BYSJ/resouse/bqsy.html"target="_blank">版权所有</a>
        <a href="http://localhost:8080/BYSJ/resouse/xtjj.html"target="_blank">系统简介</a>
        <a href="http://localhost:8080/BYSJ/user/addusermessageback.jsp"target="_blank">意见反馈</a>
        <a href="http://localhost:8080/BYSJ/resouse/jrwm.html"target="_blank">加入我们</a>
        <!-- <a href="/financing">我要融资</a> -->
        <a href="http://localhost:8080/BYSJ/resouse/lxwm.html" class="pub-return-cal"target="_blank">联系我们</a>
      
    </div>
    <div id="footer" class="home-width">
        <div class="footer-bottom-info">
            <div class="copy-right">
                <div class="secure-item">
                    <p class="friendly-links">友情链接：
                    <a href="http://www.csdn.com/" target="_blank">csdn</a>

                    <a href="http://www.youku.com/" target="_blank">优酷</a>
                    <a href="http://www.iqiyi.com/" target="_blank">爱奇艺</a>
                    <a href="http://www.tianmao.com/" target="_blank">阿里巴巴</a>
                    <a href="http://www.qq.com.cn/" target="_blank">腾讯</a>
                    <a href="http://www.baidu.com/" target="_blank">百度</a></p>
                    <a  class="secure-a fadeIn-2s" title="可信网站">
                        <img src="./resouse/image/secure_image_01_hover.png" alt="" class="sec_logo">
                    </a>
                    <a class="secure-b fadeIn-2s" title="Verisign SSL加密技术 保护您的隐私">
                        <img src="./resouse/image/secure_image_02_hover.png" alt="" class="sec_logo">
                    </a>
                    <a key="5422316defbfb01f660ec7a0" logo_size="83x30" class="secure-b fadeIn-2s" logo_type="realname">
                        <img src="./resouse/image/secure_image_04_hover.png" alt="" class="sec_logo" title="安全联盟认证">
                    </a>
                    <a id="___szfw_logo___"  class="secure-b fadeIn-2s" >
                        <img src="./resouse/image/secure_image_05_hover.png" alt="" class="sec_logo pub_nomargin" title="诚信网站">
                    </a>
                    <script type="text/javascript">
                        (function(){
                            document.getElementById('___szfw_logo___').oncontextmenu = function(){return false;}
                        })();
                    </script>
                </div>
            </div>
            <div class="service-info">
                <p class="service-title">客服热线</p>
                <p class="service-tel">157-5471-2018</p>
                <p>服务时间：9:00-21:00</p>
            </div>
            <h1>版权所有 haoxudong©2016 内蒙E(-｡-;)理财有限公司  郝ICP备案1116号</h1>
        </div>
    </div>
</div>




<!--年终活动入口-->




<div id="calInvite" class="invite-return-cal right-component icon-invite-cal1" style="right: 24.5px;"></div>

<div id="calReturn" class="pub-return-cal right-component icon-home-return-cal-1" style="display: none; right: 24.5px;"></div>
<a id="qqService" class="right-component pub-qq-service icon-qq-service-1" href="http://t.cn/R7UPlrf" target="_blank" style="display: none; right: 24.5px;"></a>
<div id="gobackTop" class="right-component pub-goback-Top icon-go-back-1" style="display: none; right: 24.5px;"></div>




<!--全局引用的js-->

    <!--<script src="http://www.zrcaifu.dev/bower_components/jquery/jquery.min.js" type="text/javascript"></script>-->
    <script src="./resouse/js/jquery.min.js" type="text/javascript"></script>
    <script src="./resouse/js/pub_common.js" type="text/javascript"></script>
    <script src="./resouse/js/allpage.js" type="text/javascript"></script>


<!--模块/layout引用的js-->


<!--页面引用的js-->


<!-- <script src="./resouse/js/register.js" type="text/javascript"></script> -->


<script type="text/javascript" >
function expertSent() {
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号码正则
	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/; //身份证
    var userPhone = $("#userPhone").val();
    var userPassword = $("#userPassword").val();
    var password1 = $("#password1").val();
    var userIdcard = $("#userIdcard").val();
 
 
    if(! isMobile.test(userPhone)) {
        $("#message").html('请输入正确手机号！');
        $("#userPhone").addClass("yxj_error");
        $("#userPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(userPassword.length<6 ) {
        $("#message").html('请输入您的密码！');
        $("#userPassword").addClass("yxj_error");
        $("#userPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(userPassword.length>16 ) {
        $("#message").html('请输入您的密码！');
        $("#userPassword").addClass("yxj_error");
        $("#userPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!password1) {
        $("#message").html('请输入确认密码');
        $("#password1").addClass("yxj_error");
        $("#password1").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
   
    
   if(userPassword != password1) {
          $("#message").html('密码不一致请检查');
          $("#userPassword").addClass("yxj_error");
          $("#password1").addClass("yxj_error");
          $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
          return false;
      }
   
    
    if(! isIDCard2.test(userIdcard)){
    	$("#message").html('输入您的身份证号码');
        $("#userIdcard").addClass("yxj_error");
        $("#userIdcard").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

  
   
}
</script>
                  




    
        
    
	











<!--统计及追踪代码代码 begin   base, register里单独写的-->



<script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F887c3a2b3c1cbafa8905bdf33f9cbc36' type='text/javascript'%3E%3C/script%3E"));
</script><script src="./resouse/js/h.js" type="text/javascript"></script>


<script type="text/javascript" src="./stats" charset="UTF-8"></script>













<script type="text/javascript">
    var _mvq = _mvq || [];
    _mvq.push(['$setAccount', 'm-80168-0']);

    _mvq.push(['$logConversion']);
    (function() {
    var mvl = document.createElement('script');
    mvl.type = 'text/javascript'; mvl.async = true;
    mvl.src = ('https:' == document.location.protocol ? 'https://static-ssl.mediav.com/mvl.js' : 'http://static.mediav.com/mvl.js');
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(mvl, s);
    })();

</script>

</body>
</html>