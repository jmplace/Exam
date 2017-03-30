package fr.lille.iut.exam.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import fr.lille.iut.exam.R;
import fr.lille.iut.exam.persistance.Auteur;



/**
 * Created by xsint on 09/03/2017.
 */
// TODO : compléter
public class UserAdapter extends ArrayAdapter<Auteur> {
    private AllUserActivity activity;

    public UserAdapter(AllUserActivity context, List<Auteur> liste) {
        super(context, 0, liste);
        activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell_user_layout, parent, false);
        }

        UserAdapter.CellViewHolder viewHolder = (UserAdapter.CellViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new UserAdapter.CellViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.texteId);
            viewHolder.nom = (TextView) convertView.findViewById(R.id.texteNom);
            viewHolder.boutonDetail = (Button) convertView.findViewById(R.id.buttonDetail);
            viewHolder.boutonDelete = (Button) convertView.findViewById(R.id.buttonDelete);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        final Auteur cell = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.id.setText(String.valueOf(cell.getId()));
        viewHolder.nom.setText(cell.getNom());

        // listener des boutons
        viewHolder.boutonDetail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailUserActivity.class);
                // Passer les informations et démarrer l'activité (forResult)
            }
        });
        viewHolder.boutonDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DeleteUserActivity.class);
                // Passer les informations et démarrer l'activité (forResult)
            }
        });

        return convertView;
    }

    private class CellViewHolder {
        public TextView id;
        public TextView nom;
        public Button boutonDetail;
        public Button boutonDelete;
    }

}
