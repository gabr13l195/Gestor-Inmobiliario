package com.springbetancour.Controlador;

import com.springbetancour.Entidad.Propiedad;
import com.springbetancour.Entidad.Propietario;
import com.springbetancour.Servicios.PropiedadServicio;
import com.springbetancour.Servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
@CrossOrigin(origins = "*")
public class PropiedadControlador {

    @Autowired
    private PropiedadServicio propiedadServicio;

    // Obtener todas las propiedades
    @GetMapping
    public ResponseEntity<List<Propiedad>> listarPropiedades() {
        return ResponseEntity.ok(propiedadServicio.listarTodas());
    }

    // Obtener una propiedad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> obtenerPropiedad(@PathVariable Long id) {
        return ResponseEntity.ok(propiedadServicio.obtenerPorId(id));
    }

    // Crear una nueva propiedad
    @PostMapping
    public ResponseEntity<Propiedad> crearPropiedad(@RequestBody Propiedad propiedad) {
        Propiedad nuevaPropiedad = propiedadServicio.guardar(propiedad);
        return ResponseEntity.ok(nuevaPropiedad);
    }

    // Actualizar una propiedad
    @PutMapping("/{id}")
    public ResponseEntity<Propiedad> actualizarPropiedad(@PathVariable Long id, @RequestBody Propiedad propiedad) {
        Propiedad actualizada = propiedadServicio.actualizar(id, propiedad);
        return ResponseEntity.ok(actualizada);
    }

    // Eliminar una propiedad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropiedad(@PathVariable Long id) {
        propiedadServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}



