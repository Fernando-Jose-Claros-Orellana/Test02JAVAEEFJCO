package com.fjco.Test02JAVAEEFJCO.Repositorio;

import com.fjco.Test02JAVAEEFJCO.Modelo.DetalleOrdenFJCO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrdenFJCO, Integer> {
}
