package com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces;

import com.fjco.Test02JAVAEEFJCO.Modelo.ProductoFJCO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Page<ProductoFJCO> buscarTodosPaginados(Pageable pageable);

    List<ProductoFJCO> obtenerTodos();

    Optional<ProductoFJCO> buscarPorId(Integer id);

    ProductoFJCO crearOEditar(ProductoFJCO producto);

    void eliminarPorId(Integer id);
}
