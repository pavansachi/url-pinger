package com.ping.db.impl;

import java.util.ArrayList;
import java.util.List;

import com.ping.db.DataDAO;
import com.ping.model.Resource;

public class ResourceDataDAOImpl implements DataDAO<Resource> {

	@Override
	public void save(Resource r) {

		System.out.println("saving the resource in the database");
	}

	@Override
	public List<Resource> find(String attr, String regexp) {
		
		return new ArrayList<Resource>();
	}

}
