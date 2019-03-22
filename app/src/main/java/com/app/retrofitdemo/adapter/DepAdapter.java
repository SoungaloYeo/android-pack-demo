package com.app.retrofitdemo.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.R;
import com.app.retrofitdemo.model.Departement;

import java.util.ArrayList;

public class DepAdapter extends ArrayAdapter<Departement> implements View.OnClickListener{

    private ArrayList<Departement> departements;
    Context context;

    public DepAdapter (ArrayList<Departement> deps, Context context){
        super(context, R.layout.row_item, deps);
        this.departements = deps;
        this.context = context;
    }

    private static class ViewHolder{
        TextView txtLibelle;
        TextView txtPopulation;
        TextView txtNbrVille;
//        RelativeLayout relativeLayout;
    }

    @Override
    public int getCount() {
        return departements.size();
    }

    @Override
    public void onClick(View v) {
        int position= (Integer) v.getTag();
        Object object = getItem(position);
        Departement departement = (Departement)object;

        Snackbar.make(v, "Release date " +departement.toString(), Snackbar.LENGTH_LONG)
                .setAction("No action", null).show();
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Departement departement = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtLibelle = convertView.findViewById(R.id.txt_lib);
            viewHolder.txtPopulation = (TextView) convertView.findViewById(R.id.txt_popu);
            viewHolder.txtNbrVille = (TextView) convertView.findViewById(R.id.txt_nbrVille);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtLibelle.setText(departement.getLibelle());
        viewHolder.txtPopulation.setText(""+departement.getPopulation());
        viewHolder.txtNbrVille.setText(""+departement.getNbreVille());
        return convertView;
    }

}
