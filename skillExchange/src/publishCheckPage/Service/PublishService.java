package publishCheckPage.Service;

import java.sql.SQLException;
import java.text.ParseException;

import publishCheckPage.Model.PublishBean;

public interface PublishService {

	PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException;

}