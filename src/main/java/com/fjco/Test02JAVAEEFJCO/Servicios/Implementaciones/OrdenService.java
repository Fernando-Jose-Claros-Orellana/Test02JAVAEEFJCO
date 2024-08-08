package com.fjco.Test02JAVAEEFJCO.Servicios.Implementaciones;

import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Repositorio.IOrdenRepository;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private IOrdenRepository ordenRepository;

    @Override
    public Page<OrdenFJCO> buscarTodosPaginados(Pageable pageable) {
        return ordenRepository.findAll(pageable);
    }

    @Override
    public List<OrdenFJCO> obtenerTodos() {
        return ordenRepository.findAll();
    }

    @Override
    public Optional<OrdenFJCO> buscarPorId(Integer id) {
        return ordenRepository.findById(id);
    }

    @Override
    public OrdenFJCO crearOEditar(OrdenFJCO orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ordenRepository.deleteById(id);
    }
}
