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
import javax.sql.DataSource;

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

import net.sf.json.JSONObject;

//import javax.naming.InitialContext;
//import javax.sql.DataSource;

public class CommentjdbcDAOIMPL implements CommentDAO {
	String jndiString = "java:comp/env/jdbc/dataBase";
	DataSource ds;

	public CommentjdbcDAOIMPL() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CommentBean> getAllUserComments() {
		List<CommentBean> list = new ArrayList<>();

		String sql = "SELECT commentNo, commentorNo, memberName, msgTime, exGrading, memCommented, msgDetail, stat FROM Webusercomment";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
//					System.out.println(rs.getInt("commentNo"));
				CommentBean wb = new CommentBean(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getTimestamp(4),
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
				list.add(wb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public int updateUserComm(int commentNo, int stat) {
		int updateNum = 0;

		String sql = "update Webusercomment set stat = ? where CommentNo = ?";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			if (stat == 0) {
				pstmt.setInt(1, 1);
			} else {
				pstmt.setInt(1, 0);
			}
			pstmt.setInt(2, commentNo);
			updateNum = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return updateNum;
	}

	@Override
	public CommentBean getUserComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentBean> getAllWebComments() {
		List<CommentBean> list = new ArrayList<>();

		String sql = "SELECT commentNo, commentorNo, memberName, msgTime, webGrading, webFluency,webSatis, webRecommend,webSugg FROM Webusercomment";

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
//				System.out.println(rs.getInt("commentNo"));
				CommentBean wb = new CommentBean(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getTimestamp(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9));

				list.add(wb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public void insertComm(CommentBean mb) {

		String sql = "INSERT INTO Webusercomment (commentorNo, memberName, webGrading, webFluency, webSatis, webRecommend, webSugg, exGrading,  memCommented, msgDetail) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, mb.getCommentorNo()); // 非使用者輸入，從session取得
			pstmt.setString(2, mb.getMemberName());// 非使用者輸入，從session取得
			pstmt.setInt(3, mb.getWebGrading());
			pstmt.setInt(4, mb.getWebFluency());
			pstmt.setInt(5, mb.getWebSatis());
			pstmt.setInt(6, mb.getWebRecommend());
			pstmt.setString(7, mb.getWebSugg());
			pstmt.setInt(8, mb.getExGrading());
			pstmt.setInt(9, mb.getMemCommented());// 非使用者輸入，從session取得
			pstmt.setString(10, mb.getMsgDetail());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public int updateWebComm(CommentBean cb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComm(int commentNo) {
		int delnum = 0;

		String sql = "delete Webusercomment where commentNo = ?";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, commentNo);
			delnum = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return delnum;
	}

	@Override
	public CommentBean getWebCommentW() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BarcharBean getWebCommentAvg(String year, String mon) {
		BarcharBean bb = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();
		String sql = "select avg(CONVERT(decimal,webGrading)),avg(CONVERT(decimal,webFluency)),avg(CONVERT(decimal,webSatis)),avg(CONVERT(decimal,webRecommend)), count(*)  from Webusercomment where year(msgTime)= ? and  month(msgTime)= ? ";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

		) {

			pstmt.setString(1, year);
			pstmt.setString(2, mon);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				Option option = new Option();
				BigDecimal int1 = rs.getBigDecimal(1);
				BigDecimal int2 = rs.getBigDecimal(2);
				BigDecimal int3 = rs.getBigDecimal(3);
				BigDecimal int4 = rs.getBigDecimal(4);
				int int5 = rs.getInt(5);
				// 设置标题与子标题
				option.title().text("網站使用評分分析").subtext("纯属虚构").x(X.center).y(Y.top);
				// 设置右上角工具箱
				option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
				// 图例
//					    option.legend().data("蒸发量", "降水量");
				option.legend().data("評分").x(X.left).y(Y.top);
				// 设置 x 轴为类目轴, y 轴为值轴
				option.xAxis(new CategoryAxis().data("對網站評分", "網站使用流暢度", "交換滿意度", "推薦意願度"))
						.yAxis(new ValueAxis().max(10));
				// 气泡提示框
				option.tooltip().trigger(Trigger.axis);

				// 柱状数据, 实验嘛，就用模拟数据了。
				Bar bar1 = new Bar("評分");
				bar1.data(int1, int2, int3, int4);
				bar1.markPoint().data(new PointData().type(MarkType.max).name("最大值"),
						new PointData().type(MarkType.min).name("最小值"));
				bar1.markLine().data(new PointData().type(MarkType.average).name("平均值"));

				// 又一个柱状数据
//					    Bar bar2 = new Bar("降水量");
//					    bar2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
//					    bar2.markPoint().data(new PointData().type(MarkType.max).name("最大值"),
//					            new PointData().type(MarkType.min).name("最小值"));
//					    bar2.markLine().data(new PointData().type(MarkType.average).name("平均值"));

				// 向 Option 中设置数据
				option.series(bar1);
				bb = new BarcharBean(int1, int2, int3, int4, int5, option);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bb;
		// 折線圖
//		Option option = new Option();
//		option.legend("高度(km)与气温(°C)变化关系");
//
//		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
//				Tool.restore, Tool.saveAsImage);
//
//		option.calculable(true);
//		option.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}km : {c}°C");
//
//		ValueAxis valueAxis = new ValueAxis();
//		valueAxis.axisLabel().formatter("{value} °C");
//		option.xAxis(valueAxis);
//
//		CategoryAxis categoryAxis = new CategoryAxis();
//		categoryAxis.axisLine().onZero(false);
//		categoryAxis.axisLabel().formatter("{value} km");
//		categoryAxis.boundaryGap(false);
//		categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
//		option.yAxis(categoryAxis);
//
//		Line line = new Line();
//		line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5)
//				.itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
//		option.series(line);

//		option.exportToHtml("line5.html");
//		option.view();

	}

	@Override
	public List<LChartBean> getLineChart(String year) {
		ResultSet rs = null;
		ArrayList<LChartBean> list = new ArrayList<>();

		try (Connection con = ds.getConnection(); CallableStatement pstmt = con.prepareCall("{Call sp_chart(?)}")

		) {
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				LChartBean lb = new LChartBean(rs.getInt(1), rs.getBigDecimal(2), rs.getBigDecimal(3),
						rs.getBigDecimal(4), rs.getBigDecimal(5));
				list.add(lb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public List<CommentBean> publishComment() {
		List<CommentBean> list = new ArrayList<>();

		String sql = "SELECT top 5 msgTime, exGrading, msgDetail FROM Webusercomment where stat=1 order by msgTime desc";

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
//				System.out.println(rs.getInt("commentNo"));
				CommentBean wb = new CommentBean(rs.getTimestamp(1), rs.getInt(2), rs.getString(3));
				list.add(wb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public List<CommentBean> watchingList(int grade) {
		List<CommentBean> list = new ArrayList<>();
		ResultSet rs=null;
		String sql = "select memCommented, count(exGrading)  from Webusercomment where exGrading < ? group by  memCommented order by count(exGrading) desc";
        
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1, grade);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentBean wb = new CommentBean(rs.getInt(1), rs.getInt(2));
				list.add(wb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return list;

	}

}
