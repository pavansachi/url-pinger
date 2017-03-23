package com.ping.service;

/**
 * strategy to handle response
 * @author pavansachi
 *
 */
public interface ResponseStrategy {

	public <Q, R> void handle(Q request, R response);
}
