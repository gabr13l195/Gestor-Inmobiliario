package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Repositorio.PropietarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServicio {

    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    public List<Propietario> listarTodos() {
        return propietarioRepositorio.findAll();
    }

    public void guardar(Propietario propietario) {
        propietarioRepositorio.save(propietario);
    }

    public void eliminar(Long id) {
        propietarioRepositorio.deleteById(id);
    }

    public Propietario obtenerPorId(Long id) {
        Optional<Propietario> propietario = propietarioRepositorio.findById(id);
        return propietario.orElse(null);
    }
}

