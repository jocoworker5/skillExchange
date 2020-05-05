package tw.leonchen.model;

import org.springframework.stereotype.Component;

@Component
public class House {

	private int houseid;
	private String housename;

	public House() {
	}
	
	public House(int houseid, String housename) {
		this.houseid = houseid;
		this.housename = housename;
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

}
