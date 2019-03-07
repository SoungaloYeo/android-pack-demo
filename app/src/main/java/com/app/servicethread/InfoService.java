package com.app.servicethread;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class InfoService extends Service {
    public  static long NOTIFICATION_INTERVAL = 2 * 1000; // 2 scds

    private Handler handler = new Handler();

    private Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        if(timer != null){
            timer.cancel();
        } else {
            timer = new Timer();
        }
        Toast.makeText(getApplicationContext(), "Affichage d'une info chaque 2 secds", Toast.LENGTH_LONG).show();
    timer.scheduleAtFixedRate(new TimeDispplayTask(), 0, NOTIFICATION_INTERVAL);
    }


    private class TimeDispplayTask extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "info :"+getDateTime(), Toast.LENGTH_SHORT).show();
                    Log.i("InfoSer.TDispplayTask", "On handler.run()"+getDateTime());
                }
            });
        }
    }

    private String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss - dd/MM/yyyy]");
        return sdf.format(new Date());
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
