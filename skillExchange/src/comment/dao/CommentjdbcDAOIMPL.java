package comment.dao;

import java.math.BigDecimal;
import java.security.interfaces.RSAKey;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.naming.InitialContext;
import javax.persistence.ParameterMode;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.series.Bar;

import comment.bean.BarcharBean;
import comment.bean.CommentBean;
import comment.bean.LChartBean;
import myPublish.Model.MyPublishBean;
import net.sf.json.JSONObject;

//import javax.naming.InitialContext;
//import javax.sql.DataSource;

public class CommentjdbcDAOIMPL implements CommentDAO {
	private Session session;
//	String jndiString = "java:comp/env/jdbc/dataBase";
//	DataSource ds;
//
//	public CommentjdbcDAOIMPL() {
//		try {
//			InitialContext ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup(jndiString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public CommentjdbcDAOIMPL(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@Override
	public List<CommentBean> getAllUserComments() {

		Query query = getSession().createQuery("from CommentBean");
		List<CommentBean> list = query.list();

		return list;
	}

	@Override
	public int updateUserComm(int commentNo, int stat) {
		int updateNum = 0;
		String hql = "update CommentBean p set p.stat = :stat where p.commentNo = :commentNo";
		Query query = getSession().createQuery(hql);
		if (stat == 0) {
			stat = 1;
		} else {
			stat = 0;
		}
		query.setParameter("stat", stat);
		query.setParameter("commentNo", commentNo);
		query.executeUpdate();
		return updateNum;
	}
//
//	@Override
//	public CommentBean getUserComment() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<CommentBean> getAllWebComments() {
		String hql = "SELECT w.commentNo, w.commentorNo, w.memberName, w.msgTime, w.webGrading, w.webFluency,w.webSatis, w.webRecommend,w.webSugg FROM CommentBean w";
		Query query = getSession().createQuery("from CommentBean");
		List<CommentBean> list = query.list();
		return list;
	}

	@Override
	public void insertComm(CommentBean mb) {

		String sql = "INSERT INTO Webusercomment (commentorNo, memberName, webGrading, webFluency, webSatis, webRecommend, webSugg, exGrading,  memCommented, msgDetail) VALUES(?,?,?,?,?,?,?,?,?,?)";

		session.save(mb);
//		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
//			pstmt.setInt(1, mb.getCommentorNo()); // 非使用者輸入，從session取得
//			pstmt.setString(2, mb.getMemberName());// 非使用者輸入，從session取得
//			pstmt.setInt(3, mb.getWebGrading());
//			pstmt.setInt(4, mb.getWebFluency());
//			pstmt.setInt(5, mb.getWebSatis());
//			pstmt.setInt(6, mb.getWebRecommend());
//			pstmt.setString(7, mb.getWebSugg());
//			pstmt.setInt(8, mb.getExGrading());
//			pstmt.setInt(9, mb.getMemCommented());// 非使用者輸入，從session取得
//			pstmt.setString(10, mb.getMsgDetail());
//			pstmt.executeUpdate();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}

//	@Override
//	public int updateWebComm(CommentBean cb) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
	@Override
	public int deleteComm(int commentNo) {
		CommentBean cb = getSession().get(CommentBean.class, commentNo);
		if (cb != null) {
			getSession().delete(cb);
			return 1;
		}
		return 0;
	}

//	@Override
//	public CommentBean getWebCommentW() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//

	public BarcharBean getWebCommentAvg(String year, String mon) {
		BarcharBean bb = null;
		ResultSet rs = null;
//		String sql = "select avg(CONVERT(decimal,webGrading)),avg(CONVERT(decimal,webFluency)),avg(CONVERT(decimal,webSatis)),avg(CONVERT(decimal,webRecommend)), count(*)  from Webusercomment where year(msgTime)= ? and  month(msgTime)= ? ";
		String hql = "select avg(cast ( p.webGrading as double)),avg(cast (p.webFluency as double)),avg(cast( p.webSatis as double)),avg(cast (p.webRecommend as double)), cast(count(*) as double)  from CommentBean p where YEAR(p.msgTime)= :year and  MONTH(p.msgTime)= :month ";
		try {
			Query query = getSession().createQuery(hql);
			query.setParameter("year", Integer.valueOf(year));
			query.setParameter("month", Integer.valueOf(mon));
			@SuppressWarnings("unchecked")
			List<Object[]> listdb = query.list();
			if (listdb.size() > 0) {

				Option option = new Option();
				Double int1 = (Double) listdb.get(0)[0];
				Double int2 = (Double) listdb.get(0)[1];
				Double int3 = (Double) listdb.get(0)[2];
				Double int4 = (Double) listdb.get(0)[3];
				Double int5 = (Double) listdb.get(0)[4];
				option.title().text("網站使用評分分析").subtext("纯属虚构").x(X.center).y(Y.top);
				option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
				option.legend().data("評分").x(X.left).y(Y.top);
				option.xAxis(new CategoryAxis().data("對網站評分", "網站使用流暢度", "交換滿意度", "推薦意願度"))
						.yAxis(new ValueAxis().max(10));
				option.tooltip().trigger(Trigger.axis);
				Bar bar1 = new Bar("評分");
				bar1.data(int1, int2, int3, int4);
				bar1.markPoint().data(new PointData().type(MarkType.max).name("最大值"),
						new PointData().type(MarkType.min).name("最小值"));
				bar1.markLine().data(new PointData().type(MarkType.average).name("平均值"));

				option.series(bar1);
				bb = new BarcharBean(int1, int2, int3, int4, int5, option);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bb;
	}

	@Override
	public List<LChartBean> getLineChart(String year) {
		ArrayList<LChartBean> list = new ArrayList<>();
		String hql = "select Month(msgtime) ,  avg(cast ( p.webGrading as double)),avg(cast (p.webFluency as double)),avg(cast( p.webSatis as double)),avg(cast (p.webRecommend as double)) from CommentBean p  where YEAR(p.msgTime)= :year group by YEAR(p.msgTime),MONTH(p.msgTime) order by YEAR(p.msgTime), MONTH(p.msgTime) asc";
		Query query = session.createQuery(hql);
		query.setParameter("year", Integer.valueOf(year));
		List<Object[]> result = query.list();
		for (int i = 0; i < result.size(); i++) {
			LChartBean lb = new LChartBean((Integer) result.get(i)[0], (Double) result.get(i)[1],
					(Double) result.get(i)[2], (Double) result.get(i)[3], (Double) result.get(i)[4]);
			list.add(lb);
		}
		return list;
	}

//
	@Override
	public List<CommentBean> publishComment() {
//		List<CommentBean> list = new ArrayList<>();
//p.msgTime, p.exGrading, p.msgDetail top5
		String hql = "SELECT p FROM CommentBean p where p.stat=1 order by p.msgTime desc";
        Query query = getSession().createQuery(hql);
//        query.setFirstResult(1);
//        query.setMaxResults(5);
        List<CommentBean> list = query.list();
		return list;
	}

	@Override
	public List<BarcharBean> watchingList(int grade) {
		List<BarcharBean> list1 = new ArrayList<>();
//		String sql = "select memCommented, count(exGrading)  from Webusercomment where exGrading < ? group by  memCommented order by count(exGrading) desc";
        String hql="select p.memCommented, count(p.exGrading)  from CommentBean p where p.exGrading <:exGrading group by  p.memCommented order by count(p.exGrading) desc";
        Query query = getSession().createQuery(hql);
        query.setParameter("exGrading", grade);
        List<Object[]>list = query.list();
//         System.out.println(list.get(0)[0].getClass().getName());
//         System.out.println(list.get(0)[1].getClass().getName());
			for(int i=0; i<list.size();i++) {
				BarcharBean wb = new BarcharBean((Integer)list.get(i)[0], (Long)list.get(i)[1]);
				list1.add(wb);
			}
		return list1;
	}

}
