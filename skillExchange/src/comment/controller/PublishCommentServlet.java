package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.bean.CommentBean;
import comment.service.CommentServiceIMPL;

/**
 * Servlet implementation class PublishCommentServlet
 */
@WebServlet("/PublishCommentServlet")
public class PublishCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublishCommentServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             CommentServiceIMPL csi = new CommentServiceIMPL();
             List<CommentBean> pc = csi.publishComment();
             HttpSession session = request.getSession();
        	 session.setAttribute("publish", pc);
			 response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
