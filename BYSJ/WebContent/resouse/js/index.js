// JavaScript Document

$(document).ready(function(){
	var j=1;
	var MyTime=false;
	var fot=500;
	var fin=400;
	var amt=300;
	var speed=5000;
	var maxpic=$("#guang_ban ul li").length;
	var autostar=true;
	$("#guang_ban").find("li").each(function(i){
		$("#guang_ban").find("li").eq(i).mouseover(function(){											  
			var cur=$("#fcimg").find("div:visible").prevAll().length;
			var m=$("#guang_ban").find("li").eq(i).find("img").attr("src");
			if(i!==cur){
				j=i;					
				$("#fcimg").find("div:visible").fadeOut(fot,function(){
				$("#fcimg").find("div").eq(i).fadeIn(fin);});
				current(this,"li");	
			}
			autostar=false;
		});
		$("#guang_ban").find("li").eq(i).mouseout(function(){autostar=true;});
	});
	function current(ele,tag){
		$(ele).addClass("crn").siblings(tag).removeClass("crn");
	}	
	var MyTime=setInterval(function(){
		if(autostar){
			$("#guang_ban").find("li").eq(j).mouseover();
			autostar=true;
			$("#fcimg div:visible").mouseover(function(){autostar=false;}).mouseout(function(){autostar=true;});
			j++;
		if(j==maxpic){
			j=0;
		}
	}} , speed);
	$(".header_top>ul>li").hover(function(){
		$(this).find(".two_sun").show();
		$(this).find(".two_sun1").show();
	},function(){
		$(this).find(".two_sun").hide();
		$(this).find(".two_sun1	").hide();
	});
	$(".footer_l2>ul>li").hover(function(){
		$(this).find(".two_sun_foot").show();
		$(this).find(".two_sun_foot1").show();
	},function(){
		$(this).find(".two_sun_foot").hide();
		$(this).find(".two_sun_foot1").hide();
	});
	$(".nav>ul>li").hover(function(){
		$(this).find(".two_sun_invest").show();
	},function(){
		$(this).find(".two_sun_invest").hide();
	});
});

//省市联集 借款企业
function changeBProvince(root,pid){
	$.rajax(root+"/changeProvince",{pid:pid},successBProvince);
}
//处理省市联集成功
function successBProvince(data) {
	$("#bankCityId").empty();
	$.each(data, function(i, item) {
		$.each(item, function(k, v) {
			$("#bankCityId").append("<option value='"+k+"'>"+v+"</option>");
		});
	});
}

function checkLogin() {
	//检查登录填写
	
	if(isEmpty($("#j_username").val())) {
		$("#j_username").attr('placeholder','请输入您的用户名或手机号');
		$("#j_username").focus();
		return false;
	}
	if(isEmpty($("#j_password").val())) {
		$("#j_password").attr('placeholder','请输入您的登录密码');
		$("#j_password").focus();
		return false;
	}
	
	return true;
}

//一个月 有效期
function setCookie(name, value) {
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
//当天有效
function setCookieByToday(name, value) {
	var exp = new Date();
	exp.setHours(24, 0, 0, 0);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
//读取cookies
function getCookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if (arr = document.cookie.match(reg))
		return (arr[2]);
	else
		return null;
}