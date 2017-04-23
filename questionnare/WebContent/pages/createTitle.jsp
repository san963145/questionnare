<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/pages/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" href="main/mobile.css">
<link rel="stylesheet" href="navbar/navbar.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css"> 
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<script src="navbar/navbar.js"></script>
<script src="createTitle/jquery-1.10.1.min.js"></script>
<style>
    
 .orange:active {
	color: #ffffff;
	background: #0067AC;
}
.blue {
	background: #0067AC;
}
#btnSubmit{
   color:#fff;
}
</style>

<script charset="UTF-8">  

	function check()
	{
		var title=document.getElementById("title").value;
		if(title=="")
	    {
			alert("请输入问卷标题!");
			return false;
	    }
		else
		{
			return true;
		}
	}	
  </script>
<title>
	创建问卷
</title></head>
<body>
<div class="TFtab" id="ulLeft" style="display: none;">
                <li class="wjx_01"><a href="../Main" index="1"><i></i>
                    <p>我的问卷</p>
                </a></li>
                <li class="wjx_04"><a href="createTitle.jsp" index="4" class="wactive"><i></i>
                    <p>创建问卷</p>
                </a></li>
                <li class="wjx_06"><a href="javascript:void(0);" index="6"><i></i>
                    <p>账号管理</p>
                </a></li>
</div>
    <div id="divHeader" class="header" onclick="navbar_show_hide()">
        <div class="header_left">
            <a href="main.jsp"><i class="back"></i></a>
        </div>
	<span class="top"></span>
        创建问卷
    </div>     
 
    <div class="content Fbk" id="divContent">
    <form name="form1" method="post" action="../CreateTitle" id="form1" onsubmit="return check()">



    <div class="Fbk_con">
        <p>
            问卷名称</p>
       <input name="title" type="title" id="title" placeholder="请输入问卷标题">
    </div>
    <div class="Fbk_con">
        <p>
            问卷说明</p>
        <textarea name="description" rows="2" cols="20" id="description"></textarea>
    </div>
        <input type="hidden" name="hfQType" id="hfQType" value="1">
    
    <button id="btnSubmit" type="submit" class="button blue mot10">创建新问卷</button>
    <div style="margin-top:10px;"> <span id="lblMsg" style="color:Red;"></span></div>
    </form>
    </div> 
    
    <footer class="clear main-footer">      
		<p class="text-center">
        <b>问卷管理系统  Version1.0</b>
      </footer>
    
      
    <script src="createTitle/fastclick.js" type="text/javascript"></script> 
        <script>
            $(function () {
                FastClick.attach(document.body);
            });
       </script>


</body>
<c:if test="${not empty result}">
     <c:if test="${result=='error'}">
         <script charset="UTF-8">
            alert("创建失败,请检查数据库连接！");
         </script>
     </c:if>
     <c:if test="${result=='repeat'}">
         <script charset="UTF-8">
            alert("该标题已存在！");
         </script>
     </c:if>
  </c:if>
</html>