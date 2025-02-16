package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Usuario;
import com.springbetancour.Servicios.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthControlador {

    private final UsuarioServicio usuarioServicio;

    public AuthControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario()); // Para que Thymeleaf reciba un objeto vacío
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model modelo) {
        System.out.println("Solicitud de registro recibida para: " + usuario.getEmail()); // Debug

        usuarioServicio.registrarUsuario(usuario.getEmail(), usuario.getPassword());

        modelo.addAttribute("mensaje", "Registro exitoso, ahora puedes iniciar sesión.");
        return "register"; // Muestra la misma página con el mensaje de éxito
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Debe coincidir con el nombre del archivo en templates/login.html
    }
}


