package com.fjco.Test02JAVAEEFJCO.Repositorio;

import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepository extends JpaRepository<OrdenFJCO, Integer> {
}
