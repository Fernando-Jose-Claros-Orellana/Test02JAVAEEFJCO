package com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces;

import com.fjco.Test02JAVAEEFJCO.Modelo.DetalleOrdenFJCO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDetalleOrdenService {
    Page<DetalleOrdenFJCO> buscarTodosPaginados(Pageable pageable);

    List<DetalleOrdenFJCO> obtenerTodos();

    Optional<DetalleOrdenFJCO> buscarPorId(Integer id);

    DetalleOrdenFJCO crearOEditar(DetalleOrdenFJCO detalleOrden);

    void eliminarPorId(Integer id);
}
