package com.app.retrofitdemo;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.R;
import com.app.retrofitdemo.dao.DepartementDao;
import com.app.retrofitdemo.repository.DepRepository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private final String TAG = "RetrofitActivity";

    @BindView(R.id.txt_retrolib)
    EditText txtLibelle;

    @BindView(R.id.txt_retropop)
    EditText txtPopulation;

    @BindView(R.id.txt_retronbrplace)
    EditText txtNbrePlace;

    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @BindView(R.id.retro_fab)
    FloatingActionButton fab;

    DepartementDao departementDao = null;
    List<Departement> departementList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);

        toolbar.setTitle("RETROFIT 2");
        setSupportActionBar(toolbar);

        departementDao = new DepartementDao();
        departementList = new ArrayList<>();

    }


    @OnClick(R.id.retro_fab)
    void submit(View view) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RetrofitActivity.this, "en cours...", Toast.LENGTH_SHORT).show();
                departementList = departementDao.getAllDep();
            }
        }, 5000);


        if (departementList != null) {
            Snackbar.make(view, "it's ok", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        for (Departement dep : departementList) {
            Log.i(TAG, "********* " + dep.toString());
        }
    }
}
