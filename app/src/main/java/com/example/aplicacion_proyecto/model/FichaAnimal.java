package com.example.aplicacion_proyecto.model;

public class FichaAnimal {
    private String nombre;
    private String tipoAnimal;
    private String fechaAdopcion;

    // Constructor
    public FichaAnimal(String nombre, String tipoAnimal, String fechaAdopcion) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.fechaAdopcion = fechaAdopcion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}