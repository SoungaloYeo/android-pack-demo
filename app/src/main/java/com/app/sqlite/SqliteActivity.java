package com.app.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.R;
import com.app.sqlite.etudiantdao.EtudiantDao;
import com.app.sqlite.model.Etudiant;

import java.util.List;

public class SqliteActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText txtNom;
    private EditText txtPrenom;
    private EditText txtCommune;
    private EditText txtFiliere;
    private Button btnAjouter;
    private Button btnShowData;

    private Etudiant etudiant;
    private EtudiantDao etudiantDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        etudiant = new Etudiant();


        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("AJOUT DANS SQLITE");
        setSupportActionBar(toolbar);

        txtNom = findViewById(R.id.txt_sqlite_nom);
        txtPrenom = findViewById(R.id.txt_sqlite_prenom);
        txtCommune = findViewById(R.id.txt_sqlite_commune);
        txtFiliere = findViewById(R.id.txt_sqlite_filiere);

        btnAjouter = findViewById(R.id.btn_sqlite_ajouter);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etudiant.setNom(txtNom.getText().toString());
                etudiant.setPrenom(txtPrenom.getText().toString());
                etudiant.setCommune(txtCommune.getText().toString());
                etudiant.setFiliere(txtFiliere.getText().toString());

                etudiantDao = new EtudiantDao(SqliteActivity.this);
                etudiantDao.ajouter(etudiant);

                Toast.makeText(SqliteActivity.this, "saved", Toast.LENGTH_LONG).show();
                clearAll();

            }
        });

        btnShowData = findViewById(R.id.btn_sqlite_show);
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etudiantDao = new EtudiantDao(SqliteActivity.this);
                List<Etudiant> etudiantList = etudiantDao.lireTous();

                for(Etudiant etudiant: etudiantList){
                    Log.i("**** SHOW DATA onClick", etudiant.toString());
                }
            }
        });

    }

    public void clearAll(){
        txtFiliere.getText().clear();
        txtCommune.getText().clear();
        txtPrenom.getText().clear();
        txtNom.getText().clear();
    }
}
