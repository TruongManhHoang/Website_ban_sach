package model;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class donhang {
	@Id
	@GeneratedValue
	private Integer ma;
	private Date ngaydathang;
	private Date ngaygiaohang;
	private String diachinhanhang;
	private String trangthaidonhang;
	private String phuongthucthanhtoan;
	private float giagoc;
	private float giaban;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_chitietdonhang")
	private chitietdonhang chitietdonhang;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_sach")
	private sach Sach;
	
	public donhang() {
		super();
	}
	


	public donhang(Integer ma, Date ngaydathang, Date ngaygiaohang, String diachinhanhang, String trangthaidonhang,
			String phuongthucthanhtoan, float giagoc, float giaban, model.chitietdonhang chitietdonhang, sach sach) {
		super();
		this.ma = ma;
		this.ngaydathang = ngaydathang;
		this.ngaygiaohang = ngaygiaohang;
		this.diachinhanhang = diachinhanhang;
		this.trangthaidonhang = trangthaidonhang;
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.giagoc = giagoc;
		this.giaban = giaban;
		this.chitietdonhang = chitietdonhang;
		Sach = sach;
	}





	public Integer getMa() {
		return ma;
	}
	public void setMa(Integer ma) {
		this.ma = ma;
	}
	public Date getNgaydathang() {
		return ngaydathang;
	}
	public void setNgaydathang(Date ngaydathang) {
		this.ngaydathang = ngaydathang;
	}
	public Date getNgaygiaohang() {
		return ngaygiaohang;
	}
	public void setNgaygiaohang(Date ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}
	public String getDiachinhanhang() {
		return diachinhanhang;
	}
	public void setDiachinhanhang(String diachinhanhang) {
		this.diachinhanhang = diachinhanhang;
	}
	public String getTrangthaidonhang() {
		return trangthaidonhang;
	}
	public void setTrangthaidonhang(String trangthaidonhang) {
		this.trangthaidonhang = trangthaidonhang;
	}
	public String getPhuongthucthanhtoan() {
		return phuongthucthanhtoan;
	}
	public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}
	public sach getSach() {
		return Sach;
	}
	public void setSach(sach sach) {
		Sach = sach;
	}
	public float getGiagoc() {
		return giagoc;
	}
	public void setGiagoc(float giagoc) {
		this.giagoc = giagoc;
	}
	public float getGiaban() {
		return giaban;
	}
	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}


	public chitietdonhang getChitietdonhang() {
		return chitietdonhang;
	}




	public void setChitietdonhang(chitietdonhang chitietdonhang) {
		this.chitietdonhang = chitietdonhang;
	}




	@Override
	public String toString() {
		return "donhang [ma=" + ma + ", ngaydathang=" + ngaydathang + ", ngaygiaohang=" + ngaygiaohang
				+ ", diachinhanhang=" + diachinhanhang + ", trangthaidonhang=" + trangthaidonhang
				+ ", phuongthucthanhtoan=" + phuongthucthanhtoan + ", giagoc=" + giagoc + ", giaban=" + giaban
				+ ", chitietdonhang=" + chitietdonhang + ", Sach=" + Sach + "]";
	}

	

	
	
}
