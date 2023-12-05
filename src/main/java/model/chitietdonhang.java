package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class chitietdonhang {
	
	@Id
	@GeneratedValue
	private Integer ma;
	private float thue;
	private float tongthanhtien;
	
	@OneToMany(mappedBy = "chitietdonhang")
	private List<donhang> danhsachdonhang;
	
	
	public chitietdonhang() {
		super();
	}
	
	public chitietdonhang(Integer ma, float thue, float tongthanhtien, List<donhang> danhsachdonhang) {
		super();
		this.ma = ma;
		this.thue = thue;
		this.tongthanhtien = tongthanhtien;
		this.danhsachdonhang = danhsachdonhang;
	}

	public Integer getMa() {
		return ma;
	}
	public void setMa(Integer ma) {
		this.ma = ma;
	}
	public float getThue() {
		return thue;
	}
	public void setThue(float thue) {
		this.thue = thue;
	}
	public float getTongthanhtien() {
		return tongthanhtien;
	}
	public void setTongthanhtien(float tongthanhtien) {
		this.tongthanhtien = tongthanhtien;
	}
	
	
	public List<donhang> getDanhsachdonhang() {
		return danhsachdonhang;
	}

	public void setDanhsachdonhang(List<donhang> danhsachdonhang) {
		this.danhsachdonhang = danhsachdonhang;
	}

	public void themDonHang(donhang dh) {
		this.danhsachdonhang.add(dh);
	}

	@Override
	public String toString() {
		return "chitietdonhang [ma=" + ma + ", thue=" + thue + ", tongthanhtien=" + tongthanhtien + ", danhsachdonhang="
				+ danhsachdonhang + "]";
	}

	
	
}
