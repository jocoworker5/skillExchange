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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comment.bean.CommentBean;
import comment.service.CommentServiceIMPL;
import skillexchange.HibernateUtil;

/**
 * Servlet implementation class PublishCommentServlet
 */
@WebServlet("/PublishCommentServlet")
public class PublishCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	Session session;
	HttpSession httpSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		factory = HibernateUtil.getSessionFactory();
		session = factory.getCurrentSession();
		CommentServiceIMPL csi = new CommentServiceIMPL(session);
		List<CommentBean> pc = csi.publishComment();
		//改用另一個list裝五比bean就好
		HttpSession session = request.getSession();
		session.setAttribute("publish", pc);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
