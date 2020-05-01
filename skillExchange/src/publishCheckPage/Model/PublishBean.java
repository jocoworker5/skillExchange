package publishCheckPage.Model;

import java.io.Serializable;

public class PublishBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String publishTitle;
    private String publishDetail;
    private String publishArea;
    private String city;
    private String district;
    private String road;
    private String publishPlace;
    private String publishPic;
    private String ownSkill;
    private String wantSkill;
    private int publishCTR;
    private String publishMark;
    private int status;
    private String skillType;
    
    public PublishBean() {
    	
    }
    public PublishBean(String publishTitle,String publishDetail,String publishArea,String city
    		,String district,String road,String publishPlace,String publishPic
    		,String ownSkill,String wantSkill,String publishMark,String skillType) {
    	
    	super();
    	this.publishTitle = publishTitle;
    	this.publishDetail = publishDetail;
    	this.publishArea = publishArea;
    	this.city = city;
    	this.district = district;
    	this.road = road;
    	this.publishPlace = publishPlace;
    	this.publishPic = publishPic;
    	this.ownSkill = ownSkill;
    	this.wantSkill = wantSkill;  
    	this.publishMark = publishMark;
    	this.skillType = skillType;
    }
    @Override
    public String toString() {
    	return "["+publishTitle+","+publishDetail+","+publishArea+","+city+","
    			+ ""+district+","+road+","+publishPlace+","+publishPic+","+ownSkill+","
    					+ ""+wantSkill+","+publishCTR+","+publishMark+","+status+","+skillType+"]";
    }
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getPublishTitle() {
		return publishTitle;
	}
	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}
	public String getPublishDetail() {
		return publishDetail;
	}
	public void setPublishDetail(String publishDetail) {
		this.publishDetail = publishDetail;
	}
	public String getPublishArea() {
		return publishArea;
	}
	public void setPublishArea(String publishArea) {
		this.publishArea = publishArea;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getPublishPlace() {
		return publishPlace;
	}
	public void setPublishPlace(String publishPlace) {
		this.publishPlace = publishPlace;
	}
	public String getPublishPic() {
		return publishPic;
	}
	public void setPublishPic(String publishPic) {
		this.publishPic = publishPic;
	}
	public String getOwnSkill() {
		return ownSkill;
	}
	public void setOwnSkill(String ownSkill) {
		this.ownSkill = ownSkill;
	}
	public String getWantSkill() {
		return wantSkill;
	}
	public void setWantSkill(String wantSkill) {
		this.wantSkill = wantSkill;
	}
	public int getPublishCTR() {
		return publishCTR;
	}
	public void setPublishCTR(int publishCTR) {
		this.publishCTR = publishCTR;
	}
	public String getPublishMark() {
		return publishMark;
	}
	public void setPublishMark(String publishMark) {
		this.publishMark = publishMark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
}
