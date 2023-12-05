package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.tacgiaDAO;
import model.tacgia;

/**
 * Servlet implementation class tacGiaController
 */
public class tacGiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tacGiaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if(controller.equals("themTacGia")) {
			themTacGiaController(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void themTacGiaController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tenTacGia = request.getParameter("tenTacGia");
		String ngaySinh = request.getParameter("ngaySinh");
		String baoLoi = "thêm tác giả thành công!";
		String url = "/tacGiaFE/themTacGia.jsp";
	
		Date ngaysinh = Date.valueOf(ngaySinh);
		tacgia tg1 = new tacgia(tenTacGia, ngaysinh, null);
		tacgiaDAO.getInstance().insert(tg1);
		
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
