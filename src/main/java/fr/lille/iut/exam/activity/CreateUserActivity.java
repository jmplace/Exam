package fr.lille.iut.exam.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.lille.iut.exam.R;
import fr.lille.iut.exam.persistance.Auteur;
import fr.lille.iut.exam.persistance.AuteurDao;
import fr.lille.iut.exam.persistance.IAuteurDao;

// TODO : compléter
public class CreateUserActivity extends AppCompatActivity {

    private IAuteurDao auteurDao;
    private EditText textViewNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        textViewNom = (EditText) findViewById(R.id.textViewNom);
        Button button = (Button) findViewById(R.id.buttonCreate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
