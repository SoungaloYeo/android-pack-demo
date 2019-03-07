package com.app.activeAndroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.app.R;

public class OrmActivity extends AppCompatActivity {
    private EditText txtCode;
    private EditText txtDesign;
    private EditText population;
    private EditText txtDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

//        ActiveAndroid.initialize(this);
        txtCode = findViewById(R.id.txt_ormcode);
        txtDesign = findViewById(R.id.txt_ormdesign);
        population = findViewById(R.id.txt_ormpopu);
        txtDep = findViewById(R.id.txt_ormdep);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Ville ville = new Ville();
                ville.setCode(txtCode.getText().toString());
                ville.setDesignation(txtDesign.getText().toString());
                ville.setPopulation(Integer.parseInt(population.getText().toString()));
                ville.setDep(txtDep.getText().toString());
                
                if(VilleDao.add(ville) > 0){
                    Toast.makeText(OrmActivity.this, "saved...", Toast.LENGTH_SHORT).show();
                };
            }
        });
    }

}
