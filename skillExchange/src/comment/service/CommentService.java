package comment.service;

import java.util.List;

import com.github.abel533.echarts.Option;

import comment.bean.BarcharBean;
import comment.bean.CommentBean;
import comment.bean.LChartBean;



public interface CommentService {
	void insertComm(CommentBean cb);
	int deleteComm(int wb);	
	public List<CommentBean> publishComment();
	public List<CommentBean> getAllUserComments();
	int updateUserComm(int commentNo, int stat);
//	public CommentBean getUserComment();
	public BarcharBean getWebCommentAvg(String year, String mon);
	public List<LChartBean> getLineChart(String year);
//	
	public List<CommentBean> getAllWebComments();
//	int updateWebComm(CommentBean wb);
//	public CommentBean getWebCommentW();
	 public List<BarcharBean> watchingList(int grade);
}
