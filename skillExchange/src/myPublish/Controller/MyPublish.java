package myPublish.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myPublish.Model.MyPublishBean;
import myPublish.Service.myPublishService;
import skillexchange.HibernateUtil;

@WebServlet("/MyPublish")
public class MyPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	Session session;
	HttpSession httpSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//        test2
		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
		List<MyPublishBean> mylist;
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			myPublishService service = new myPublishService(session);
			mylist = service.myPublish(2);
			httpSession.setAttribute("mypublish", mylist);

			response.sendRedirect(request.getContextPath()+"/myPublish.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
