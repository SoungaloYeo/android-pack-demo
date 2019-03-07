package com.app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {
    private EditText txtNomWifi;
    private TextView txtvNomWifi;

    private EditText txtPassword;
    private TextView txtvPassword;

    private Switch etatWifi;

    private Button btnAjout;
    private Button btnMemoriser;

    public static final String PREFS = "PREFS";

    public static final String TEXT_NOM_WIFI = "NOM_WIFI";
    public static final String TEXT_PASS = "TEXT_PASS";
    public static final String ETAT_SWITCH = "ETAT_SWITCH";

    private String textForWifi;
    private String textForPass;
    private boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        this.txtNomWifi = findViewById(R.id.txt_nom_wifi);
        this.txtvNomWifi = findViewById(R.id.txtv_nom_wifi);

        this.txtPassword = findViewById(R.id.txt_password);
        this.txtvPassword = findViewById(R.id.txtv_password);

        this.etatWifi = findViewById(R.id.etat_switch);

        this.btnAjout = findViewById(R.id.btn_ajout);
        this.btnMemoriser = findViewById(R.id.btn_memoriser);

        this.btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtvNomWifi.setText(txtNomWifi.getText().toString());
                txtvPassword.setText(txtPassword.getText().toString());
            }
        });

        this.btnMemoriser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateData();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT_NOM_WIFI, txtvNomWifi.getText().toString());
        editor.putString(TEXT_PASS, txtvPassword.getText().toString());
        editor.putBoolean(ETAT_SWITCH, etatWifi.isChecked());

        editor.apply();
        Toast.makeText(PreferenceActivity.this, "DONNÉES MÉMORISÉES", Toast.LENGTH_SHORT).show();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        this.textForWifi = sharedPreferences.getString(TEXT_NOM_WIFI, "default");
        this.textForPass = sharedPreferences.getString(TEXT_PASS, "default");
        this.switchOnOff = sharedPreferences.getBoolean(ETAT_SWITCH, false);
    }

    public void updateData() {
        this.txtvNomWifi.setText(this.textForWifi);
        this.txtvPassword.setText(this.textForPass);
        this.etatWifi.setChecked(this.switchOnOff);
    }


}
