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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" href="editNew/mobile.css">
<link rel="stylesheet" href="editNew/edit.css">
<link rel="stylesheet" href="navbar/navbar.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css"> 
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<script src="navbar/navbar.js"></script>
<script src="editNew/jquery-1.10.1.min.js"></script>
<title>
	编辑问卷
</title>
<style>
    
 .orange:active {
	color: #ffffff;
	background: #0067AC;
}
.blue {
	background: #0067AC;
}
.btnSubmit{
   color:#fff;
}
</style>
</head>
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
            <a href="createTitle.jsp"><i class="back"></i></a>
        </div>
	<span class="top"></span>
        编辑问卷
        
    </div>
     
        <div id="divSurvey" class="edit_content"> <ul class="q_list"><li class="q_list_li"><div class="q_list_text"><h2 id="begin_desc">${title}<div style="color:#999;">${description}</div></h2><div class="q_linst_info">
	<a style="font-size:16px; display:block;" href="editTitle.jsp?paperID=${paperID}">编辑</a>
	<a style="font-size:16px; display:block;" href="../GetPaper?isPreview=1&paperID=${paperID}">预览</a>
            
       
	</div><div style="clear:both;"></div></div></li></ul><ul class="q_list" id="q_list"></ul></div>
   <div style="padding:28px 0 35px;background:#fff;text-align:center;">
        <a class="button blue addq" style="width:180px;font-size:1.4em;padding:3px 0 3px;text-align:center;margin:0 auto;" href="addQuestion.jsp?paperID=${paperID}">
	<i class="add_icon btnSubmit" style="height:26px;vertical-align:middle;"></i><span class="btnSubmit">添加新题<span></a>
    </div>
    <footer class="clear main-footer">      
		<p class="text-center">
        <b>问卷管理系统  Version1.0</b>
      </footer>
     <script src="editNew/fastclick.js" type="text/javascript"></script> 
        <script>
            $(function() {  
                FastClick.attach(document.body);  
            });  
       </script>


</body></html>