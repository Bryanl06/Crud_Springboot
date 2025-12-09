package com.example.crud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Proyecciones")
public class Proyeccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyeccion")

    @Schema(description = " ID Autoincrement", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id_proyeccion;
    private Integer id_pelicula;
    private Integer id_sala;
    private LocalDate fecha_hora_inicio;
    private LocalDate fecha_hora_fin;
    private double precio_entrada;
    private Integer asientos_disponibles;

    public Integer getId_proyeccion() {
        return id_proyeccion;
    }

    public void setId_proyeccion(Integer id_proyeccion) {
        this.id_proyeccion = id_proyeccion;
    }

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public LocalDate getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(LocalDate fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public LocalDate getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(LocalDate fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public double getPrecio_entrada() {
        return precio_entrada;
    }

    public void setPrecio_entrada(double precio_entrada) {
        this.precio_entrada = precio_entrada;
    }

    public Integer getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public void setAsientos_disponibles(Integer asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }
}
