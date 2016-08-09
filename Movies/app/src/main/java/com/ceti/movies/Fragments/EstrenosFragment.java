package com.ceti.movies.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
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
    private SwipeRefreshLayout mSwipe;
    private List<Pelicula> lista = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estrenos,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mSwipe = (SwipeRefreshLayout) view.findViewById(R.id.refrescar);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.add(new Pelicula("0001","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        lista.add(new Pelicula("0002","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        lista.add(new Pelicula("0003","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        lista.add(new Pelicula("0004","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        lista.add(new Pelicula("0005","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        lista.add(new Pelicula("0006","El conjuro 2","Esta es una pelicula de terror",R.drawable.portada));
        EstrenoAdapter estrenoAdapter = new EstrenoAdapter(lista);
        mRecyclerView.setAdapter(estrenoAdapter);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                lista.add(new Pelicula("0007","Los vengadores","Pelicula de acción no antes vista",R.drawable.portada));
                lista.add(new Pelicula("0008","Los vengadores","Pelicula de acción no antes vista",R.drawable.portada));
                EstrenoAdapter estrenoAdapter = new EstrenoAdapter(lista);
                mRecyclerView.setAdapter(estrenoAdapter);
                mSwipe.setRefreshing(false);
            }
        });
        return view;
    }
}
