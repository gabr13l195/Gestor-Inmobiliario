package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Usuario;
import com.springbetancour.Repositorio.UsuarioRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void registrarUsuario(String email, String password) {
        System.out.println("Registrando usuario: " + email); // Verifica si se ejecuta

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(password)); // Encripta la contraseña

        usuarioRepositorio.save(usuario);
        System.out.println("Usuario guardado en la base de datos: " + email);
    }


    public Optional<Usuario> encontrarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
}

