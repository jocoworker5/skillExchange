package tw.leonchen.model;

public class LoginService {

	private LoginDAO loginDao;

	public LoginService() {
	}
	
	public LoginService(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	public void setLoginDao(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	public boolean checkLogin(String user, String pwd) {
		return loginDao.checkLogin(user, pwd);
	}

}
