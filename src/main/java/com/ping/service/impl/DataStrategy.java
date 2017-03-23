package com.ping.service.impl;

import java.util.List;
import java.util.Map;

import com.ping.db.DataDAO;
import com.ping.db.impl.ResourceDataDAOImpl;
import com.ping.model.Request;
import com.ping.model.Resource;
import com.ping.model.Response;
import com.ping.service.ResponseStrategy;

/**
 * strategy to handle 
 * @author pavansachi
 *
 */
public class DataStrategy implements ResponseStrategy {

	private List<String> matchers = null;

	public DataStrategy(List<String> matchers) {
		this.matchers = matchers;
	}

	private DataDAO<Resource> dao = new ResourceDataDAOImpl();

	public <Q, R> void handle(Q request, R response) {

		Request req = (Request) request;
		Response res = (Response) response;

		for (String match: matchers) {

			if (req.getPath().contains(match)) {

				Resource resource = new Resource();
				resource.setPath(req.getPath());
				resource.setRequest(req.getData());
				resource.setTimestamp(res.getTimestamp());
				resource.setResponseTime(res.getResponseTime());
				resource.setResult(res.getData());

				Map<String, List<String>> headers = res.getHeaders();

				List<String> cookie = headers.get("Set-Cookie");

				// cookie is available
				if (cookie != null && cookie.size() > 0) {

					System.out.println("Cookie is in the response. Setting the cookie");
					resource.setCookie(String.format("Set-Cookie: %s", cookie.get(0)));
				}

				dao.save(resource);
			}
		}
	}

	public DataDAO<Resource> getDao() {
		return dao;
	}

	public void setDao(DataDAO<Resource> dao) {
		this.dao = dao;
	}

}
