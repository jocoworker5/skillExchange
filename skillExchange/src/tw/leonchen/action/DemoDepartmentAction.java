package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import skillexchange.HibernateUtil;
import tw.leonchen.model.Department;

public class DemoDepartmentAction {

	public static void main(String[] args) {
		//StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		//SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//Session session = factory.openSession();
		Session session = factory.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		Department dBean = new Department();
		dBean.setDeptname("HR");
		session.save(dBean);
		
		ts.commit();
		//session.close();
		//factory.close();
		HibernateUtil.closeSessionFactory();

	}

}
