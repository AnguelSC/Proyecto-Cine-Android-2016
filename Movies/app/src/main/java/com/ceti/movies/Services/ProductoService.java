package com.ceti.movies.Services;


import com.ceti.movies.Models.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
//   http://elcangrejo.pideloya.click/service/






public interface ProductoService {
    @GET("productos/1")
    Call<List<Producto>> productosList();

    @POST("productos/create")
    Call<Producto> createProducto(@Field("minombre") String first);
}
