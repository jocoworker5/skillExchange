package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comment.bean.LChartBean;
import comment.service.CommentServiceIMPL;
import net.sf.json.JSONArray;
import skillexchange.HibernateUtil;

/**
 * Servlet implementation class OutputLineChart
 */
@WebServlet(urlPatterns = {"/OutputLineChart","/page2/dist/OutputLineChart"})
public class OutputLineChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	Session session;
	HttpSession httpSession;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		CommentServiceIMPL csi = new CommentServiceIMPL(session);
//		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("yearmonths");
//		System.out.println(year);
//		year="2020";
		List<LChartBean> list = csi.getLineChart(year);
		JSONArray jsonArr=JSONArray.fromObject(list);
//		System.out.println(jsonArr.toString());
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(jsonArr.toString());
		out.flush();
		out.close();
		
		session.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
