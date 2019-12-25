package com.odix.fr.webClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "gateway-MS")
public interface PartenaireClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/partenaire/getCountPartenaires")
	Long getCountPartenaires();
}
