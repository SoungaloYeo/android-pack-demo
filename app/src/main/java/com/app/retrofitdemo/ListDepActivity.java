package com.app.retrofitdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.app.R;
import com.app.retrofitdemo.adapter.DepAdapter;
import com.app.retrofitdemo.model.Departement;
import com.app.retrofitdemo.dao.DepartementDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListDepActivity extends AppCompatActivity {

    private final String TAG = "ListDepActivity";

    @BindView(R.id.listView)
    ListView listView;

    @BindView(R.id.list_toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private List<Departement> departements = null;
    private DepartementDao departementDao = null;

    DepAdapter depAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dep);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        departements = new ArrayList<>();
        departementDao = new DepartementDao();

        departements = departementDao.getAllDep(progressBar,listView, this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
