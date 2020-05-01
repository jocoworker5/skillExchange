package publishPage.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publisharea")
public class publishAreaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer no;
	private String publishAreaId;
	private String publishAreaCN;
	private String publishAreaEN;
	
	public publishAreaBean() {
		
	}

	@Id
	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
    
	@Column(name = "publishAreaId")
	public String getPublishAreaId() {
		return publishAreaId;
	}

	public void setPublishAreaId(String publishAreaId) {
		this.publishAreaId = publishAreaId;
	}
    
	@Column(name = "publishAreaCN")
	public String getPublishAreaCN() {
		return publishAreaCN;
	}

	public void setPublishAreaCN(String publishAreaCN) {
		this.publishAreaCN = publishAreaCN;
	}
    
	@Column(name = "publishAreaEN")
	public String getPublishAreaEN() {
		return publishAreaEN;
	}

	public void setPublishAreaEN(String publishAreaEN) {
		this.publishAreaEN = publishAreaEN;
	}


	
}
