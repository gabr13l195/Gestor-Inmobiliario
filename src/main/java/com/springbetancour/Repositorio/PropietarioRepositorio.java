package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropietarioRepositorio extends JpaRepository<Propietario, Long> {

    List<Propietario> findByNombre(String nombre);

    List<Propietario> findByNombreContaining(String keyword);
}

