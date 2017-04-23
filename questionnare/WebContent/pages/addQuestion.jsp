<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/pages/";  
   String paperID=(String)request.getParameter("paperID");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" href="addQuestion/mobile.css">
<link rel="stylesheet" href="addQuestion/edit.css">
<link rel="stylesheet" href="navbar/navbar.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css"> 
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<script src="navbar/navbar.js"></script>
<script src="addQuestion/jquery-1.10.1.min.js"></script>


<title>
添加问题
</title>
<style>
.choice_item{
   display:inline;
   margin-top:5px;
   margin-left:20px;
   margin-right:20px;
}
</style>
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
            <a href="editNew.jsp"><i class="back"></i></a>
        </div>
	<span class="top"></span>
        <span id="spanQtype">单选题</span>
    </div>
    
    <div class="edit_utils">
      <form method="post" action="../AddQuestion?paperID=<%=paperID %>" id="qform">
        <div class="BlankBlock">
            <div class="BlockTitle">
                <h2 style="font-weight:normal;font-size:18px;">
                    标题</h2>
            </div>
            <div class="BlockCon InputBor">
                <input class="topic_input" type="text" placeholder="请输入题目标题" name="title" id="question_title">
                
            </div>
        </div>
        <div id="divRadioCheck" class="mobile_an">
            <ul class="SelectType">
                <li id="type_single" class="active" onclick="single()">单选题</li>
                <li id="type_multiple" class="" onclick="multiple()">多选题</li>
            </ul>
            
            <script>
               function single(){
            	   $("#typeChoice").val("1");
		           $("#type_single").addClass("active");
		           $("#type_multiple").removeClass("active");
               }
               function multiple(){
            	  $("#typeChoice").val("2");
		          $("#type_multiple").addClass("active");
		          $("#type_single").removeClass("active");
               }
            </script>
           <input name="typeChoice" id="typeChoice" style="visibility:hidden"/>
           
            <div class="Q_Style_con" style="background:#fff;padding:10px 0 15px;">
                 <div style="margin-bottom:10px;font-size:14px;color:#262626;">
                     <div style="float:left;margin:0 10px;" id="divTipChoice">选项</div>
                     <div style="float:left;">内容</div>
                     <div style="clear:both;"></div>
                 </div>
                <div id="option_list">
                  
                <div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 15px 12px 20px;"><b style="font-size:18px">A</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemA" value="">
		  </div>
		 </div>
		</div>
		<div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 15px 12px 20px;"><b style="font-size:18px">B</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemB" value="">
		  </div>
		 </div>
		</div>
		<div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 15px 12px 20px;"><b style="font-size:18px">C</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemC" value="">
		  </div>
		 </div>
		</div>
		<div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 15px 12px 20px;"><b style="font-size:18px">D</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemD" value="">
		  </div>
		 </div>
		</div>
		<div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 16px 12px 20px;"><b style="font-size:18px">E</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemE" value="">
		  </div>
		 </div>
		</div>
		<div class="sel_items">
		 <div>
		  <div style="float:left;margin:12px 17px 12px 20px;"><b style="font-size:18px">F</b></div>
		  <div class="input" style="float:left;width: 80%;">
		     <input placeholder="选项内容" name="itemF" value="">
		  </div>
		 </div>
		</div>
		
            </div>

          
           
            
             
        </div>

        
        
        <div class="mobile_an" style="margin-bottom:25px;padding-top:10px;">
            
         
           
           <button id="btnSubmit" type="submit" class="button blue mot10">确认</button>
                <div style="">
                    <span id="lblMsg" style="color:Red;"></span>
                </div>
           
        </div>
    </div>
    </form>
    </div>
    
    <footer class="clear main-footer">      
		<p class="text-center">
        <b>问卷管理系统  Version1.0</b>
      </footer>
     <script src="addQuestion/fastclick.js" type="text/javascript"></script> 
        <script>
            $(function() {  
                FastClick.attach(document.body);  
            });  
       </script>
       <script src="addQuestion/lrz.bundle.js" type="text/javascript"></script>


</body>
<c:if test="${not empty result}">
     <c:if test="${result=='error'}">
         <script charset="UTF-8">
            alert("添加失败,请检查数据库连接！");
         </script>
     </c:if>
  </c:if>
</html>