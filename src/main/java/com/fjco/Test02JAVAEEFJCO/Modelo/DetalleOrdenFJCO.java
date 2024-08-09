package com.fjco.Test02JAVAEEFJCO.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "DetalleOrden")
public class DetalleOrdenFJCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenFJCO ordenFJCO;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoFJCO productoFJCO;

    private int cantidadFJCO;


    private double precioFJCO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdenFJCO getOrdenFJCO() {
        return ordenFJCO;
    }

    public void setOrdenFJCO(OrdenFJCO ordenFJCO) {
        this.ordenFJCO = ordenFJCO;
    }

    public ProductoFJCO getProductoFJCO() {
        return productoFJCO;
    }

    public void setProductoFJCO(ProductoFJCO productoFJCO) {
        this.productoFJCO = productoFJCO;
    }

    public int getCantidadFJCO() {
        return cantidadFJCO;
    }

    public void setCantidadFJCO(int cantidadFJCO) {
        this.cantidadFJCO = cantidadFJCO;
    }

    public double getPrecioFJCO() {
        return precioFJCO;
    }

    public void setPrecioFJCO(double precioFJCO) {
        this.precioFJCO = precioFJCO;
    }
}
