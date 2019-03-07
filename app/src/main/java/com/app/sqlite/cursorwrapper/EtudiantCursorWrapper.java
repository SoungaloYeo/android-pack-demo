package com.app.sqlite.cursorwrapper;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.app.sqlite.database.MyDBSchema;
import com.app.sqlite.model.Etudiant;

public class EtudiantCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public EtudiantCursorWrapper(Cursor cursor) {
        super(cursor);
    }



    public Etudiant getEtudiant(){
        String mId  = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.ID));
        String mNom  = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.NOM));
        String mPrenom  = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.PRENOM));
        String mCommune  = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.COMMUNE));
        String mfiliere  = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.FILIERE));

        Etudiant etudiant = new Etudiant();
        etudiant.setId(Long.valueOf(mId));
        etudiant.setNom(mNom);
        etudiant.setPrenom(mPrenom);
        etudiant.setCommune(mCommune);
        etudiant.setFiliere(mfiliere);

        return etudiant;
    }
}
