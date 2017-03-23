package com.ping.executor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.ping.model.Request;
import com.ping.service.PingService;

public class PingTest {

	public static void main(String[] args) throws IOException {

		PingService service = new PingService();
		
		Request req1 = new Request();
		req1.setPath("http://google.com");
		req1.setMethodType("get");
		
		Request req2 = new Request();
		req2.setPath("http://yahoo.com");
		req2.setMethodType("get");
		
		List<Request> requests = Arrays.asList(req1, req2);

		System.out.println("pinging the requests");
		
		service.sendAndHandleResponse(requests);

	}

}
