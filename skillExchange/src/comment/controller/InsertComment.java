package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.bean.CommentBean;
import comment.service.CommentServiceIMPL;

/**
 * Servlet implementation class InsertComment
 */
@WebServlet(urlPatterns = {"/InsertComment","/page2/dist/InsertComment"})
public class InsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       int speed = Integer.valueOf(request.getParameter("speed"));
       int rec = Integer.valueOf(request.getParameter("rec"));
       int satis = Integer.valueOf(request.getParameter("ex"));
       int rating1 = Integer.valueOf(request.getParameter("rating"));
       String susg = request.getParameter("susg");
       int rating2 = Integer.valueOf(request.getParameter("rat"));
       String susg1 = request.getParameter("susg1");
       CommentBean cb = new CommentBean();
       cb.setCommentorNo(1); //未來從session.getAttribute()取得 
       cb.setMemberName("文采元"); //session.getAttribute()取得
       cb.setWebGrading(rating1);
       cb.setWebFluency(speed);
       cb.setWebSatis(satis);
       cb.setWebRecommend(rec);
       cb.setWebSugg(susg);
       cb.setExGrading(rating2);
       cb.setMemCommented(10); //session.getAttribute()取得
       cb.setMsgDetail(susg1);
       CommentServiceIMPL csi = new CommentServiceIMPL();
       csi.insertComm(cb);
       response.sendRedirect(request.getContextPath()+"/feedback.jsp");
//       RequestDispatcher rd = request.getRequestDispatcher("/page2/dist/feedback.jsp");
//       rd.forward(request, response);
//       return;	
	}

}
