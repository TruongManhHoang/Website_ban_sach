package DAO;

import java.util.List;

public interface interfaceDAO<T> {
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
	
	public List<T> selectAll();
	
	public T selectById(T t);
	
	public List<T> selectByCondition(String condition);
}
