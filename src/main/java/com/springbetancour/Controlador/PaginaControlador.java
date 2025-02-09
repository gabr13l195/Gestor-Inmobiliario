package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Cliente;
import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Entidad.Consulta;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaginaControlador {

    // Formulario para comprar propiedades (Cliente)
    @GetMapping("/comprar")
    public String mostrarPaginaComprar(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "screens/comprar";
    }

    @PostMapping("/enviarCompra")
    public String procesarFormularioCompra(@Valid @ModelAttribute("cliente") Cliente cliente,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "screens/comprar";
        }
        return "screens/registroExitoso";
    }

    // Formulario para vender propiedades (Propietario)
    @GetMapping("/vender")
    public String mostrarPaginaVender(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "screens/vender";
    }

    @PostMapping("/enviarVenta")
    public String procesarFormularioVenta(@Valid @ModelAttribute("propietario") Propietario propietario,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "screens/vender";
        }
        return "screens/registroExitoso";
    }

    // Formulario de contacto (Consulta)
    @GetMapping("/contactos")
    public String mostrarPaginaContactos(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "screens/contactos";
    }

    @PostMapping("/enviarConsulta")
    public String procesarFormularioConsulta(@Valid @ModelAttribute("consulta") Consulta consulta,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "screens/contactos";
        }
        return "screens/registroExitoso";
    }

    // Página de servicios
    @GetMapping("/servicios")
    public String mostrarPaginaServicios() {
        return "screens/servicios";
    }

    // Página de propiedades
    @GetMapping("/propiedades")
    public String mostrarPaginaPropiedades() {
        return "screens/propiedades";
    }
}







