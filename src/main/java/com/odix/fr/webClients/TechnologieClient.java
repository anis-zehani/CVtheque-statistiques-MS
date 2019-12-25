package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "backend-MS")
public interface TechnologieClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/technologie/getCountTechnologies")
	Long getCountTechnologies();
}
