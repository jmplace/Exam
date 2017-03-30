package fr.lille.iut.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import fr.lille.iut.exam.R;
import fr.lille.iut.exam.persistance.Auteur;
import fr.lille.iut.exam.persistance.AuteurDao;
import fr.lille.iut.exam.persistance.IAuteurDao;

// TODO : compléter
public class AllUserActivity extends AppCompatActivity {

    ListView mListView;
    UserAdapter adapter;
    List<Auteur> auteurList;
    final IAuteurDao auteurDao = new AuteurDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        // mapping du layout
        Button buttonDelete = (Button) findViewById(R.id.buttonVider);
        mListView = (ListView) findViewById(R.id.listView);

        // on va chercher les données
        auteurDao.open();
        auteurList = auteurDao.getAll();
        auteurDao.close();

        // on construit l'adapter
        adapter = new UserAdapter(AllUserActivity.this, auteurList);
        mListView.setAdapter(adapter);

        // on définit les listener des boutons
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auteurDao.open();
                auteurDao.removeAllUser();
                auteurDao.close();
                // on met à jour la liste de l'adapter
                auteurList.clear();
                // on demande le refresh des données
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // on recharge la liste depuis la BD
        super.onActivityResult(requestCode, resultCode, data);
        auteurDao.open();
        auteurList.clear();
        // on change le contenue de la liste de l'adapter (garder la même liste)
        auteurList.addAll(auteurDao.getAll());
        auteurDao.close();
        // on prévient l'adapter pour faire un refresh
        adapter.notifyDataSetChanged();
    }
}
