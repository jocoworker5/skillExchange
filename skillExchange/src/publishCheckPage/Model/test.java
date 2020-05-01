package publishCheckPage.Model;

import java.util.List;

import publishPage.Model.PublishPageDao;
import publishPage.Model.publishSelectBean;

public class test {

	public static void main(String[] args) {
		PublishPageDao dao = new PublishPageDao();
		List<publishSelectBean> skill = dao.Skill();
	
	}

}
