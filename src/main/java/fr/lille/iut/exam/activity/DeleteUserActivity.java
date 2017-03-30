package fr.lille.iut.exam.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import fr.lille.iut.exam.R;
import fr.lille.iut.exam.persistance.Auteur;
import fr.lille.iut.exam.persistance.AuteurDao;
import fr.lille.iut.exam.persistance.IAuteurDao;

// TODO : compléter
public class DeleteUserActivity extends AppCompatActivity {

    private int id;
    private IAuteurDao auteurDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        // mapping
        Button button = (Button) findViewById(R.id.buttonDelete);

        // récupérer l'id de l'intent

        // récupérer les données de la BD

        // initialiser le textview

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auteurDao.open();
                auteurDao.removeAuteurById(id);
                auteurDao.close();
                finish();
            }
        });

    }
}
