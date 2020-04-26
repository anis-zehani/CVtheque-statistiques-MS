package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("opportunites-ms")
public interface OpportuniteClient {

	@GetMapping("/api/opportunite/getCountOpportunites")
	Long getCountOpportunites();
}
