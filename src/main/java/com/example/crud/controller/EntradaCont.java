package com.example.crud.controller;

import com.example.crud.model.Entrada;
import com.example.crud.service.EntradaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaCont {
    @Autowired
    private EntradaServ service;

    @GetMapping
    public List<Entrada> listar() {
        return service.listar();
    }

    @GetMapping("/{id_entrada}")
    public Entrada buscarPorId(@PathVariable Integer id_entrada) {
        return service.buscarPorId(id_entrada);
    }

    @PostMapping
    public Entrada agregarEntr(@RequestBody Entrada entrada){
        return service.agregarEntra(entrada);
    }

    @PutMapping("/{id_entrada}")
    public Entrada actualizarEntrada(@PathVariable Integer id_entrada, @RequestBody Entrada entrada){
        entrada.setId_entrada(id_entrada);
        return service.actualizarEntrada(id_entrada, entrada);
    }

    @DeleteMapping
    public void eliminarEntrada(@RequestBody Integer id_entrada){
        service.eliminar(id_entrada);
    }
}
