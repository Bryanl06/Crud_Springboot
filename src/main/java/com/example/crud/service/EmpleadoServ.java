package com.example.crud.service;

import com.example.crud.model.Persona;
import com.example.crud.repository.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServ {
    @Autowired
    private EmpleadoRepo repository;

    public Persona agregar(Persona persona){
        return repository.save(persona);
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
            return repository.save(e);
        }).orElse(null);
    }

    public List<Persona> listarActivo(boolean activo){
        return repository.findByActivo(activo);
    }

    public void eliminar(Integer id_empleado){
        repository.deleteById(id_empleado);
    }
}
