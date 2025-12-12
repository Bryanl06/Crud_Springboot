package com.example.crud.repository;

import com.example.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepo extends JpaRepository<Persona, Integer> {
    List<Persona> findByActivo(boolean activo);
}
