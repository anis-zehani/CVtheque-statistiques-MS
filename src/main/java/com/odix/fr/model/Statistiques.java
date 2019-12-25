package com.odix.fr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Statistiques implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7411885250319618267L;
	
	@Id
	private @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	@Column
	private Long totalCandidats;
	
	@Column
	private Long totalOpportunites;
	
	@Column
	private Long totalPartenaires;
	
	@Column
	private Long totalContacts;
	
	@Column
	private Long totalTechnologies;
	
	@Column
	private Long totalEntreprises;

	public Long getId() {
		return id;
	}

	public Long getTotalCandidats() {
		return totalCandidats;
	}

	public Long getTotalOpportunites() {
		return totalOpportunites;
	}

	public Long getTotalPartenaires() {
		return totalPartenaires;
	}

	public Long getTotalContacts() {
		return totalContacts;
	}

	public Long getTotalTechnologies() {
		return totalTechnologies;
	}

	public Long getTotalEntreprises() {
		return totalEntreprises;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTotalCandidats(Long totalCandidats) {
		this.totalCandidats = totalCandidats;
	}

	public void setTotalOpportunites(Long totalOpportunites) {
		this.totalOpportunites = totalOpportunites;
	}

	public void setTotalPartenaires(Long totalPartenaires) {
		this.totalPartenaires = totalPartenaires;
	}

	public void setTotalContacts(Long totalContacts) {
		this.totalContacts = totalContacts;
	}

	public void setTotalTechnologies(Long totalTechnologies) {
		this.totalTechnologies = totalTechnologies;
	}

	public void setTotalEntreprises(Long totalEntreprises) {
		this.totalEntreprises = totalEntreprises;
	}
}
