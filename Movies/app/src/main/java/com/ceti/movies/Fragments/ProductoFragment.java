package com.ceti.movies.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ceti.movies.Adapters.ProductoAdapter;
import com.ceti.movies.Models.Producto;
import com.ceti.movies.R;
import com.ceti.movies.Services.ProductoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adrian-OTI on 15/08/2016.
 */
public class ProductoFragment extends Fragment {
    List<Producto> myLista = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout sw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estrenos,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        sw = (SwipeRefreshLayout) view.findViewById(R.id.refrescar);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                sw.setRefreshing(false);
            }
        });
        return view;
    }



    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://elcangrejo.pideloya.click/service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductoService service = retrofit.create(ProductoService.class);
        Call<List<Producto>> productos = service.productosList();
        productos.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                Toast.makeText(getActivity(), ""+response.body().size(), Toast.LENGTH_SHORT).show();
                myLista = response.body();
                ProductoAdapter adapter = new ProductoAdapter(myLista);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }
}
