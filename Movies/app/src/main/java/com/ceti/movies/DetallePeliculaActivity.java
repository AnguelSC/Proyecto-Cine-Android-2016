package com.ceti.movies;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetallePeliculaActivity extends AppCompatActivity {
    private TextView resumen;
    private String titulo,txtResumen,imagen,codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        resumen = (TextView) findViewById(R.id.resumen);

        titulo = (String) getIntent().getExtras().getString("titulo");
        txtResumen = (String) getIntent().getExtras().getString("resumen");
        codigo = (String) getIntent().getExtras().getString("codigo");
        resumen.setText(txtResumen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(titulo);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.favorito);

        final SharedPreferences sharedPref = getSharedPreferences("misFavoritos", Context.MODE_PRIVATE);
        final String verificar = sharedPref.getString(codigo,null);
        if(verificar != null){
            fab.setImageResource(R.drawable.ic_favorite_black_24dp);
        }else{
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences local = getApplicationContext().getSharedPreferences("misFavoritos", Context.MODE_PRIVATE);
                String ver = local.getString(codigo,null);
                if(ver == null){
                    SharedPreferences.Editor editor = local.edit();
                    editor.putString(codigo,"agregado");
                    editor.commit();
                    fab.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Toast.makeText(getApplicationContext(), "Agregado a tus favoritos", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences.Editor editor = local.edit();
                    editor.putString(codigo,null);
                    editor.commit();
                    fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(getApplicationContext(), "Esta pelicula ya no es tu favorita", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
