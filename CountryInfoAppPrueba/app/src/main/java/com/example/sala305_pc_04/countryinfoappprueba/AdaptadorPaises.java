package com.example.sala305_pc_04.countryinfoappprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorPaises extends ArrayAdapter<Paises> {
    public AdaptadorPaises(Context context, ArrayList<Paises> datos) {
        super(context, R.layout.ly_item_paises, datos);
    }



    public View getView(int position, View convertView, ViewGroup parent) {


        //Inflador de Datos
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_item_paises, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblNamePais);
        lblTitulo.setText(getItem(position).getName());

        //TextView lblcode2 = (TextView)item.findViewById(R.id.Lblalpha2);
        //lblcode2.setText(getItem(position).getAlpha2_code());

        //TextView lblcode3 = (TextView)item.findViewById(R.id.Lblalpha3);
        //lblcode3.setText(getItem(position).getAlpha3_code());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgPais);
        Glide.with(this.getContext())
                .load(getItem(position).getImagen())
               .error(R.drawable.ic_launcher_background)
               .into(imageView);


        return(item);
    }
}
