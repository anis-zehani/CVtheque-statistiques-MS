package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gateway-ms")
public interface CandidatClient {

	@GetMapping("/api/gateway/candidat/getCountCandidats")
	Long getCountCandidats();
}
