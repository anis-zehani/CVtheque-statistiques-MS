package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "opportunites-MS")
public interface OpportuniteClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/opportunite/getCountOpportunites")
	Long getCountOpportunites();
}
