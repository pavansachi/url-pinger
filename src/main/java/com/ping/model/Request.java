package com.ping.model;

/*
 * model to represent a payload object
 */
public class Request {

	@Override
	public String toString() {
		return "[path=" + path + ", contentType=" + contentType + ", payload=" + data + ", methodType="
				+ methodType + "]";
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private String path;
	private String contentType;
	private String data;
	private String methodType;
	
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
