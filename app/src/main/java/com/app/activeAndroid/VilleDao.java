package com.app.activeAndroid;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

public class VilleDao {

    public static List<Ville> getAll(){
        return new Select()
                .from(Ville.class)
                .orderBy("id asc")
                .execute();
    }

    public static Ville getOne(String code){
        return new Select()
                .from(Ville.class)
                .where("code =?", code)
                .executeSingle();
    }

    public static Long add(Ville ville){
        return ville.save();
    }

    public static Long update(Ville ville){
//        v.setDesignation(ville.getDesignation());
//        v.setPopulation(ville.getPopulation());
//        v.setDep(ville.getDep());
        if(getOne(ville.getCode()) != null) {
            return ville.save();
        };
        return 0L;
    }

    public static void deleteOne(String code){
        new Delete()
                .from(Ville.class)
                .where("code =?", code)
                .executeSingle();
    }

    public static void deleteAll(){
        new Delete().from(Ville.class)
        .execute();
    }
}
