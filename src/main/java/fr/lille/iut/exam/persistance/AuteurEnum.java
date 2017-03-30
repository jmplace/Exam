package fr.lille.iut.exam.persistance;

/**
 * Created by xsint on 09/03/2017.
 */
public enum AuteurEnum {
    COL_ID("ID", 0), COL_NOM("Nom", 1);

    private String nom;
    private int numeroColonne;

    AuteurEnum(String nom, int numeroColonne) {
        this.nom = nom;
        this.numeroColonne = numeroColonne;
    }

    public int getNumeroColonne() {
        return numeroColonne;
    }

    public void setNumeroColonne(int numeroColonne) {
        this.numeroColonne = numeroColonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
