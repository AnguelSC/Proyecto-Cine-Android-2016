package com.ceti.listado;

/**
 * Created by Adrian-OTI on 18/07/2016.
 */
public class Pelicula {
    private String Titulo;
    private int imagen;


    public Pelicula(String Titulo,int imagen){
        this.Titulo = Titulo;
        this.imagen = imagen;
    }
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
