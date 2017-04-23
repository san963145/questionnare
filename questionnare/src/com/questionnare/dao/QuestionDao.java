package com.questionnare.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.questionnare.model.Question;

public class QuestionDao {

	public static boolean add(String title,String type,String itemA,String itemB,String itemC,String itemD,String itemE,String itemF,String paperID)
	{	
		Connection conn=ConnManager.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			PreparedStatement ps = conn.prepareStatement("insert into question(questionID,title,type,itemA,itemB,itemC,itemD,itemE,itemF,paperID) values(?,?,?,?,?,?,?,?,?,?)");
			Long questionID=System.currentTimeMillis();
			ps.setString(1, questionID.toString());
			ps.setString(2, title);
			ps.setString(3, type);
			ps.setString(4, itemA);
			ps.setString(5, itemB);
			ps.setString(6, itemC);
			ps.setString(7, itemD);
			ps.setString(8, itemE);
			ps.setString(9, itemF);
			ps.setString(10, paperID);
			ps.execute();
			conn.commit();
		}  catch(Exception e)
		  {
			try {
				conn.rollback();
				return false;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		  }		
		   finally{
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  return true;
	}

	public static int getQuestionCountByPaper(String paperID)
	{	
		Connection conn=ConnManager.getConnection(); 
		try
		{
			PreparedStatement ps = conn.prepareStatement("select count(*) count from question where paperID=?");
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
	public static ArrayList<Question> getQuestionsByPaperID(String paperID)
	{	
		Connection conn=ConnManager.getConnection();
		ArrayList<Question>result=new ArrayList<Question>();
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from question where paperID=?");
			ps.setString(1, paperID);
			ps.execute();
			ResultSet rs=ps.getResultSet();			
			while(rs.next())
			{
				String questionID=rs.getString("questionID");
				String title=rs.getString("title");
				String type=rs.getString("type");
				String itemA=rs.getString("itemA");
				String itemB=rs.getString("itemB");
				String itemC=rs.getString("itemC");
				String itemD=rs.getString("itemD");
				String itemE=rs.getString("itemE");
				String itemF=rs.getString("itemF");
				Question question=new Question(questionID,title,type,itemA,itemB,itemC,itemD,itemE,itemF,paperID);
				result.add(question);
			}	
		}  catch(Exception e)
		  {
			e.printStackTrace();
		  }		
		   finally{
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  return result;
	}

}
