package com.ceti.movies.Models;

import java.util.List;

/**
 * Created by Adrian-OTI on 15/08/2016.
 */
public class Producto {
    private int pro_Id;
    private String pro_Nombre;
    private String pro_Descripcion;
    private String pro_Imagen;
    private List<Presentacion> presentaciones;

    public int getPro_Id() {
        return pro_Id;
    }

    public void setPro_Id(int pro_Id) {
        this.pro_Id = pro_Id;
    }

    public String getPro_Nombre() {
        return pro_Nombre;
    }

    public void setPro_Nombre(String pro_Nombre) {
        this.pro_Nombre = pro_Nombre;
    }

    public String getPro_Descripcion() {
        return pro_Descripcion;
    }

    public void setPro_Descripcion(String pro_Descripcion) {
        this.pro_Descripcion = pro_Descripcion;
    }

    public String getPro_Imagen() {
        return pro_Imagen;
    }

    public void setPro_Imagen(String pro_Imagen) {
        this.pro_Imagen = pro_Imagen;
    }

    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;
    }
}
