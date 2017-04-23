<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/pages/";  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">

<title>问卷</title>
<script type="text/javascript">
    if (window.location.hash) {
        window.location.hash = "";
        window.location.href = window.location.href.replace("#", "");
    }
    var isWeiXin=0;
</script>
<link rel="stylesheet" href="paper/jqmobo.css">
<link rel="stylesheet" href="paper/navbar.css">

<script src="navbar/navbar.js"></script>

<script src="paper/jquery.min.js"></script>
<script type="text/javascript">
    !window.jQuery && document.write('<script src="/js/mobile/jquery-1.10.1.min.js"><\/script>');
</script>

 <script src="paper/hintinfo.js" type="text/javascript"></script>
 <script src="paper/jqmobo2.js" type="text/javascript"></script>
 <style>
  
    .header{
            background: none repeat scroll 0 0 #0067ac;
            color: #fff;
            display: inline-block;
            font-size: 20px;
            height: 50px;
            line-height: 50px;
            overflow: hidden;
            padding: 0 35px;
            text-align: center;
            text-overflow: ellipsis;
            white-space: nowrap;
            width: 100%;
            z-index: 999;
            position: relative;
    }
    .header .header_text{
            display: inline-block;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            width: 100%;
    }
    .header_left{
            position: absolute;
            left: 0px;
            top: 0px;
            width: 60px;
            height: 50px;
    }
    .header_left a{
            display: block;
            width: 100%;
            height: 100%;
    }
    .back{
            display: inline-block;
            width: 21px;
            height: 21px;
            margin: 15px auto 0 auto;
            background-position: 0 0;
            background-repeat: no-repeat;
            background-image: url('left.png');
            background-size: contain;
    }
    .header_right{
            position: absolute;
            right: 0px;
            top: 0px;
            min-width: 60px;
            height: 50px; /*background-color: #3DA4DE;*/
    }
    .header_right a{
            display: block;
            width: 100%;
            height: 100%;
    }
    .header_right a .button_1{
            float: left;
            margin-top: 10px;
    }
    .button_1{
            border-radius: 2px;
            color: #fff;
            display: inline-block;
            font-size: 14px;
            line-height: 21px;
            padding: 5px 10px;
	    
     }
    .rm10{
            margin-right: 10px;
    }
    .More_set{
            background-color: #fdfbcb;
            border: 1px solid #f3f3f3;
            padding: 10px;
            text-align: right;
    }
    .More_set p{
            color: #757774;
            font-size: 16px;
            margin: 0;
            padding: 0;
            padding-bottom: 5px;
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
    <div id="divTopHeader">
        <div id="divTitleHeader" class="header" onclick="navbar_show_hide()">
            <div class="header_left">
                <a href="editNew.jsp"><i class="back"></i>
                </a>
            </div>
	    <span class="top"></span>
          
                ${title }
            
        </div>
        <div id="divSet">
            <div class="More_set">
                <p>
                                                                   当前为预览页面<c:if test="${not empty published}">
                   ,该问卷处于发布状态
               </c:if>
               <c:if test="${empty published}">
                   <span> </span>                    
                    <a href="../GetPaper?paperID=${paperID}&isPublish=1" id="hrefCopy"  style="background: #0067ac;" class="button_1 rm10">点击发布</a>
               </c:if>
              </p>

                       

            </div>
        </div>
       
    </div>
   
    <form id="form1" method="post">
    
    
    <div id="toptitle" style="display: none;">
        <h1 class="htitle">
           ${title }</h1>
    </div>
    
     
    
    
    <div id="divContent">
        <div id="divDesc" class="formfield">
            <span class="description">
                ${description }</span>
        </div>
        
        
        
        
        
        <div id="divQuestion">
            ${fullPaper }
        </div>


        <div class="footer">
            <div class="ValError">
            </div>
            <div id="divSubmit" style="padding: 10px;">
                
                <a id="ctlNext" href="javascript:;" class="button blue">
                    提交</a>

            </div>
            
            
        </div>
       
    </div>
    
    </form>  
     
       <script src="paper/fastclick.js" type="text/javascript"></script> 
        <script>
        $(function() {  
            FastClick.attach(document.body);  
        });  
       </script>
     
   


</body></html>