package com.odix.fr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odix.fr.service.StatistiquesService;


@RestController
@RequestMapping("/api/statistiques")
public class StatistiquesController {
	
	@Autowired
	StatistiquesService statistiquesService;
	
	//Retourne les 6 chiffres clés de base
	@GetMapping("/all")
	public Map<String, Long> getStatistiques() {
	    return statistiquesService.getStatistiques();
	}
}
