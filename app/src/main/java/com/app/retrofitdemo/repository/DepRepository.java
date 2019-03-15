package com.app.retrofitdemo.repository;

import com.app.retrofitdemo.Departement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface DepRepository {

//    @Headers({
//            "Accept: application/vnd.github.v3.full+json",
//            "User-Agent: Retrofit-Sample-App"
//    })
    @GET("all/")
    Call<List<Departement>> getAllDep();

    @GET("./{id}")
    Call<Departement> getOneDep(@Path("id") Long id);

    @POST("./")
    Call<Departement> addDep(@Body Departement departement);

    @PUT(".")
    Call<Departement> updateDep(Long id, @Body Departement departement);

    @DELETE("./{id}")
    Call<Departement> deleteDep(@Path("id") Long id);
}
