package tw.leonchen.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class OpenSessionViewFilter implements Filter {

	private SessionFactory sessionFactory;
	private WebApplicationContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String sessionFactoryBeanName = filterConfig.getInitParameter("sessionFactoryBeanName");
		ServletContext application = filterConfig.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		sessionFactory = (SessionFactory)context.getBean(sessionFactoryBeanName);		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Transaction Begin.");
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Transaction RollBack.");
			e.printStackTrace();
		} finally {
			System.out.println("Session Closed.");
			((ConfigurableApplicationContext)context).close();
		}
	}

	@Override
	public void destroy() {
	}

}
