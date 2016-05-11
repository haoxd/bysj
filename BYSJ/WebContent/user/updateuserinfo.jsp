<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>完善－个人信息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="../resouse/css/usermymessage.css">
    <script type="text/javascript" src="../resouse/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="../resouse/js/jquery.ui.select.js"></script>
    <script language="javascript">
        $(document).ready(function(){
            $("#zhuanye").sSelect();
            $("#lingyu").sSelect();
            $(".dropselectbox h4").css("width","340px");
            $(".dropselectbox ul").css("width","338px");
        });
        //选择select的值
        function selectMe(_select){
            //选中的值为
            //alert("选中的值为::" + _select[_select.selectedIndex].value);
        }
    </script>
    <style type="text/css">
        /* 大屏幕 */
        @media (min-width: 1500px) {
            .boxcenter{width:1460px; margin:22px auto;}
            .yxj_con1,.yxj_con2,.yxj_con3{width:400px;}
            .yxj_ul2 li{width:60px; height:128px;float:left; text-align:center; margin-left:4%; margin-right:4%;}
            .yxj_cen{max-width: 1460px;min-width: 1280px;}
        }
        @media (min-width: 1280px) and (max-width:1499px) {
            .boxcenter{width:97%;max-width:1460px; min-width:960px;}
            .yxj_con1,.yxj_con2,.yxj_con3{width:27%; max-width:410px; min-width:310px;}
            .yxj_cen{max-width: 1460px;min-width: 1250px;}
        }
        @media (max-width: 1280px) {
            .yxj_nav2{display:block;}
            .yxj_cd{display:none;}
        }
        @media (min-width: 1000px) and (max-width:1279px) {
            .boxcenter{max-width:1080px; margin:22px auto;}
            .yxj_word{margin-right:2%}
            .yxj_cen{max-width:1280px;}
            .yxj_list22{border-bottom: 1px solid #f2f2f2;padding-bottom: 10px;}
            .yxj_ul2 li{width:60px; height:128px;float:left; text-align:center; margin-left:3.6%; margin-right:3.6%;}
        }
        /* 横向放置的手机和竖向放置的平板之间的分辨率 */
        @media (max-width: 999px) {
            .boxcenter{width:960px; margin:20px auto;}
            .yxj_word{margin-right:14px}
            .yxj_line33{display:block;}
            .yxj_cen{width:960px;}
        }
/*李冬新加样式开始20160119开始*/
.yxj_zx01{}
.yxj_zx01 a.bklj_a{float:right;font-size:18px;color:#FFC107;}
/*李冬新加样式开始20160119结束*/
    </style>
<script type="text/javascript">
    $(document).ready(function(e) {
        $(".yxj_nav2").hover(function(){
            $(".yxj_nav2 dd").toggle();
        })

        $(".yxj_box01 ul,.yxj_box01 li").css("width","100%");

    });
</script><style>
    body{font-family: "PingFangSC-Medium", "STHeitiSC-Light","微软雅黑", SimHei, sans-serif; -webkit-font-smoothing:antialiased;}
    .dropdown,.dropselectbox,.dropdown ul li{width:340px;}
    .dropdown h4{background-position:320px center; text-align:left; text-indent:10px; font-size:14px; color:#c4c4c4;}
    .dropdown ul li{text-align:left; text-indent:10px;font-size:14px; color:#c4c4c4;}
    .dropdown ul li:first-child{background-position:320px center;}
</style>
</head>
<body onload="register.init()">
<!--导航开始-->


<script type="text/javascript">
    
	var path = "";
	var userName = "";
    $(".yxj_nav2").hover(function(){
        $(".yxj_nav2 dd").toggle();
    })
</script>
<style>
    .yxj_admin h1 {
        font-size: 13px;
        cursor: pointer;
        font-weight: bold;
    }
    .yxj_admin h1:hover {
        color: #FFC107;
    }
</style>
<!--导航开始--><jsp:include page="/util/headtoap.jsp"></jsp:include>

<!--导航结束-->

<!--导航结束-->

<!--内容开始-->
<div class="yxj_main2">
 <div class="boxcenter" style="overflow:visible;">
    <div class="yxj_zhuce" style="overflow:visible;">
       <img src="../resouse/image/logo.png">
       <div class="yxj_zc_con" style="overflow:visible;height: 500px;">
          <div class="yxj_line3" style="background: rgb(250, 197, 59);"></div>
          <div class="yxj_zx01">
             <h1>个人信息：</h1>

             <h2><font color="yellow" size="5px">${updateuserinfo }</font></h2>
             <span style="color: #ff0000;font-size: 14px;" id="message"></span>
          </div>
        <form  action="/BYSJ/user/updateUserInfoByUserId" method="post" class="yxj_zx02" style="overflow:visible; height:400px;" onsubmit="return expertSent()">
           
             <div class="yxj_zx02L" style="overflow:visible;">
               <input type="hidden" name="userID" value="${queryUser.userID}">
                 <h1><p>姓名</p><span>请输入自己的姓名</span></h1>
                  <input type="text" id="UserName" name="userName" placeholder="${queryUser.userName }">
                  <h1><p>昵称</p><span>请输入自己认为最帅的网民</span></h1>
                  <input type="text" id="UserNickName" name="userNickName" placeholder="${queryUser.userNickName }">
                  <h1><p>年龄</p><span>请输入自己的年龄</span></h1>
                  <input type="text" id="UserAge" name="userAge" placeholder="${queryUser.userAge }">
                  <h1><p>邮箱地址</p><span>用于找回密码</span></h1>
					<input type="text" id="UserEmil" name="userEmil" placeholder="${queryUser.userEmil }">
                
             </div>
             <div class="yxj_zx02R" style="overflow:visible;">
                <h1><p>性别</p><span>男/女</span></h1>
				<input type="text" id="UserSex" name="userSex" placeholder="${queryUser.userSex }">
				<h1><p>自我介绍</p><span>个人简介</span></h1>
				<textarea rows="5" cols="19" id="UserText" name="userText"  style="resize: none; height:200px; width:320px; font-family:'黑体'; " placeholder="${queryUser.userText }" ></textarea>		
                <div class="yxj_ty" style="margin-top:20px;">
                    <input id="expertRegisterBtn" type="submit" value="保存信息" class="yxj_yhzc" style="width: 340px; cursor: pointer; background: #fd8238;">
                </div>
             </div>
          </form>
       </div>   
    </div>
  </div>
</div>
<!--内容结束-->


<!-- 底部信息 -->
<jsp:include page="/util/loadtoap.jsp"></jsp:include>
<script type="text/javascript" >
function expertSent() {
    var UserName = $("#UserName").val();
    var UserNickName = $("#UserNickName").val();
    var UserAge = $("#UserAge").val();
    var UserEmil = $("#UserEmil").val();
    var UserText = $("#UserText").val();
    var UserSex = $("#UserSex").val();
 
    if(!UserName) {
        $("#message").html('请输入用户名！');
        $("#UserName").addClass("yxj_error");
        $("#UserName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    
  /*  if(!password1 || !password2) {
        $("#message").html('请输入密码！');
        $("#password1").addClass("yxj_error");
        $("#password2").addClass("yxj_error");
        password1 == '' ? $("#password1").focus() : $("#password2").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return;
    }*/
    
    if(!UserNickName){
    	$("#message").html('请输入昵称');
        $("#UserNickName").addClass("yxj_error");
        $("#UserNickName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

    if(!UserAge) {
        $("#message").html('请输入您的年龄');
        $("#UserAge").addClass("yxj_error");
        $("#UserAge").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!UserEmil) {
        $("#message").html('请输入您的邮箱');
        $("#UserEmil").addClass("yxj_error");
        $("#UserEmil").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

    if("男"!=UserSex && "女"!=UserSex)
    	{
    	 $("#message").html('性别只能输入男/女');
         $("#UserSex").addClass("yxj_error");
         $("#UserSex").addClass("yxj_error");
         $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
         return false;
    	}
  /*  if(password1 != password2) {
        $("#message").html('两次密码输入不一致，请检查');
        $("#password1").addClass("yxj_error");
        $("#password2").addClass("yxj_error");
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return;
    }*/
 
    if(!UserText){
    	$("#message").html('请输个人简介');
        $("#UserText").addClass("yxj_error");
        $("#UserText").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
}
</script>



</body>
</html>