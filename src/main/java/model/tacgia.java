package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class tacgia {
	
	@Id
	@GeneratedValue
	private Integer ma;
	private String ten;
	private Date ngaysinh;
	
	@OneToMany(mappedBy = "tacGia")
	
	private List<sach> sachs;
	
	public tacgia() {
		super();
	}
	
	public tacgia(String ten, Date ngaysinh, List<sach> sachs) {
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.sachs = sachs;
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
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	public List<sach> getSachs() {
		return sachs;
	}

	public void setSachs(List<sach> sachs) {
		this.sachs = sachs;
	}

	@Override
	public String toString() {
		return "tacgia [ma=" + ma + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", sachs=" + sachs + "]";
	}

	
	
	
}
