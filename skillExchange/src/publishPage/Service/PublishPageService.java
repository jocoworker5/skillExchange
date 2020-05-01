package publishPage.Service;

import java.util.List;

import org.hibernate.Session;

import publishPage.Model.PublishPageDao;
import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;

public class PublishPageService {
	private PublishPageDao ppDao;
	private Session session;

	public PublishPageService(Session session) {
		this.session = session;
		ppDao = new PublishPageDao(session);
	}

	public List<publishSelectBean> Skill() {
		return ppDao.Skill();
	}

	public List<publishAreaBean> Area() {
		return ppDao.Area();
	}

	public List<publishCityBean> City() {
		return ppDao.City();
	}
}
