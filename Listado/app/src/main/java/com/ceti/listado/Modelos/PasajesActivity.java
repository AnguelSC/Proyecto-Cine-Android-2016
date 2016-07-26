package com.ceti.listado.Modelos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ceti.listado.R;

import java.util.ArrayList;
import java.util.List;




public class PasajesActivity extends AppCompatActivity {
    private List<Pasaje> miLista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        Pasaje nuevo = new Pasaje();
        nuevo.setAsiento(1);
        nuevo.setNumero(14);
        nuevo.setPersona(new Persona("Miguel Angel Sirlopu C","73130609"));
        miLista.add(nuevo);
    }
}
