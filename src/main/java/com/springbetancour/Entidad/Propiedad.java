package com.springbetancour.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String ubicacion;
    private Double precio;
    private String estado;

    @Column(nullable = false)
    private Double tamaño = 0.0;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    // Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTamaño() {
        return tamaño;
    }

    public void setTamaño(Double tamaño) {
        this.tamaño = tamaño;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}

