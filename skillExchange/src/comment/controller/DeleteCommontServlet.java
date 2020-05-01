package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentServiceIMPL;

/**
 * Servlet implementation class DeleteCommontServlet
 */
@WebServlet("/DeleteCommontServlet")
public class DeleteCommontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("key"));
		CommentServiceIMPL cis = new CommentServiceIMPL();
		cis.deleteComm(id);	
		String header = request.getHeader("referer");
		System.out.println(header);
		if(header.contains("http://localhost:8080"+request.getContextPath()+"/FindUserCommentServlet")) {
		response.sendRedirect(request.getContextPath()+"/FindUserCommentServlet");
//		rd.forward(request, response);
//		return;
		} else {
			response.sendRedirect(request.getContextPath()+"/FindWebCommentServlet");
//			rd.forward(request, response);
//			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
