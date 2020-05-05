package tw.leonchen.model;

public class LoginDAO {

	public void init() {
		//System.out.println("init");
	}
	
	public boolean checkLogin(String user, String pwd) {
//	   if(user.equals("john") && pwd.equals("test123")) {
//		   return true;
//	   }
//	   return false;

		if ("john".equals(user) && "test123".equals(pwd)) {
			return true;
		}
		return false;
	}
	
	public void destroy() {
		//System.out.println("destroy");
	}
}
