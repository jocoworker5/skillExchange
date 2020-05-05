package tw.leonchen.model;

import org.springframework.stereotype.Repository;

@Repository("usersDao")
public class UsersDAO {
   public boolean verifyProfile(Users users) {
	   if(users.getUsername()!=null && users.getUserpwd()!=null) {
		   return true;
	   }
	   return false;
   }
}
