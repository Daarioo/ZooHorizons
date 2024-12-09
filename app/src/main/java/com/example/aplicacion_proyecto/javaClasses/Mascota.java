package com.example.aplicacion_proyecto.javaClasses;

public class Mascota {
    private String nombre;
    private int imagenId;

    public Mascota(String nombre, int imagenId) {
        this.nombre = nombre;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenId() {
        return imagenId;
    }
}
