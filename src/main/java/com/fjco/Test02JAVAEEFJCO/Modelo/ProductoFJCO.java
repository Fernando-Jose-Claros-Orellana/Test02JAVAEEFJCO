package com.fjco.Test02JAVAEEFJCO.Modelo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Producto")
public class ProductoFJCO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreFJCO;

    @OneToMany(mappedBy = "productoFJCO")
    private Set<DetalleOrdenFJCO> detalles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
