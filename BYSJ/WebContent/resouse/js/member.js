var outtime = 2000;//提示框销毁
var seconds=120;//短信失效秒数
var saveBtn = "saveBtn";//按钮变灰id
var saveBtnName = "saveBtn";//提交方法名称 id
var regEnName =/[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;//验证真实姓名
var regUsername =/^(?![0-9]+$)[0-9A-Za-z]{6,16}$/;
var regCnCard =/^([\d]{15}|[\d]{18}|[\d]{17}[x|X])$/;//验证身份证
var regPhone=/^13[0-9]{9}$|14[0-9]{9}$|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;//手机号码
var regPwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;//密码
var regEmail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;//邮件
var regBankCard=/^\d{6}|\d{16}|\d{19}$/;//银行卡
	
/**
 * 安全设置 
 * @param types 1实名认证 2手机认证 3手机修改 4邮箱绑定 5邮箱修改 6登录密码修改 7交易密码设置 8 交易密码修改 9 密保问题设置 10 密保问题修改 11 密保问题重置
 */
function safeSeting(root,types) {
	window.location.href = root+"/userSafe/setingInit?types="+types;
}
//实名认证验证
function checkRealname() {
	var obj = $("#realname");
	if(isEmpty(obj.val())) {
		$(".realnameMsg").html("真实姓名不能为空!");
		return false;
	}
	if(!regEnName.test(obj.val())){
		$(".realnameMsg").html("请正确输入您的真实姓名!");
		return false;
	}
	$(".realnameMsg").html("");
	return true;
}
function checkIdCard() {
	var obj = $("#idCard");
	if(isEmpty(obj.val())) {
		$(".idCardMsg").html("身份证号不能为空!");
		return false;
	}
	if(!regCnCard.test(obj.val())){
		$(".idCardMsg").html("请正确输入您的身份证号!");
		return false;
	}
	$(".idCardMsg").html("");
	return true;
}//实名认证验证

//手机修改
function checkOldMobile(tel) {
	var obj = $("#oldMobile");
	if(isEmpty(obj.val())) {
		$(".oldMobileMsg").html("原手机号码不能为空!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".oldMobileMsg").html("手机号码格式不正确!");
		return false;
	}
	if(tel != obj.val()){
		$(".oldMobileMsg").html("请正确输入您的原手机号码!");
		return false;
	}
	$(".oldMobileMsg").html("");
	return true;
}
function checkCashPwd() {
	var obj = $("#cashPwd");
	if(isEmpty(obj.val())) {
		$(".cashPwdMsg").html("交易密码不能为空!");
		return false;
	}
	$(".cashPwdMsg").html("");
	return true;
}
function checkNewMobile() {
	var obj = $("#newMobile");
	if(isEmpty(obj.val())) {
		$(".newMobileMsg").html("新手机号码不能为空!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".newMobileMsg").html("手机号码格式不正确!");
		return false;
	}
	if($("#oldMobile") == obj.val()){
		$(".newMobileMsg").html("新手机号码不能是原手机号码!");
		return false;
	}
	$(".newMobileMsg").html("");
	return true;
}


//手机修改
//发送修改手机验证码
function sendMsgByUpdateTel(root) {
	if(checkOldMobile($("#mobileNumber").val()) && checkNewMobile()) {
		$("#huoqu").removeAttr("href");
		sendMsg(root,$("#newMobile").val(),2);
	}
}
//绑定邮件 修改邮件
function checkNewEmail() {
	var email = $("#email").val();
	var obj = $("#newEmail");
	if(isEmpty(obj.val())) {
		$(".newEmailMsg").html("新邮箱不能为空!");
		return false;
	}
	if(!regEmail.test(obj.val())){
		$(".newEmailMsg").html("邮件格式不正确!");
		return false;
	}
	if(email == obj.val()){
		$(".newEmailMsg").html("新邮箱不能是修改前的邮箱!");
		return false;
	}
	$(".newEmailMsg").html("");
	return true;
}
function checkOldEmail() {
	var email = $("#email").val();
	var obj = $("#oldEmail");
	if(isEmpty(obj.val())) {
		$(".oldEmailMsg").html("原邮箱不能为空!");
		return false;
	}
	if(!regEmail.test(obj.val())){
		$(".oldEmailMsg").html("邮件格式不正确!");
		return false;
	}
	if(email != obj.val()){
		$(".oldEmailMsg").html("请正确输入您的原邮箱!");
		return false;
	}
	$(".oldEmailMsg").html("");
	return true;
}
//绑定邮件
//发送绑定邮件验证码
function sendMsgByUpdateEmail(root) {
	if(checkNewEmail()) {
		$("#huoqu").removeAttr("href");
		sendMsg(root,$("#newEmail").val(),3);
	}
}

//登录密码修改
function checkOldPwd() {
	var obj = $("#oldPwd");
	if(isEmpty(obj.val())) {
		$(".oldPwdMsg").html("原登录密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".oldPwdMsg").html("密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	$(".oldPwdMsg").html("");
	return true;
}
//忘记密码检测共用
function checkNewPwd() {
	var obj = $("#newPwd");
	var obj1 = $("#oldPwd");
	if(isEmpty(obj.val())) {
		$(".newPwdMsg").html("新密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".newPwdMsg").html("密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	if(obj.val() == obj1.val()) {
		$(".newPwdMsg").html("新密码不能是原密码!");
		return false;
	}
	$(".newPwdMsg").html("");
	return true;
}
function checkRnewPwd() {
	var obj = $("#rnewPwd");
	if(isEmpty(obj.val())) {
		$(".rnewPwdMsg").html("重复新密码不能为空!");
		return false;
	}
	if( $("#newPwd").val() != obj.val()){
		$(".rnewPwdMsg").html("两次密码不一致!");
		return false;
	}
	$(".rnewPwdMsg").html("");
	return true;
}//忘记密码检测共用
//登录密码修改
//交易密码设置，修改
function checkOldCashPwd() {
	var obj = $("#oldCashPwd");
	if(isEmpty(obj.val())) {
		$(".oldCashPwdMsg").html("原交易密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".oldCashPwdMsg").html("交易密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	$(".oldCashPwdMsg").html("");
	return true;
}

function checkNewCashPwd() {
	var obj = $("#newCashPwd");
	var obj1 = $("#oldCashPwd");
	if(isEmpty(obj.val())) {
		$(".newCashPwdMsg").html("新交易密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".newCashPwdMsg").html("交易密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	if(obj.val() == obj1.val()) {
		$(".newCashPwdMsg").html("新交易密码不能是原交易密码!");
		return false;
	}
	$(".newCashPwdMsg").html("");
	return true;
}
function checkCashPwd() {
	var obj = $("#cashPwd");
	if(isEmpty(obj.val())) {
		$(".cashPwdMsg").html("交易密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".cashPwdMsg").html("交易密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	$(".cashPwdMsg").html("");
	return true;
}
function checkReNewcashPwd() {
	var obj = $("#renewcashPwd");
	if(isEmpty(obj.val())) {
		$(".renewcashPwdMsg").html("确认交易密码不能为空!");
		return false;
	}
	if($("#newCashPwd").val() != obj.val()){
		$(".renewcashPwdMsg").html("两次密码不一致!");
		return false;
	}
	$(".renewcashPwdMsg").html("");
	return true;
}
function checkRecashPwd() {
	var obj = $("#recashPwd");
	if(isEmpty(obj.val())) {
		$(".recashPwdMsg").html("确认交易密码不能为空!");
		return false;
	}
	if($("#cashPwd").val() != obj.val()){
		$(".recashPwdMsg").html("两次密码不一致!");
		return false;
	}
	$(".recashPwdMsg").html("");
	return true;
}
//交易密码设置发送短信
function sendMsgByCashPwdSet(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,'',9);
}
//交易密码设置，修改


//忘记密码 
function checkUsername(root) {
	var obj = $("#username");
	if(isEmpty(obj.val())) {
		$(".usernameMsg").html("用户名不能为空!");
		return false;
	}
	if(!regUsername.test(obj.val())){
		$(".usernameMsg").html("用户名为6-16位的字母或数字和字母组合!");
		return false;
	}
	if(typeof(root) == 'undefined' || root=='') {
		$(".usernameMsg").html("");
		return true;
	} else {
		checkUserNameExists(obj.val(),root);
	}
}
function checkMobileNumbere(root) {
	var obj = $("#mobileNumber");
	if(isEmpty(obj.val())) {
		$(".mobileNumberMsg").html("手机号码不能为空!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".mobileNumberMsg").html("请输入正确的手机号码格式!");
		return false;
	}
	//验证用户名是否存在
	if(typeof(root) == 'undefined' || root=='') {
		$(".mobileNumberMsg").html("");
		return true;
	} else {
		checkMobileNumberExists(obj.val(),root);
	}
}
function checkVerifyCode() {
	var obj = $("#verifyCode");
	if(isEmpty(obj.val())) {
		$(".verifyCodeMsg").html("验证码不能为空!");
		return false;
	}
	$(".verifyCodeMsg").html("");
	return true;
}

//密保问题设置修改重置
function checkSecurityAnswer() {
	var obj = $("#securityAnswer");
	if(isEmpty(obj.val())) {
		$(".securityAnswerMsg").html("密保问题答案不能为空!");
		return false;
	}
	$(".securityAnswerMsg").html("");
	return true;
}
function checkOldSecurityAnswer() {
	var obj = $("#oldSecurityAnswer");
	if(isEmpty(obj.val())) {
		$(".oldSecurityAnswerMsg").html("原密保答案不能为空!");
		return false;
	}
	$(".oldSecurityAnswerMsg").html("");
	return true;
}
//发送修改手机验证码 重置密保问题
function sendMsgBysecurityQuestionReset(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,"",7);
}
//发送修改手机验证码 重置交易密码
function sendMsgByCashPwdReset(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,"",8);
}
//检查用户名是否存在
function checkUserNameExists(username,root) {
	//loading 图片
	$("#imgunMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkUserNameExists",{username:username},function(data) {
		$("#imgunMsg").html("");
		if(data.status == "y") {
			$(".usernameMsg").html("用户名不存在!");
			return false;
		} else {
			$(".usernameMsg").html("");
			return true;
		}
	});
}
//检查手机号码是否存在
function checkMobileNumberExists(mobileNumber,root) {
	//loading 图片
	$("#imgmnMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkMobileNumberExists",{mobileNumber:mobileNumber},function(data) {
		$("#imgmnMsg").html("");
		if(data.status == "y") {
			$(".mobileNumberMsg").html("手机号码不存在!");
			return false;
		} else {
			$(".mobileNumberMsg").html("");
			return true;
		}
	});
}
//忘记密码 
//注册
function checkTelNumber(root) {
	var obj = $("#telNumber");
	if(isEmpty(obj.val())) {
		$(".telNumberMsg").html("手机号码不能为空!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".telNumberMsg").html("请输入正确的手机号码格式!");
		return false;
	}
	if(typeof(root) == 'undefined' || root=='') {
		$(".telNumberMsg").html("");
		return true;
	} else {
		checkMobileNumberExistsByRegister(obj.val(),rootPath);
	}
}

function checkUserName(root) {
	var obj = $("#username");
	if(isEmpty(obj.val())) {
		$(".usernameMsg").html("用户名不能为空!");
		return false;
	}
	if(!regUsername.test(obj.val())){
		$(".usernameMsg").html("用户名为6-16位的字母或数字和字母组合!");
		return false;
	}
	if(typeof(root) == 'undefined' || root=='') {
		$(".usernameMsg").html("");
		return true;
	} else {
		checkUserNameExistsByRegister(obj.val(),root);
	}
}
function checkPassword() {
	var obj = $("#password");
	if(isEmpty(obj.val())) {
		$(".passwordMsg").html("密码不能为空!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".passwordMsg").html("密码必须且只允许包含数字和字母，长度为6-16位!");
		return false;
	}
	$(".passwordMsg").html("");
	return true;
}
function checkRepassword() {
	var obj = $("#repassword");
	if(isEmpty(obj.val())) {
		$(".repasswordMsg").html("确认密码不能为空!");
		return false;
	}
	if( $("#password").val() != obj.val()){
		$(".repasswordMsg").html("两次密码不一致!");
		return false;
	}
	$(".repasswordMsg").html("");
	return true;
}
//注册发送短信
function sendMsgByRegister(root) {
	if(checkTelNumber()) {
		$("#huoqu").addClass("btn_a_disable");
		$("#huoqu").removeAttr("href");
		$("#verifyCode").attr("readonly","readonly");
		$("#verifyCode").removeAttr("onkeyup");
		sendMsg(root,$("#telNumber").val(),5);
	}
}





//控制注册来源
function rschange(val,num) {
	if(val=="客户经理" || val=="其他") {
		$("#oregsource1").show();
	} else {
		$("#oregsource1").hide();
	}
	if(num!=0) {
		$("#oregsource").val("");
	}
}

function checkAgreement(bool) {
	var saveBtn1 = "nextStep";
	if(bool) {
		$("#"+saveBtn1).removeClass("btn_disable");
		$("#"+saveBtn1).attr("style","cursor:pointer;");
		$("#"+saveBtn1).removeAttr("disabled");
	} else {
		$("#"+saveBtn1).addClass("btn_disable");
		$("#"+saveBtn1).removeAttr("style");
		$("#"+saveBtn1).attr("disabled","disabled");
	}
}
//检查用户名是否存在
function checkUserNameExistsByRegister(username,root) {
	//loading 图片
	$("#imgunMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkUserNameExists",{username:username},function(data) {
		$("#imgunMsg").html("");
		if(data.status == "n") {
			$(".usernameMsg").html("用户名已存在!");
			return false;
		} else {
			$(".usernameMsg").html("");
			return true;
		}
	});
}
//检查手机号码是否存在
function checkMobileNumberExistsByRegister(mobileNumber,root) {
	//loading 图片
	$("#imgmnMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkMobileNumberExists",{mobileNumber:mobileNumber},function(data) {
		$("#imgmnMsg").html("");
		if(data.status == "n") {
			$(".telNumberMsg").html("手机号码已存在!");
			return false;
		} else {
			$(".telNumberMsg").html("");
			return true;
		}
	});
}
//注册
/**
 * 商品签收 
 * @param goid 商品订单id
 */
function qianshou(root,goid) {
	Util.confirm('提示','您确定签收吗？',function() {
		$.rajax(root+"/userReward/goodsSign",{id:goid},successFn);
	});
}

//修改头像
function updataPhoto(root,types,imgid) {
	var option = {title:'更换头像',onSelect:upload,ybtn:'确定'};
	Util.Model('<iframe scrolling="no" id="ifileupload" frameborder="0" width="480px" height="150px" src="'+root+'/include/singleupload.jsp?types='+types+'&imgid='+imgid+'"></iframe>',option);
}
function upload(obj,modelBox,modelBody) {
	var url = $("#ifileupload").contents().find("#url").val();
	var imgid = $("#ifileupload").contents().find("#imgid").val();
	var path = $("#ifileupload").contents().find("#path").val();
	if(url != "") {
		updateImg(imgid,path,url,modelBox,modelBody);
	} else {
		Util.alert("警告","请先上传文件","warning");
	}
}
//申请债权转让
function transferApply(root,invId) {
	var option = {title:'转让设置',onSelect:applyTransfer,ybtn:'我要转让',width:840};
	Util.Model('<iframe scrolling="no" id="transferFrame" name="transferFrame" frameborder="0" width="840px" height="530px" src="'+root+'/userZq/apply?invId='+invId+'"></iframe>',option);
}
function applyTransfer(obj,modelBox,modelBody) {
	if($("#transferFrame")[0].contentWindow.checkMoney() && $("#transferFrame")[0].contentWindow.checkDiscountGold()) {
		var form = $("#transferFrame").contents().find("#myform");
		form.submit();
		Util.modelClose(modelBox, modelBody);
	}
}//申请债权转让
//债权转让撤销
function withdrawTransfer(root,trid) {
	Util.confirm('提示','确定要撤销此债权转让信息？',function() {
		$.rajax(root+"/userZq/withdrawTransfer",{trid:trid},successFn);
	});
}
//更换图片路径 并关闭model
function updateImg(imgid,root,url,modelBox,modelBody) {
	$.ajax({
        type: "post",
        data:{"url":url},
        url: root+"/member/updatPhoto",
        dataType: "json",
        success: function(data){
        	if(data.status == 'y') {
	        	$("#"+imgid).attr("src",root + url);
	        	Util.modelClose(modelBox, modelBody);
	        }
        }
    });
}

//默认银行卡
function bankCardDefault(bid,root,seqNum) {
	if(seqNum == -1) {
		var option = {text:'该卡已默认!',time:outtime};
		Util.jDialog.Alert(option);
	} else {
		$.rajax(root+"/userBankcard/bankCardDefault",{id:bid},successFn);
	}
	
}
//删除银行卡
function bankCardDel(bid,root) {
	Util.confirm('提示','确定要删除此银行卡？',function() {
		$.rajax(root+"/userBankcard/bankCardDel",{id:bid},successFn);
	});
}
var tempSelectValue = "";
//省市联集
function changeProvince(root,pid,selectValue){
	tempSelectValue = selectValue;
	$.rajax(root+"/activity/changeProvince",{pid:pid},successProvince);
}
//处理省市联集成功
function successProvince(data) {
	$("#bankCityId").empty();
	$.each(data, function(i, item) {
		$.each(item, function(k, v) {
			if(k == tempSelectValue) {
				$("#bankCityId").append("<option value='"+k+"' selected='selected'>"+v+"</option>");
			} else {
				$("#bankCityId").append("<option value='"+k+"'>"+v+"</option>");
			}
		});
	});
	$("#bankCityId").select2({
		width : 150
	});
}
//添加银行卡验证
function checkCardNo() {
	var obj = $("#cardNo");
	if(isEmpty(obj.val())) {
		$(".cardNoMsg").html("银行卡号不能为空!");
		return false;
	}
	if(!regBankCard.test(obj.val())){
		$(".cardNoMsg").html("请正确输入您的银行卡号!");
		return false;
	}
	$(".cardNoMsg").html("");
	return true;
}
function checkCfcardNo() {
	var obj = $("#cfcardNo");
	if(isEmpty(obj.val())) {
		$(".cfcardNoMsg").html("确认银行卡号不能为空!");
		return false;
	}
	if(obj.val() != $("#cardNo").val()) {
		$(".cfcardNoMsg").html("两次银行卡不一致!");
		return false;
	}
	$(".cfcardNoMsg").html("");
	return true;
}
function checkName() {
	var obj = $("#name");
	if(isEmpty(obj.val())) {
		$(".nameMsg").html("开户行不能为空!");
		return false;
	}
	$(".nameMsg").html("");
	return true;
}

function checkAuthCode() {
	var obj = $("#authCode");
	if(isEmpty(obj.val())) {
		$(".authCodeMsg").html("验证码不能为空!");
		return false;
	}
	$(".authCodeMsg").html("");
	return true;
}
//添加银行卡验证

//获取债权转让的截止时间 根据转让记录id
function obtainEndTime(root,tranId) {
	$.ajax({
        type: "post",
        data: {tranId:tranId},
        url: root+"/zqzr/obtainEndTime",
        dataType: "json",
        success: function(data){
        	$("#"+data.id+"Span").html(data.hours);
        }
    });
}


//添加银行发送验证码短信
function sendMsg(root,tel,types) {
	$("#huoqu").removeAttr("href");
	var url = "";
	if(types == 1) {
		url = root+"/userBankcard/sendMsg";
	} else if(types == 2) {
		url = root+"/userSafe/sendMsg";
	} else if(types == 3) {
		url = root+"/userSafe/sendEmailMsg";
	} else if(types == 4) {
		url = root+"/forgetPwd/sendMsg";
	} else if(types == 5) {
		url = root+"/register/sendMsg";
	} else if(types == 6) {
		url = root+"/userZq/sendMsg";
	} else if(types == 7) {
		url = root+"/userSafe/sendMessageBySQReset";
	} else if(types == 8) {
		url = root+"/userSafe/sendMessageByCashPwdReset";
	} else if(types == 9) {
		url = root+"/userSafe/sendMsgByCashPwdSet";
	}
	if(types == 5) {
		$.rajax(url,{mobileNumber:tel},regSuccessSengMsg);
	} else {
		$.rajax(url,{mobileNumber:tel},successSengMsg);
	}
	
}
//注册处理发送短信成功
function regSuccessSengMsg(data) {
	var option = {text:data.info,time:outtime};
	if(data.status=='y') {
		Util.jDialog.Alert(option);
		$("#huoqu").addClass("btn_a_disable");
		var timer1 = setInterval(function() {
			seconds = seconds-1;
			if(seconds>0) {
				$("#huoqu").text("获取中 "+seconds);
			} else {
				$("#huoqu").text("重新获取 ");
				//$("#huoqu").attr("href",data.href);
				$("#verifyCode").removeAttr("readonly");
				$("#verifyCode").attr("onkeyup","checkIsCorrectCode();");
				$("#yz_box").click();
				seconds=120;
				clearInterval(timer1);
				//$("#huoqu").removeClass("btn_a_disable");
			}
		}, 1000);
	} else if(data.status=='n') {
		Util.jDialog.Alert(option);
		$("#huoqu").attr("href",data.href);
		$("#huoqu").removeClass("btn_a_disable");
	}
}

//处理发送短信成功
function successSengMsg(data) {
	var option = {text:data.info,time:outtime};
	if(data.status=='y') {
		Util.jDialog.Alert(option);
		$("#huoqu").addClass("btn_a_disable");
		var timer1 = setInterval(function() {
			seconds = seconds-1;
			if(seconds>0) {
				$("#huoqu").text("获取中 "+seconds);
			} else {
				$("#huoqu").text("重新获取 ");
				$("#huoqu").attr("href",data.href);
				seconds=120;
				clearInterval(timer1);
				$("#huoqu").removeClass("btn_a_disable");
			}
		}, 1000);
	} else if(data.status=='n') {
		Util.jDialog.Alert(option);
		$("#huoqu").attr("href",data.href);
		$("#huoqu").removeClass("btn_a_disable");
	}
}


function successDefauleFn(data) {
	if(data.status=='y') {
		if(typeof(data.info) == 'undefined' || data.info=='') {
			window.location.href = data.url;
		} else {
			var option = {};
			if(isEmpty(data.url)) {
				option = {text:data.info,time:outtime,url:'reload'};
			} else {
				option = {text:data.info,time:outtime,url:data.url};
			}
			Util.jDialog.Alert(option);
		}
	} else if(data.status=='n') {
		if(!isEmpty(data.info)) {
			if(isEmpty(data.url)) {
				option = {text:data.info,time:outtime};
			} else {
				option = {text:data.info,time:outtime,url:data.url};
			}
			Util.jDialog.Alert(option);
			$("#"+saveBtn).removeClass("btn_a_disable");
			$("#"+saveBtn).attr("href","javascript:"+saveBtnName+"();");
		}
	}
}

function successDefauleBtnFn(data) {
	if(data.status=='y') {
		if(typeof(data.info) == 'undefined' || data.info=='') {
			window.location.href = data.url;
		} else {
			var option = {};
			if(isEmpty(data.url)) {
				option = {text:data.info,time:outtime,url:'reload'};
			} else {
				option = {text:data.info,time:outtime,url:data.url};
			}
			Util.jDialog.Alert(option);
		}
	} else if(data.status=='n') {
		var option = {text:data.info,time:outtime};
		Util.jDialog.Alert(option);
		$("#"+saveBtn).removeClass("btn_disable");
		$("#"+saveBtn).attr("style","cursor:pointer;");
		$("#"+saveBtn).removeAttr("disabled");
	}
}

//ajax处理成功返回值
function successFn(data) {
	if(data.status=='y') {
		var option = {};
		if(isEmpty(data.url)) {
			option = {text:data.info,time:outtime,url:'reload'};
		} else {
			option = {text:data.info,time:outtime,url:data.url};
		}
		Util.jDialog.Alert(option);
	} else if(data.status=='n') {
		var option = {text:data.info,time:outtime};
		Util.jDialog.Alert(option);
	}
}


/**
 * 不再提示 充值 提现
 */
function noPrompt(root,types) {
	if(types==1) {
		//充值
		Util.confirm('提示','确定不在提示此信息？',function() {
			$.rajax(root+"/userRecharge/noPrompt",{},successFn);
		});
	} else if(types==2) {
		//提现
		Util.confirm('提示','确定不在提示此信息？',function() {
			$.rajax(root+"/userWithdraw/noPrompt",{},successFn);
		});
	}
}

$(function(){
	/**
	 * ajax封装
	 * url 发送请求的地址
	 * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
	 * successfn 成功回调函数
	 */
	jQuery.rajax=function(url, data, successfn) {
	    data = (data==null || data=="" || typeof(data)=="undefined") ? {"date": new Date().getTime()} : data;
	    $.ajax({
	        type: "post",
	        data: data,
	        url: url,
	        dataType: "json",
	        success: function(d){
	            successfn(d);
	        }
	    });
	};
});
/**
 * 判断值是都为空 
 * @param val
 * @returns {Boolean} true 为空
 */
function isEmpty(val) {
	if(typeof(val) == "undefined" || val == "") {
		return true;
	}
	return false;
}
function onpickedJump(url){
		if($("#f_time").val() && $("#e_time").val()){
			url += "&f_time="+$("#f_time").val()+"&e_time="+$("#e_time").val();
			window.location.href=url; 
		}
}
function onclearedJump(url){
	if(!$("#e_time").val() && !$("#f_time").val()) {
		window.location.href=url; 
	}
}