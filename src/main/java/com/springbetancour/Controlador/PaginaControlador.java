package com.springbetancour.Controlador;

import com.springbetancour.Entidad.FormularioContacto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaginaControlador {

    @GetMapping("/contactos")
    public String mostrarPaginaContactos(Model model) {
        model.addAttribute("formularioContacto", new FormularioContacto());
        return "screens/contactos";
    }


    @PostMapping("/enviarFormulario")
    public String enviarFormulario(@Valid @ModelAttribute("formularioContacto") FormularioContacto formularioContacto,
                                   BindingResult bindingResult, Model model) {
        // Si hay errores en la validación, volver a la página de contactos
        if (bindingResult.hasErrors()) {
            return "screens/contactos";
        }
        // Si esta correcto se va a la pagina de validacion.
        return "screens/registroExitoso";
    }


    @GetMapping("/servicios")
    public  String mostrarPaginaServicios(){
        return "screens/servicios";
    }
}







