package com.pucminas.petshop.repository;

import com.pucminas.petshop.entity.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {
}
