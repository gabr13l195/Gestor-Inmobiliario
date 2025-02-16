package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Servicios.PropiedadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/propietarios")
public class PropietarioControlador {

    @Autowired
    private PropiedadServicio propiedadServicio;

    // Mostrar la lista de propiedades del usuario
    @GetMapping
    public String listarPropiedadesDelUsuario(Model modelo) {
        List<Propiedad> propiedades = propiedadServicio.listarTodas(); // TODO: Filtrar por usuario autenticado
        modelo.addAttribute("propiedades", propiedades);
        modelo.addAttribute("propiedad", new Propiedad()); // Para agregar una nueva propiedad
        return "screens/propietarios";
    }

    // Mostrar formulario para editar una propiedad con sus datos cargados
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Propiedad propiedad = propiedadServicio.obtenerPorId(id);
        if (propiedad != null) {
            modelo.addAttribute("propiedad", propiedad);
            return "screens/nuevaPropiedad"; // Usa el mismo formulario para editar
        } else {
            return "redirect:/propietarios";
        }
    }

    // Guardar cambios de una propiedad editada
    @PostMapping("/actualizar")
    public String actualizarPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) {
        propiedadServicio.guardar(propiedad);
        return "redirect:/propietarios";
    }

    // Eliminar una propiedad
    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable Long id) {
        propiedadServicio.eliminar(id);
        return "redirect:/propietarios";
    }
}






