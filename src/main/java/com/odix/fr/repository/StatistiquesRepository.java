package com.odix.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odix.fr.model.Statistiques;

@Repository
public interface StatistiquesRepository extends JpaRepository<Statistiques, Long> {

	Statistiques findOneById(Long id);
}
