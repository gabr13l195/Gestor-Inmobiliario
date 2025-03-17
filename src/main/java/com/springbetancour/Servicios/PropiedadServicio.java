package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Repositorio.PropiedadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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

    // Obtener una propiedad por ID
    public Propiedad obtenerPorId(Long id) {
        return propiedadRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada con ID: " + id));
    }

    // Guardar una nueva propiedad
    public Propiedad guardar(Propiedad propiedad) {
        return propiedadRepositorio.save(propiedad);
    }

    // Actualizar una propiedad
    public Propiedad actualizar(Long id, Propiedad propiedad) {
        Propiedad existente = propiedadRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada con ID: " + id));

        // Actualizar los campos necesarios
        existente.setTipo(propiedad.getTipo());
        existente.setPrecio(propiedad.getPrecio());
        existente.setUbicacion(propiedad.getUbicacion());
        existente.setTamano(propiedad.getTamano());
        existente.setEstado(propiedad.getEstado());
        existente.setPropietario(propiedad.getPropietario());

        return propiedadRepositorio.save(existente);
    }

    // Eliminar una propiedad
    public void eliminar(Long id) {
        propiedadRepositorio.deleteById(id);
    }
}



