package com.app.servicethread;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.R;

public class ThreadServiceActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        imageView = findViewById(R.id.img_thread);
        button = findViewById(R.id.btn_gothread);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ThreadServiceActivity.this, "Changement de l'image en quelques secondes", Toast.LENGTH_LONG).show();

                new Thread(new Runnable() {
                    public void run() {
                        final Bitmap bitmap =
                                Utility.loadImageFromNetwork("http://10000codeurs.com/wp-content/uploads/2018/01/logo-10000codeurs-100px.jpg");
                        imageView.post(new Runnable() {
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                }).start();

            }
        });

        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), InfoService.class));
            }
        });

        btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), InfoService.class));
            }
        });
    }
}
