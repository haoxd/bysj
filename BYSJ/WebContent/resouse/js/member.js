var outtime = 2000;//��ʾ������
var seconds=120;//����ʧЧ����
var saveBtn = "saveBtn";//��ť���id
var saveBtnName = "saveBtn";//�ύ�������� id
var regEnName =/[\u4E00-\u9FA5]{2,5}(?:��[\u4E00-\u9FA5]{2,5})*/;//��֤��ʵ����
var regUsername =/^(?![0-9]+$)[0-9A-Za-z]{6,16}$/;
var regCnCard =/^([\d]{15}|[\d]{18}|[\d]{17}[x|X])$/;//��֤���֤
var regPhone=/^13[0-9]{9}$|14[0-9]{9}$|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;//�ֻ�����
var regPwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;//����
var regEmail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;//�ʼ�
var regBankCard=/^\d{6}|\d{16}|\d{19}$/;//���п�
	
/**
 * ��ȫ���� 
 * @param types 1ʵ����֤ 2�ֻ���֤ 3�ֻ��޸� 4����� 5�����޸� 6��¼�����޸� 7������������ 8 ���������޸� 9 �ܱ��������� 10 �ܱ������޸� 11 �ܱ���������
 */
function safeSeting(root,types) {
	window.location.href = root+"/userSafe/setingInit?types="+types;
}
//ʵ����֤��֤
function checkRealname() {
	var obj = $("#realname");
	if(isEmpty(obj.val())) {
		$(".realnameMsg").html("��ʵ��������Ϊ��!");
		return false;
	}
	if(!regEnName.test(obj.val())){
		$(".realnameMsg").html("����ȷ����������ʵ����!");
		return false;
	}
	$(".realnameMsg").html("");
	return true;
}
function checkIdCard() {
	var obj = $("#idCard");
	if(isEmpty(obj.val())) {
		$(".idCardMsg").html("���֤�Ų���Ϊ��!");
		return false;
	}
	if(!regCnCard.test(obj.val())){
		$(".idCardMsg").html("����ȷ�����������֤��!");
		return false;
	}
	$(".idCardMsg").html("");
	return true;
}//ʵ����֤��֤

//�ֻ��޸�
function checkOldMobile(tel) {
	var obj = $("#oldMobile");
	if(isEmpty(obj.val())) {
		$(".oldMobileMsg").html("ԭ�ֻ����벻��Ϊ��!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".oldMobileMsg").html("�ֻ������ʽ����ȷ!");
		return false;
	}
	if(tel != obj.val()){
		$(".oldMobileMsg").html("����ȷ��������ԭ�ֻ�����!");
		return false;
	}
	$(".oldMobileMsg").html("");
	return true;
}
function checkCashPwd() {
	var obj = $("#cashPwd");
	if(isEmpty(obj.val())) {
		$(".cashPwdMsg").html("�������벻��Ϊ��!");
		return false;
	}
	$(".cashPwdMsg").html("");
	return true;
}
function checkNewMobile() {
	var obj = $("#newMobile");
	if(isEmpty(obj.val())) {
		$(".newMobileMsg").html("���ֻ����벻��Ϊ��!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".newMobileMsg").html("�ֻ������ʽ����ȷ!");
		return false;
	}
	if($("#oldMobile") == obj.val()){
		$(".newMobileMsg").html("���ֻ����벻����ԭ�ֻ�����!");
		return false;
	}
	$(".newMobileMsg").html("");
	return true;
}


//�ֻ��޸�
//�����޸��ֻ���֤��
function sendMsgByUpdateTel(root) {
	if(checkOldMobile($("#mobileNumber").val()) && checkNewMobile()) {
		$("#huoqu").removeAttr("href");
		sendMsg(root,$("#newMobile").val(),2);
	}
}
//���ʼ� �޸��ʼ�
function checkNewEmail() {
	var email = $("#email").val();
	var obj = $("#newEmail");
	if(isEmpty(obj.val())) {
		$(".newEmailMsg").html("�����䲻��Ϊ��!");
		return false;
	}
	if(!regEmail.test(obj.val())){
		$(".newEmailMsg").html("�ʼ���ʽ����ȷ!");
		return false;
	}
	if(email == obj.val()){
		$(".newEmailMsg").html("�����䲻�����޸�ǰ������!");
		return false;
	}
	$(".newEmailMsg").html("");
	return true;
}
function checkOldEmail() {
	var email = $("#email").val();
	var obj = $("#oldEmail");
	if(isEmpty(obj.val())) {
		$(".oldEmailMsg").html("ԭ���䲻��Ϊ��!");
		return false;
	}
	if(!regEmail.test(obj.val())){
		$(".oldEmailMsg").html("�ʼ���ʽ����ȷ!");
		return false;
	}
	if(email != obj.val()){
		$(".oldEmailMsg").html("����ȷ��������ԭ����!");
		return false;
	}
	$(".oldEmailMsg").html("");
	return true;
}
//���ʼ�
//���Ͱ��ʼ���֤��
function sendMsgByUpdateEmail(root) {
	if(checkNewEmail()) {
		$("#huoqu").removeAttr("href");
		sendMsg(root,$("#newEmail").val(),3);
	}
}

//��¼�����޸�
function checkOldPwd() {
	var obj = $("#oldPwd");
	if(isEmpty(obj.val())) {
		$(".oldPwdMsg").html("ԭ��¼���벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".oldPwdMsg").html("���������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	$(".oldPwdMsg").html("");
	return true;
}
//���������⹲��
function checkNewPwd() {
	var obj = $("#newPwd");
	var obj1 = $("#oldPwd");
	if(isEmpty(obj.val())) {
		$(".newPwdMsg").html("�����벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".newPwdMsg").html("���������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	if(obj.val() == obj1.val()) {
		$(".newPwdMsg").html("�����벻����ԭ����!");
		return false;
	}
	$(".newPwdMsg").html("");
	return true;
}
function checkRnewPwd() {
	var obj = $("#rnewPwd");
	if(isEmpty(obj.val())) {
		$(".rnewPwdMsg").html("�ظ������벻��Ϊ��!");
		return false;
	}
	if( $("#newPwd").val() != obj.val()){
		$(".rnewPwdMsg").html("�������벻һ��!");
		return false;
	}
	$(".rnewPwdMsg").html("");
	return true;
}//���������⹲��
//��¼�����޸�
//�����������ã��޸�
function checkOldCashPwd() {
	var obj = $("#oldCashPwd");
	if(isEmpty(obj.val())) {
		$(".oldCashPwdMsg").html("ԭ�������벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".oldCashPwdMsg").html("�������������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	$(".oldCashPwdMsg").html("");
	return true;
}

function checkNewCashPwd() {
	var obj = $("#newCashPwd");
	var obj1 = $("#oldCashPwd");
	if(isEmpty(obj.val())) {
		$(".newCashPwdMsg").html("�½������벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".newCashPwdMsg").html("�������������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	if(obj.val() == obj1.val()) {
		$(".newCashPwdMsg").html("�½������벻����ԭ��������!");
		return false;
	}
	$(".newCashPwdMsg").html("");
	return true;
}
function checkCashPwd() {
	var obj = $("#cashPwd");
	if(isEmpty(obj.val())) {
		$(".cashPwdMsg").html("�������벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".cashPwdMsg").html("�������������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	$(".cashPwdMsg").html("");
	return true;
}
function checkReNewcashPwd() {
	var obj = $("#renewcashPwd");
	if(isEmpty(obj.val())) {
		$(".renewcashPwdMsg").html("ȷ�Ͻ������벻��Ϊ��!");
		return false;
	}
	if($("#newCashPwd").val() != obj.val()){
		$(".renewcashPwdMsg").html("�������벻һ��!");
		return false;
	}
	$(".renewcashPwdMsg").html("");
	return true;
}
function checkRecashPwd() {
	var obj = $("#recashPwd");
	if(isEmpty(obj.val())) {
		$(".recashPwdMsg").html("ȷ�Ͻ������벻��Ϊ��!");
		return false;
	}
	if($("#cashPwd").val() != obj.val()){
		$(".recashPwdMsg").html("�������벻һ��!");
		return false;
	}
	$(".recashPwdMsg").html("");
	return true;
}
//�����������÷��Ͷ���
function sendMsgByCashPwdSet(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,'',9);
}
//�����������ã��޸�


//�������� 
function checkUsername(root) {
	var obj = $("#username");
	if(isEmpty(obj.val())) {
		$(".usernameMsg").html("�û�������Ϊ��!");
		return false;
	}
	if(!regUsername.test(obj.val())){
		$(".usernameMsg").html("�û���Ϊ6-16λ����ĸ�����ֺ���ĸ���!");
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
		$(".mobileNumberMsg").html("�ֻ����벻��Ϊ��!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".mobileNumberMsg").html("��������ȷ���ֻ������ʽ!");
		return false;
	}
	//��֤�û����Ƿ����
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
		$(".verifyCodeMsg").html("��֤�벻��Ϊ��!");
		return false;
	}
	$(".verifyCodeMsg").html("");
	return true;
}

//�ܱ����������޸�����
function checkSecurityAnswer() {
	var obj = $("#securityAnswer");
	if(isEmpty(obj.val())) {
		$(".securityAnswerMsg").html("�ܱ�����𰸲���Ϊ��!");
		return false;
	}
	$(".securityAnswerMsg").html("");
	return true;
}
function checkOldSecurityAnswer() {
	var obj = $("#oldSecurityAnswer");
	if(isEmpty(obj.val())) {
		$(".oldSecurityAnswerMsg").html("ԭ�ܱ��𰸲���Ϊ��!");
		return false;
	}
	$(".oldSecurityAnswerMsg").html("");
	return true;
}
//�����޸��ֻ���֤�� �����ܱ�����
function sendMsgBysecurityQuestionReset(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,"",7);
}
//�����޸��ֻ���֤�� ���ý�������
function sendMsgByCashPwdReset(root) {
	$("#huoqu").removeAttr("href");
	sendMsg(root,"",8);
}
//����û����Ƿ����
function checkUserNameExists(username,root) {
	//loading ͼƬ
	$("#imgunMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkUserNameExists",{username:username},function(data) {
		$("#imgunMsg").html("");
		if(data.status == "y") {
			$(".usernameMsg").html("�û���������!");
			return false;
		} else {
			$(".usernameMsg").html("");
			return true;
		}
	});
}
//����ֻ������Ƿ����
function checkMobileNumberExists(mobileNumber,root) {
	//loading ͼƬ
	$("#imgmnMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkMobileNumberExists",{mobileNumber:mobileNumber},function(data) {
		$("#imgmnMsg").html("");
		if(data.status == "y") {
			$(".mobileNumberMsg").html("�ֻ����벻����!");
			return false;
		} else {
			$(".mobileNumberMsg").html("");
			return true;
		}
	});
}
//�������� 
//ע��
function checkTelNumber(root) {
	var obj = $("#telNumber");
	if(isEmpty(obj.val())) {
		$(".telNumberMsg").html("�ֻ����벻��Ϊ��!");
		return false;
	}
	if(!regPhone.test(obj.val())){
		$(".telNumberMsg").html("��������ȷ���ֻ������ʽ!");
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
		$(".usernameMsg").html("�û�������Ϊ��!");
		return false;
	}
	if(!regUsername.test(obj.val())){
		$(".usernameMsg").html("�û���Ϊ6-16λ����ĸ�����ֺ���ĸ���!");
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
		$(".passwordMsg").html("���벻��Ϊ��!");
		return false;
	}
	if(!regPwd.test(obj.val())){
		$(".passwordMsg").html("���������ֻ����������ֺ���ĸ������Ϊ6-16λ!");
		return false;
	}
	$(".passwordMsg").html("");
	return true;
}
function checkRepassword() {
	var obj = $("#repassword");
	if(isEmpty(obj.val())) {
		$(".repasswordMsg").html("ȷ�����벻��Ϊ��!");
		return false;
	}
	if( $("#password").val() != obj.val()){
		$(".repasswordMsg").html("�������벻һ��!");
		return false;
	}
	$(".repasswordMsg").html("");
	return true;
}
//ע�ᷢ�Ͷ���
function sendMsgByRegister(root) {
	if(checkTelNumber()) {
		$("#huoqu").addClass("btn_a_disable");
		$("#huoqu").removeAttr("href");
		$("#verifyCode").attr("readonly","readonly");
		$("#verifyCode").removeAttr("onkeyup");
		sendMsg(root,$("#telNumber").val(),5);
	}
}





//����ע����Դ
function rschange(val,num) {
	if(val=="�ͻ�����" || val=="����") {
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
//����û����Ƿ����
function checkUserNameExistsByRegister(username,root) {
	//loading ͼƬ
	$("#imgunMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkUserNameExists",{username:username},function(data) {
		$("#imgunMsg").html("");
		if(data.status == "n") {
			$(".usernameMsg").html("�û����Ѵ���!");
			return false;
		} else {
			$(".usernameMsg").html("");
			return true;
		}
	});
}
//����ֻ������Ƿ����
function checkMobileNumberExistsByRegister(mobileNumber,root) {
	//loading ͼƬ
	$("#imgmnMsg").html('<img src="'+root+'/site/themes/default/images/big_load.gif" id="loadid" border="0" />');
	$.rajax(root+"/forgetPwd/checkMobileNumberExists",{mobileNumber:mobileNumber},function(data) {
		$("#imgmnMsg").html("");
		if(data.status == "n") {
			$(".telNumberMsg").html("�ֻ������Ѵ���!");
			return false;
		} else {
			$(".telNumberMsg").html("");
			return true;
		}
	});
}
//ע��
/**
 * ��Ʒǩ�� 
 * @param goid ��Ʒ����id
 */
function qianshou(root,goid) {
	Util.confirm('��ʾ','��ȷ��ǩ����',function() {
		$.rajax(root+"/userReward/goodsSign",{id:goid},successFn);
	});
}

//�޸�ͷ��
function updataPhoto(root,types,imgid) {
	var option = {title:'����ͷ��',onSelect:upload,ybtn:'ȷ��'};
	Util.Model('<iframe scrolling="no" id="ifileupload" frameborder="0" width="480px" height="150px" src="'+root+'/include/singleupload.jsp?types='+types+'&imgid='+imgid+'"></iframe>',option);
}
function upload(obj,modelBox,modelBody) {
	var url = $("#ifileupload").contents().find("#url").val();
	var imgid = $("#ifileupload").contents().find("#imgid").val();
	var path = $("#ifileupload").contents().find("#path").val();
	if(url != "") {
		updateImg(imgid,path,url,modelBox,modelBody);
	} else {
		Util.alert("����","�����ϴ��ļ�","warning");
	}
}
//����ծȨת��
function transferApply(root,invId) {
	var option = {title:'ת������',onSelect:applyTransfer,ybtn:'��Ҫת��',width:840};
	Util.Model('<iframe scrolling="no" id="transferFrame" name="transferFrame" frameborder="0" width="840px" height="530px" src="'+root+'/userZq/apply?invId='+invId+'"></iframe>',option);
}
function applyTransfer(obj,modelBox,modelBody) {
	if($("#transferFrame")[0].contentWindow.checkMoney() && $("#transferFrame")[0].contentWindow.checkDiscountGold()) {
		var form = $("#transferFrame").contents().find("#myform");
		form.submit();
		Util.modelClose(modelBox, modelBody);
	}
}//����ծȨת��
//ծȨת�ó���
function withdrawTransfer(root,trid) {
	Util.confirm('��ʾ','ȷ��Ҫ������ծȨת����Ϣ��',function() {
		$.rajax(root+"/userZq/withdrawTransfer",{trid:trid},successFn);
	});
}
//����ͼƬ·�� ���ر�model
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

//Ĭ�����п�
function bankCardDefault(bid,root,seqNum) {
	if(seqNum == -1) {
		var option = {text:'�ÿ���Ĭ��!',time:outtime};
		Util.jDialog.Alert(option);
	} else {
		$.rajax(root+"/userBankcard/bankCardDefault",{id:bid},successFn);
	}
	
}
//ɾ�����п�
function bankCardDel(bid,root) {
	Util.confirm('��ʾ','ȷ��Ҫɾ�������п���',function() {
		$.rajax(root+"/userBankcard/bankCardDel",{id:bid},successFn);
	});
}
var tempSelectValue = "";
//ʡ������
function changeProvince(root,pid,selectValue){
	tempSelectValue = selectValue;
	$.rajax(root+"/activity/changeProvince",{pid:pid},successProvince);
}
//����ʡ�������ɹ�
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
//������п���֤
function checkCardNo() {
	var obj = $("#cardNo");
	if(isEmpty(obj.val())) {
		$(".cardNoMsg").html("���п��Ų���Ϊ��!");
		return false;
	}
	if(!regBankCard.test(obj.val())){
		$(".cardNoMsg").html("����ȷ�����������п���!");
		return false;
	}
	$(".cardNoMsg").html("");
	return true;
}
function checkCfcardNo() {
	var obj = $("#cfcardNo");
	if(isEmpty(obj.val())) {
		$(".cfcardNoMsg").html("ȷ�����п��Ų���Ϊ��!");
		return false;
	}
	if(obj.val() != $("#cardNo").val()) {
		$(".cfcardNoMsg").html("�������п���һ��!");
		return false;
	}
	$(".cfcardNoMsg").html("");
	return true;
}
function checkName() {
	var obj = $("#name");
	if(isEmpty(obj.val())) {
		$(".nameMsg").html("�����в���Ϊ��!");
		return false;
	}
	$(".nameMsg").html("");
	return true;
}

function checkAuthCode() {
	var obj = $("#authCode");
	if(isEmpty(obj.val())) {
		$(".authCodeMsg").html("��֤�벻��Ϊ��!");
		return false;
	}
	$(".authCodeMsg").html("");
	return true;
}
//������п���֤

//��ȡծȨת�õĽ�ֹʱ�� ����ת�ü�¼id
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


//������з�����֤�����
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
//ע�ᴦ���Ͷ��ųɹ�
function regSuccessSengMsg(data) {
	var option = {text:data.info,time:outtime};
	if(data.status=='y') {
		Util.jDialog.Alert(option);
		$("#huoqu").addClass("btn_a_disable");
		var timer1 = setInterval(function() {
			seconds = seconds-1;
			if(seconds>0) {
				$("#huoqu").text("��ȡ�� "+seconds);
			} else {
				$("#huoqu").text("���»�ȡ ");
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

//�����Ͷ��ųɹ�
function successSengMsg(data) {
	var option = {text:data.info,time:outtime};
	if(data.status=='y') {
		Util.jDialog.Alert(option);
		$("#huoqu").addClass("btn_a_disable");
		var timer1 = setInterval(function() {
			seconds = seconds-1;
			if(seconds>0) {
				$("#huoqu").text("��ȡ�� "+seconds);
			} else {
				$("#huoqu").text("���»�ȡ ");
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

//ajax����ɹ�����ֵ
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
 * ������ʾ ��ֵ ����
 */
function noPrompt(root,types) {
	if(types==1) {
		//��ֵ
		Util.confirm('��ʾ','ȷ��������ʾ����Ϣ��',function() {
			$.rajax(root+"/userRecharge/noPrompt",{},successFn);
		});
	} else if(types==2) {
		//����
		Util.confirm('��ʾ','ȷ��������ʾ����Ϣ��',function() {
			$.rajax(root+"/userWithdraw/noPrompt",{},successFn);
		});
	}
}

$(function(){
	/**
	 * ajax��װ
	 * url ��������ĵ�ַ
	 * data ���͵������������ݣ�����洢���磺{"date": new Date().getTime(), "state": 1}
	 * successfn �ɹ��ص�����
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
 * �ж�ֵ�Ƕ�Ϊ�� 
 * @param val
 * @returns {Boolean} true Ϊ��
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