package com.ceti.movies.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceti.movies.Models.Pelicula;
import com.ceti.movies.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian-OTI on 8/08/2016.
 */
public class ProximoAdapter extends RecyclerView.Adapter<ProximoAdapter.myViewHolder>{
    private List<Pelicula> list = new ArrayList<>();
    public ProximoAdapter(List<Pelicula> list){
        this.list = list;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_proximo, parent, false);
        myViewHolder vh = new myViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Pelicula pelicula = list.get(position);
        holder.titulo.setText(pelicula.getNombre());
        holder.resumen.setText(pelicula.getResumen());
        holder.imagen.setImageResource(pelicula.getImagen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private ImageView imagen;
        private TextView resumen;
        private ImageButton favorito;
        public myViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            resumen = (TextView) itemView.findViewById(R.id.resumen);
            favorito = (ImageButton) itemView.findViewById(R.id.favorito);
        }
    }
}
