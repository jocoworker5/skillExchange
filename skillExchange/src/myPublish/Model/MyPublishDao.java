package myPublish.Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MyPublishDao {
	private Session session;

	public MyPublishDao(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public List<MyPublishBean> myPublish(int memberRegNo) {
		@SuppressWarnings("unchecked")
		Query<MyPublishBean> query = getSession()
				.createQuery("select p from MyPublishBean p where p.memberRegNo = :memberRegNo");
		query.setParameter("memberRegNo", memberRegNo);
		List<MyPublishBean> myPublishBeans = query.list();
		return myPublishBeans;
	}

	public boolean myPubDele(int myPubNo) {

		MyPublishBean publishBean = getSession().get(MyPublishBean.class, myPubNo);

		if (publishBean != null) {
			getSession().delete(publishBean);
			return true;
		}

		return false;

	}

	public MyPublishBean selUpdatePublish(int myPubNo) {

//		System.out.println(a);

//		String hql = "Select PublishTitle,PublishDetail,PublishArea,City"
//				+ ",District,Road,PublishPlace,OwnSkill,WantSkill,PublishMark from Publish p where p.PublishNo = ? ";
//		System.out.println("dao:" + myPubNo);
		System.out.println(getSession().get(MyPublishBean.class, myPubNo));
		return getSession().get(MyPublishBean.class, myPubNo);

	}

	public MyPublishBean datePublish(MyPublishBean bean) {
		String hql = "Update MyPublishBean p set p.myTitle = :myTitle , p.myDetail = :myDetail , p.myArea = :myArea "
				+ ", p.myCity = :myCity , p.myDistrict = :myDistrict , p.myRoad = :myRoad , p.myPlace = :myPlace , p.myOwnSkill = :myOwnSkill , p.myWantSkill = :myWantSkill , p.myMark = :myMark "
				+ "where p.publishNo = :publishNo";
		Query query = getSession().createQuery(hql);
		query.setParameter("myTitle", bean.getMyTitle());
		query.setParameter("myDetail", bean.getMyDetail());
		query.setParameter("myArea", bean.getMyArea());
		query.setParameter("myCity", bean.getMyCity());
		query.setParameter("myDistrict", bean.getMyDistrict());
		query.setParameter("myRoad", bean.getMyRoad());
		query.setParameter("myPlace", bean.getMyPlace());
		query.setParameter("myOwnSkill", bean.getMyOwnSkill());
		query.setParameter("myWantSkill", bean.getMyWantSkill());
		query.setParameter("myMark", bean.getMyMark());
		query.setParameter("publishNo", bean.getPublishNo());
		query.executeUpdate();
		return null;
	}
//	public List<MyPublishBean> myPublishimf(int myPubNo){
//
//		String myPublish = "Select PublishNo,PublishTitle,PublishDetail,PublishArea,City"
//				+ ",District,Road,PublishPlace,OwnSkill,WantSkill,PublishMark from Publish where PublishNo = ? ";
//		
//		List<MyPublishBean> myPublishBeans = new ArrayList<MyPublishBean>();
//		try (
//			Connection conn = ds.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(myPublish);	
//		){
//			pstmt.setInt(1, myPubNo);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				MyPublishBean mpb = new MyPublishBean(rs.getInt("PublishNo"),rs.getString("PublishTitle"),rs.getString("PublishDetail"),rs.getString("PublishArea")
//						,rs.getString("City"),rs.getString("District"),rs.getString("Road"),rs.getString("PublishPlace")
//						,rs.getString("OwnSkill"),rs.getString("WantSkill"),rs.getString("PublishMark"));
//				myPublishBeans.add(mpb);
//			}
//			rs.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return myPublishBeans;
//		
//	}
}
