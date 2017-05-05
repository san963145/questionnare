package com.questionnare.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiveParser {
	

	public static Map<String,String> parse(HttpServletRequest request, HttpServletResponse response) throws IOException
	{		
        StringBuffer sb = new StringBuffer();  
        InputStream is = request.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
        BufferedReader br = new BufferedReader(isr);  
        String s = "";  
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
        String xml = sb.toString();             
        int toUserNameStartIndex=xml.indexOf("<ToUserName>")+21;
        int toUserNameEndIndex=xml.indexOf("]]></ToUserName>");
        int fromUserNameStartIndex=xml.indexOf("<FromUserName>")+23;
        int fromUserNameEndIndex=xml.indexOf("]]></FromUserName>");        
        int msgTypeStartIndex=xml.indexOf("<MsgType>")+18;
        int msgTypeEndIndex=xml.indexOf("]]></MsgType>");
        String msgType=xml.substring(msgTypeStartIndex,msgTypeEndIndex);
        String content="non_text";
        if(msgType.equals("text")){
        	int contentStartIndex=xml.indexOf("<Content>")+18;
            int contentEndIndex=xml.indexOf("]]></Content>");
            content=xml.substring(contentStartIndex, contentEndIndex);
        }
        String toUserName=xml.substring(toUserNameStartIndex, toUserNameEndIndex);
        String fromUserName=xml.substring(fromUserNameStartIndex, fromUserNameEndIndex);
        Map<String,String> map=new HashMap<String,String>();
        map.put("toUserName", toUserName);
        map.put("fromUserName", fromUserName);
        map.put("content", content);
        return map;
	}

}
