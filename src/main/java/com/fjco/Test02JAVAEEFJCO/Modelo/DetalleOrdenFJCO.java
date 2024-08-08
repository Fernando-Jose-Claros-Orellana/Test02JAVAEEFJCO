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

    @NotBlank(message = "La cantidad es requerida")
    private int cantidadFJCO;

    @NotBlank(message = "El precio es requerido")
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

    @NotBlank(message = "La cantidad es requerida")
    public int getCantidadFJCO() {
        return cantidadFJCO;
    }

    public void setCantidadFJCO(@NotBlank(message = "La cantidad es requerida") int cantidadFJCO) {
        this.cantidadFJCO = cantidadFJCO;
    }

    @NotBlank(message = "El precio es requerido")
    public double getPrecioFJCO() {
        return precioFJCO;
    }

    public void setPrecioFJCO(@NotBlank(message = "El precio es requerido") double precioFJCO) {
        this.precioFJCO = precioFJCO;
    }
}
