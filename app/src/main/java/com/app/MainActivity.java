package com.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.activeAndroid.OrmActivity;
import com.app.retrofit2.RetrofitActivity;
import com.app.common.CommonPersonne;
import com.app.model.Personne;
import com.app.servicethread.ThreadServiceActivity;
import com.app.sqlite.SqliteActivity;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtPrenom;
    private EditText txtCommune;
    private Button btnAjouter;
    private Toolbar toolbar;
    private Personne personne;


    private List<Personne> personnes = CommonPersonne.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.toolBar);
        this.toolbar.setTitle("Formulaire de Personne");
        setSupportActionBar(this.toolbar);

        this.txtName = findViewById(R.id.txt_nom);
        this.txtPrenom = findViewById(R.id.txt_prenom);
        this.txtCommune = findViewById(R.id.txt_commune);
        this.btnAjouter = findViewById(R.id.btn_ajouter);

        this.btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personne = new Personne(
                        "0001",
                        txtName.getText().toString(),
                        txtPrenom.getText().toString(),
                        txtCommune.getText().toString()
                );
                personnes.add(personne);
                viderChamps();

//                Toast.makeText(MainActivity.this, personne.toString(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra(CommonPersonne.EXTRA_LISTE_PERS, (Serializable) personnes);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_list:
                Intent intent1 = new Intent(this, RecyclerActivity.class);
                startActivity(intent1);
                break;
            case R.id.itempreference:
                Intent intent2 = new Intent(this, PreferenceActivity.class);
                startActivity(intent2);
                break;
            case R.id.item_reach:
                Toast.makeText(this, "PAS DE RECHERCHE POUR LE MOMENT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_sqlite:
                Intent intent3 = new Intent(this, SqliteActivity.class);
                startActivity(intent3);
                break;
            case R.id.item_thservice:
                Intent intent4 = new Intent(this, ThreadServiceActivity.class);
                startActivity(intent4);
                break;
            case R.id.item_retrofit:
                Intent intent5 = new Intent(this, RetrofitActivity.class);
                startActivity(intent5);
                break;
            case R.id.item_orm:
                Intent intent6 = new Intent(this, OrmActivity.class);
                startActivity(intent6);
                break;
            case R.id.item_quitter:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void viderChamps() {
        this.txtName.setText("");
        this.txtPrenom.setText("");
        this.txtCommune.setText("");
    }
}
