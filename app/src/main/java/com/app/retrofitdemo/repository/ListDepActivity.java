package com.app.retrofitdemo.repository;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.app.R;
import com.app.retrofitdemo.Departement;
import com.app.retrofitdemo.Utilities;
import com.app.retrofitdemo.dao.DepartementDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dep);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        departements = new ArrayList<>();
        departementDao = new DepartementDao();
        departements = departementDao.getAllDep();

//progressBar.setVisibility(View.INVISIBLE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    private class TacheArrière extends AsyncTask<Integer, Integer, Integer> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Integer doInBackground(Integer... integers) {
//            departements = departementDao.getAllDep();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Integer s) {
//            super.onPostExecute(s);
//        }
//    }
}
