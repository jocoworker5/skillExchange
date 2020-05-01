package comment.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;

import comment.bean.BarcharBean;
import comment.service.CommentServiceIMPL;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class OutputBarChart
 */
@WebServlet(urlPatterns = {"/OutputBarChart","/page2/dist/OutputBarChart"})
public class OutputBarChart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//        response.setContentType("text/html,charset=UTF-8");
		String year = request.getParameter("year");
		String mon = request.getParameter("mon");
//		System.out.println(year);
//		System.out.println(mon);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CommentServiceIMPL service = new CommentServiceIMPL();
		BarcharBean bb = service.getWebCommentAvg(year, mon);
		JSONObject json = JSONObject.fromObject(bb.getOption());
		out.write(json.toString());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
