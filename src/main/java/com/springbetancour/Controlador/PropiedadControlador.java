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

    // Listar todas las propiedades en la página principal de propiedades
    @GetMapping
    public String listarPropiedades(Model modelo) {
        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/propiedades";
    }

    // Mostrar la página de ventas
    @GetMapping("/ventas")
    public String mostrarVentas(Model modelo) {
//        modelo.addAttribute("propiedades", propiedadServicio.listarTodas());
        return "screens/ventas";
    }

    // Mostrar el formulario para crear una nueva propiedad
    @GetMapping("/nuevaPropiedad")
    public String mostrarFormularioNuevaPropiedad(Model modelo) {
        modelo.addAttribute("propiedad", new Propiedad()); // Crear un objeto vacío para el formulario
        return "screens/nuevaPropiedad"; // Renderizar la vista nuevaPropiedad.html
    }

    // Guardar una nueva propiedad desde el formulario
    @PostMapping("/guardar")
    public String guardarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) {
        propiedadServicio.guardar(propiedad); // Guardar la nueva propiedad en la base de datos
        return "redirect:/propiedades"; // Redirigir a la lista de propiedades
    }

    // Eliminar una propiedad por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable Long id) {
        propiedadServicio.eliminar(id); // Eliminar la propiedad por ID
        return "redirect:/propiedades"; // Redirigir a la lista de propiedades
    }

}
