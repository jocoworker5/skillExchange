package publishPage.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class publishCityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cityCN;
	private String cityEN;
	private String publishAreaID;

	public publishCityBean() {

	}

	public publishCityBean(String CityCN, String PublishAreaID) {
		super();
		this.cityCN = CityCN;
		this.publishAreaID = PublishAreaID;
	}
    
	@Id
	@Column(name = "citycn")
	public String getCityCN() {
		return cityCN;
	}

	public void setCityCN(String citycn) {
		this.cityCN = citycn;
	}
    
	
	@Column(name = "cityen")
	public String getCityEN() {
		return cityEN;
	}

	public void setCityEN(String cityen) {
		this.cityEN = cityen;
	}
    
	
	@Column(name = "publishareaid")
	public String getPublishAreaID() {
		return publishAreaID;
	}

	public void setPublishAreaID(String publishAreaID) {
		this.publishAreaID = publishAreaID;
	}

}
