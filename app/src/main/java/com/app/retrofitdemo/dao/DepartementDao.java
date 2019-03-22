package com.app.retrofitdemo.dao;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.app.retrofitdemo.adapter.DepAdapter;
import com.app.retrofitdemo.model.Departement;
import com.app.retrofitdemo.shared.Utilities;
import com.app.retrofitdemo.repository.DepRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartementDao {

    private final String TAG ="DepartementDao";

    private DepRepository depRepository;
    private Departement departement = null;
    private ArrayList<Departement> deps = null;
    private boolean bool;

    public DepartementDao() {
        this.depRepository = Utilities.getDepService();
    }

    public List<Departement> getAllDep(final ProgressBar progressBar, final ListView listView, final Context context) {
        Call<List<Departement>> call = Utilities.getDepService().getAllDep();

        call.enqueue(new Callback<List<Departement>>() {
            @Override
            public void onResponse(Call<List<Departement>> call, Response<List<Departement>> response) {
                if (response.isSuccessful()) {
                    deps = new ArrayList<>();
                    deps = (ArrayList<Departement>) response.body();
                    for (Departement dep : deps) {
                        Log.i(TAG,dep.toString());
                    }

                    DepAdapter depAdapter = new DepAdapter(deps, context);

                    listView.setAdapter(depAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            departement = deps.get(position);

                            Snackbar.make(view, departement.getLibelle()+"\n"+departement.getPopulation()+" Nbre ville: "+departement.getNbreVille(), Snackbar.LENGTH_LONG)
                                    .setAction("No action", null).show();
                        }
                    });
                    progressBar.setVisibility(View.INVISIBLE);
                }else {
                    Log.i(TAG, "!!! "+response.code()+" "+response.message());
                }
            }
            @Override
            public void onFailure(Call<List<Departement>> call, Throwable t) {
                Log.i(TAG, "*** Failure retry again");

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


    public Departement addDep(final Departement dep) {
        Call<Departement> call = depRepository.addDep(dep);
        call.enqueue(new Callback<Departement>() {
            @Override
            public void onResponse(Call<Departement> call, Response<Departement> response) {
                if (response.isSuccessful()) {
                    bool = true;
                    departement = response.body();
                    Log.i(TAG, "****** Ajouté...");
                }
            }
            @Override
            public void onFailure(Call<Departement> call, Throwable t) {
                Log.i(TAG, t.getMessage());
                bool = false;
            }
        });
        return departement;
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
