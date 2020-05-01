package publishCheckPage.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import publishCheckPage.Model.PublishBean;
import publishCheckPage.Service.PublishService;
import publishCheckPage.Service.PublishServicelmpl;



@WebServlet("/publishCheckPage.Controller/publishCheckPageServlet")
public class publishCheckPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
//		String publishTitle = (String)request.getAttribute("publishTitle"); 
//		System.out.println(publishTitle);
		
		
		
		HttpSession session = request.getSession();
		String publishTitle = session.getAttribute("publishTitle").toString();
		String publishPic = session.getAttribute("publishPic").toString();
		String publishDetail = session.getAttribute("publishDetail").toString();
		String ownSkill = session.getAttribute("ownSkill").toString();
		String wantSkill = session.getAttribute("wantSkill").toString();
		String publishArea = session.getAttribute("publishArea").toString();
		String City = session.getAttribute("City").toString();
		String district = session.getAttribute("district").toString();
		String road = session.getAttribute("road").toString();
		String publishPlace = session.getAttribute("publishPlace").toString();
		String publishMark = session.getAttribute("publishMark").toString();
		String skillType = session.getAttribute("skillType").toString();
		
//		String publishTitle = "";
//		String publishPic = "";
//		String publishDetail = "";
//		String ownSkill = "";
//		String wantSkill = "";
//		String publishArea = "";
//		String City = "";
//		String district = "";
//		String road = "";
//		String publishPlace = "";
//		String publishMark = "";
//		long size = 0;
//		InputStream is = null;
//		
////		Collection<Part> parts = request.getParts();
////		Global.exploreParts(parts, request);
//		
//		if(parts != null) {
//			for(Part p : parts) {
//				String fidName = p.getName();
//				String value = session.getAttribute(fidName).toString();
//				
//				if(p.getContentType() == null) {
//					if(fidName.equalsIgnoreCase("publishTitle")) {
//						publishTitle = value;
//					}else if(fidName.equalsIgnoreCase("publishDetail")) {
//						publishDetail = value;
//					}else if(fidName.equalsIgnoreCase("ownSkill")) {
//						ownSkill = value;
//					}else if(fidName.equalsIgnoreCase("wantSkill")) {
//						wantSkill = value;
//					}else if(publishArea.equalsIgnoreCase("publishArea")) {
//						publishArea = value;
//					}else if(fidName.equalsIgnoreCase("City")) {
//						City = value;
//					}else if(fidName.equalsIgnoreCase("district")) {
//						district = value;
//					}else if(fidName.equalsIgnoreCase("road")) {
//						road = value;
//					}else if(fidName.equalsIgnoreCase("publishPlace")) {
//						publishPlace = value;
//					}else if(fidName.equalsIgnoreCase("publishMark")) {
//						publishMark = value;
//					}
//				}else {
//					publishPic = Global.getFileName(p);
//					publishPic = Global.adjustFileName(publishPic, Global.IMAGE_FILENAME_LENGTH);
//					if(publishPic != null && publishPic.trim().length() > 0) {
//						size = p.getSize();
//						is = p.getInputStream();
//					}
//				}
//			}
//		}
//		
//		try {
//			Blob blob = System2018.fileToBlob(is, size);
//			
//	
//		} catch (IOException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		try {
			
			PublishService service = new PublishServicelmpl();
			PublishBean Pb = new PublishBean(publishTitle,publishDetail,publishArea,City
					,district,road,publishPlace,publishPic,ownSkill,wantSkill,publishMark,skillType);
			service.insertPublish(Pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.sendRedirect(request.getContextPath()+"/PublishFinishPage.jsp");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/PublishFinishPage.jsp");
//		rd.forward(request, response);
//		return;
	}

}
