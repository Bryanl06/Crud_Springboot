package com.example.crud.repository;

import com.example.crud.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntradaRepo extends JpaRepository<Entrada,Integer> {

}

