package com.ceti.movies.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ceti.movies.Adapters.ProximoAdapter;
import com.ceti.movies.Models.Pelicula;
import com.ceti.movies.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian-OTI on 18/07/2016.
 */
public class ProximoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipe;
    private List<Pelicula> lista = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proximo, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mSwipe = (SwipeRefreshLayout) view.findViewById(R.id.refrescar);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        lista.add(new Pelicula("0001", "El conjuro 2", "30-11-2016", R.drawable.portada));
        lista.add(new Pelicula("0002", "El conjuro 2", "30-11-2016", R.drawable.portada));
        lista.add(new Pelicula("0003", "El conjuro 2", "30-11-2016", R.drawable.portada));
        lista.add(new Pelicula("0004", "El conjuro 2", "30-11-2016", R.drawable.portada));
        lista.add(new Pelicula("0005", "El conjuro 2", "30-11-2016", R.drawable.portada));
        lista.add(new Pelicula("0006", "El conjuro 2", "30-11-2016", R.drawable.portada));
        ProximoAdapter proximoAdapter = new ProximoAdapter(lista);
        mRecyclerView.setAdapter(proximoAdapter);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                lista.add(new Pelicula("0007", "Los vengadores", "Pelicula de acción no antes vista", R.drawable.portada));
                lista.add(new Pelicula("0008", "Los vengadores", "Pelicula de acción no antes vista", R.drawable.portada));
                ProximoAdapter proximoAdapter = new ProximoAdapter(lista);
                mRecyclerView.setAdapter(proximoAdapter);
                mSwipe.setRefreshing(false);
            }
        });
        return view;
    }
}
