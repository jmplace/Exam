package fr.lille.iut.exam.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fr.lille.iut.exam.R;
import fr.lille.iut.exam.persistance.Auteur;
import fr.lille.iut.exam.persistance.AuteurDao;
import fr.lille.iut.exam.persistance.IAuteurDao;

// TODO : compléter & modifier
public class DetailUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        TextView textViewId = (TextView) findViewById(R.id.textViewId);
        TextView textViewNom = (TextView) findViewById(R.id.textViewNom);

        // récupérer les données de l'intent
        int id = 0;

        IAuteurDao auteurDao = new AuteurDao(this);
        auteurDao.open();
        Auteur auteur = auteurDao.getAuteurById(id);
        auteurDao.close();

        textViewId.setText(String.valueOf(id));
        textViewNom.setText(auteur.getNom());

    }
}
