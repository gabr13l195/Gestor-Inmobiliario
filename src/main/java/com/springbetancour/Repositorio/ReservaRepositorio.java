package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

    List<Reserva> findByEstado(String estado);

    List<Reserva> findByClienteId(Long clienteId);

    List<Reserva> findByPropiedadId(Long propiedadId);
}

