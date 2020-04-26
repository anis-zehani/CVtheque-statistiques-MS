package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gateway-ms")
public interface PartenaireClient {

	@GetMapping("/api/gateway/partenaire/getCountPartenaires")
	Long getCountPartenaires();
}
