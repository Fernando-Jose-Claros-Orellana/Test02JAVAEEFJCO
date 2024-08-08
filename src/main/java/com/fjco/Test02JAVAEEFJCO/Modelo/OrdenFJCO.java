package com.fjco.Test02JAVAEEFJCO.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class OrdenFJCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;

    @OneToMany(mappedBy = "ordenFJCO")
    private Set<DetalleOrdenFJCO> detalles = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<DetalleOrdenFJCO> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleOrdenFJCO> detalles) {
        this.detalles = detalles;
    }
}
