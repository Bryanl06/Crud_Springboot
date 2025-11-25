package com.example.crud.service;

import com.example.crud.model.Peliculas;
import com.example.crud.repository.PeliculasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServ {
    @Autowired
    private PeliculasRepo repository;

    public Peliculas agregar(Peliculas peliculas){
        return repository.save(peliculas);
    }

    public List<Peliculas> listarPeliculas(){
        return repository.findAll();
    }

    public Peliculas actualizarPelicula(Integer id_pelicula,  Peliculas peliculas){
        peliculas.setId_pelicula(id_pelicula);
        return repository.save(peliculas);
    }

    public void eliminar(Integer id_pelicula){
        repository.deleteById(id_pelicula);
    }
}
