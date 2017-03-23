package com.ping.model;

import java.util.List;
import java.util.Map;

/*
 * model to represent a response object
 */
public class Response {

	private String data;
	
	private Map<String, List<String>> headers;
	
	private long timestamp;
	
	private long responseTime;

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", headers=" + headers + ", timestamp=" + timestamp + ", responseTime="
				+ responseTime + "]";
	}

}
