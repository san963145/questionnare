package com.questionnare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.questionnare.model.Paper;

public class PaperDao {
		
	public static Paper getPaperByPaperID(String paperID)
	{	
		Connection conn=ConnManager.getConnection(); 
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from paper where paperID=?");
			ps.setString(1, paperID);
			ps.execute();
			ResultSet rs=ps.getResultSet();			
			while(rs.next())
			{
				String title=rs.getString("title");
				String description=rs.getString("description");
				String user=rs.getString("userID");
				Paper paper=new Paper(paperID,title,description,user,0,0);
				return paper;
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
	public static boolean get(String title)
	{	
		Connection conn=ConnManager.getConnection(); 
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from paper where title=?");
			ps.setString(1, title);
			ps.execute();
			ResultSet rs=ps.getResultSet();			
			if(rs.next())
			{				
				return true;
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
		  return false;
	}
	public static ArrayList<Paper> getPapersByUserID(String userID)
	{	
		Connection conn=ConnManager.getConnection(); 
		ArrayList<Paper>result=new ArrayList<Paper>();
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from paper where userID=?");
			ps.setString(1, userID);
			ps.execute();
			ResultSet rs=ps.getResultSet();			
			while(rs.next())
			{
				String paperID=rs.getString("paperID");
				String title=rs.getString("title");
				String description=rs.getString("description");
				String user=rs.getString("userID");
				int questionCount=QuestionDao.getQuestionCountByPaper(paperID);
				int finishedCount=FinishedListDao.getFinishedCountByPaper(paperID);
				Paper paper=new Paper(paperID,title,description,user,questionCount,finishedCount);
				result.add(paper);
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
		  return result;
	}
	public static boolean add(String paperID,String title,String description,String userID)
	{	
		Connection conn=ConnManager.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			PreparedStatement ps = conn.prepareStatement("insert into paper(paperID,title,description,userID) values(?,?,?,?)");
			ps.setString(1, paperID);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setString(4, userID);
			ps.execute();
			conn.commit();
			return true;
		}  catch(Exception e)
		  {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		  return false;
	}

}
