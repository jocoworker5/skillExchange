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
import myPublish.Model.upPubBean;
import myPublish.Service.myPublishService;
import skillexchange.HibernateUtil;

/**
 * Servlet implementation class MyPublishUpSucc
 */
@WebServlet("/MyPublishUpSucc")
public class MyPublishUpSucc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession httpSession;
	Session session;

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

		String myTitle = request.getParameter("myTitle");
		String myDetail = request.getParameter("myDetail");
		String myArea = request.getParameter("myArea");
		String myCity = request.getParameter("myCity");
		String myDistrict = request.getParameter("myDistrict");
		String myRoad = request.getParameter("myRoad");
		String myPlace = request.getParameter("myPlace");
		String myOwnSkill = request.getParameter("myOwnSkill");
		String myWantSkill = request.getParameter("myWantSkill");
		String myMark = request.getParameter("myMark");
		int pubNo = Integer.parseInt(httpSession.getAttribute("pubNo").toString());

		System.out.println(myTitle);
		System.out.println(pubNo);

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			myPublishService service = new myPublishService(session);
			MyPublishBean upb = new MyPublishBean(pubNo, myTitle, myDetail, myArea, myCity, myDistrict, myRoad, myPlace,
					myOwnSkill, myWantSkill, myMark);

			service.datePublish(upb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/skillExchange/UpdateFinish.jsp");

	}

}
