package com.example.crud.service;

import com.example.crud.model.Entrada;
import com.example.crud.repository.EntradaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaServ {
    @Autowired
    private EntradaRepo repository;

    public Entrada agregarEntra(Entrada entrada) {
        return  repository.save(entrada);
    }

    public List<Entrada> listar(){
        return repository.findAll();
    }

    public Entrada buscarPorId(Integer id_entrada){
        return repository.findById(id_entrada).orElse(null);
    }

    public Entrada actualizarEntrada(Integer id_entrada, Entrada entrada) {
        return repository.findById(id_entrada).map( e -> {
            e.setId_entrada(entrada.getId_entrada());
            e.setId_proyeccion(entrada.getId_proyeccion());
            e.setFecha(entrada.getFecha());
            e.setCantidad(entrada.getCantidad());
            e.setPrecio(entrada.getPrecio());
            return repository.save(e);
        }).orElse(null);
    }


    public void eliminar(Integer id_entrada){
        repository.deleteById(id_entrada);
    }
}
