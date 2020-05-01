package publishCheckPage.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PublishDaoImpl implements PublishDao {
	DataSource ds = null;
	
	public PublishDaoImpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/dataBase");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "Insert into Publish (PublishTitle,PublishDetail,PublishArea,City"
			+ ",District,Road,PublishPlace,PublishPic,OwnSkill,WantSkill,upDateTime,PublishMark,Status,skillType,MemberRegNo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 

	@Override
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		PublishBean result = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT);
		){
			pstmt.setString(1, bean.getPublishTitle());
//			pstmt.setInt(2, 1120);
			pstmt.setString(2, bean.getPublishDetail());
			pstmt.setString(3, bean.getPublishArea());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getDistrict());
			pstmt.setString(6, bean.getRoad());
			pstmt.setString(7, bean.getPublishPlace());
			pstmt.setString(8, bean.getPublishPic());
			pstmt.setString(9, bean.getOwnSkill());
			pstmt.setString(10, bean.getWantSkill());
			
			java.util.Date date = new java.util.Date();
//			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			System.out.println(date.getTime());
//			Date now = format.parse(date.getTime());
//			Timestamp upDateTime = new java.sql.Timestamp(now.getTime());
			Timestamp upDateTime = new java.sql.Timestamp(date.getTime());
			
			System.out.println(upDateTime);
			
			pstmt.setTimestamp(11,upDateTime);
			pstmt.setString(12, bean.getPublishMark());
			pstmt.setInt(13, 1);
			pstmt.setString(14, bean.getSkillType());
			pstmt.setInt(15, 2);
			
			int i = pstmt.executeUpdate();
			if(i == 1) {
				result = this.select(bean.getPublishTitle());
			}
		}
		return result;
	}

	private PublishBean select(String publishTitle) {
		// TODO Auto-generated method stub
		return null;
	}

}
