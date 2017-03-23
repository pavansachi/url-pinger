package com.ping.net;

import com.ping.model.Request;
import com.ping.model.Response;

/**
 * template for http client
 * @author pavansachi
 *
 */
public interface IHttpTemplate {

	/*
	 * get response for a single request
	 */
	public Response getResponse(Request request) 
	throws Exception;
	
}
