package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "backend-ms:8001", fallback = EntrepriseClient.EntrepriseClientFallback.class)
@FeignClient("backend-ms:8001")
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
