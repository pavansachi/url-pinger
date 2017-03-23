package com.ping;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ping.db.DataDAO;
import com.ping.model.Resource;
import com.ping.service.PingService;

public class PingTest {

	@Test
	public void testGetCookieUrls() {
		
		PingService service = new PingService();
		
		service.setDao(new DataDAO<Resource>() {
			
			@Override
			public void save(Resource t) {
				
			}
			
			@Override
			public List<Resource> find(String attr, String regexp) {

				Resource res1 = new Resource();
				res1.setPath("http://google.com");
				res1.setCookie("Set-Cookie: abc");
				
				Resource res2 = new Resource();
				res2.setPath("http://yahoo.com");
				
				return Arrays.asList(res1, res2);
			}
		});
		
		Assert.assertTrue(service.getUrlList().size() > 0);
	}
	
}
