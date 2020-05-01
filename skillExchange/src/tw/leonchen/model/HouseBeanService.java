package tw.leonchen.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanService {

	private HouseBeanDAO hDao;
	private Session session;

	public HouseBeanService(Session session) {
		this.session = session;
		hDao = new HouseBeanDAO(session);
	}

	@Override
	public HouseBean insertData(HouseBean hBean) {
		session.beginTransaction();
		HouseBean hB1 = hDao.insertData(hBean);
		session.getTransaction().commit();
		return hB1;
	}

	@Override
	public HouseBean queryData(int id) {
		session.beginTransaction();
		HouseBean hb1 = hDao.queryData(id);
		session.getTransaction().commit();
		return hb1;
	}

	@Override
	public List<HouseBean> queryAllData() {
		session.beginTransaction();
		List<HouseBean> list = hDao.queryAllData();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public HouseBean updateData(int id, String houseName) {
		session.beginTransaction();
		HouseBean hb1 = hDao.updateData(id, houseName);
		session.getTransaction().commit();
		return hb1;
	}

	@Override
	public boolean deleteData(int id) {
		session.beginTransaction();
		boolean status = hDao.deleteData(id);
		session.getTransaction().commit();
		return status;
	}

}
