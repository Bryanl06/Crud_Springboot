package com.example.crud.controller;

import com.example.crud.model.Persona;
import com.example.crud.service.EmpleadoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoCont {

    @Autowired
    private EmpleadoServ service;

    @GetMapping
    public List<Persona> listar(){
        return service.listar();
    }

    @GetMapping("/{id_empleado}")
    public Persona buscarporId(@PathVariable Integer id_empleado){
        return service.buscarPorId(id_empleado);
    }

    @PostMapping
    public Persona agregar(@RequestBody Persona persona){
        return service.agregar(persona);
    }

    @PutMapping("/{id_empleado}")
    public Persona actualizar(@PathVariable Integer id_empleado,@RequestBody Persona persona){
        persona.setId_empleado(id_empleado);
        return service.actualizar(id_empleado, persona);
    }

    @DeleteMapping("/{id_empleado}")
    public void eliminar(@PathVariable Integer id_empleado){
        service.eliminar(id_empleado);
    }
}
