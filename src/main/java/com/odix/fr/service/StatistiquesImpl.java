package com.odix.fr.service;

import java.util.HashMap;
import java.util.Map;

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
	

	CandidatClient candidatClient;
	PartenaireClient partenaireClient;
	ContactClient contactClient;
	OpportuniteClient opportuniteClient;
	TechnologieClient technologieClient;
	EntrepriseClient entrepriseClient;
	
	private final StatistiquesRepository statistiquesRepository;
	
	public StatistiquesImpl
	(
			StatistiquesRepository statistiquesRepository, 
			CandidatClient candidatClient,
			PartenaireClient partenaireClient,
			ContactClient contactClient,
			OpportuniteClient opportuniteClient,
			TechnologieClient technologieClient,
			EntrepriseClient entrepriseClient
	) 
	{
		super();
		this.statistiquesRepository = statistiquesRepository;
		this.candidatClient = candidatClient;
		this.partenaireClient = partenaireClient;
		this.contactClient = contactClient;
		this.opportuniteClient = opportuniteClient;
		this.technologieClient = technologieClient;
		this.entrepriseClient = entrepriseClient;
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
			Statistiques statistiques = statistiquesRepository.findOneById((long) 1);
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

		Statistiques statistiques = statistiquesRepository.findOneById((long) 1);
		
		Long totalCandidats = statistiques.getTotalCandidats();
		Long totalOpportunites = statistiques.getTotalOpportunites();
		Long totalPartenaires = statistiques.getTotalPartenaires();
		Long totalContacts = statistiques.getTotalContacts();
		Long totalTechnologies = statistiques.getTotalTechnologies();
		Long totalEntreprises = statistiques.getTotalEntreprises();
		
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
