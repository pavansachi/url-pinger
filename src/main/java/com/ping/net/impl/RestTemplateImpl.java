package com.ping.net.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.ping.model.Request;
import com.ping.model.Response;
import com.ping.net.IHttpTemplate;

/**
 * rest template
 * @author pavansachi
 *
 */
public class RestTemplateImpl implements IHttpTemplate {

	public Response getResponse(final Request request) 
			throws Exception {

		final String path = request.getPath(); 
		
		StringBuilder data = new StringBuilder();
		
		URL url = null;
		
		Response response = new Response();
		
		try {
			
			System.out.println(String.format("Opening a connection to %s", path));
			url = new URL(path);

			URLConnection conn = url.openConnection();

//			String value = conn.getHeaderField("Set-Cookie");
//
//			System.out.println("Set-Cookie: " + value);

			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String res = null;

			data = new StringBuilder();

			while((res = br.readLine()) != null) {

				data.append(res + "\n");
			}
			
			response.setTimestamp(new Date().getTime());
			response.setData(data.toString());
			response.setHeaders(conn.getHeaderFields());

		} catch (MalformedURLException e) {
			
			response.setTimestamp(new Date().getTime());
			response.setData(e.getMessage());
			
			e.printStackTrace();
		}

		return response;
	}

}
