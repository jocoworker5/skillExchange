package tw.leonchen.model;

import org.springframework.stereotype.Component;

@Component(value = "user1")
//@Component("user1")
public class Users {
	private int id;
	private String username;
	private String userpwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}
