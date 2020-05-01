package tw.leonchen.model;

import java.util.List;

public interface IHouseBeanDAO {
	public HouseBean insertData(HouseBean hBean);
	public HouseBean queryData(int id);
	public List<HouseBean> queryAllData();
	public HouseBean updateData(int id, String houseName);
	public boolean deleteData(int id);
}
