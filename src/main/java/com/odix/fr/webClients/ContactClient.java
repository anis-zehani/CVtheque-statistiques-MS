package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "gateway-MS")
public interface ContactClient {
	@RequestMapping(method = RequestMethod.GET, value = "/api/contact/getCountContacts")
	Long getCountContacts();
}
