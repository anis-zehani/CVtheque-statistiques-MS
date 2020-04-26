package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-ms", fallback = PartenaireClient.PartenaireClientFallback.class)
public interface PartenaireClient {

	@GetMapping("/api/gateway/partenaire/getCountPartenaires")
	Long getCountPartenaires();
	
	@Component
	public static class PartenaireClientFallback {

		public Long getCountPartenaires() {
			System.out.println("getCountPartenaires");
			return null;
		}
	}
}
