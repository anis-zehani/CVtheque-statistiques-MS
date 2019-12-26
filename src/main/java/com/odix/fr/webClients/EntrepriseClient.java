package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("backend-MS")
public interface EntrepriseClient {

	@GetMapping("/api/entreprise/getCountEntreprises")
	Long getCountEntreprises();
}
