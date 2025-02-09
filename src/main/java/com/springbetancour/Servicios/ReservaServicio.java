package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Reserva;
import com.springbetancour.Repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    // Listar todas las reservas
    public List<Reserva> listarTodas() {
        return reservaRepositorio.findAll();
    }

    // Guardar una reserva
    public void guardar(Reserva reserva) {
        reservaRepositorio.save(reserva);
    }

    // Obtener una reserva por ID
    public Reserva obtenerPorId(Long id) {
        return reservaRepositorio.findById(id).orElse(null);
    }

    // Eliminar una reserva por ID
    public void eliminar(Long id) {
        reservaRepositorio.deleteById(id);
    }
}
