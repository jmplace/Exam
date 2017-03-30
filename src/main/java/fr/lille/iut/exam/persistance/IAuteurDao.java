package fr.lille.iut.exam.persistance;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by xsint on 09/03/2017.
 */
public interface IAuteurDao {

    void open();

    void close();

    SQLiteDatabase getBDD();

    long insertAuteur(Auteur auteur);

    int updateAuteur(int id, Auteur auteur);

    int removeAuteurById(int id);

    List<Auteur> getAll();

    Auteur getAuteurByNom(String nom);

    Auteur getAuteurById(int id);

    int removeAllUser();
}
