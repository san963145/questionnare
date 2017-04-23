package com.questionnare.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnare.dao.AdminDao;
import com.questionnare.util.ReceiveParser;
import com.questionnare.util.ReplyContent;
import com.questionnare.util.SignUtil;


/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String signature = request.getParameter("signature");  

		String timestamp = request.getParameter("timestamp");  

        String nonce = request.getParameter("nonce");  
 
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  

        if (SignUtil.checkSignature(signature, timestamp, nonce)) 
        {  
           out.print(echostr);  
        }  
        out.close();  
        out = null;	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");
        ServletContext application=this.getServletContext();
        Map<String,String> xmlMap=ReceiveParser.parse(request, response);
        String toUserName=xmlMap.get("toUserName");
        String fromUserName=xmlMap.get("fromUserName");//openID
        String content=xmlMap.get("content");
        String checkUserID=AdminDao.checkUserID(content);
        String paperID=(String)application.getAttribute("paperID");
        String curOpenID=(String)application.getAttribute("openID");
        if(curOpenID!=null){
        	if(curOpenID.equals(fromUserName)){
        		String title="返回系统";
           	    String url="http://cheline.applinzi.com/Login";
           	    String replyContent="点击进入我的问卷";
           	    String xml=ReplyContent.generateXML(fromUserName, toUserName, title, replyContent, url);
           	    response.getWriter().write(xml);
           	    return;
        	}      	
        }
        if(paperID!=null){ 
        	  String title="填写问卷";
         	  String url="http://cheline.applinzi.com/GetPaper?openID="+fromUserName;
         	  String replyContent="点击链接可填写问卷.";
         	  String xml=ReplyContent.generateXML(fromUserName, toUserName, title, replyContent, url);
         	  response.getWriter().write(xml);

        }else if(checkUserID==null){
        	String replyContent="当前未发布任何问卷,请提供管理员账号!";
       	    String xml=ReplyContent.generateXML(fromUserName, toUserName, replyContent);
       	    response.getWriter().write(xml);
        }else{
        	String title="系统登录";
       	    String url="http://cheline.applinzi.com/pages/index.jsp?openID="+fromUserName;
       	    String replyContent="登录系统发布问卷";
       	    String xml=ReplyContent.generateXML(fromUserName, toUserName, title, replyContent, url);
       	    response.getWriter().write(xml);
        }
	}

}
