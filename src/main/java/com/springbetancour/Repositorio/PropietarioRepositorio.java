package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, Long> {

    List<Propietario> findByNombre(String nombre);

    List<Propietario> findByNombreContaining(String keyword);
}

