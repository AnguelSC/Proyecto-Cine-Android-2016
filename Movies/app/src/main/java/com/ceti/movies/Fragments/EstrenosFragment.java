package com.ceti.movies.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ceti.movies.Adapters.EstrenoAdapter;
import com.ceti.movies.Models.Pelicula;
import com.ceti.movies.R;

import java.util.ArrayList;
import java.util.List;


public class EstrenosFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Pelicula> lista = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estrenos,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        lista.add(new Pelicula("El conjuro 2","Esta es una pelicula de terror",0));
        EstrenoAdapter estrenoAdapter = new EstrenoAdapter(lista);
        mRecyclerView.setAdapter(estrenoAdapter);
        return view;
    }
}
