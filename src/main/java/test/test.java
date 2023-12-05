package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DAO.chitietdonhangDAO;
import DAO.donhangDAO;
import DAO.khachhangDAO;
import DAO.quantrivienDAO;
import DAO.sachDAO;
import DAO.tacgiaDAO;
import model.chitietdonhang;
import model.donhang;
import model.khachhang;
import model.quantrivien;
import model.sach;
import model.tacgia;
import until.guiMail;
import until.taoMaXacThuc;

public class test {
	public static void main(String[] args) {
//		List<sach> arr1 = new ArrayList<>();
//		tacgia tacgia = new tacgia("Hoang", null, arr1);
//		sach sach1 = new sach(null, null, null, null, 1000, null, tacgia);
//		arr1.add(sach1);
//		
//		tacgiaDAO.getInstance().insert(tacgia);
//		sachDAO.getInstance().insert(sach1);
		
//		List<donhang> arr = new ArrayList<>();
//		chitietdonhang ctdh = new chitietdonhang(1, 1, 1, arr);
//		donhang dh = new donhang(1, null, null, "Hanoi1", "dang van chuyen1", "pay", 10000, 10000, ctdh, null);
//		arr.add(dh);
//		
//		chitietdonhangDAO.getInstance().insert(ctdh);
//		donhangDAO.getInstance().insert(dh);
//////		
//		sach s = new sach("dfasd", "dfasd", null, null, 0, null, null);
//		sachDAO.getInstance().insert(s);
//		quantrivien quantrivien = new quantrivien(1, "Hoang", "hanoi", "nam", null, "24124", "123@", null, null);
//		quantrivienDAO.getInstance().insert(quantrivien);
//		khachhang kh = new khachhang();
//		String tenDangNhap = "Hoang";
//		khachhangDAO.getInstance().kiemtratendangnhap(tenDangNhap);
//		List<sach> list = new ArrayList<>();
//		tacgia tacgia = new tacgia("hoang", new Date(24-10-2003),list);
//		tacgiaDAO.getInstance().insert(tacgia);
	
//		String t = "hoang";
//		tacgiaDAO.getInstance().selectByTen("hoang");
		String t = "dfgadsfasd";
		khachhang khachhang = new khachhang();
		khachhang.setDuongDanAnh(t);
		khachhangDAO.getInstance().update(khachhang);
		
	}
}
