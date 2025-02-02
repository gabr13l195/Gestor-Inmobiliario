package com.springbetancour.Entidad;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FormularioContacto {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String nombre;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "Debe proporcionar un correo electrónico válido.")
    private String email;

    @NotBlank(message = "El mensaje es obligatorio.")
    @Size(min = 10, max = 500, message = "El mensaje debe tener entre 10 y 500 caracteres.")
    private String mensaje;

    @NotNull(message = "El número de teléfono es obligatorio.")
    @Size(min = 1, max = 10, message = "El número de teléfono debe tener entre 1 y 10 dígitos.")
    private String numero;

    // Getters y Setters (opcional debido a @Data de Lombok)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}


