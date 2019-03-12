package com.app.retrofit2.repository;

import com.app.retrofit2.Departement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DepRepository {

    @GET("departements/")
    Call<List<Departement>> getDepartements();

    @POST("departements/")
    Call<Departement> addDepartement(@Body Departement departement);

    @POST("departements/{id}")
    Call<Departement> updateDepartement(@Body Departement departement);

    @DELETE("departements/{id}")
    Call<Departement> deleteDepartement(@Path("id") int id);
}
