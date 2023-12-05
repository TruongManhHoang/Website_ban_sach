package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//import org.apache.tomcat.util.http.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.RequestContext;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import DAO.khachhangDAO;
import model.khachhang;
import until.guiMail;
import until.maHoaMatKhau;
import until.taoMaXacThuc;

/**
 * Servlet implementation class KhachhangController
 */
public class KhachhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachhangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if(controller.equals("dangXuat")) {
			dangXuatController(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if(controller.equals("dangnhap")) {
			dangNhapController(request,response);
		}
		
		if(controller.equals("xacthuc")) {
			xacThucController(request, response);
		}
		if(controller.equals("dangky")) {
			dangKyController(request, response);
		}
		if(controller.equals("taomaxacthuc")) {
			taoMaXacThucController(request, response);
		}
		if(controller.equals("doiMatKhau")) {
			doiMatKhauController(request, response);
		}
		if(controller.equals("thongtinkhachhang")) {
			thayDoiThongTinController(request, response);
		}
		if(controller.equals("doiAnh")) {
			thayDoiAnh(request, response);
		}
		
	}
	
	
	public void dangNhapController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			
			String url = "";
			String baoLoi = "";
			
			khachhang kh = khachhangDAO.getInstance().selectByTendangnhap(tenDangNhap);
			if(kh == null) {
				baoLoi = "sai ten dang nhap";
				url = "/khachHangFE/dangNhapVaDangKy.jsp";
			}else {
				if(!kh.getMatkhau().equals(maHoaMatKhau.maHoa(matKhau))) {
					baoLoi = "sai mat khau";
					url = "/khachHangFE/dangNhapVaDangKy.jsp";
				}else {
					url = "/khachHangFE/trangchu.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("khachHang", kh);
				}
			}
			
			request.setAttribute("baoLoi", baoLoi);
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void dangKyController (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
		    String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String soDienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("soDienThoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			String baoLoi = "";
			String url = "";
			khachhang kh = khachhangDAO.getInstance().selectByTendangnhap(tenDangNhap);
			if(khachhangDAO.getInstance().kiemtratendangnhap(tenDangNhap)) {
				baoLoi = "Ten dang nhap da ton tai";
				url = "/khachHangFE/dangky.jsp";
			}
			
			if(matKhau.equals(matKhauNhapLai)) {
				if(kh != null) {
					baoLoi = "Ten dang nhap da ton tai!";
					url = "/khachHangFE/dangky.jsp";
				}else {
					Date ns = null;
					try {
						ns = Date.valueOf(ngaySinh);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String matkhau = maHoaMatKhau.maHoa(matKhau);
				 
				    khachhang kh1 = new khachhang(1, hoVaTen, ns, diaChiKhachHang, gioiTinh, soDienThoai, email, tenDangNhap, matkhau);
				    
				    khachhangDAO.getInstance().insert(kh1);
				    
				    HttpSession session = request.getSession();
				    session.setAttribute("khachHang", kh1);
				
					url = "/khachHangFE/dangKyThanhCong.jsp";
				}
			}else {
				baoLoi = "mat khau khong khop!";
				url = "/khachHangFE/dangky.jsp";
			}
			
			request.setAttribute("baoLoi", baoLoi);
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void taoMaXacThucController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 try {
			 
			 String url = "/khachHangFE/nhapMaXacThuc.jsp";
			 
			 String maxacthuc = taoMaXacThuc.layMaXacThuc();
			 System.out.println(maxacthuc);
			 
			 HttpSession session = request.getSession(false);
			 khachhang kh = (khachhang)session.getAttribute("khachHang");
			 
			 session.setAttribute("maxacthuc", maxacthuc);
			 
			 guiMail.sendEmail(kh.getEmail(), "xác thực tài khoản","đây là mã xác thực của bạn" + maxacthuc + ",mã có hiệu lực trong 5 phút.");
			 
			 long hieulucma = Instant.now().plusSeconds(300).getEpochSecond();
			 session.setAttribute("hieulucma", hieulucma);
			 
			 RequestDispatcher rd = request.getRequestDispatcher(url);
			 rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	
     public void xacThucController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			String baoLoi = "";
			String url = "";
			
			String maXacThucDuocNhap = request.getParameter("maXacThucDuocNhap");
			
			HttpSession session = request.getSession(false);
			String maXacThuc = (String)session.getAttribute("maxacthuc");
			long hieuLucMa = (long)session.getAttribute("hieulucma");
			
			if(hieuLucMa < Instant.now().getEpochSecond()) {
				session.removeAttribute("maxacthuc");
				session.removeAttribute("hieulucma");
				baoLoi = "mã đã hết hiệu lực, vui lòng tạo lại";
				url = "/khachHangFE/nhapMaXacThuc.jsp";
			}else {
				
			}if(maXacThuc.equals(maXacThucDuocNhap)) {
				url = "/khachHangFE/trangchu.jsp";
			}else {
				url = "/khachHangFE/nhapMaXacThuc.jsp";
				baoLoi = "sai mã xác thực, vui lòng nhập lại!";
			}
		
		request.setAttribute("baoLoi", baoLoi);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		

     }catch (Exception e) {
		e.printStackTrace();
	}

}
     public void doiMatKhauController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  		try {
 			String matKhauCu = request.getParameter("matKhauCu");
 			String matKhauMoi = request.getParameter("matKhauMoi");
 			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
 			
 			String url = "";
 			String baoLoi = "";
 			
 			HttpSession session = request.getSession(false);
 			
 			if(matKhauCu.equals(matKhauMoi)) {
 				baoLoi = "Mật khẩu mới không được trùng với mật khẩu cũ";
 				url = "/khachHangFE/doimatkhau.jsp";
 			}else {
 				if(!matKhauMoi.equals(matKhauMoiNhapLai)) {
 					baoLoi = "Mật khẩu không trùng nhau";
 					url = "/khachHangFE/doimatkhau.jsp";
 				}else {
 					khachhang khachHang1 = (khachhang)session.getAttribute("khachHang");
 					if(khachHang1.getMatkhau().equals(maHoaMatKhau.maHoa(matKhauCu))) {
 						matKhauMoi = maHoaMatKhau.maHoa(matKhauMoi);
 						khachHang1.setMatkhau(matKhauMoi);
 						khachhangDAO.getInstance().update(khachHang1);
 						baoLoi = "Đổi mật khẩu thành công";
 						url = "/khachHangFE/doimatkhau.jsp";
 						session.removeAttribute("khachHang");
 						session.setAttribute("khachHang", khachHang1);
 					}else {
 						baoLoi = "Sai mật khẩu";
 						url = "/khachHangFE/doimatkhau.jsp";
 					}
 				}
 			}
 			
 			request.setAttribute("baoLoi", baoLoi);
 			
 			RequestDispatcher rd = request.getRequestDispatcher(url);
 			rd.forward(request, response);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
  		
  	}
     public void thayDoiThongTinController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   		try {
   			String url = "/khachHangFE/thongtinkhachhang.jsp";
  			String baoLoi = "đổi thông tin thành công";
  			
   			String hoVaTen = request.getParameter("hoVaTen");
 			String gioiTinh = request.getParameter("gioiTinh");
 			String ngaySinh = request.getParameter("ngaySinh");
 			String soDienThoai = request.getParameter("dienThoai");
 			String email = request.getParameter("email");
 			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
 			
 			Date ns = null;
  			try {
 				ns = Date.valueOf(ngaySinh);
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
  			
  			HttpSession session = request.getSession(false);
  			khachhang kh = (khachhang)session.getAttribute("khachHang");
  			
  			kh.setTen(hoVaTen);
  			kh.setDiachi(diaChiKhachHang);
  			kh.setEmail(email);
  			kh.setGioitinh(gioiTinh);
  			kh.setTuoi(ns);
  			kh.setSdt(soDienThoai);

  			khachhangDAO.getInstance().update(kh);
  			
  			session.removeAttribute("khachHang");
  			session.setAttribute("khachHang", kh);
  			
  			request.setAttribute("baoLoi", baoLoi);
  			RequestDispatcher rd = request.getRequestDispatcher(url);
  			rd.forward(request, response);
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
   		
   	}
     
      
      public void dangXuatController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    		try {
    			HttpSession session = request.getSession(false);
    			if(session!=null) {
    				session.invalidate();
    			}
    			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()	;
   			
    			response.sendRedirect(url + "/khachHangFE/dangNhapVaDangKy.jsp");
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
    		
    	}
      public void thayDoiAnh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	  	System.out.println("123");
			Object obj = request.getSession().getAttribute("khachHang");
			khachhang khachHang = null;
			if (obj != null)
				khachHang = (khachhang) obj;
			if (khachHang != null) {
				try {
					String folder = getServletContext().getRealPath("avatar");
					System.out.println(folder);
					File file;
					int maxFileSize = 5000 * 1024;
					int maxMemSize = 5000 * 1024;

					String contentType = request.getContentType();

					if (contentType.indexOf(contentType) >= 0) {
						DiskFileItemFactory factory = new DiskFileItemFactory();

						// Quy dinh dung luong toi da cho 1 file
						factory.setSizeThreshold(maxMemSize);

						// Tao file upload
						ServletFileUpload upload = new ServletFileUpload(factory);

						upload.setSizeMax(maxFileSize);

						List<FileItem> files = upload.parseRequest(request);

						for (FileItem fileItem : files) {
							if(!fileItem.isFormField()) {
								String fileName = System.currentTimeMillis() + fileItem.getName();
								String path = folder + "\\" + fileName;
								file = new File(path);
		
								fileItem.write(file);
		
								khachHang.setDuongDanAnh(fileName);
								khachhangDAO khachHangDAO = new khachhangDAO();
								khachhangDAO.getInstance().update(khachHang);
								khachHang = khachHangDAO.selectById(khachHang);
							}else {
								String name = fileItem.getFieldName();
								String value = fileItem.getString();
								System.out.println(name+" : "+value);
							}
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	  
      }
      }

}

