package com.ping.db;

import java.util.List;

/**
 * database operations
 * @author pavansachi
 *
 */
public interface DataDAO<T> {

	void save(T t);
	
	List<T> find(String attr, String regexp);
}
