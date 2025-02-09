package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropiedadRepositorio extends JpaRepository<Propiedad, Long> {

    List<Propiedad> findByEstado(String estado);

    List<Propiedad> findByPrecioBetween(Double precioMin, Double precioMax);

    List<Propiedad> findByTipo(String tipo);
}
