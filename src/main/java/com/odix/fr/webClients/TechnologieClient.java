package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("backend-ms")
public interface TechnologieClient {

	@GetMapping("/api/technologie/getCountTechnologies")
	Long getCountTechnologies();
}
