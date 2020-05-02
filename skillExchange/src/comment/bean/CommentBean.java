package comment.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "webusercomment")
public class CommentBean {
	private int commentNo;
	private int commentorNo;
	private String memberName;
	private java.sql.Timestamp msgTime;
	private int webGrading;
	private int webFluency;
	private int webSatis;
	private int webRecommend;
	private String webSugg;
	private int exGrading;
	private int memCommented;
	private String msgDetail;
	private int stat;

	public CommentBean() {
	}

	public CommentBean(int commentNo, int commentorNo, String memberName, Timestamp msgTime, int exGrading,
			int memCommented, String msgDetail, int stat) {
		super();
		this.commentNo = commentNo;
		this.commentorNo = commentorNo;
		this.memberName = memberName;
		this.msgTime = msgTime;
		this.exGrading = exGrading;
		this.memCommented = memCommented;
		this.msgDetail = msgDetail;
		this.stat = stat;
	}

	public CommentBean(Timestamp msgTime, int exGrading, String msgDetail) {
		super();
		this.msgTime = msgTime;
		this.exGrading = exGrading;
		this.msgDetail = msgDetail;
	}

	public CommentBean(int commentNo, int commentorNo, String memberName, Timestamp msgTime, int webGrading,
			int webFluency, int webSatis, int webRecommend, String webSugg) {
		super();
		this.commentNo = commentNo;
		this.commentorNo = commentorNo;
		this.memberName = memberName;
		this.msgTime = msgTime;
		this.webGrading = webGrading;
		this.webFluency = webFluency;
		this.webSatis = webSatis;
		this.webRecommend = webRecommend;
		this.webSugg = webSugg;
	}

	public CommentBean(int commentorNo, String memberName, int webGrading, int webFluency, int webSatis,
			int webRecommend, String webSugg, int exGrading, int memCommented, String msgDetail) {
		super();

		this.commentorNo = commentorNo;
		this.memberName = memberName;
		this.webGrading = webGrading;
		this.webFluency = webFluency;
		this.webSatis = webSatis;
		this.webRecommend = webRecommend;
		this.webSugg = webSugg;
		this.exGrading = exGrading;
		this.memCommented = memCommented;
		this.msgDetail = msgDetail;
	}

	public CommentBean(int memCommented, int exGradingCount) {
		super();
		this.exGrading = exGradingCount;
		this.memCommented = memCommented;
	}

	@Id
	@Column(name = "commentNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	@Column(name = "commentorno")
	public int getCommentorNo() {
		return commentorNo;
	}

	public void setCommentorNo(int commentorNo) {
		this.commentorNo = commentorNo;
	}

	@Column(name = "membername")
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "msgtime")
	public java.sql.Timestamp getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(java.sql.Timestamp msgTime) {
		this.msgTime = msgTime;
	}

	@Column(name = "webgrading")
	public int getWebGrading() {
		return webGrading;
	}

	public void setWebGrading(int webGrading) {
		this.webGrading = webGrading;
	}

	@Column(name = "webfluency")
	public int getWebFluency() {
		return webFluency;
	}

	public void setWebFluency(int webFluency) {
		this.webFluency = webFluency;
	}

	@Column(name = "websatis")
	public int getWebSatis() {
		return webSatis;
	}

	public void setWebSatis(int webSatis) {
		this.webSatis = webSatis;
	}

	@Column(name = "webrecommend")
	public int getWebRecommend() {
		return webRecommend;
	}

	public void setWebRecommend(int webRecommend) {
		this.webRecommend = webRecommend;
	}

	@Column(name = "websugg")
	public String getWebSugg() {
		return webSugg;
	}

	public void setWebSugg(String webSugg) {
		this.webSugg = webSugg;
	}

	@Column(name = "exgrading")
	public int getExGrading() {
		return exGrading;
	}

	public void setExGrading(int exGrading) {
		this.exGrading = exGrading;
	}

	@Column(name = "memcommented")
	public int getMemCommented() {
		return memCommented;
	}

	public void setMemCommented(int memCommented) {
		this.memCommented = memCommented;
	}

	@Column(name = "msgdetail")
	public String getMsgDetail() {
		return msgDetail;
	}

	public void setMsgDetail(String msgDetail) {
		this.msgDetail = msgDetail;
	}

	@Column(name = "stat")
	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

}
