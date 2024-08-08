package com.fjco.Test02JAVAEEFJCO.Modelo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class ProductoFJCO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreFJCO;

    @OneToMany(mappedBy = "productoFJCO")
    private Set<DetalleOrdenFJCO> detalles = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreFJCO() {
        return nombreFJCO;
    }

    public void setNombreFJCO(String nombreFJCO) {
        this.nombreFJCO = nombreFJCO;
    }

    public Set<DetalleOrdenFJCO> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleOrdenFJCO> detalles) {
        this.detalles = detalles;
    }
}
