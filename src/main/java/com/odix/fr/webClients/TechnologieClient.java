package com.odix.fr.webClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "backend-ms:8001", fallback = TechnologieClient.TechnologieClientFallback.class)
@FeignClient("http://backend-ms")
public interface TechnologieClient {

	@GetMapping("/api/technologie/getCountTechnologies")
	Long getCountTechnologies();
	
	@Component
	public static class TechnologieClientFallback {

		public Long getCountTechnologies() {
			System.out.println("getCountTechnologies");
			return (long) 0;
		}
	}
}

