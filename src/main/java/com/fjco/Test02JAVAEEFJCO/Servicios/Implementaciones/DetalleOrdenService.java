package com.fjco.Test02JAVAEEFJCO.Servicios.Implementaciones;

import com.fjco.Test02JAVAEEFJCO.Modelo.DetalleOrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Repositorio.IDetalleOrdenRepository;
import com.fjco.Test02JAVAEEFJCO.Repositorio.IOrdenRepository;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IDetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenService implements IDetalleOrdenService {
    @Autowired
    private IDetalleOrdenRepository detalleOrdenRepository;

    @Override
    public Page<DetalleOrdenFJCO> buscarTodosPaginados(Pageable pageable) {
        return detalleOrdenRepository.findAll(pageable);
    }

    @Override
    public List<DetalleOrdenFJCO> obtenerTodos() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public Optional<DetalleOrdenFJCO> buscarPorId(Integer id) {
        return detalleOrdenRepository.findById(id);
    }

    @Override
    public DetalleOrdenFJCO crearOEditar(DetalleOrdenFJCO detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detalleOrdenRepository.deleteById(id);
    }
}
