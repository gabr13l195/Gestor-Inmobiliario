package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Reserva;
import com.springbetancour.Servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    // Listar todas las reservas
    @GetMapping
    public String listarReservas(Model modelo) {
        modelo.addAttribute("reservas", reservaServicio.listarTodas());
        return "screens/reservas";
    }

    // Mostrar formulario para crear una nueva reserva
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaReserva(Model modelo) {
        modelo.addAttribute("reserva", new Reserva());
        return "screens/formularioReserva";
    }

    // Guardar una nueva reserva
    @PostMapping
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaServicio.guardar(reserva);
        return "redirect:/reservas";
    }

    // Eliminar una reserva
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaServicio.eliminar(id);
        return "redirect:/reservas";
    }
}
