package com.fjco.Test02JAVAEEFJCO.Servicios.Implementaciones;

import com.fjco.Test02JAVAEEFJCO.Modelo.ProductoFJCO;
import com.fjco.Test02JAVAEEFJCO.Repositorio.IProductoRepository;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public Page<ProductoFJCO> buscarTodosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoFJCO> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoFJCO> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoFJCO crearOEditar(ProductoFJCO producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
