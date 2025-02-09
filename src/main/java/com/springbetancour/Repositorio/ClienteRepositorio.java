package com.springbetancour.Repositorio;

import com.springbetancour.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombre(String nombre);

    Cliente findByEmail(String email);
}
