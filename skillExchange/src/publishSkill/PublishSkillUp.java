package publishSkill;

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

import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;
import publishPage.Service.PublishPageService;
import skillexchange.HibernateUtil;

@WebServlet("/PublishSkillUp")
public class PublishSkillUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	Session session;
	HttpSession httpSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession httpSession = request.getSession();
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			PublishPageService service = new PublishPageService(session);
			List<publishSelectBean> list = service.Skill();
//		for(publishSelectBean pBean :list) {
//			 System.out.println(pBean.getSkillNameCN());
//		}
			List<publishAreaBean> area = service.Area();
			List<publishCityBean> city = service.City();

			httpSession.setAttribute("skill", list);
			httpSession.setAttribute("area", area);
			httpSession.setAttribute("city", city);

			response.sendRedirect(request.getContextPath() + "/UpdatePage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
