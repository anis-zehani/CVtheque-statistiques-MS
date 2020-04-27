package com.odix.fr.webClients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-ms:8080", fallback = ContactClient.ContactClientFallback.class)
@RibbonClient(name = "gateway-ms")
public interface ContactClient {
	
	@GetMapping("/api/gateway/contact/getCountContacts")
	public Long getCountContacts();
	
	@Component
	public static class ContactClientFallback {

		public Long getCountContacts() {
			System.out.println("getCountContacts");
			return (long) 0;
		}
	}
}
