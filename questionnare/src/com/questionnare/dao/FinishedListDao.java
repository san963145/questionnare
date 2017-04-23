package com.questionnare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FinishedListDao {
	
	public static int getFinishedCountByPaper(String paperID)
	{	
		Connection conn=ConnManager.getConnection(); 
		try
		{
			PreparedStatement ps = conn.prepareStatement("select count(*) count from finishedList where paperID=?");
			ps.setString(1, paperID);
			ps.execute();
			ResultSet rs=ps.getResultSet();			
			if(rs.next())
			{
				int count=rs.getInt("count");
				return count;
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
		  return 0;
	}

}
