package com.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.app.adapter.MyAdapter;
import com.app.common.CommonPersonne;
import com.app.model.Personne;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Personne> personnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        this.toolbar = findViewById(R.id.toolBar);
        this.toolbar.setTitle("LISTE DES PERSONNES");
        setSupportActionBar(this.toolbar);

        this.recyclerView = findViewById(R.id.my_recycler);

        Intent intent = getIntent();
        this.personnes = (ArrayList<Personne>) intent.getSerializableExtra(CommonPersonne.EXTRA_LISTE_PERS);

        if(this.personnes == null){
            this.personnes = CommonPersonne.getList();
        }
        Toast.makeText(this, personnes.toString(), Toast.LENGTH_SHORT).show();

        this.recyclerView.setAdapter(new MyAdapter(this, this.personnes));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

