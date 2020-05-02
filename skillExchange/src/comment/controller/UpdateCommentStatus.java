package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comment.service.CommentServiceIMPL;
import skillexchange.HibernateUtil;

/**
 * Servlet implementation class UpdateCommentStatus
 */
@WebServlet(urlPatterns= {"/UpdateCommentStatus","/page2/dist/UpdateCommentStatus"})
public class UpdateCommentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	Session session;
	HttpSession httpSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int commentNo = Integer.valueOf(request.getParameter("key"));
		int stat = Integer.valueOf(request.getParameter("stat"));
		factory = HibernateUtil.getSessionFactory();
		session = factory.getCurrentSession();
		CommentServiceIMPL csi = new CommentServiceIMPL(session);
		csi.updateUserComm(commentNo, stat);
		 RequestDispatcher rd = request.getRequestDispatcher("FindUserCommentServlet");
		 rd.forward(request, response);
		 return;	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
