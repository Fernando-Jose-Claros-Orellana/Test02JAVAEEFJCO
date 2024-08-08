package com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces;

import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {
    Page<OrdenFJCO> buscarTodosPaginados(Pageable pageable);

    List<OrdenFJCO> obtenerTodos();

    Optional<OrdenFJCO> buscarPorId(Integer id);

    OrdenFJCO crearOEditar(OrdenFJCO orden);

    void eliminarPorId(Integer id);
}
