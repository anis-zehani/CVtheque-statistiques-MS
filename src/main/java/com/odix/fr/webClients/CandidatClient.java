package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "gateway-MS")
public interface CandidatClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/candidat/getCountCandidats")
	Long getCountCandidats();
}
