package model;

import java.sql.Date;
import java.time.Year;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class sach {
	@Id
	@GeneratedValue
	private Integer ma;
	private String ten;
	private String theloai;
	private Year namxuatban;
	private String nhaxuatban;
	private float gia;
	private String duongdananh;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_tacgia")
	private tacgia tacGia;

	public sach() {
		super();
	}

	public sach(String ten, String theloai, Year namxuatban, String nhaxuatban, float gia,
			String duongdananh, tacgia tacGia) {
		super();
		this.ten = ten;
		this.theloai = theloai;
		this.namxuatban = namxuatban;
		this.nhaxuatban = nhaxuatban;
		this.gia = gia;
		this.duongdananh = duongdananh;
		this.tacGia = tacGia;
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

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public Year getNamxuatban() {
		return namxuatban;
	}

	public void setNamxuatban(Year namxuatban) {
		this.namxuatban = namxuatban;
	}

	public String getNhaxuatban() {
		return nhaxuatban;
	}

	public void setNhaxuatban(String nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getDuongdananh() {
		return duongdananh;
	}

	public void setDuongdananh(String duongdananh) {
		this.duongdananh = duongdananh;
	}

	public tacgia getTacGia() {
		return tacGia;
	}

	public void setTacGia(tacgia tacGia) {
		this.tacGia = tacGia;
	}

	@Override
	public String toString() {
		return "sach [ma=" + ma + ", ten=" + ten + ", theloai=" + theloai + ", namxuatban=" + namxuatban
				+ ", nhaxuatban=" + nhaxuatban + ", gia=" + gia + ", duongdananh=" + duongdananh + ", tacGia=" + tacGia
				+ "]";
	}
	
	
	
}
