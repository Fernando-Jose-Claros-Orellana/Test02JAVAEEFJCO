package com.fjco.Test02JAVAEEFJCO.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orden")
public class OrdenFJCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @OneToMany(mappedBy = "ordenFJCO")
    private Set<DetalleOrdenFJCO> detalles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "La fecha de vencimiento es requerida") LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull(message = "La fecha de vencimiento es requerida") LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<DetalleOrdenFJCO> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleOrdenFJCO> detalles) {
        this.detalles = detalles;
    }
}
