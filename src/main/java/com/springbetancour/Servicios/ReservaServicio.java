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

    // Obtener una reserva por ID
    public Reserva obtenerPorId(Long id) {
        return reservaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    // Guardar una nueva reserva
    public Reserva guardar(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    // Actualizar una reserva
    public Reserva actualizar(Long id, Reserva reserva) {
        Reserva existente = reservaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));

        // Actualizar los campos necesarios
        existente.setCliente(reserva.getCliente());
        existente.setPropiedad(reserva.getPropiedad());
        existente.setFechaVisita(reserva.getFechaVisita());
        existente.setEstado(reserva.getEstado());

        return reservaRepositorio.save(existente);
    }

    // Eliminar una reserva
    public void eliminar(Long id) {
        reservaRepositorio.deleteById(id);
    }
}
