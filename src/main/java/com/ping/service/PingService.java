package com.ping.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ping.db.DataDAO;
import com.ping.db.impl.ResourceDataDAOImpl;
import com.ping.model.Request;
import com.ping.model.Resource;
import com.ping.model.Response;
import com.ping.net.IHttpTemplate;
import com.ping.net.impl.RestTemplateImpl;
import com.ping.service.impl.DataStrategy;
import com.ping.service.impl.PrintStrategy;

/**
 * ping functions
 * @author pavansachi
 *
 */
public class PingService {

	private DataDAO<Resource> dao = new ResourceDataDAOImpl();

	public void sendAndHandleResponse(List<Request> requests) {

		IHttpTemplate restTemplate = new RestTemplateImpl();

		List<ResponseStrategy> strategyList = Arrays.asList(
				new PrintStrategy(Arrays.asList("google.com", "test.com")),
				new DataStrategy(Arrays.asList("site1.com", "google.com", "yahoo.com", "site2.com")));

		requests.stream().forEach((request) -> {

			try {
				Response response = restTemplate.getResponse(request);

				for (ResponseStrategy strategy: strategyList) {

					strategy.handle(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

	public List<String> getUrlList() {

		List<Resource> resources = dao.find("cookie", "^(Set-Cookie:)");
		
		List<String> urls = resources.stream().map((e) -> e.getPath())
				.collect(Collectors.toList());

		return urls;
	}

}
