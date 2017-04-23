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
<link rel="stylesheet" href="main/mobile.css"/>
<link rel="stylesheet" href="main/list.css"/>
<link rel="stylesheet" href="navbar/navbar.css"/>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css"/>
<link rel="stylesheet" href="dist/css/AdminLTE.min.css"/> 
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css"/>
<script src="navbar/navbar.js"></script>
<script src="main/jquery-1.10.1.min.js"></script>
<title>
	我的问卷
</title>
<style>
.glyphicon{
   font-size:30px;
   color:#54676e;
}
.glyphicon_font{
   margin-top:3px;
   font-size:12px;
   color:#54676e;
   font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}
</style>

</head>
<script>
function exit(){
	if(confirm("退出并取消问卷发布状态?")){
		window.location="../Exit";
        return false;
	}
}
</script>
<body>
<div class="TFtab" id="ulLeft" style="display: none;">
                <li class="wjx_01"><a href="../Main" index="1" class="wactive"><i></i>
                    <p>我的问卷</p>
                </a></li>
                <li class="wjx_04"><a href="createTitle.jsp" index="4"><i></i>
                    <p>创建问卷</p>
                </a></li>
                <li class="wjx_06"><a href="javascript:void(0);" index="6"><i></i>
                    <p>账号管理</p>
                </a></li>
</div>
		
<div id="divHeader" class="header" onclick="navbar_show_hide()">
         <div class="header_left navmeun_more">
            <a class="A_add_but" href="javascript:;"><i class="add_but add_but_dh" onclick="exit()"></i></a>
        </div>
	<span class="top">
	</span>
        我的问卷

    </div>
    
    ${paperListContent}
    
    <div id="divPage" style="text-align:center; margin:20px auto;">
    
    </div>
    
    <div id="divDingTip" style="margin:20px 0;text-align:center;">
        <b>问卷管理系统  Version1.0</b>
    </div>
   
   
     
    <script>
    var isShowbox = false;
    var isNav_menu = false;
    var hasQCount=1;
    $(function () {
        $('.div_add_but').bind('click', show_hide_addmackbox);
        $('.navmeun_more').bind('click', show_hide_navmeun_more);
        $('html').bind('click', Close_addmackbox);
        $('.addSurvey,.mackbox').bind('click', function () { isShowbox = false; isNav_menu = false; });
        if(!hasQCount && !$(".topic_ipt input")[0]){
            show_hide_addmackbox();
        }
        $("#txtInput").bind("keydown",function(event){
            if(event.keyCode==13){
                $("#search").trigger("click");
            }
        });
    });
    $(function () {
        $("#search").bind("click", function () {
            var key = $(".topic_ipt input").val();
            var loc = "qlistnew.aspx?name=" + encodeURIComponent(key);
            if(isDingDing)
                loc+="&dd_nav_bgcolor=FF5E97F6";
            window.location=loc;
        });
    });
    function Close_addmackbox() {
 
        if (isShowbox) {
            $('.addSurvey').hide();
//            $('.add_but').removeClass('add_but_dh');
        }
    
        if (isNav_menu) {
            $('.nav_more').hide();
        }
    }
    function show_hide_addmackbox() {
        isShowbox = false;
        if ($('.addSurvey:visible').length > 0) {
            $('.addSurvey').hide();
            setTimeout(function () { isShowbox = false; }, 50);
        } else {
            $('.addSurvey').show();
            $('.nav_more').hide();
            setTimeout(function () { isShowbox = true; }, 50);
        }
        return false;
    }
    function show_hide_navmeun_more() {
        isNav_menu = false;
        if ($('.nav_more:visible').length > 0) {
            $('.nav_more').hide();
            setTimeout(function () { isNav_menu = false; }, 50);
        } else {
            $('.nav_more').show();
            $('.addSurvey').hide();
            setTimeout(function () { isNav_menu = true; }, 50);
        }
        return false;
    }
</script>
    <script type="text/javascript">
        var isLioffon = false;
        var curLi = null;
        var isDingDing=0;
        var ddcorpid="";
        function bind_touch_event() {
            $(window).bind('click', function () {
                if (isLioffon) {
                    //$('.share_result_menu').hide();
                    if ($('.loadMack').length) { return; } else { $('.share_result_menu').hide(); curLi = null; }
                }
            });
            $('.sr_result').bind('click', function (e) {
                e.preventDefault();
                var par =$(this.parentNode.parentNode.parentNode.parentNode);// $(this).parents(".list_li");
                var count = $(this).attr("count");
                if (count) {
                	var id = par.attr("aid");
                    var loc = "#" + id;
                    //window.location=loc;
                    return false;                 
                }else{
                	loadMack({ off: 'on', Limg: 0, text: '该问卷未收集答案，请先发布问卷', set: 1200 });
                    e.stopPropagation();
                    return false;
                }
              
            });
            $('.sr_share').bind('click', function (e) {
                e.preventDefault();
                var par =$(this.parentNode.parentNode.parentNode.parentNode);// $(this).parents(".list_li");
                var curpub=$(this.parentNode.parentNode.parentNode.parentNode.parentNode).attr("curpub");
                
                var aid = par.attr("aid");
                if(aid==curpub){
                	loadMack({ off: 'on', Limg: 0, text: '该问卷当前处于发布状态', set: 1200 });
                    e.stopPropagation();
                    return false;
                }else{
                	if(confirm("确认发布?")){
                		var loc = "../GetPaper?paperID=" + aid+"&isPublish=1";
                        window.location=loc;
                        return false;
                	}else{
                		e.stopPropagation();
                        return false;
                	}
                }
                
                location.href=loc;
                return false;
            });
            $('.sr_list_edit').bind('click', function (e) {
                var par =$(this.parentNode.parentNode.parentNode.parentNode);// $(this).parents(".list_li");
                var aid = par.attr("aid");
                var curpub=$(this.parentNode.parentNode.parentNode.parentNode.parentNode).attr("curpub");
                if(aid==curpub){
                	if(confirm("暂停收集答案?")){
                		var loc = "../CreateTitle?paperID=" + aid;
                        window.location=loc;
                        return false;
                	}else{
                		e.stopPropagation();
                        return false;
                	}
                }else{
                	var loc = "../CreateTitle?paperID=" + aid;
                    window.location=loc;
                    return false;
                }                                                          
            });
            $('.sr_list_del').bind('click', function (e) {
                var par =$(this.parentNode.parentNode.parentNode.parentNode);// $(this).parents(".list_li");

                if (confirm('确定删除？')) {
                    location.href = "#" + par.attr("aid");
                }
                e.stopPropagation();
                return false;
            });
            
            //var listid = $(this).attr('id');
            $('.list_li').bind('click', function (e) {
                isLioffon = false;
                if (curLi && curLi != this)//之前的收缩
                    $(curLi).find('.share_result_menu').slideUp(600);
                if ($(this).find('.share_result_menu').css("display") == "block") {
                    $(this).find('.share_result_menu').slideUp(600);
                }
                else {
                    $(this).find('.share_result_menu').slideDown(600); isLioffon = true;
                    Close_addmackbox();
                }
                curLi = this;
                
                e.stopPropagation();
                e.preventDefault();
                return false;
            });
            $('.list_li a').bind("click",function(e){
                e.stopPropagation();
                return true;
            });
        }
        $(function () {
            bind_touch_event();
        });
        function loadMack(obj) {
            if (obj.off == "off") {
                $(".loadMack,.loadCon").fadeOut("800", function () {
                    $(this).remove();
                });
                return;
            }
            var wbod = document.documentElement.clientWidth || document.body.clientWidth;
            var hwid = document.documentElement.clientHeight || document.body.clientHeight;
            var hbod = $("body").height();
            if (obj.set == undefined) { obj.set = 0 }
            if (obj.Mack == undefined) { obj.Mack = '<div class="loadMack" style="width:' + wbod + 'px;height:' + hwid + 'px;"></div>'; } else { obj.Mack = ''; }
            $("body").append('' + obj.Mack + '<div style="left:0px;top:0px;" class="loadCon"><p style="text-align:center;font-size:14px;">' + obj.text + '</p></div>');
            if (obj.set !== 0) {
                setTimeout(function () {
                    $(".loadMack,.loadCon").fadeOut("800", function () {
                        $(this).remove();
                        return;
                    });
                }, obj.set);
            }
            loadwidth = $('.loadCon').width();
            $('.loadCon').css({ left: ($(document).width() - loadwidth) / 2 - 20, top: 150 });
        }
    </script>
    
     <script src="main/fastclick.js" type="text/javascript"></script> 
        <script>
            $(function() {  
                FastClick.attach(document.body);  
            });  
       </script>


</body></html>