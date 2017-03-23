package com.ping.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ping.model.Request;
import com.ping.service.PingService;

public class PingTest {

	public static void main(String[] args) throws IOException {

		PingService service = new PingService();

		List<Request> requests = new ArrayList<Request>();
		
		if (args != null && args.length > 0) {

			for (String url: args) {
				
				Request req = new Request();
				req.setPath(url);
				req.setMethodType("get");
				
				requests.add(req);
			}
			
			System.out.println("pinging the requests");

			service.sendAndHandleResponse(requests);
		}
		else {
			
			System.out.println("no urls to ping!");
		}

	}

}
