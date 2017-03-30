package fr.lille.iut.exam.persistance;

/**
 * Created by xsint on 09/03/2017.
 */
public class Auteur {

    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", super.toString()=" + super.toString() +
                '}';
    }
}
