package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Servicios.PropiedadServicio;
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

    // Listar todas las propiedades en la página principal de propiedades
    @GetMapping
    public String listarPropiedades(Model modelo) {
        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/propiedades";
    }

    // Mostrar la página de ventas
    @GetMapping("/ventas")
    public String mostrarVentas(Model modelo) {
        List<Propiedad> propiedades = propiedadServicio.listarTodas();
        modelo.addAttribute("propiedades", propiedades);
        return "screens/ventas";
    }

    // Mostrar el formulario para agregar una nueva propiedad
    @GetMapping("/nuevaPropiedad")
    public String mostrarFormularioNuevaPropiedad(Model modelo) {
        modelo.addAttribute("propiedad", new Propiedad()); // Crear un nuevo objeto vacío para el formulario
        return "screens/nuevaPropiedad";
    }

    // Guardar una nueva propiedad
    @PostMapping("/guardar")
    public String guardarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) {
        propiedadServicio.guardar(propiedad);
        return "redirect:/propiedades";
    }

    // Mostrar el formulario para editar una propiedad existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Propiedad propiedad = propiedadServicio.obtenerPorId(id);
        if (propiedad != null) {
            modelo.addAttribute("propiedad", propiedad);
            return "screens/nuevaPropiedad"; // Usa el mismo formulario para editar
        } else {
            return "redirect:/propiedades";
        }
    }

    // Guardar cambios de una propiedad editada
    @PostMapping("/actualizar")
    public String actualizarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) {
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
