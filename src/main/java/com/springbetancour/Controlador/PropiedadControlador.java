package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Servicios.PropiedadServicio;
import com.springbetancour.Servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/propiedades")
public class PropiedadControlador {

    @Autowired
    private PropiedadServicio propiedadServicio;

    @Autowired
    private PropietarioServicio propietarioServicio;

    // Listar todas las propiedades
    @GetMapping
    public String listarPropiedades(Model modelo) {
        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/propiedades";
    }

    // Mostrar propiedades en la sección de ventas
    @GetMapping("/ventas")
    public String mostrarVentas(Model modelo) {
        List<Propiedad> propiedades = propiedadServicio.listarTodas();
        modelo.addAttribute("propiedades", propiedades);
        return "screens/ventas";
    }

    // Mostrar el formulario para agregar una nueva propiedad
    @GetMapping("/nuevaPropiedad")
    public String mostrarFormularioNuevaPropiedad(Model modelo) {
        modelo.addAttribute("propiedad", new Propiedad());
        modelo.addAttribute("propietarios", propietarioServicio.listarTodos()); // Listamos propietarios disponibles
        return "screens/nuevaPropiedad";
    }

    // Guardar una nueva propiedad con relación a un propietario
    @PostMapping("/guardar")
    public String guardarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad, @RequestParam Long propietarioId) {
        Propietario propietario = propietarioServicio.obtenerPorId(propietarioId);
        if (propietario != null) {
            propiedad.setPropietario(propietario);
            propiedadServicio.guardar(propiedad);
        }
        return "redirect:/propietarios"; // Redirigir a la lista de propiedades de los propietarios
    }

    // Mostrar el formulario para editar una propiedad existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Propiedad propiedad = propiedadServicio.obtenerPorId(id);
        if (propiedad != null) {
            modelo.addAttribute("propiedad", propiedad);
            modelo.addAttribute("propietarios", propietarioServicio.listarTodos()); // Listamos propietarios disponibles
            return "screens/nuevaPropiedad"; // Usa el mismo formulario para editar
        } else {
            return "redirect:/propiedades";
        }
    }

    // Guardar los cambios de una propiedad editada
    @PostMapping("/actualizar")
    public String actualizarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad, @RequestParam Long propietarioId) {
        Propietario propietario = propietarioServicio.obtenerPorId(propietarioId);
        if (propietario != null) {
            propiedad.setPropietario(propietario);
            propiedadServicio.guardar(propiedad);
        }
        return "redirect:/propietarios";
    }

    // Eliminar una propiedad por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable Long id) {
        propiedadServicio.eliminar(id);
        return "redirect:/propiedades";
    }
}


