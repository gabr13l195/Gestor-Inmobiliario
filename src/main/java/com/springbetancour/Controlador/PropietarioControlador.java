package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/propietarios")
public class PropietarioControlador {

    @Autowired
    private PropietarioServicio propietarioServicio;

    // Listar todos los propietarios
    @GetMapping
    public String listarPropietarios(Model modelo) {
        modelo.addAttribute("propietarios", propietarioServicio.listarTodos());
        return "screens/propietarios"; // Vista a mostrar
    }

    // Mostrar formulario para crear un nuevo propietario
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPropietario(Model modelo) {
        modelo.addAttribute("propietario", new Propietario());
        return "screens/formularioPropietario";
    }

    // Guardar un nuevo propietario
    @PostMapping
    public String guardarPropietario(@ModelAttribute("propietario") Propietario propietario) {
        propietarioServicio.guardar(propietario);
        return "redirect:/propietarios";
    }

    // Eliminar un propietario
    @GetMapping("/eliminar/{id}")
    public String eliminarPropietario(@PathVariable Long id) {
        propietarioServicio.eliminar(id);
        return "redirect:/propietarios";
    }
}








