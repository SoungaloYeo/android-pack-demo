package com.app.retrofitdemo.dao;

import android.util.Log;

import com.app.retrofitdemo.Departement;
import com.app.retrofitdemo.Utilities;
import com.app.retrofitdemo.repository.DepRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartementDao {

    DepRepository depRepository;
    Departement departement;
    List<Departement> deps = null;
    boolean bool;

    public DepartementDao() {
        this.depRepository = Utilities.getDepService();
    }

    public List<Departement> getAllDep() {
        Call<List<Departement>> call = depRepository.getAllDep();

        call.enqueue(new Callback<List<Departement>>() {
            @Override
            public void onResponse(Call<List<Departement>> call, Response<List<Departement>> response) {
                if (response.isSuccessful()) {
                    deps = new ArrayList<>();
                    deps = response.body();
                }
            }
            @Override
            public void onFailure(Call<List<Departement>> call, Throwable t) {

            }
        });
        return deps;
    }

    public Departement getOneDep(Long id) {
        Call<Departement> call = depRepository.getOneDep(id);

        call.enqueue(new Callback<Departement>() {
            @Override
            public void onResponse(Call<Departement> call, Response<Departement> response) {
                if (response.isSuccessful()) {
                    departement = new Departement();
                    departement = response.body();
                }
            }
            @Override
            public void onFailure(Call<Departement> call, Throwable t) {

            }
        });
        return departement;
    }


    public boolean addDep(Departement departement) {
        Call<Departement> call = depRepository.addDep(departement);
        call.enqueue(new Callback<Departement>() {
            @Override
            public void onResponse(Call<Departement> call, Response<Departement> response) {
                if (response.isSuccessful()) {
                    bool = true;
                }
            }
            @Override
            public void onFailure(Call<Departement> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                bool = false;
            }
        });
        return bool;
    }


    public boolean updateDep(Departement departement) {
        Call<Departement> call = depRepository.updateDep(departement.getId(), departement);
        call.enqueue(new Callback<Departement>() {
            @Override
            public void onResponse(Call<Departement> call, Response<Departement> response) {
                if(response.isSuccessful()){
                    bool = true;
                }
            }
            @Override
            public void onFailure(Call<Departement> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        return true;
    }


    public boolean deleteDep(Long id) {
        Call<Departement> call = depRepository.deleteDep(id);
        call.enqueue(new Callback<Departement>() {
            @Override
            public void onResponse(Call<Departement> call, Response<Departement> response) {
                if(response.isSuccessful()){
                    bool = true;
                }
            }
            @Override
            public void onFailure(Call<Departement> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                bool = false;
            }
        });
        return bool;
    }
}
