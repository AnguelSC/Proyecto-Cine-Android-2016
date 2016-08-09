package com.ceti.movies.Models;

/**
 * Created by Adrian-OTI on 8/08/2016.
 */
public class Pelicula {
    private String nombre;
    private String resumen;
    private int imagen;
    public Pelicula(String nombre, String resumen, int imagen){
        this.nombre = nombre;
        this.resumen = resumen;
        this.imagen = imagen;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}
