package com.questionnare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDao {
	
	public static String checkAdminLogin(String userID, String password)
	{	
		Connection conn = ConnManager.getConnection(); 	
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from admin where userID=? and password=?");
			ps.setString(1, userID);
			ps.setString(2, password);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if(rs.next())
			{
				String result = rs.getString("userID");
				return result;
			}	
		}  catch(Exception e)
		  {
			e.printStackTrace();
		  }		
		   finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  return null;
	}
	
	public static String checkUserID(String userID)
	{	
		Connection conn=ConnManager.getConnection(); 	
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from admin where userID=?");
			ps.setString(1, userID);
			ps.execute();
			ResultSet rs=ps.getResultSet();
			if(rs.next())
			{
				String result=rs.getString("userID");
				return result;
			}	
		}  catch(Exception e)
		  {
			e.printStackTrace();
		  }		
		   finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  return null;
	}


}
