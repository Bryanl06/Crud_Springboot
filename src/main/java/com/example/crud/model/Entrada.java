package com.example.crud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Entradas")
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")

    @Schema(description = "ID Autoincrement", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id_entrada;
    private Integer id_proyeccion;
    private LocalDate fecha;
    private Integer cantidad;
    private double precio;

    public Integer getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Integer id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Integer getId_proyeccion() {
        return id_proyeccion;
    }

    public void setId_proyeccion(Integer id_proyeccion) {
        this.id_proyeccion = id_proyeccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
