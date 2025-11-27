package com.example.crud.controller;

import com.example.crud.model.Peliculas;
import com.example.crud.service.PeliculasServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id_pelicula}")
    public Peliculas buscarpeliId(@PathVariable Integer id_pelicula){

        return serivce.buscarpeliId(id_pelicula);
    }

    @PostMapping
    public Peliculas agregarPeli(@RequestBody Peliculas peliculas){
        return serivce.agregarPeli(peliculas);
    }

    @PutMapping("/{id_pelicula}")
    public Peliculas actualizarPelicula(@PathVariable Integer id_pelicula, @RequestBody Peliculas peliculas){
        peliculas.setId_pelicula(id_pelicula);
        return serivce.actualizarPelicula(id_pelicula, peliculas);
    }

    @DeleteMapping("/{id_pelicula}")
    public void eliminarPeli(@PathVariable Integer id_pelicula){
        serivce.eliminarPeli(id_pelicula);
    }
}
