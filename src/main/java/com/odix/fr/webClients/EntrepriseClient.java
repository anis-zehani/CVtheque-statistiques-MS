package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "backend-ms", fallback = EntrepriseClient.EntrepriseClientFallback.class)
public interface EntrepriseClient {

	@GetMapping("/api/entreprise/getCountEntreprises")
	Long getCountEntreprises();
	
	@Component
	public static class EntrepriseClientFallback {

		public Long getCountEntreprises() {
			System.out.println("getCountEntreprises");
			return (long) 0;
		}
	}
}
