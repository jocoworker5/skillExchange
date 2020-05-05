package tw.leonchen.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
	@Autowired
	private HouseDAO houseDao;

//	@Autowired
//	public HouseService(HouseDAO houseDao) {
//		this.houseDao = houseDao;
//	}
	
	public House select(int houseid) throws SQLException {
		return houseDao.select(houseid);
	}

}
