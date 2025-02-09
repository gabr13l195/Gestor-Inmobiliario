package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Servicios.PropiedadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/propiedades")
public class PropiedadControlador {

    @Autowired
    private PropiedadServicio propiedadServicio;

    @GetMapping("/ventas")
    public String mostrarVentas(Model modelo) {
        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/ventas";
    }

    // Listar todas las propiedades
    @GetMapping
    public String listarPropiedades(Model modelo) {
        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/propiedades";
    }

    // Mostrar formulario para crear una nueva propiedad
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaPropiedad(Model modelo) {
        modelo.addAttribute("propiedad", new Propiedad());
        return "screens/formularioPropiedad";
    }

    // Guardar una nueva propiedad
    @PostMapping
    public String guardarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) {
        propiedadServicio.guardar(propiedad);
        return "redirect:/propiedades";
    }

    // Eliminar una propiedad
    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable Long id) {
        propiedadServicio.eliminar(id);
        return "redirect:/propiedades";
    }
}
