package Controller;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import DAO.sachDAO;
import DAO.tacgiaDAO;
import model.khachhang;
import model.sach;
import model.tacgia;

/**
 * Servlet implementation class sachController
 */
public class sachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(controller.equals("chonSach")) {
//			chonSachController(request,response);
//		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if(controller.equals("themSach")) {
			themSachController(request,response);
		}
		doGet(request, response);
	}
		public void themSachController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String tenSach = request.getParameter("tenSach");
			String tacGia = request.getParameter("tacGia");
			String theLoai = request.getParameter("theLoai");
			String nhaXuatBan = request.getParameter("nhaXuatBan");
			String namXuatBan = request.getParameter("namXuatBan");
			String gia = request.getParameter("gia");
			String chonAnhCuaSach = request.getParameter("chonAnhCuaSach");
			String baoLoi = "";
			String url = "";
			tacgia t = tacgiaDAO.getInstance().selectByTen(tacGia);
			if(t.equals(null)) {
				baoLoi = "khong co tac gia tuong ung!";
				url = "quanTriVienFE/themSach.jsp";
			}else {
				float gia1 = Float.parseFloat(gia);
				int nxb = Integer.valueOf(namXuatBan);
				Year namxuatban = Year.of(nxb);
				sach s = new sach(tenSach, theLoai, namxuatban, nhaXuatBan, gia1, chonAnhCuaSach, null);
				sachDAO.getInstance().insert(s);
				baoLoi = "Them sach thanh cong!";
				url = "quanTriVienFE/themSach.jsp";
			}
			
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	}
	
//		public void chonSachController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//			String baoLoi = "";
//			String url = "/sachFe/chonSachDeSua.jsp";
//			List<sach> arr = sachDAO.getInstance().selectAll();
//			request.setAttribute("arr", arr);
//			
//				float gia1 = Float.parseFloat(gia);
//				int nxb = Integer.valueOf(namXuatBan);
//				Year namxuatban = Year.of(nxb);
//				sach s = new sach(tenSach, theLoai, namxuatban, nhaXuatBan, gia1, chonAnhCuaSach, null);
//				sachDAO.getInstance().insert(s);
//				baoLoi = "Them sach thanh cong!";
//				url = "quanTriVienFE/themSach.jsp";
//			}
//			
//			request.setAttribute("baoLoi", baoLoi);
//			RequestDispatcher rd = request.getRequestDispatcher(url);
//			rd.forward(request, response);
//	}

		public void thayDoiAnhController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		}
		}
