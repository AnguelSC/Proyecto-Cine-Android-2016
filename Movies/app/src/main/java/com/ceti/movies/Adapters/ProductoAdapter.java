package com.ceti.movies.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ceti.movies.Models.Producto;
import com.ceti.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian-OTI on 15/08/2016.
 */
public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.myViewHolder> {

    private List<Producto> lista = new ArrayList<>();
    private Context context;
    public ProductoAdapter(List<Producto> lista){
        this.lista = lista;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_producto,parent,false);
        context = parent.getContext();
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Producto producto = lista.get(position);
        holder.titulo.setText(producto.getPro_Nombre());
        holder.resumen.setText(producto.getPro_Descripcion());
        Toast.makeText(context, ""+producto.getPro_Imagen(), Toast.LENGTH_SHORT).show();
        Picasso.with(context).load(producto.getPro_Imagen()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView resumen;
        private ImageView imageView;
        public myViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            resumen = (TextView) itemView.findViewById(R.id.resumen);
            imageView = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}
