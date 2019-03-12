package com.app.retrofit2;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.txt_retrolib)
    EditText txtLibelle;

    @BindView(R.id.txt_retropop)
    EditText txtPopulation;

    @BindView(R.id.txt_retronbrplace)
    EditText txtNbrePlace;


//    @BindView(R.id.retro_fab)
//    FloatingActionButton fab;

    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);

        toolbar.setTitle("RETROFIT 2");
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.retro_fab)
    void submit(View view){

        Snackbar.make(view, "Replace with your own action: in Retrofit", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
