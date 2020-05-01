package myPublish.Service;

import java.util.List;

import org.hibernate.Session;

import myPublish.Model.MyPublishBean;
import myPublish.Model.MyPublishDao;
import myPublish.Model.upPubBean;

public class myPublishService {
	private MyPublishDao mlDao;
	private Session session;

	public myPublishService(Session session) {
		this.session = session;
		mlDao = new MyPublishDao(session);
	}

	public List<MyPublishBean> myPublish(int memberRegNo) {
		List<MyPublishBean> publishList = mlDao.myPublish(memberRegNo);
		return publishList;
	}

	public boolean myPubDele(int myPubNo) {
		return mlDao.myPubDele(myPubNo);
	}

	public MyPublishBean selUpdatePublish(int myPubNo) {
		System.out.println("service:" + myPubNo);
		return mlDao.selUpdatePublish(myPubNo);
	}
		public MyPublishBean datePublish(MyPublishBean bean) {
			return mlDao.datePublish(bean);
		}
//		public List<MyPublishBean> myPublishimf(int myPubNo){
//			return mlDao.myPublishimf(myPubNo);
//		}
}
