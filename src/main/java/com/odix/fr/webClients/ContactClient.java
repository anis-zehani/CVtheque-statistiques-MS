package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-ms", fallback = ContactClient.ContactClientFallback.class)
public interface ContactClient {
	
	@GetMapping("/api/gateway/contact/getCountContacts")
	public Long getCountContacts();
	
	@Component
	public static class ContactClientFallback {

		public Long getCountContacts() {
			System.out.println("getCountContacts");
			return null;
		}
	}
}
