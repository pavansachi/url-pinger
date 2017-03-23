package com.ping.model;

/**
 * model to represent a http resource
 * @author pavansachi
 *
 */
public class Resource {

	public Resource() {
		super();
	}

	/*
	 * path
	 */
	private String path;
	
	/*
	 * response
	 */
	private String result;
	
	/*
	 * time of request
	 */
	private long timestamp;
	
	/*
	 * time taken for response
	 */
	private long responseTime;
	
	/*
	 * 
	 */
	private String request;
	
	/**
	 * Set-Cookie
	 */
	private String cookie;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	@Override
	public String toString() {
		return "Resource [path=" + path + ", result=" + result + ", timestamp=" + timestamp + ", responseTime="
				+ responseTime + ", request=" + request + ", cookie=" + cookie + "]";
	}
	
	
	
}
