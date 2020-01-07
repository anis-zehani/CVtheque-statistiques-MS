package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-MS")
public interface ContactClient {
	
	@GetMapping("/api/contact/getCountContacts")
	public Long getCountContacts();
}
