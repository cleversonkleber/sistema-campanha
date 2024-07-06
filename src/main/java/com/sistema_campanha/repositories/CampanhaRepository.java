package com.sistema_campanha.repositories;

import com.sistema_campanha.entities.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
}
