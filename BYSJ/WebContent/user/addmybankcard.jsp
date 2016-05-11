<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E(-｡-;)理财【MY收入】</title>
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

.yxj_zx01{}
.yxj_zx01 a.bklj_a{float:right;font-size:18px;color:#FFC107;}

    </style>
<script type="text/javascript">
    $(document).ready(function(e) {
        $(".yxj_nav2").hover(function(){
            $(".yxj_nav2 dd").toggle();
        })

        $(".yxj_box01 ul,.yxj_box01 li").css("width","100%");

    });
</script>
<style>
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
       <div class="yxj_zc_con" style="overflow:visible;height: 450px;">
          <div class="yxj_line3" style="background: rgb(250, 197, 59);"></div>
          <div class="yxj_zx01">
             <h1>添加我的银行：</h1>
 			<h2><font color="red">${backfailinfo }</font></h2>
 			
        
             <span style="color: #ff0000;font-size: 14px;" id="message"></span>
          </div>
        <form  action="/BYSJ/bankcard/addUserBankCard" method="post" class="yxj_zx02" style="overflow:visible; height:400px;"enctype="multipart/form-data" onsubmit="return expertSent()">
           
             <div class="yxj_zx02L" style="overflow:visible;">
              <input type="hidden" name="bankCard_User" value="${user.userID}">
                 <h1><p>银行卡号</p><span> </span></h1>
                  <input type="text" id="backCardNumber" name="backCardNumber" placeholder=" 请输入银行卡号">
                  <h1><p>银行卡类型</p><span>请输入您的银行卡类型</span></h1>
                 <select id="lingyu" name="backCardState">
                      <option value="0" id="pleaseselect">请选择</option>
                      
                          <option value="中国银行">中国银行</option>
                      
                          <option value="中国农业银行">中国农业银行</option>
                      
                          <option value="中国建设银行">中国建设银行</option>
                      
                          <option value="中国工商银行">中国工商银行</option>
                      
                          <option value="中国光大银行">中国光大银行</option>
                      
                          <option value="中国民生银行">中国民生银行</option>
                      
                          <option value="中国交通银行">中国交通银行</option>
                      
                          <option value="中国招商银行">中国招商银行</option>
                      
                          
                      
                  </select>
                 
                  <h1><p>银行卡照片</p><span>gif|jpg|jpeg|png|gif|jpg|png</span></h1>
               
           <input style="display: none" type="file" name="bankcardfile" id="bankcardfile" onchange="javascript:setImagePreview();" >
      <div class="input-append">
  
   <a class="btn" onclick="$('input[id=bankcardfile]').click();">选择银行卡照片</a>
</div>

             </div>
             <div class="yxj_zx02R" style="overflow:visible;">
                	
				<h1><p>照片预览</p><span></span></h1>
			 <table width="100%" border="1"  height="190px">
			  <tr>
			  <td>
			    <img id="preview" width=-1 height=-1 style="diplay:none" />
			  </td>
			  </tr>
		 </table>
                <div class="yxj_ty" style="margin-top:20px;">
                    <input  id="expertRegisterBtn" type="submit" value="保存银行卡信息" class="yxj_yhzc" style="width: 340px; cursor: pointer; background: #fd8238;">
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
<script>
function setImagePreview() {
        var docObj=document.getElementById("bankcardfile");
 
        var imgObjPreview=document.getElementById("preview");
                if(docObj.files &&    docObj.files[0]){
                        //火狐下，直接设img属性
                        imgObjPreview.style.display = 'block';
                        imgObjPreview.style.width = '330px';
                        imgObjPreview.style.height = '220px';                    
                        //imgObjPreview.src = docObj.files[0].getAsDataURL();

      //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式  
      imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);

                }else{
                        //IE下，使用滤镜
                        docObj.select();
                        var imgSrc = document.selection.createRange().text;
                        var localImagId = document.getElementById("localImag");
                        //必须设置初始大小
                        localImagId.style.width = "500px";
                        localImagId.style.height = "320px";
                        //图片异常的捕捉，防止用户修改后缀来伪造图片
try{
                                localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                        }catch(e){
                                alert("您上传的图片格式不正确，请重新选择!");
                                return false;
                        }
                        imgObjPreview.style.display = 'none';
                        document.selection.empty();
                }
                return true;
        }
</script>
<script type="text/javascript" >
function expertSent() {
    var backCardNumber = $("#backCardNumber").val();
    var  bankcardfile = $("#bankcardfile").val();
 	var cardInfo= /.(gif|jpg|jpeg|png|gif|jpg|png)$/;
    var card = /^(\d{16}|\d{19})$/;
	
   
    if(!card.test(backCardNumber)) {
        $("#message").html('请输入正确的银行卡号');
        $("#backCardNumber").addClass("yxj_error");
        $("#backCardNumber").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!bankcardfile) {
        $("#message").html('请选择银行卡图片');
        $("#bankcardfile").addClass("yxj_error");
        $("#bankcardfile").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
 
    if(!cardInfo.test(bankcardfile)) {
        $("#message").html('请上传正确格式的照片');
        $("#bankcardfile").addClass("yxj_error");
        $("#bankcardfile").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
   
 
}
</script>




</body>
</html>