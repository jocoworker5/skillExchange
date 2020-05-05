package tw.leonchen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HouseDAO {
	@Autowired @Qualifier("sqlserverdataSource")
	private DataSource datasource;

//	@Autowired 
//	public HouseDAO(@Qualifier("sqlserverdataSource") DataSource datasource) {
//        this.datasource = datasource;
//	}
	
	public House select(int houseid) throws SQLException {
		Connection conn = datasource.getConnection();
		
		String sqlstr = "Select * From House Where houseid=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, houseid);
		
		ResultSet rs = preState.executeQuery();
		House hBean = null;
		if(rs.next()) {
			hBean = new House(rs.getInt(1), rs.getString(2));
		}
		
		rs.close();
		preState.close();
		conn.close();
		
		return hBean;		
	}

}
