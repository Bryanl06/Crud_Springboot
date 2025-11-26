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

    public Peliculas agregarPeli(Peliculas peliculas){
        return repository.save(peliculas);
    }

    public List<Peliculas> listarPeliculas(){
        return repository.findAll();
    }

    public Peliculas buscarpeliId(Integer id_pelicula){
        return repository.findById(id_pelicula).orElse(null);
    }

    public Peliculas actualizarPelicula(Integer id_pelicula, Peliculas peliculas){
        return repository.findById(id_pelicula).map(e ->{
            e.setTitulo(peliculas.getTitulo());
            e.setDuracion_minutos(peliculas.getDuracion_minutos());
            e.setGenero(peliculas.getGenero());
            e.setClasificacion(peliculas.getClasificacion());
            e.setDirector(peliculas.getDirector());
            e.setSinopsis(peliculas.getSinopsis());
            e.setFecha_estreno(peliculas.getFecha_estreno());
            e.setPopularidad(peliculas.getPopularidad());
            e.setActiva(true);
            e.setFecha_baja(peliculas.getFecha_baja());
            return repository.save(e);
        }).orElse(null);
    }

    public void eliminarPeli(Integer id_pelicula){
        repository.deleteById(id_pelicula);
    }

}
