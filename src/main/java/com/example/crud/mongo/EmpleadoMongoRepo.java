package com.example.crud.mongo;

import com.example.crud.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoMongoRepo extends MongoRepository<Persona, Integer> {
    List<Persona> findByActivo(boolean activo);
}
