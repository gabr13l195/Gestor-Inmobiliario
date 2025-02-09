package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Repositorio.PropietarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServicio {

    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    // Listar todos los propietarios
    public List<Propietario> listarTodos() {
        return propietarioRepositorio.findAll();
    }

    // Guardar un propietario
    public void guardar(Propietario propietario) {
        propietarioRepositorio.save(propietario);
    }

    // Obtener un propietario por ID
    public Propietario obtenerPorId(Long id) {
        return propietarioRepositorio.findById(id).orElse(null);
    }

    // Eliminar un propietario por ID
    public void eliminar(Long id) {
        propietarioRepositorio.deleteById(id);
    }
}

