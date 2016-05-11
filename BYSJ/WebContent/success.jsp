<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<font color="red"><b>${thisBackUpdatejspUser.UserId}</b></font>
,您好,您已成功登录本系统; 现在是：
  <script type="text/javascript">
        today = new Date();
        document.write(today.getFullYear(),"年","",today.getMonth()+1,"月","",today.getDate(),"日 ",today.getHours(),"时",today.getMinutes(),"分",today.getSeconds(),"秒"+",");
        var week = today.getDay();
        document.write(getWeek(week));
        function getWeek(week){                                                                                 
        	if(week == 0) return "星期日";
            if(week == 1) return "星期一";
            if(week == 2) return "星期二";
            if(week == 3) return "星期三";
            if(week == 4) return "星期四";
            if(week == 5) return "星期五";
            if(week == 6) return "星期六";
        }
        </script>
</body>
</html>