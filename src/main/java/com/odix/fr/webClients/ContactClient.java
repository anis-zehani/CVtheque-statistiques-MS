package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-ms")
public interface ContactClient {
	
	@GetMapping("/api/gateway/contact/getCountContacts")
	public Long getCountContacts();
}
