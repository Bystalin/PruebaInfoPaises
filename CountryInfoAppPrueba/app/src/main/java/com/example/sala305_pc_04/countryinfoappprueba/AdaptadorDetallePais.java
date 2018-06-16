package com.example.sala305_pc_04.countryinfoappprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.ArrayList;

public class AdaptadorDetallePais extends ArrayAdapter<DetallePais> {
    public AdaptadorDetallePais(Context context, ArrayList<DetallePais> datos) {
        super(context, R.layout.activity_detalle_pais, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        //Inflador de Datos
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_detalle_pais, null);

        TextView lblNombre= (TextView)item.findViewById(R.id.LblNombre);
        lblNombre.setText(getItem(position).getNombre());

        TextView lblcapital = (TextView)item.findViewById(R.id.LblCapital);
        lblcapital.setText(getItem(position).getCapital());

        TextView lblNorte = (TextView)item.findViewById(R.id.LblNorte);
        lblNorte.setText(getItem(position).getNorte());

        TextView lblSur = (TextView)item.findViewById(R.id.LblSur);
        lblSur.setText(getItem(position).getSur());

        TextView lblEste = (TextView)item.findViewById(R.id.LblEste);
        lblEste.setText(getItem(position).getEste());

        TextView lblOeste = (TextView)item.findViewById(R.id.LblOeste);
        lblOeste.setText(getItem(position).getOeste());

        return(item);
    }
}
