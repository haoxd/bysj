/**
 * Created on 15/12/22.
 */
var register = (function() {
    var usernameFlag = false;
    var usernameTemp = "";

    function init() {
        $("#username").bind("blur", function () {
            $("#username").removeClass("onfour");
        });
        $("#username").bind("focus", function () {
            $("#username").addClass("onfour");
            $("#username").removeClass("yxj_success");
            $("#username").removeClass("yxj_error");
        });
        $("#password1").bind("blur", function () {
            $("#password1").removeClass("onfour");
        });
        $("#password1").bind("focus", function () {
            $("#password1").addClass("onfour");
            $("#password1").removeClass("yxj_success");
            $("#password1").removeClass("yxj_error");
        });
        $("#password2").bind("blur", function () {
            $("#password2").removeClass("onfour");
        });
        $("#password2").bind("focus", function () {
            $("#password2").addClass("onfour");
            $("#password2").removeClass("yxj_success");
            $("#password2").removeClass("yxj_error");
        });
        $("#checkcode").bind("blur", function () {
            $("#checkcode").removeClass("onfour");
        });
        $("#checkcode").bind("focus", function () {
            $("#checkcode").addClass("onfour");
            $("#checkcode").removeClass("yxj_success");
            $("#checkcode").removeClass("yxj_error");
        });
        $("#registerBtn").bind("click", send);
        $("#userProtocol").bind("click", function() {
            var checked = $("#userProtocol")[0].checked;
            if(checked) {
                $("#registerBtn").css("background", "#FFC107");
                $("#registerBtn").removeAttr("disabled");

            }else {
                $("#registerBtn").css("background", "#f4f4f4");
                $("#registerBtn").attr("disabled","disabled");

            }
        });
        
        $("#expertRegisterBtn").bind("click", expertSent);
        $("#expertProtocol").bind("click", function() {
            var checked = $("#expertProtocol")[0].checked;
            if(checked) {
                $("#expertRegisterBtn").css("background", "#FFC107");
                $("#expertRegisterBtn").removeAttr("disabled");

            }else {
                $("#expertRegisterBtn").css("background", "#f4f4f4");
                $("#expertRegisterBtn").attr("disabled","disabled");

            }
        });

    }


    function send() {
        var username = $("#username").val();
        var password1 = $("#password1").val();
        var password2 = $("#password2").val();
        var email = $("#email").val();
        var categoryId = $("#lingyu").val();
        var checkcode = $("#checkcode").val();
        

        //清空提示
        $("#message").html('');
        $("#username").removeClass("yxj_error");
        $("#password1").removeClass("yxj_error");
        $("#password2").removeClass("yxj_error");
        $("#checkcode").removeClass("yxj_error");
        $("#email").removeClass("yxj_error");
        $("#username").removeClass("yxj_success");
        $("#password1").removeClass("yxj_success");
        $("#password2").removeClass("yxj_success");
        $("#checkcode").removeClass("yxj_success");
        $("#email").removeClass("yxj_success");

        if(!username) {
            $("#message").html('请输入用户名！');
            $("#username").addClass("yxj_error");
            $("#username").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        
        if(!password1 || !password2) {
            $("#message").html('请输入密码！');
            $("#password1").addClass("yxj_error");
            $("#password2").addClass("yxj_error");
            password1 == '' ? $("#password1").focus() : $("#password2").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        
        if(password1.length < 6){
        	$("#message").html('密码长度不正确！');
            $("#password1").addClass("yxj_error");
            $("#password1").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }

        if(password1 != password2) {
            $("#message").html('两次密码输入不一致，请检查');
            $("#password1").addClass("yxj_error");
            $("#password2").addClass("yxj_error");
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        
        if(!email) {
            $("#message").html('请输入邮箱地址！');
            $("#email").addClass("yxj_error");
            $("#email").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }


        if(categoryId == 0) {
            $("#message").html('请选择擅长领域');
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }


        if(!checkcode) {
            $("#message").html('请输入验证码！');
            $("#checkcode").addClass("onfour");
            $("#checkcode").focus();
            return;
        }

        if(checkcode.toLowerCase() != "27ey") {
            $("#message").html('验证码输入错误，请检查！');
            $("#checkcode").addClass("onfour");
            $("#checkcode").focus();
            return;
        }
        
        $.ajax({
            type: "POST",
            url: path + "/user!register.action",
            data: {"username": username, "password": password1, "categoryId": categoryId,"email" : email, "checkcode": checkcode},
            success: function (result) {
                if (result.status < 0) {
                    $("#message").html(result.msg);
                    return;
                }
                alert(result.msg);
                location.href = path + "/frontLogin";
            }
        });
    }
    
    function expertSent() {
        var UserName = $("#UserName").val();
        var UserNickName = $("#UserNickName").val();
        var UserAge = $("#UserAge").val();
        var UserEmil = $("#UserEmil").val();
        var UserText = $("#UserText").val();
        var UserSex = $("#UserSex").val();
       /* var checkcode = $("#checkcode").val();
        
        //---专家注册---
        var realName = $("#realName").val();
        var company = $("#company").val();
        var phone = $("#phone").val();
        var workon = $("#workon").val();*/

      
        if(!UserName) {
            $("#message").html('请输入用户名！');
            $("#UserName").addClass("yxj_error");
            $("#UserName").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
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
            return;
        }

        if(!UserAge) {
            $("#message").html('请输入您的年龄');
            $("#UserAge").addClass("yxj_error");
            $("#UserAge").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        if(!UserEmil) {
            $("#message").html('请输入您的邮箱');
            $("#UserEmil").addClass("yxj_error");
            $("#UserEmil").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
    
        if("男"!=UserSex && "女"!=UserSex)
        	{
        	 $("#message").html('性别只能输入男/女');
             $("#UserSex").addClass("yxj_error");
             $("#UserSex").addClass("yxj_error");
             $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
             return;
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
            return;
        }

    /*    if(categoryId == 0) {
            $("#message").html('请选择擅长领域');
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }*/

        /*if(!realName) {
            $("#message").html('请输入真实姓名！');
            $("#realName").addClass("yxj_error");
            $("#realName").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        if(!company) {
            $("#message").html('请输入公司名称！');
            $("#company").addClass("yxj_error");
            $("#company").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }
        if(!phone) {
            $("#message").html('请输入联系电话！');
            $("#phone").addClass("yxj_error");
            $("#phone").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }*/
       /* if(!workon) {
            $("#message").html('请输入从事专业！');
            $("#workon").addClass("yxj_error");
            $("#workon").focus();
            $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
            return;
        }*/
     /*   
        if(!checkcode) {
            $("#message").html('请输入验证码！');
            $("#checkcode").addClass("onfour");
            $("#checkcode").focus();
            return;
        }*/

       /* if(checkcode.toLowerCase() != "27ey") {
            $("#message").html('验证码输入错误，请检查！');
            $("#checkcode").addClass("onfour");
            $("#checkcode").focus();
            return;
        }*/


        $.ajax({
            type: "POST",
          //  url: path + "/user!register_IDS.action",
            url: path + "/user!register.action",
            data: {"username": username, "password": password1, "categoryId": categoryId,"email" : email, 
            	"realName" : realName, "company" : company, "workon": workon, "phone" : phone, "checkcode": checkcode,"isExpert":"1"},
            success: function (result) {
                if (result.status < 0) {
                    $("#message").html(result.msg);
                    return;
                }else{
					alert(result.msg);
					location.href = path + "/frontLogin.action";
				}
                
            }
        });
    }

    return {
        init: init,
        send: send,
        expertSent: expertSent
    }
})();