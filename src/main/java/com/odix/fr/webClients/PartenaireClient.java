package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gateway-MS")
public interface PartenaireClient {

	@GetMapping("/api/partenaire/getCountPartenaires")
	Long getCountPartenaires();
}
