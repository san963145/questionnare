package com.questionnare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnare.dao.AdminDao;
import com.questionnare.dao.PaperDao;
import com.questionnare.model.Paper;
import com.questionnare.util.Generator;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String userID=(String)application.getAttribute("userID");
		ArrayList<Paper>paperList=PaperDao.getPapersByUserID(userID);
		String paperListContent=Generator.generatePaperList(paperList);
		request.setAttribute("result","success");
		request.setAttribute("paperListContent",paperListContent);
		request.getRequestDispatcher("pages/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		ServletContext application=(ServletContext) request.getServletContext();
		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		String openID=(String) session.getAttribute("openID");
		String loginResult=AdminDao.checkAdminLogin(userID, password);
		if(loginResult==null){
			request.setAttribute("result","error");
			request.getRequestDispatcher("pages/index.jsp").forward(request, response);
			return;
		}else{
			String curUser=(String)application.getAttribute("openID");
			if(curUser!=null){
				request.setAttribute("result","busy");
				request.getRequestDispatcher("pages/index.jsp").forward(request, response);
				return;
			}
			application.setAttribute("userID", userID);
			if(openID!=null){
				session.removeAttribute("openID");
				application.setAttribute("openID", openID);
			}
			ArrayList<Paper>paperList=PaperDao.getPapersByUserID(userID);
			String paperListContent=Generator.generatePaperList(paperList);
			request.setAttribute("result","success");
			request.setAttribute("paperListContent",paperListContent);
			request.getRequestDispatcher("pages/main.jsp").forward(request, response);
		}
	}
	

}
