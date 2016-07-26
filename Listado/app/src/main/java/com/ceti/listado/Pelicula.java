package com.ceti.listado;

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
