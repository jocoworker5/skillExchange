package tw.leonchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import skillexchange.HibernateUtil;
import tw.leonchen.model.Book;

@WebServlet("/TestHibernateJndiActionServletEx1")
public class TestHibernateJndiActionServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			factory = HibernateUtil.getSessionFactory();
			List<Book> books = processBookQuery();
			for(Book book: books) {
				out.write("ID:" + book.getId() + "<br/>");
				out.write("Book Name:" + book.getBookname() + "<br/>");
				out.write("Author:" + book.getAuthor() + "<br/>");
				out.write("Price:" + book.getPrice() + "<br/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Done");
			out.close();
		}
	}

	private List<Book> processBookQuery() {
		Query<Book> query = factory.getCurrentSession().createQuery("from Book", Book.class);
		return (List<Book>) query.list();
	}

}
