package publishPage.Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class PublishPageDao {
	private Session session;

	public PublishPageDao(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishSelectBean> Skill() {

//		String selSkill = "Select SkillNameCN from Skill";

		Query query = getSession().createQuery("from publishSelectBean");
		List<publishSelectBean> skillBeans = query.list();
		return skillBeans;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishAreaBean> Area() {

//		String Area = "Select PublishAreaCN,PublishAreaID from PublishArea";

		
		Query query = getSession().createQuery("from publishAreaBean");
		List<publishAreaBean> areaBeans = query.list();
		return areaBeans;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishCityBean> City() {

//		String City = "Select CityCN,PublishAreaID from City";

		
		Query query = getSession().createQuery("from publishCityBean");
		List<publishCityBean> cityBeans = query.list();
		return cityBeans;
	}
}
