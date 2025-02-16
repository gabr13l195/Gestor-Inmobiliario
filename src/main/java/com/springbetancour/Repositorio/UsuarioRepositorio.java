package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); // Busca por email en lugar de username
}

