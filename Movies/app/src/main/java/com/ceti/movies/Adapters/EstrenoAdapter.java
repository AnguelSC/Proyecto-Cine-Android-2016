package com.ceti.movies.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ceti.movies.Models.Pelicula;
import com.ceti.movies.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian-OTI on 8/08/2016.
 */
public class EstrenoAdapter extends RecyclerView.Adapter<EstrenoAdapter.myViewHolder>{
    private List<Pelicula> list = new ArrayList<>();
    public EstrenoAdapter(List<Pelicula> list){
        this.list = list;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_estreno, parent, false);
        myViewHolder vh = new myViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Pelicula pelicula = list.get(position);
        holder.titulo.setText(pelicula.getNombre());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        public myViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
        }
    }
}
