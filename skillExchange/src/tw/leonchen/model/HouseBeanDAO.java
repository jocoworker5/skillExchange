package tw.leonchen.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDAO implements IHouseBeanDAO{
	private Session session;

	public HouseBeanDAO(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public HouseBean insertData(HouseBean hBean) {
		HouseBean myBean = getSession().get(HouseBean.class, hBean.getHouseid());
		
		if(myBean==null) {
			getSession().save(hBean);
			return hBean;
		}
		
		return null;
	}
	
	public HouseBean queryData(int id) {
		HouseBean myBean = getSession().get(HouseBean.class, id);
		return myBean;
	}
	
	public List<HouseBean> queryAllData() {
		Query<HouseBean> query = getSession().createQuery("From HouseBean", HouseBean.class);
		List<HouseBean> list = query.list();
		return list;
	}
	
	public HouseBean updateData(int id, String houseName) {
		HouseBean myBean = getSession().get(HouseBean.class, id);
		
		if(myBean!=null) {
			myBean.setHousename(houseName);
			getSession().update(myBean);
		}
		
		return myBean;
	}
	
	public boolean deleteData(int id) {
		HouseBean myBean = getSession().get(HouseBean.class, id);
		
		if(myBean!=null) {
			getSession().delete(myBean);
			return true;
		}
		
		return false;
	}

}













