package com.example.crud.service;

import com.example.crud.model.Proyeccion;
import com.example.crud.repository.ProyecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyecServ {
    @Autowired
    private ProyecRepo repository;

    public Proyeccion agregarProye(Proyeccion proyeccion){
        return repository.save(proyeccion);
    }

    public List<Proyeccion> listar(){
        return repository.findAll();
    }

    public Proyeccion buscarPorId(Integer id_proyeccion){
        return repository.findById(id_proyeccion).orElse(null);
    }

    public Proyeccion actualizarProyec(Integer id_proyeccion, Proyeccion proyeccion){
        return repository.findById(id_proyeccion).map( e -> {
            e.setId_proyeccion(proyeccion.getId_proyeccion());
            e.setId_pelicula(proyeccion.getId_pelicula());
            e.setId_sala(proyeccion.getId_sala());
            e.setFecha_hora_inicio(proyeccion.getFecha_hora_inicio());
            e.setFecha_hora_fin(proyeccion.getFecha_hora_fin());
            e.setPrecio_entrada(proyeccion.getPrecio_entrada());
            e.setAsientos_disponibles(proyeccion.getAsientos_disponibles());
            return repository.save(e);
        }).orElse(null);
    }
    public void eliminar(Integer id_proyeccion){
        repository.deleteById(id_proyeccion);
    }
}
