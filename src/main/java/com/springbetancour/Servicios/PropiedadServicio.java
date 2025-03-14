package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Repositorio.PropiedadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropiedadServicio {

    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    public List<Propiedad> listarTodas() {
        return propiedadRepositorio.findAll();
    }

    public Propiedad obtenerPorId(Long id) {
        return propiedadRepositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        propiedadRepositorio.deleteById(id);
    }

    public void actualizarPropiedad(Long id, Propiedad nuevaPropiedad) {
        Optional<Propiedad> propiedadExistente = propiedadRepositorio.findById(id);
        if (propiedadExistente.isPresent()) {
            Propiedad propiedad = propiedadExistente.get();
            propiedad.setTipo(nuevaPropiedad.getTipo());
            propiedad.setUbicacion(nuevaPropiedad.getUbicacion());
            propiedad.setPrecio(nuevaPropiedad.getPrecio());
            propiedad.setEstado(nuevaPropiedad.getEstado());
            propiedadRepositorio.save(propiedad);
        }
    }

    public void guardar(Propiedad propiedad) {
        propiedadRepositorio.save(propiedad);
    }
}


