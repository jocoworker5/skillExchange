package tw.leonchen.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.leonchen.model.HouseBean;
import tw.leonchen.model.HouseBeanService;

@WebServlet("/TestSpringJndiActionServletEx2")
public class TestSpringJndiActionServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			ServletContext application = this.getServletContext();
			context = WebApplicationContextUtils.getWebApplicationContext(application);
			
			SessionFactory sessionFactory =	(SessionFactory)context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			
			HouseBeanService houseBeanService = (HouseBeanService)context.getBean("houseBeanService");
			HouseBean hBean = houseBeanService.queryData(1001);
			out.println("Id1:" + hBean.getHouseid() + "<br/>");
			out.println("Name1:" + hBean.getHousename() + "<br/>");
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Done");
			((ConfigurableApplicationContext)context).close();
			out.close();
		}
	}

}
