package tw.leonchen.model;

import java.util.List;

public class HouseBeanService {

	private HouseBeanDAO hDao;

	public HouseBeanService(HouseBeanDAO hDao) {
		this.hDao = hDao;
	}

	public HouseBean insertData(HouseBean hBean) {
		HouseBean hB1 = hDao.insertData(hBean);
		return hB1;
	}

	public HouseBean queryData(int id) {
		HouseBean hb1 = hDao.queryData(id);
		return hb1;
	}

	public List<HouseBean> queryAllData() {
		List<HouseBean> list = hDao.queryAllData();
		return list;
	}

	public HouseBean updateData(int id, String houseName) {
		HouseBean hb1 = hDao.updateData(id, houseName);
		return hb1;
	}

	public boolean deleteData(int id) {
		boolean status = hDao.deleteData(id);
		return status;
	}

}
