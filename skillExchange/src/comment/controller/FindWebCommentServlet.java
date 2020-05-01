package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.bean.CommentBean;
import comment.service.CommentServiceIMPL;

/**
 * Servlet implementation class FindWebCommentServlet
 */
@WebServlet(urlPatterns = {"/FindWebCommentServlet","/page2/dist/FindWebCommentServlet"})
public class FindWebCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentServiceIMPL service = new CommentServiceIMPL();
	     List<CommentBean> comments = service.getAllWebComments();
		 request.setAttribute("webcomments", comments);
		 RequestDispatcher rd = request.getRequestDispatcher("/Webcomment.jsp");
		 rd.forward(request, response);
		 return;		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
