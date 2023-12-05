package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.quantrivienDAO;
import model.quantrivien;
import until.maHoaMatKhau;

/**
 * Servlet implementation class quantrivienController
 */
public class quantrivienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quantrivienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if (controller.equals("dangxuat")) {
			dangXuatController(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if (controller.equals("dangky")) {
			dangKyController(request, response);
		}
		if (controller.equals("dangnhap")) {
			dangNhapController(request, response);	
		}
		if (controller.equals("doiMatKhau")) {
			doiMatKhauController(request, response);
		}
		if(controller.equals("thongtinkhachhang")) {
			thayDoiThongTinController(request, response);
		}
		doGet(request, response);
	}

	public void dangKyController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			String baoLoi = "";
			String url = "";

			quantrivien qt = quantrivienDAO.getInstance().selectByTendangnhap(tenDangNhap);

			if (matKhau.equals(matKhauNhapLai)) {
				if (qt != null) {
					baoLoi = "Ten dang nhap da ton tai!";
					url = "/quanTriVienFE/dangky.jsp";
				} else {
					Date ns = null;
					try {
						ns = Date.valueOf(ngaySinh);
					} catch (Exception e) {
						e.printStackTrace();
					}

					String matkhau = maHoaMatKhau.maHoa(matKhau);
					quantrivien qt1 = new quantrivien(1, hoVaTen, diaChiKhachHang, gioiTinh, ns, soDienThoai, email,
							tenDangNhap, matkhau);

					quantrivienDAO.getInstance().insert(qt1);

					HttpSession session = request.getSession();
					session.setAttribute("quantrivien", qt);

					url = "/quanTriVienFE/dangNhapVaDangKy.jsp";
				}
			} else {
				baoLoi = "mat khau qtong qtop!";
				url = "/quanTriVienFE/dangky.jsp";
			}

			request.setAttribute("baoLoi", baoLoi);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dangNhapController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			
			String url = "";
			String baoLoi = "";
			
			quantrivien qt = quantrivienDAO.getInstance().selectByTendangnhap(tenDangNhap);
			if(qt == null) {
				baoLoi = "sai ten dang nhap";
				url = "/quanTriVienFE/dangNhapVaDangKy.jsp";
			}else {
				if(!qt.getMatKhau().equals(maHoaMatKhau.maHoa(matKhau))) {
					baoLoi = "sai mat khau";
					url = "/quanTriVienFE/dangNhapVaDangKy.jsp";
				}else {
					url = "/quanTriVienFE/trangchu.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("quantrivien", qt);
				}
			}
			
			request.setAttribute("baoLoi", baoLoi);
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doiMatKhauController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String matKhauCu = request.getParameter("matKhauCu");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

			String url = "";
			String baoLoi = "";

			HttpSession session = request.getSession(false);

			if (matKhauCu.equals(matKhauMoi)) {
				baoLoi = "Mật qtẩu mới qtông được trùng với mật qtẩu cũ";
				url = "/quanTriVienFE/doimatkhau.jsp";
			} else {
				if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
					baoLoi = "Mật khẩu không trùng nhau";
					url = "/quanTriVienFE/doimatkhau.jsp";
				} else {
					quantrivien qt = (quantrivien) session.getAttribute("quantrivien");
					if (qt.getMatKhau().equals(maHoaMatKhau.maHoa(matKhauCu))) {
						matKhauMoi = maHoaMatKhau.maHoa(matKhauMoi);
						qt.setMatKhau(matKhauMoi);
						quantrivienDAO.getInstance().update(qt);
						baoLoi = "Đổi mật khẩu thành công";
						url = "/quanTriVienFE/doimatkhau.jsp";
						session.removeAttribute("quantrivien");
						session.setAttribute("quantrivien", qt);
					} else {
						baoLoi = "Sai mật khẩu";
						url = "/quantrivienFE/doimatkhau.jsp";
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
	
	public void dangXuatController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()	;
			
			response.sendRedirect(url + "/quanTriVienFE/dangNhapVaDangKy.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void thayDoiThongTinController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   		try {
   			String url = "/quanTriVienFE/thongtinquantrivien.jsp";
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
  			quantrivien qt = (quantrivien)session.getAttribute("quantrivien");
  			
  			qt.setTen(hoVaTen);
  			qt.setDiaChi(diaChiKhachHang);
  			qt.setEmail(email);
  			qt.setGioiTinh(gioiTinh);
  			qt.setNgaySinh(ns);
  			qt.setSdt(soDienThoai);

  			quantrivienDAO.getInstance().update(qt);
  			
  			session.removeAttribute("quantrivien");
  			session.setAttribute("quantrivien", qt);
  			
  			request.setAttribute("baoLoi", baoLoi);
  			RequestDispatcher rd = request.getRequestDispatcher(url);
  			rd.forward(request, response);
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
   		
   	}

}
