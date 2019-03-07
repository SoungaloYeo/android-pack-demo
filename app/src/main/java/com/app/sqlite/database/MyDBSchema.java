package com.app.sqlite.database;

public class MyDBSchema {

    public static final  class  Etudiant {
            public static final String TABLE_NAME = "etudiant";

            public static final class MyColumns {
                public static final String ID = "id";
                public static final String NOM = "nom";
                public static final String PRENOM = "prenom";
                public static final String COMMUNE = "commune";
                public static final String FILIERE = "filiere";

            }
    }

    public static final  class  Salle {
            public static final String TABLE_NAME = "salle";

            public static final class MyColumns {
                public static final String ID = "id";
                public static final String DESIGN = "designation";
                public static final String NBR_PLACE = "nbr_place";

            }
    }
}
