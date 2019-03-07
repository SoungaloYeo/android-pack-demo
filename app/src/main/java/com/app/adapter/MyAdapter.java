package com.app.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.R;
import com.app.model.Personne;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context context;
    private final List<Personne> listPersonne;

    Dialog dialog;
    TextView txtNomPrenom;
    TextView txtCommune;


    public MyAdapter(Context context, List<Personne> listPersonne) {
        this.context = context;
        this.listPersonne = listPersonne;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(this.context).inflate(R.layout.item_personne, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        // dialog
        this.dialog = new Dialog(context);
        this.dialog.setContentView(R.layout.detail_personne);

        myViewHolder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "PERSONNE N° 00" + String.valueOf(myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                txtNomPrenom = dialog.findViewById(R.id.txtv_nom_prenom);
                txtCommune = dialog.findViewById(R.id.txtv_commune);

                int pos = myViewHolder.getAdapterPosition();
                Personne personne = listPersonne.get(pos);

                txtNomPrenom.setText(personne.getNom()+" "+personne.getPrenom());
                txtCommune.setText(personne.getCommune());

                dialog.show();
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Personne personne = this.listPersonne.get(i);
        myViewHolder.txtNomPrenom.setText(personne.getNom() + " " + personne.getPrenom());
        myViewHolder.txtCode.setText(personne.getCode());
        myViewHolder.txtCommune.setText(personne.getCommune());
    }

    @Override
    public int getItemCount() {
        return this.listPersonne.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomPrenom;
        TextView txtCommune;
        TextView txtCode;

        CardView itemCardView;

        public MyViewHolder(View view) {
            super(view);
            this.txtCode = view.findViewById(R.id.txt_code);
            this.txtCommune = view.findViewById(R.id.txt_commune);
            this.txtNomPrenom = view.findViewById(R.id.txt_nom_prenom);

            this.itemCardView = view.findViewById(R.id.item_cardView);
        }
    }


}
