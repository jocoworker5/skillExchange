package publishCheckPage.Service;

import java.sql.SQLException;
import java.text.ParseException;

import publishCheckPage.Model.PublishBean;
import publishCheckPage.Model.PublishDao;
import publishCheckPage.Model.PublishDaoImpl;

public class PublishServicelmpl implements PublishService  {
	
	PublishDao pubDao;
	
	public PublishServicelmpl() {
		pubDao = new PublishDaoImpl();
	}
	@Override
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		return pubDao.insertPublish(bean);
	}
	

}
