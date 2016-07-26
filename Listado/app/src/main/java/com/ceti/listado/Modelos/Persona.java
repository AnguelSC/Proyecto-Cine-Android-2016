package com.ceti.listado.Modelos;

/**
 * Created by Adrian-OTI on 25/07/2016.
 */
public class Persona {






    private String nombre;
    private String DNI;

    public Persona(String _nombre,String _DNI){
        nombre = _nombre;
        DNI = _DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
