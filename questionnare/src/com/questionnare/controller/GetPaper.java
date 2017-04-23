package com.questionnare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnare.dao.PaperDao;
import com.questionnare.dao.QuestionDao;
import com.questionnare.model.Paper;
import com.questionnare.model.Question;
import com.questionnare.util.Generator;

/**
 * Servlet implementation class GetPaper
 */
@WebServlet("/GetPaper")
public class GetPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ServletContext application=(ServletContext) request.getServletContext();
		String paperID=(String)request.getParameter("paperID");
		if(paperID==null){
			paperID=(String)application.getAttribute("paperID");
		}
		String isPreview=(String)request.getParameter("isPreview");
		String isPublish=(String)request.getParameter("isPublish");
		Paper paper=PaperDao.getPaperByPaperID(paperID);
		ArrayList<Question> questions=QuestionDao.getQuestionsByPaperID(paperID);
	    String fullPaper=Generator.generateFullPaper(paper,questions);
	    request.setAttribute("paperID",paperID);
	    request.setAttribute("result","success");
	    request.setAttribute("title",paper.getTitle());
	    request.setAttribute("description",paper.getDescription());
	    request.setAttribute("fullPaper",fullPaper);
	    String published=(String)application.getAttribute("published");
	    String openID=(String)request.getParameter("openID");
	    if(published!=null && openID==null){
	    	application.setAttribute("paperID", paperID);
    		request.setAttribute("published",1);
    		application.setAttribute("published","1");
    		request.getRequestDispatcher("pages/paperPreview.jsp").forward(request, response);
	        return;
	    }
	    if(isPreview!=null ||isPublish!=null){
	    	if(isPublish!=null){
	    		application.setAttribute("paperID", paperID);
	    		request.setAttribute("published","1");
	    		application.setAttribute("published","1");
	    	}	    	
	    	request.getRequestDispatcher("pages/paperPreview.jsp").forward(request, response);	    
	    }else{
	    	request.getRequestDispatcher("pages/paper.jsp?openID="+openID).forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
