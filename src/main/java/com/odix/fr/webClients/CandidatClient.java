package com.odix.fr.webClients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "gateway-ms:8080", fallback = CandidatClient.CandidatClientFallback.class)
@RibbonClient(name = "gateway-ms")
public interface CandidatClient {

	@GetMapping("/api/gateway/candidat/getCountCandidats")
	Long getCountCandidats();
	
	@Component
	public static class CandidatClientFallback {

		public Long getCountCandidats() {
			System.out.println("getCountCandidats");
			return (long) 0;
		}
	}
}
