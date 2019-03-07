package com.app.servicethread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.net.URL;

public class Utility {

    // trouve ID  de l'image correspondant à partie du nom de l'image (dans le repertoire ressource drawable).
    public static int getDrawableResIdByNom(Context context, String resNom) {
        String pkgName = context.getPackageName();
        // Return 0 si non trouve.
        int resID = context.getResources().getIdentifier(resNom, "drawable", pkgName);
        Log.i("Utility", "Nom de la ressource : " + resNom + "==> Ressource ID = " + resID);
        return resID;
    }


    public static Bitmap loadImageFromNetwork(String urlStr) {
        try {
            URL url = new URL(urlStr);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bmp;
        } catch (Exception e) {
            Log.i("*** IN loadImageFromNw","erreur de chargement...");
            return null;
        }
    }
}
