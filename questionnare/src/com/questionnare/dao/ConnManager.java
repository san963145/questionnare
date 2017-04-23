package com.questionnare.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnManager {
	
	private static final String driverClass="com.mysql.jdbc.Driver";//驱动程序名
	private static final String jdbcURL="jdbc:mysql://beuqtvyqdbrv.mysql.sae.sina.com.cn:10461/dl_xixi?useUnicode=true&characterEncoding=UTF-8";
	private static final String name="root";
	private static final String pwd="123456";
	
	public static Connection getConnection(){
		Connection con = null;
		//遍历查询结果集
		try {
			Class.forName(driverClass);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection(jdbcURL, name, pwd);//连接到数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
