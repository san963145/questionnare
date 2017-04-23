package com.questionnare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnare.dao.PaperDao;
import com.questionnare.dao.QuestionDao;
import com.questionnare.model.Paper;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String typeChoice=request.getParameter("typeChoice");
		String itemA=request.getParameter("itemA");
		String itemB=request.getParameter("itemB");
		String itemC=request.getParameter("itemC");
		String itemD=request.getParameter("itemD");
		String itemE=request.getParameter("itemE");
		String itemF=request.getParameter("itemF");
		String paperID=request.getParameter("paperID");
		Paper paper=PaperDao.getPaperByPaperID(paperID);
		if(typeChoice==null){
			typeChoice="1";
		}else if(typeChoice.length()==0){
			typeChoice="1";
		}
		boolean addResult=QuestionDao.add(title, typeChoice, itemA, itemB, itemC, itemD, itemE, itemF, paperID);
	    if(addResult){
	    	request.setAttribute("result","success");
	    	request.setAttribute("paperID",paperID);
			request.setAttribute("title",paper.getTitle());
			request.setAttribute("description",paper.getDescription());
			request.getRequestDispatcher("pages/editNew.jsp").forward(request, response);
			return;
	    }else{
	    	request.setAttribute("result","error");
			request.getRequestDispatcher("pages/addQuestion.jsp").forward(request, response);
			return;
	    }
	
	}

}
