package myPublish.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myPublish.Model.MyPublishBean;
import myPublish.Service.myPublishService;

@WebServlet("/MyPublishImfor")
public class MyPublishImfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String publishNo = request.getParameter("publishNo");
		System.out.println(publishNo);
		int pubNo = Integer.parseInt(publishNo);
		
		myPublishService service = new myPublishService();
		List<MyPublishBean> mylistimfor = service.myPublishimf(pubNo);
		
		session.setAttribute("mylistimfor",mylistimfor);
		
		response.sendRedirect(request.getContextPath()+"/myPublishImfor.jsp");	
	}	
}
