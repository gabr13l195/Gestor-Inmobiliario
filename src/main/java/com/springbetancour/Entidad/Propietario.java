package com.springbetancour.Entidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Propietario {

    @NotBlank(message = "El tipo de propiedad es obligatorio.")
    private String tipo;

    @NotNull(message = "El precio es obligatorio.")
    private Double precio;

    @NotBlank(message = "La ubicación es obligatoria.")
    private String ubicacion;

    @NotNull(message = "El tamaño es obligatorio.")
    private Double tamaño;

    @NotBlank(message = "El estado de la propiedad es obligatorio.")
    private String estado;

    @NotBlank(message = "El nombre del propietario es obligatorio.")
    private String propietario;


    //NO ME FUNCIONA DATA
    //SE AÑADEN GETTER AND SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getTamaño() {
        return tamaño;
    }

    public void setTamaño(Double tamaño) {
        this.tamaño = tamaño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}

