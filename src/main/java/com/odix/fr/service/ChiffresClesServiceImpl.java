package com.odix.fr.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ChiffresClesServiceImpl implements ChiffresClesService {
	
	/*private final CandidatRepository candidatRepository;
	private final OpportuniteRepository opportuniteRepository;
	private final PartenaireRepository partenaireRepository;
	private final ContactRepository contactRepository;
	private final TechnologieRepository technologieRepository;
	private final EntrepriseRepository entrepriseRepository;
	
	public ChiffresClesServiceImpl(CandidatRepository candidatRepository, OpportuniteRepository opportuniteRepository,
			PartenaireRepository partenaireRepository, ContactRepository contactRepository,
			TechnologieRepository technologieRepository, EntrepriseRepository entrepriseRepository) {
		super();
		this.candidatRepository = candidatRepository;
		this.opportuniteRepository = opportuniteRepository;
		this.partenaireRepository = partenaireRepository;
		this.contactRepository = contactRepository;
		this.technologieRepository = technologieRepository;
		this.entrepriseRepository = entrepriseRepository;
	}*/
	
	//Retourne les 6 chiffres clés de base
	@Override
	public Map<String, Long> getChiffreCles(){
		
		/*Long totalCandidats = candidatRepository.count();
		Long totalOpportunites = opportuniteRepository.count();
		Long totalPartenaires = partenaireRepository.count();
		Long totalContacts = contactRepository.count();
		Long totalTechnologies = technologieRepository.count();
		Long totalEntreprises = entrepriseRepository.count();*/
		
		Map<String, Long> map = new HashMap<>();
		
		/*map.put("totalCandidats", totalCandidats);
		map.put("totalOpportunites", totalOpportunites);
		map.put("totalPartenaires", totalPartenaires);
		map.put("totalContacts", totalContacts);
		map.put("totalTechnologies", totalTechnologies);
		map.put("totalEntreprises", totalEntreprises);*/
		
		map.put("totalCandidats", 0L);
		map.put("totalOpportunites", 0L);
		map.put("totalPartenaires", 0L);
		map.put("totalContacts", 0L);
		map.put("totalTechnologies", 0L);
		map.put("totalEntreprises", 0L);
		
		return map;
	}
}
