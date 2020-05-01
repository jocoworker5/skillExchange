package myPublish.Model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publish")
public class MyPublishBean implements Serializable {
	private static final long serialVersionUID = 1L;

	int publishNo;
	int memberRegNo;
	String myTitle;
	String myDetail;
	String myArea;
	String myCity;
	String myDistrict;
	String myRoad;
	String myPlace;
	String publishPic;
	String myOwnSkill;
	String myWantSkill;
	Timestamp updateTime;
	Integer publishctr;
	String myMark;
	String status;
	String skillType;

	public MyPublishBean() {

	}

//	public MyPublishBean(int publishNo,String myTitle,String myDetail,String myArea,String myCity,String myDistrict
//			,String myRoad,String myPlace,String myOwnSkill,String myWantSkill,String myMark) {
//		
//		super();
//		this.publishNo = publishNo;
//		this.myTitle = myTitle;
//		this.myDetail = myDetail;
//		this.myArea = myArea;
//		this.myCity = myCity;
//		this.myDistrict = myDistrict;
//		this.myRoad = myRoad;
//		this.myPlace = myPlace;
//		this.myOwnSkill = myOwnSkill;
//		this.myWantSkill = myWantSkill;
//		this.myMark = myMark;
//	}
//	
//	@Override
//	public String toString() {
//		return "["+publishNo+","+myTitle+","+myDetail+","+myArea+","+myCity+","+myDistrict+""
//				+ ","+myRoad+","+myPlace+","+myOwnSkill+","+myWantSkill+","+myMark+"]";
//	}


	public MyPublishBean(int publishNo, String myTitle, String myDetail, String myArea, String myCity, String myDistrict,
		String myRoad, String myPlace, String myOwnSkill, String myWantSkill, String myMark) {
	super();
	this.publishNo = publishNo;
	this.myTitle = myTitle;
	this.myDetail = myDetail;
	this.myArea = myArea;
	this.myCity = myCity;
	this.myDistrict = myDistrict;
	this.myRoad = myRoad;
	this.myPlace = myPlace;
	this.myOwnSkill = myOwnSkill;
	this.myWantSkill = myWantSkill;
	this.myMark = myMark;
}

	@Id
	@Column(name = "publishno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPublishNo() {
		return publishNo;
	}

	public void setPublishNo(int publishNo) {
		this.publishNo = publishNo;
	}

	@Column(name = "memberregno")
	public int getMemberRegNo() {
		return memberRegNo;
	}

	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	@Column(name = "publishtitle")
	public String getMyTitle() {
		return myTitle;
	}

	public void setMyTitle(String myTitle) {
		this.myTitle = myTitle;
	}

	@Column(name = "publishdetail")
	public String getMyDetail() {
		return myDetail;
	}

	public void setMyDetail(String myDetail) {
		this.myDetail = myDetail;
	}

	@Column(name = "publisharea")
	public String getMyArea() {
		return myArea;
	}

	public void setMyArea(String myArea) {
		this.myArea = myArea;
	}

	@Column(name = "city")
	public String getMyCity() {
		return myCity;
	}

	public void setMyCity(String myCity) {
		this.myCity = myCity;
	}

	@Column(name = "district")
	public String getMyDistrict() {
		return myDistrict;
	}

	public void setMyDistrict(String myDistrict) {
		this.myDistrict = myDistrict;
	}

	@Column(name = "road")
	public String getMyRoad() {
		return myRoad;
	}

	public void setMyRoad(String myRoad) {
		this.myRoad = myRoad;
	}

	@Column(name = "publishplace")
	public String getMyPlace() {
		return myPlace;
	}

	public void setMyPlace(String myPlace) {
		this.myPlace = myPlace;
	}
	
	@Column(name = "publishpic")
	public String getPublishPic() {
		return publishPic;
	}

	public void setPublishPic(String publishPic) {
		this.publishPic = publishPic;
	}

	@Column(name = "ownskill")
	public String getMyOwnSkill() {
		return myOwnSkill;
	}

	public void setMyOwnSkill(String myOwnSkill) {
		this.myOwnSkill = myOwnSkill;
	}

	@Column(name = "wantskill")
	public String getMyWantSkill() {
		return myWantSkill;
	}

	public void setMyWantSkill(String myWantSkill) {
		this.myWantSkill = myWantSkill;
	}

	@Column(name = "publishmark")
	public String getMyMark() {
		return myMark;
	}

	public void setMyMark(String myMark) {
		this.myMark = myMark;
	}

	
	@Column(name = "updatetime")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "publishCTR")
	public Integer getPublishctr() {
		return publishctr;
	}

	public void setPublishctr(Integer publishctr) {
		this.publishctr = publishctr;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "skilltype")
	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

}
