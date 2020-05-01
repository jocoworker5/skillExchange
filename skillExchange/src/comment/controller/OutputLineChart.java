package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.bean.LChartBean;
import comment.service.CommentServiceIMPL;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class OutputLineChart
 */
@WebServlet(urlPatterns = {"/OutputLineChart","/page2/dist/OutputLineChart"})
public class OutputLineChart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentServiceIMPL csi = new CommentServiceIMPL();
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
