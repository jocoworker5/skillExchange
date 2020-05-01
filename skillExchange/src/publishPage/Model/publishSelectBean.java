package publishPage.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class publishSelectBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer skillno;
	private String SkillNameCN;
	private String skillNameEN;
	private String typeCN;
	private String typeEN;

	public publishSelectBean() {

	}

	@Id
	@Column(name = "skillno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSkillno() {
		return skillno;
	}

	public void setSkillno(Integer skillno) {
		this.skillno = skillno;
	}

	@Column(name = "skillnamecn")
	public String getSkillNameCN() {
		return SkillNameCN;
	}

	public void setSkillNameCN(String skillNameCN) {
		SkillNameCN = skillNameCN;
	}

	@Column(name = "skillnameen")
	public String getSkillNameEN() {
		return skillNameEN;
	}

	public void setSkillNameEN(String skillNameEN) {
		this.skillNameEN = skillNameEN;
	}
	@Column(name = "typecn")
	public String getTypeCN() {
		return typeCN;
	}

	public void setTypeCN(String typeCN) {
		this.typeCN = typeCN;
	}
	@Column(name = "typeen")
	public String getTypeEN() {
		return typeEN;
	}

	public void setTypeEN(String typeEN) {
		this.typeEN = typeEN;
	}

}
