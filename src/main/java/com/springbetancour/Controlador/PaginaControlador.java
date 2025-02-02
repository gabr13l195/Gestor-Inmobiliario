package com.springbetancour.Controlador;

import com.springbetancour.Entidad.FormularioComprar;
import com.springbetancour.Entidad.FormularioContacto;
import com.springbetancour.Entidad.FormularioVender;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaginaControlador {

    // Página de Contactos
    @GetMapping("/contactos")
    public String mostrarPaginaContactos(Model model) {
        model.addAttribute("formularioContacto", new FormularioContacto());
        return "screens/contactos";
    }

    @PostMapping("/enviarFormulario")
    public String enviarFormulario(@Valid @ModelAttribute("formularioContacto") FormularioContacto formularioContacto,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "screens/contactos";
        }
        return "screens/registroExitoso";
    }

    // Página de Comprar
    @GetMapping("/comprar")
    public String mostrarPaginaComprar(Model model) {
        model.addAttribute("formularioComprar", new FormularioComprar());
        return "screens/comprar";
    }

    @PostMapping("/enviarFormularioComprar")
    public String enviarFormularioComprar(@Valid @ModelAttribute("formularioComprar") FormularioComprar formularioComprar,
                                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "screens/comprar";
        }
        return "screens/registroExitoso";
    }

    // Página de Vender
    @GetMapping("/vender")
    public String mostrarPaginaVender(Model model) {
        model.addAttribute("formularioVender", new FormularioVender());
        return "screens/vender";
    }

    @PostMapping("/enviarFormularioVender")
    public String enviarFormularioVender(@Valid @ModelAttribute("formularioVender") FormularioVender formularioVender,
                                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "screens/vender";
        }
        return "screens/registroExitoso";
    }

    // Página de Servicios
    @GetMapping("/servicios")
    public String mostrarPaginaServicios() {
        return "screens/servicios";
    }

    // Página de Propiedades
    @GetMapping("/propiedades")
    public String mostrarPaginaPropiedades() {
        return "screens/propiedades";
    }
}







