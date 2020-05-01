package publishCheckPage.Model;

import java.sql.SQLException;
import java.text.ParseException;


public interface PublishDao {

	PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException;
	
}