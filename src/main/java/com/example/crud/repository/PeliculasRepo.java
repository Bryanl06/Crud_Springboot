package com.example.crud.repository;

import com.example.crud.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepo extends JpaRepository<Peliculas, Integer> {
}

