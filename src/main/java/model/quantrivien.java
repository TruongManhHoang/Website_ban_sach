package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class quantrivien {
	@Id
	@GeneratedValue
	private Integer ma;
	private String ten;
	private String diaChi;
	private String gioiTinh;
	private Date ngaySinh;
	private String sdt;
	private String email;
	private String tenDangNhap;
	private String matKhau;
	public quantrivien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public quantrivien(Integer ma, String ten, String diaChi, String gioiTinh, Date ngaySinh, String sdt, String email,
			String tenDangNhap, String matKhau) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public Integer getMa() {
		return ma;
	}
	public void setMa(Integer ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "quantrivien [ma=" + ma + ", ten=" + ten + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", email=" + email + ", tenDangNhap=" + tenDangNhap
				+ ", matKhau=" + matKhau + "]";
	}
	
	
}
