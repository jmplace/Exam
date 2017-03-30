package fr.lille.iut.exam.persistance;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xsint on 09/03/2017.
 */
public class MaBaseSQLite extends SQLiteOpenHelper {
    public static final int VERSION_BDD = 1;
    public static final String NOM_BDD = "auteur.db";

    public static final String TABLE_AUTEUR = "auteur";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_AUTEUR +
            " (" + AuteurEnum.COL_ID.getNom() + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            AuteurEnum.COL_NOM.getNom() + " TEXT NOT NULL);";

    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // On peut fait ce qu'on veut ici (stratégie à choisir)
        // dans notre cas, on supprime la table et on la recrée
        db.execSQL("DROP TABLE " + TABLE_AUTEUR + ";");
        onCreate(db);
    }
}
