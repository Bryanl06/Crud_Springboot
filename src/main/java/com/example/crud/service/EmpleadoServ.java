package com.example.crud.service;

import com.example.crud.model.Persona;
import com.example.crud.repository.EmpleadoRepo;
import com.example.crud.mongo.EmpleadoMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServ {
    @Autowired
    private EmpleadoRepo repository;

    @Autowired
    private EmpleadoMongoRepo mongoRepository;

    public Persona agregar(Persona persona){
        Persona personaGuardada = repository.save(persona);
        mongoRepository.save(personaGuardada);

        return personaGuardada;
    }

    public List<Persona> listar(){
        return repository.findAll();
    }

    public Persona buscarPorId(Integer id_empleado){
        return repository.findById(id_empleado).orElse(null);
    }

    public Persona actualizar(Integer id_empleado, Persona persona){
        return repository.findById(id_empleado).map(e -> {
            e.setNombre(persona.getNombre());
            e.setPuesto(persona.getPuesto());
            e.setTipo_jornada(persona.getTipo_jornada());
            e.setEmail(persona.getEmail());
            e.setTelefono(persona.getTelefono());
            e.setFecha_contratacion(persona.getFecha_contratacion());
            e.setSalario_hora(persona.getSalario_hora());
            e.setActivo(persona.getActivo());

            // Guardamos en MySQL
            Persona actualizado = repository.save(e);
            // Sincronizamos con MongoDB
            mongoRepository.save(actualizado);

            return actualizado;
        }).orElse(null);
    }

    public List<Persona> listarActivo(boolean activo){
        return repository.findByActivo(activo);
    }

    public void eliminar(Integer id_empleado){
        // Eliminamos de MySQL
        repository.deleteById(id_empleado);
        // Eliminamos de MongoDB
        mongoRepository.deleteById(id_empleado);
    }

    public String migrarAMongo() {
        try {
            // 1. Traemos los datos de MySQL
            List<Persona> listaMysql = repository.findAll();

            if (listaMysql.isEmpty()) {
                return "No hay empleados en MySQL para migrar.";
            }

            // 2. Los guardamos en MongoDB Compass
            mongoRepository.saveAll(listaMysql);

            return "Migración exitosa. Se pasaron " + listaMysql.size() + " registros a MongoDB.";
        } catch (Exception e) {
            return "Error al migrar: " + e.getMessage();
        }
    }
}
