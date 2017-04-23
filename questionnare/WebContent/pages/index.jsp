<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/pages/";  
   String openID=request.getParameter("openID");
   if(openID!=null)
   {
	   session.setAttribute("openID", openID);
   }
   else
   {
	   session.removeAttribute("openID");
   }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1"/>
<link rel="stylesheet" href="index/mobile.css"/>
<title>
	问卷登录系统
</title>
<script src="index/jquery-1.10.1.min.js"></script>
<style>
#getYzm, .getYzm
{
    padding:0;
}
</style>
<script charset="UTF-8">  

	function check()
	{
		var userID=document.getElementById("userID").value;
		var password=document.getElementById("password").value;
		if(userID=="")
	    {
			alert("请输入用户名!");
			return false;
	    }
		else if(password=="")
		{
			alert("请输入密码!");
			return false;
		}
		else
		{
			return true;
		}
	}	
  </script>
</head>
<body>
    <div class="i_header">
        <div class="header_c">
            <a href="index.jsp" id="hrefLogo" class="logo"></a>
        </div>
    </div>
    <div class="content">
        <form name="form1" method="post" action="../Login" id="form1" onsubmit="return check()">

        <ul class="unstyled matrix_ul">
            <li>
                <div class="topic_input">
                    <div class="topic_bel">
                        <i class="ico_phone"></i>
                    </div>
                    <div class="topic_ipt">
                        <input name="userID" id="userID"  placeholder="用户名" class="btx"/>
                    </div>
                </div>
            </li>
            <li>
                <div class="topic_input">
                    <div class="topic_bel">
                        <i class="ico_p"></i>
                    </div>
                    <div class="topic_ipt">
                        <input name="password" type="password" id="password" placeholder="密码" class="btx"/>
                    </div>
                </div>
            </li>
              
            
        </ul>
        <div style="margin-top: 20px;">
            <button id="btnSubmit" type="submit" class="button orange">登录</button></div>
        
        </form>
    
         <script>
             
        </script>
    </div>
    <div id="divDingTip" style="margin:20px 0;text-align:center;">
        <b>问卷管理系统  Version1.0</b>
    </div>


</body>

 <c:if test="${not empty result}">
     <c:if test="${result=='busy'}">
         <script charset="UTF-8">
            alert("系统忙！");
         </script>
     </c:if>
     <c:if test="${result=='error'}">
         <script charset="UTF-8">
            alert("用户名不存在或密码错误！");
         </script>
     </c:if>
  </c:if>
</html>