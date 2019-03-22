package com.app.retrofitdemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.app.R;
import com.app.retrofitdemo.dao.DepartementDao;
import com.app.retrofitdemo.model.Departement;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends AppCompatActivity {

    private final String TAG = "RetrofitActivity";

    @BindView(R.id.txt_retrolib)
    EditText txtLibelle;

    @BindView(R.id.txt_retropop)
    EditText txtPopulation;

    @BindView(R.id.txt_retronbrville)
    EditText txtNbreVille;

    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @BindView(R.id.retro_fab)
    FloatingActionButton fab;

    DepartementDao departementDao = null;
    List<Departement> departementList;
    Departement departement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);

        toolbar.setTitle("RETROFIT 2");
        setSupportActionBar(toolbar);

        departementDao = new DepartementDao();
//        departementList = new ArrayList<>();
        departement = new Departement();
    }


    @OnClick(R.id.retro_fab)
    void submit(View view) {
        departement.setLibelle(txtLibelle.getText().toString());
        departement.setPopulation(Integer.parseInt(txtPopulation.getText().toString()));
        departement.setNbreVille(Integer.parseInt(txtPopulation.getText().toString()));
        departementDao.addDep(departement);
        clear();
        Snackbar.make(view, "it's ok", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        startActivity(new Intent(RetrofitActivity.this, ListDepActivity.class));
    }

    void clear() {
        this.txtLibelle.getText().clear();
        this.txtNbreVille.getText().clear();
        this.txtPopulation.getText().clear();
    }

}
