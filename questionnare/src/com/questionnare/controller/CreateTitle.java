package com.questionnare.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnare.dao.PaperDao;
import com.questionnare.model.Paper;

/**
 * Servlet implementation class CreateTitle
 */
@WebServlet("/CreateTitle")
public class CreateTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTitle() {
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
		String paperID=request.getParameter("paperID");
		Paper paper=PaperDao.getPaperByPaperID(paperID);
		if(paper!=null){
			request.setAttribute("result","success");
			request.setAttribute("paperID",paperID);
			request.setAttribute("title",paper.getTitle());
			request.setAttribute("description",paper.getDescription());
			request.getRequestDispatcher("pages/editNew.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ServletContext application=(ServletContext) request.getServletContext();
		String title=request.getParameter("title");
		boolean isRepeat=PaperDao.get(title);
		if(isRepeat){
			request.setAttribute("result","repeat");
			request.getRequestDispatcher("pages/createTitle.jsp").forward(request, response);
			return;
		}
		String paperID=new Long(System.currentTimeMillis()).toString();
		String description=request.getParameter("description");
		String userID=(String)application.getAttribute("userID");
		boolean addResult=PaperDao.add(paperID,title, description, userID);
		if(addResult){
			request.setAttribute("result","success");
			request.setAttribute("paperID",paperID);
			request.setAttribute("title",title);
			request.setAttribute("description",description);
			request.getRequestDispatcher("pages/editNew.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("result","error");
			request.getRequestDispatcher("pages/createTitle.jsp").forward(request, response);
			return;
		}
	}

}
