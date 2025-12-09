package com.example.crud.controller;

import com.example.crud.model.Proyeccion;
import com.example.crud.service.ProyecServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyecCont {

    @Autowired
    private ProyecServ service;

    @GetMapping
    public List<Proyeccion> listar(){
        return service.listar();
    }

    @GetMapping("/{id_proyeccion}")
    public Proyeccion buscarPorId(@PathVariable Integer id_proyeccion){
        return service.buscarPorId(id_proyeccion);
    }

    @PostMapping
    public Proyeccion agregarProye(@RequestBody Proyeccion proyeccion){
        return service.agregarProye(proyeccion);
    }

    @PutMapping("/{id_proyeccion}")
    public Proyeccion actualizarProyec(@PathVariable Integer id_proyeccion, @RequestBody Proyeccion proyeccion){
        proyeccion.setId_proyeccion(id_proyeccion);
        return service.actualizarProyec(id_proyeccion, proyeccion);
    }

    @DeleteMapping("/{id_proyeccion}")
    public void eliminarProyeccion(@PathVariable Integer id_proyeccion){
        service.eliminar(id_proyeccion);
    }
}
