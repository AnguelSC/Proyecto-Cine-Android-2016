package com.ceti.listado;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.ceti.listado.Modelos.Pasaje;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lista);
        List<Pelicula> data = new ArrayList<>();


        Pasaje nuevo = new Pasaje();
        nuevo.setAsiento(1);
        nuevo.setNumero(14);
        nuevo.setPersona();

        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        data.add(new Pelicula("Pelicula Estreno",R.drawable.buscandoadory));
        ListaAdapter listaAdapter = new ListaAdapter(getApplicationContext(),R.layout.item,data);
        listView.setAdapter(listaAdapter);
        listView.deferNotifyDataSetChanged();
    }

    class ListaAdapter extends ArrayAdapter<Pelicula> {
        private List<Pelicula> lista = new ArrayList<>();
        public ListaAdapter(Context context, int resource,List<Pelicula> data) {
            super(context, resource);
            lista = data;
        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Pelicula pelicula = lista.get(position);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(pelicula.getImagen());
            TextView textView = (TextView) convertView.findViewById(R.id.textView);
            textView.setText(pelicula.getTitulo());
            return convertView;
        }
    }
}
