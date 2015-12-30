package sgomez.ejercicios.apuntaextra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sgomez.ejercicios.apuntaextra.Model.Local;
import sgomez.ejercicios.apuntaextra.R;

/**
 * Created by dam209 on 03/12/2015.
 */
public class LocalAdapter extends BaseAdapter {

    private ArrayList<Local> entradas;
    private int idView;
    private Context contexto;

    public LocalAdapter(Context context, int IdView, ArrayList<Local> entradas) {
        super();
        this.contexto = context;
        this.entradas = entradas;
        this.idView = IdView;
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int position) {
        return entradas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(idView, null);
            onEntrada(entradas.get(position), convertView);
        }
        return convertView;
    }

    public void onEntrada(Local entrada, View view) {
        TextView titulo = (TextView) view.findViewById(R.id.viewItem);
        titulo.setText((entrada).getNombre());
        TextView subTitulo = (TextView) view.findViewById(R.id.viewSubItem);
        subTitulo.setText((entrada).getDireccion());
    }
}