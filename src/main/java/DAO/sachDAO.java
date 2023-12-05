package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.khachhang;
import model.sach;
import until.hibernateSessionFactory;

public class sachDAO implements interfaceDAO<sach> {
	public static sachDAO getInstance() {
		return new sachDAO();
	}

	@Override
	public boolean insert(sach t) {
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
	public boolean update(sach t) {
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
	public boolean delete(sach t) {
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
	public List<sach> selectAll() {
		List<sach> arr = new ArrayList<sach>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from sach";
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
	public sach selectById(sach t) {
		List<sach> arr = new ArrayList<sach>();
		try {
			SessionFactory SF = hibernateSessionFactory.getsessionfactory();
			if(SF!=null) {
				Session session = SF.openSession();
				try {
					Transaction tran = session.beginTransaction();
					String hsql = "from sach s where s.ma =: ma";
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
	public List<sach> selectByCondition(String condition) {
		List<sach> arr = new ArrayList<sach>();
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
