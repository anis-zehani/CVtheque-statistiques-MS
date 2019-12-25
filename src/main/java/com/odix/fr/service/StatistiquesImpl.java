package com.odix.fr.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.odix.fr.model.Statistiques;
import com.odix.fr.repository.StatistiquesRepository;
import com.odix.fr.webClients.CandidatClient;
import com.odix.fr.webClients.ContactClient;
import com.odix.fr.webClients.EntrepriseClient;
import com.odix.fr.webClients.OpportuniteClient;
import com.odix.fr.webClients.PartenaireClient;
import com.odix.fr.webClients.TechnologieClient;

@Service
public class StatistiquesImpl implements StatistiquesService {
	
	@Autowired
	CandidatClient candidatClient;
	
	@Autowired
	PartenaireClient partenaireClient;
	
	@Autowired
	ContactClient contactClient;
	
	@Autowired
	OpportuniteClient opportuniteClient;
	
	@Autowired
	TechnologieClient technologieClient;
	
	@Autowired
	EntrepriseClient entrepriseClient;
	
	private final StatistiquesRepository statistiquesRepository;
	
	public StatistiquesImpl(StatistiquesRepository statistiquesRepository) {
		super();
		this.statistiquesRepository = statistiquesRepository;
	}


	// CRON ici qui fait appel aux 6 Web Clients Feign puis UPDATE les 6 chiffres clés dans la BDD : chaque 15 minutes
	@Scheduled(fixedRate = 900000)
	public void cronUpdate6ChiffresClesViaWebClients() {
		
		// On récupère les statistiques via les client Feign
		Long totalCandidats = candidatClient.getCountCandidats();
		Long totalPartenaires = partenaireClient.getCountPartenaires();
		Long totalContacts = contactClient.getCountContacts();
		Long totalOpportunites = opportuniteClient.getCountOpportunites();
		Long totalTechnologies = technologieClient.getCountTechnologies();
		Long totalEntreprises = entrepriseClient.getCountEntreprises();
		
		// On met à jour si la ligne existe
		if(statistiquesRepository.count() > 0) {
			Statistiques statistiques = statistiquesRepository.getOne(0L);
			statistiquesRepository.save(statistiques);
		}
		//On ajoute une ligne
		else {
			Statistiques statistiques = new Statistiques();
			statistiques.setTotalCandidats(totalCandidats);
			statistiques.setTotalPartenaires(totalPartenaires);
			statistiques.setTotalContacts(totalContacts);
			statistiques.setTotalOpportunites(totalOpportunites);
			statistiques.setTotalTechnologies(totalTechnologies);
			statistiques.setTotalEntreprises(totalEntreprises);
			statistiquesRepository.save(statistiques);
		}
	}
	
	//Retourne les 6 chiffres clés de base
	@Override
	public Map<String, Long> getStatistiques(){
		
		// Initialisations
		Long totalCandidats = 0L;
		Long totalOpportunites = 0L;
		Long totalPartenaires = 0L;
		Long totalContacts = 0L;
		Long totalTechnologies = 0L;
		Long totalEntreprises = 0L;
		
		Statistiques statistiques = statistiquesRepository.getOne(0L);
		
		totalCandidats = statistiques.getTotalCandidats();
		totalOpportunites = statistiques.getTotalOpportunites();
		totalPartenaires = statistiques.getTotalPartenaires();
		totalContacts = statistiques.getTotalContacts();
		totalTechnologies = statistiques.getTotalTechnologies();
		totalEntreprises = statistiques.getTotalEntreprises();
		
		Map<String, Long> map = new HashMap<>();
		
		map.put("totalCandidats", totalCandidats);
		map.put("totalOpportunites", totalOpportunites);
		map.put("totalPartenaires", totalPartenaires);
		map.put("totalContacts", totalContacts);
		map.put("totalTechnologies", totalTechnologies);
		map.put("totalEntreprises", totalEntreprises);
		
		return map;
	}
}
