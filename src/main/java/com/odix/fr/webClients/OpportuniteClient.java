package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "opportunites-ms:8002", fallback = OpportuniteClient.OpportuniteClientFallback.class)
@FeignClient("opportunites-ms")
public interface OpportuniteClient {

	@GetMapping("/api/opportunite/getCountOpportunites")
	Long getCountOpportunites();
	
	@Component
	public static class OpportuniteClientFallback {

		public Long getCountOpportunites() {
			System.out.println("getCountOpportunites");
			return (long) 0;
		}
	}
}
