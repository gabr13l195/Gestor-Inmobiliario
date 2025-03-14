package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Cliente;
import com.springbetancour.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    // Listar todos los clientes
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteServicio.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Mostrar formulario para crear un nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model modelo) {
        modelo.addAttribute("cliente", new Cliente());
        return "screens/formularioCliente";
    }

    // Guardar un nuevo cliente
    @PostMapping
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.guardar(cliente);
        return "redirect:/clientes";
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminar(id);
        return "redirect:/clientes";
    }
}

