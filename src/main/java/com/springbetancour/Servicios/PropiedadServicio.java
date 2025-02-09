package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Repositorio.PropiedadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadServicio {

    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    // Listar todas las propiedades
    public List<Propiedad> listarTodas() {
        return propiedadRepositorio.findAll();
    }

    // Guardar una propiedad
    public void guardar(Propiedad propiedad) {
        propiedadRepositorio.save(propiedad);
    }

    // Obtener una propiedad por ID
    public Propiedad obtenerPorId(Long id) {
        return propiedadRepositorio.findById(id).orElse(null);
    }

    // Eliminar una propiedad por ID
    public void eliminar(Long id) {
        propiedadRepositorio.deleteById(id);
    }
}
