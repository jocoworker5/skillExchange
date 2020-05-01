package myPublish.Controller;

import java.io.IOException;

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

@WebServlet("/MyPublishUpDate")
public class MyPublishUpDate extends HttpServlet {
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

		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
//
		String publishNo = request.getParameter("publishNo");
		System.out.println(publishNo);
		int pubNo = Integer.parseInt(publishNo);

		httpSession.setAttribute("pubNo", pubNo);

		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			myPublishService service = new myPublishService(session);
			MyPublishBean sbean = service.selUpdatePublish( pubNo);
			System.out.println(sbean.getMyTitle() + sbean.getMyDetail() + sbean.getMyArea() + sbean.getMyCity()
					+ sbean.getMyDistrict() + sbean.getMyRoad());

			httpSession.setAttribute("myTitle", sbean.getMyTitle());
			httpSession.setAttribute("myDetail", sbean.getMyDetail());
			httpSession.setAttribute("myArea", sbean.getMyArea());
			httpSession.setAttribute("myCity", sbean.getMyCity());
			httpSession.setAttribute("myDistrict", sbean.getMyDistrict());
			httpSession.setAttribute("myRoad", sbean.getMyRoad());
			httpSession.setAttribute("myPlace", sbean.getMyPlace());
			httpSession.setAttribute("myOwnSkill", sbean.getMyOwnSkill());
			httpSession.setAttribute("myWantSkill", sbean.getMyWantSkill());
			httpSession.setAttribute("myMark", sbean.getMyMark());
			response.sendRedirect("/skillExchange/testUp.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
