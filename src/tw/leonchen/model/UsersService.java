package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService {

	@Autowired @Qualifier(value = "usersDao")
	private UsersDAO usersDao;

//	//@Autowired
//	public UsersService(UsersDAO usersDao) {
//       this.usersDao = usersDao;
//	}
	
	public boolean verifyProfile(Users users) {
		return usersDao.verifyProfile(users);
	}

}
