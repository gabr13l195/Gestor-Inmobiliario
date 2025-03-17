package com.springbetancour.Servicios;

import com.springbetancour.Entidad.Cliente;
import com.springbetancour.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // Listar todos los clientes
    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    // Guardar un cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }
    // Obtener un cliente por ID
    public Cliente obtenerPorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    // Eliminar un cliente por ID
    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        Cliente existente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizar los campos
        existente.setNombre(cliente.getNombre());
        existente.setEmail(cliente.getEmail());
        existente.setTelefono(cliente.getTelefono());

        return clienteRepositorio.save(existente);
    }

}
