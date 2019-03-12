package com.app.activeAndroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrmActivity extends AppCompatActivity {

    @BindView(R.id.txt_ormcode)
    EditText txtCode;

    @BindView(R.id.txt_ormdesign)
    EditText txtDesign;

    @BindView(R.id.txt_ormpopu)
    EditText population;

    @BindView(R.id.txt_ormdep)
    EditText txtDep;

//    @BindView(R.id.fab)
//    FloatingActionButton fab;

    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm);

        ButterKnife.bind(this);

        toolbar.setTitle("ORM - ActiveDirectory");
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.fab)
    public void submit(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        Ville ville = new Ville();
        ville.setCode(txtCode.getText().toString());
        ville.setDesignation(txtDesign.getText().toString());
        ville.setPopulation(Integer.parseInt(population.getText().toString()));
        ville.setDep(txtDep.getText().toString());

        if (VilleDao.add(ville) > 0) {
            Toast.makeText(OrmActivity.this, "saved...", Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    public void clear() {
        txtCode.getText().clear();
        txtDep.getText().clear();
        txtDesign.getText().clear();
        population.getText().clear();
    }

}
