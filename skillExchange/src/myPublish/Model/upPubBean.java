package myPublish.Model;

import java.io.Serializable;

public class upPubBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	String myTitle;
	String myDetail;
	String myArea;
	String myCity;
	String myDistrict;
	String myRoad;
	String myPlace;
	String myOwnSkill;
	String myWantSkill;
	String myMark;
	String publishNo;
	
	public upPubBean() {
		
	}
	public upPubBean(String myTitle,String myDetail,String myArea,String myCity,String myDistrict
			,String myRoad,String myPlace,String myOwnSkill,String myWantSkill,String myMark,String publishNo) {
		
		super();
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
		this.publishNo = publishNo;
	}
	@Override
	public String toString() {
		return "upPubBean [myTitle=" + myTitle + ", myDetail=" + myDetail + ", myArea=" + myArea + ", myCity=" + myCity
				+ ", myDistrict=" + myDistrict + ", myRoad=" + myRoad + ", myPlace=" + myPlace + ", myOwnSkill="
				+ myOwnSkill + ", myWantSkill=" + myWantSkill + ", myMark=" + myMark + ", publishNo=" + publishNo + "]";
	}
	public String getMyTitle() {
		return myTitle;
	}
	public void setMyTitle(String myTitle) {
		this.myTitle = myTitle;
	}
	public String getMyDetail() {
		return myDetail;
	}
	public void setMyDetail(String myDetail) {
		this.myDetail = myDetail;
	}
	public String getMyArea() {
		return myArea;
	}
	public void setMyArea(String myArea) {
		this.myArea = myArea;
	}
	public String getMyCity() {
		return myCity;
	}
	public void setMyCity(String myCity) {
		this.myCity = myCity;
	}
	public String getMyDistrict() {
		return myDistrict;
	}
	public void setMyDistrict(String myDistrict) {
		this.myDistrict = myDistrict;
	}
	public String getMyRoad() {
		return myRoad;
	}
	public void setMyRoad(String myRoad) {
		this.myRoad = myRoad;
	}
	public String getMyPlace() {
		return myPlace;
	}
	public void setMyPlace(String myPlace) {
		this.myPlace = myPlace;
	}
	public String getMyOwnSkill() {
		return myOwnSkill;
	}
	public void setMyOwnSkill(String myOwnSkill) {
		this.myOwnSkill = myOwnSkill;
	}
	public String getMyWantSkill() {
		return myWantSkill;
	}
	public void setMyWantSkill(String myWantSkill) {
		this.myWantSkill = myWantSkill;
	}
	public String getMyMark() {
		return myMark;
	}
	public void setMyMark(String myMark) {
		this.myMark = myMark;
	}
	public String getPublishNo() {
		return publishNo;
	}
	public void setPublishNo(String publishNo) {
		this.publishNo = publishNo;
	}
	

}
