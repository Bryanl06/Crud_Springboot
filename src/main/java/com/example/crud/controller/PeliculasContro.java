package com.example.crud.controller;

import com.example.crud.model.Peliculas;
import com.example.crud.service.PeliculasServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculasContro {
    @Autowired
    private PeliculasServ serivce;

    @GetMapping
    public List<Peliculas> listar(){
        return serivce.listarPeliculas();
    }
}
