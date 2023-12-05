package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.khachhang;
import until.hibernateSessionFactory;

public class khachhangDAO implements interfaceDAO<khachhang> {
	
	public static khachhangDAO getInstance() {
		return new khachhangDAO();
	}

	@Override
	public boolean insert(khachhang t) {
		boolean b = false;
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					session.save(t);
					tran.commit();
					b = true;
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(khachhang t) {
		boolean b = false;
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					session.update(t);
					tran.commit();
					b = true;
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(khachhang t) {
		boolean b = false;
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					session.delete(t);
					tran.commit();
					b = true;
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<khachhang> selectAll() {
		List<khachhang> arr = new ArrayList<khachhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from khachhang";
					Query query = session.createQuery(hsql);
					arr = query.getResultList();
					tran.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public khachhang selectById(khachhang t) {
		List<khachhang> arr = new ArrayList<khachhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from khachhang k where k.ma = ma";
					Query query = session.createQuery(hsql);
					query.setParameter("ma", t.getMa());
					arr = query.getResultList();
					tran.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(arr.size() > 0) {
			return arr.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<khachhang> selectByCondition(String condition) {
		List<khachhang> arr = new ArrayList<khachhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = condition;
					Query query = session.createQuery(hsql);
					arr = query.getResultList();
					tran.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public khachhang selectByTendangnhap(String tenDangNhap) {
		List<khachhang> arr = new ArrayList<khachhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from khachhang k where k.tendangnhap =: tendangnhap";
					Query query = session.createQuery(hsql);
					query.setParameter("tendangnhap", tenDangNhap);
					arr = query.getResultList();
					tran.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(arr.size() > 0) {
			return arr.get(0);
		}else {
			return null;
		}
	}
		public boolean kiemtratendangnhap(String tenDangNhap) {
			List<khachhang> arr = new ArrayList<khachhang>();
			boolean b = false;
			try {
				SessionFactory SF = hibernateSessionFactory.getsessionfactory();
				if(SF!=null) {
					Session session = SF.openSession();
					try {
						Transaction tran = session.beginTransaction();
						String hsql = "from khachhang k where k.tendangnhap =: tendangnhap";
						Query query = session.createQuery(hsql);
						query.setParameter("tendangnhap", tenDangNhap);
						arr = query.getResultList();
						tran.commit();

					} finally {
						session.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return b = true;
			}
			return b;
			
}
		public khachhang updateImage(khachhang t) {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "UPDATE khachhang kh SET kh.duongDanAnh=: t ";
					Query query = session.createQuery(hsql);
					query.setParameter("t", t);
					session.update(t);
					tran.commit();
				} finally {
					session.close();
				}
			}
		return null;
		} 

		
}
