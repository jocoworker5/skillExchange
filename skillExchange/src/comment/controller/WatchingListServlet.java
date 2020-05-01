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
 * Servlet implementation class WatchingListServlet
 */
@WebServlet("/WatchingListServlet")
public class WatchingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int grade = Integer.parseInt(request.getParameter("grade"));
		CommentServiceIMPL csi = new CommentServiceIMPL();
		List<CommentBean> wlist = csi.watchingList(grade);
		request.setAttribute("watching", wlist);
		RequestDispatcher rd = request.getRequestDispatcher("FindUserCommentServlet");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
