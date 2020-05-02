package comment.service;

import java.util.List;

import org.hibernate.Session;

import com.github.abel533.echarts.Option;

import comment.bean.BarcharBean;
import comment.bean.CommentBean;
import comment.bean.LChartBean;

import comment.dao.CommentjdbcDAOIMPL;

public class CommentServiceIMPL implements CommentService {
	CommentjdbcDAOIMPL uDao;
	private Session session;

	public CommentServiceIMPL(Session session) {
		this.session = session;
		uDao = new CommentjdbcDAOIMPL(session);
	}

	public CommentServiceIMPL(CommentjdbcDAOIMPL uDao) {
		super();
		this.uDao = uDao;
	}

	@Override
	public List<CommentBean> getAllUserComments() {
		// TODO Auto-generated method stub
		return uDao.getAllUserComments();
	}
//
	@Override
	public int updateUserComm(int CommentNo, int stat) {

		return uDao.updateUserComm(CommentNo, stat);
	}
//
//	@Override
//	public CommentBean getUserComment() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<CommentBean> getAllWebComments() {
		// TODO Auto-generated method stub
		return uDao.getAllWebComments();
	}
//
	@Override
	public void insertComm(CommentBean wb) {
		uDao.insertComm(wb);

	}
//
//	@Override
//	public int updateWebComm(CommentBean wb) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
	@Override
	public int deleteComm(int wb) {
		return uDao.deleteComm(wb);
	}
//
//	@Override
//	public CommentBean getWebCommentW() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	@Override
	public BarcharBean getWebCommentAvg(String year, String mon) {
		return uDao.getWebCommentAvg(year, mon);
	}
//
	@Override
	public List<LChartBean> getLineChart(String year) {
		return uDao.getLineChart(year);
	}
//
	@Override
	public List<CommentBean> publishComment() {
		return uDao.publishComment();
	}
//
	@Override
	public List<BarcharBean> watchingList(int grade) {

		return uDao.watchingList(grade);
	}

}
