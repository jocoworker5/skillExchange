package comment.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comment.bean.CommentBean;
import skillexchange.HibernateUtil;

public class Test {
	private static SessionFactory factory;
	static Session session;
	HttpSession httpSession;

	public static void main(String[] args) {
		factory = HibernateUtil.getSessionFactory();
		session = factory.getCurrentSession();	
	  CommentjdbcDAOIMPL cap = new CommentjdbcDAOIMPL(session);
	  List<CommentBean> pc = cap.publishComment();
	  System.out.println(pc.get(0).getCommentorNo());

	}

}
