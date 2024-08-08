package com.fjco.Test02JAVAEEFJCO.Repositorio;

import com.fjco.Test02JAVAEEFJCO.Modelo.ProductoFJCO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoFJCO, Integer> {
}
