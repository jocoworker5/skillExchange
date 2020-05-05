package tw.leonchen.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

@WebServlet("/TestSpringJndiActionServletEx1")
public class TestSpringJndiActionServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;
	
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		context =WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			HouseService houseService = (HouseService)context.getBean("houseService");
			House hBean = houseService.select(1001);
			out.println("Id1:" + hBean.getHouseid() + "<br/>");
			out.println("Name1:" + hBean.getHousename() + "<br/>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Done");
			((ConfigurableApplicationContext)context).close();
			out.close();
		}
	}

}
