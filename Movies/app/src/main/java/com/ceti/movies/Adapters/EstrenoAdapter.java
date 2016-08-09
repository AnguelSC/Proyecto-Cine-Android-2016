package com.ceti.movies.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ceti.movies.DetallePeliculaActivity;
import com.ceti.movies.Models.Pelicula;
import com.ceti.movies.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian-OTI on 8/08/2016.
 */
public class EstrenoAdapter extends RecyclerView.Adapter<EstrenoAdapter.myViewHolder>{
    private List<Pelicula> list = new ArrayList<>();
    private Context context;
    public EstrenoAdapter(List<Pelicula> list){
        this.list = list;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_estreno, parent, false);
        myViewHolder vh = new myViewHolder(v);
        vh.setContext(parent.getContext());
        return vh;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {
        final Pelicula pelicula = list.get(position);
        holder.titulo.setText(pelicula.getNombre());
        holder.resumen.setText(pelicula.getResumen());
        holder.imagen.setImageResource(pelicula.getImagen());
        final SharedPreferences sharedPref = context.getSharedPreferences("misFavoritos", Context.MODE_PRIVATE);
        final String verificar = sharedPref.getString(pelicula.getCodigo(),null);
        if(verificar != null){
            holder.favorito.setImageResource(R.drawable.ic_favorite_black_24dp);
        }else{
            holder.favorito.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
        holder.favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences local = context.getSharedPreferences("misFavoritos", Context.MODE_PRIVATE);
                String ver = local.getString(pelicula.getCodigo(),null);
                if(ver == null){
                    SharedPreferences.Editor editor = local.edit();
                    editor.putString(pelicula.getCodigo(),"agregado");
                    editor.commit();
                    holder.favorito.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Toast.makeText(context, "Agregado a tus favoritos", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences.Editor editor = local.edit();
                    editor.putString(pelicula.getCodigo(),null);
                    editor.commit();
                    holder.favorito.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(context, "Esta pelicula ya no es tu favorita", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetallePeliculaActivity.class);
                intent.putExtra("titulo",pelicula.getNombre());
                intent.putExtra("resumen",pelicula.getResumen());
                intent.putExtra("codigo",pelicula.getCodigo());
                intent.putExtra("imagen",pelicula.getImagen());
                context.startActivity(intent);
            }
        });
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
        private ImageButton ver;
        private Context context;
        public myViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            resumen = (TextView) itemView.findViewById(R.id.resumen);
            favorito = (ImageButton) itemView.findViewById(R.id.favorito);
            ver = (ImageButton) itemView.findViewById(R.id.ver);
        }

        public void setContext(Context context) {
            this.context = context;
        }
    }
}
