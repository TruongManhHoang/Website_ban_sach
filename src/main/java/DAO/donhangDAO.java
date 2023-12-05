package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.donhang;
import model.sach;
import until.hibernateSessionFactory;

public class donhangDAO implements interfaceDAO<donhang>{
	public static donhangDAO getInstance() {
		return new donhangDAO();
	}

	@Override
	public boolean insert(donhang t) {
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
	public boolean update(donhang t) {
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
	public boolean delete(donhang t) {
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
	public List<donhang> selectAll() {
		List<donhang> arr = new ArrayList<donhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from donhang";
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
	public donhang selectById(donhang t) {
		List<donhang> arr = new ArrayList<donhang>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from donhang dh where dh.ma =: ma";
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
	public List<donhang> selectByCondition(String condition) {
		List<donhang> arr = new ArrayList<donhang>();
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
	
}
