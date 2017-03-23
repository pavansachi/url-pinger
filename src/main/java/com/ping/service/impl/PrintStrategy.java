package com.ping.service.impl;

import java.util.List;

import com.ping.model.Request;
import com.ping.service.ResponseStrategy;

public class PrintStrategy implements ResponseStrategy {

	private List<String> matchers = null;
	
	public PrintStrategy(List<String> matchers) {
		this.matchers = matchers;
	}
	
	public <Q, R> void handle(Q request, R response) {

		Request req = (Request) request;
		
		for (String match: matchers) {
			
			if (req.getPath().contains(match)) {
				
				System.out.println("**************************");
				System.out.println("printing out the results");
				System.out.println(response);
				System.out.println("**************************");
			}
		}
	}

}
