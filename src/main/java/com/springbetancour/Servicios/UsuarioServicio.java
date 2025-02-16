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
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(password)); // Encripta la contraseña
        usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> encontrarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
}

