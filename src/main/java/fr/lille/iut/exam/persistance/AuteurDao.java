package fr.lille.iut.exam.persistance;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static fr.lille.iut.exam.persistance.MaBaseSQLite.TABLE_AUTEUR;


/**
 * Created by xsint on 09/03/2017.
 */
public class AuteurDao implements IAuteurDao {

    private SQLiteDatabase bdd;
    // le helper
    private MaBaseSQLite maBaseSQLite;

    public AuteurDao(Context context) {
        //On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, MaBaseSQLite.NOM_BDD, null, MaBaseSQLite.VERSION_BDD);
    }


    @Override
    public void open() {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    @Override
    public void close() {
        //on ferme l'accès à la BDD
        bdd.close();
    }

    @Override
    public SQLiteDatabase getBDD() {
        return bdd;
    }

    @Override
    public long insertAuteur(final Auteur auteur) {
        // TODO : compléter & modifier

        //Création d'un ContentValues (fonctionne comme une HashMap)
        //on lui ajoute une valeur associée à une clé/colonne / valeur
        //on insère l'objet dans la BDD via le ContentValues

        return 0;
    }

    @Override
    public int updateAuteur(final int id, final Auteur auteur) {
        // La mise à jour d'un auteur dans la BDD fonctionne plus ou moins comme une insertion
        // il faut simple préciser quel auteur on doit mettre à jour grâce à l'ID
        final ContentValues values = new ContentValues();
        values.put(AuteurEnum.COL_NOM.getNom(), auteur.getNom());
        return bdd.update(TABLE_AUTEUR, values, AuteurEnum.COL_ID.getNom() + " = " + id, null);
    }

    @Override
    public int removeAuteurById(final int id) {
        //Suppression d'un auteur de la BDD grâce à l'ID
        return bdd.delete(TABLE_AUTEUR, AuteurEnum.COL_ID.getNom() + " = " + id, null);
    }

    @Override
    public Auteur getAuteurByNom(final String nom) {
        // TODO : compléter & modifier

        //Récupère dans un Cursor les valeur correspondant à un auteur contenu dans la BDD
        // (ici on sélectionne l'auteur grâce à son nom)
        //si aucun élément n'a été retourné dans la requête, on renvoie null

        //Sinon on se place sur le premier élément
        return null;
    }

    @Override
    public Auteur getAuteurById(final int id) {
        //Récupère dans un Cursor les valeur correspondant à un auteur contenu dans la BDD
        // (ici on sélectionne l'  auteur grâce à son id)
        final Cursor c = bdd.query(TABLE_AUTEUR, new String[]{AuteurEnum.COL_ID.getNom(), AuteurEnum.COL_NOM.getNom()},
                AuteurEnum.COL_ID.getNom() + " = " + id, null, null, null, null);
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0) {
            return null;
        }

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        final Auteur auteur = cursorToAuteur(c);
        c.close();
        return auteur;
    }

    @Override
    public int removeAllUser() {
        return bdd.delete(TABLE_AUTEUR, null, null);
    }

    @Override
    public List<Auteur> getAll() {
        // TODO : compléter & modifier

        //Récupère dans un Cursor les valeur correspondant à un auteur contenu dans la BDD
        //si aucun élément n'a été retourné dans la requête, on renvoie null

        //Sinon on se place sur le premier élément
        final List<Auteur> auteur = new ArrayList<>();
        return auteur;
    }

    //Cette méthode permet de convertir le contenu d'un cursor en List<auteur>
    private List<Auteur> cursorToListAuteur(final Cursor c) {
        // TODO : compléter
        final List<Auteur> auteurList = new ArrayList<>();

        return auteurList;
    }

    //Cette méthode permet de convertir le contenu d'un cursor en un auteur
    private Auteur cursorToAuteur(final Cursor c) {
        //On créé un auteur
        final Auteur auteur = new Auteur();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        auteur.setId(c.getInt(AuteurEnum.COL_ID.getNumeroColonne()));
        auteur.setNom(c.getString(AuteurEnum.COL_NOM.getNumeroColonne()));

        //On retourne l'auteur
        return auteur;
    }

}
