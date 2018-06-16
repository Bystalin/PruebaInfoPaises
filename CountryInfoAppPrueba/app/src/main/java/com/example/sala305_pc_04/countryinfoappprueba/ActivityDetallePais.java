package com.example.sala305_pc_04.countryinfoappprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class ActivityDetallePais extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);

        //-------------------Obtener los datos que fueron enviados de otra actividad
        Bundle bundle = this.getIntent().getExtras();
        String volumnen = bundle.getString("Codigo2");

        //FIN-------------------Obtener los datos que fueron enviados de otra actividad

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/"+ bundle.getString("Codigo2") +".json", datos,ActivityDetallePais.this, ActivityDetallePais.this);
        ws.execute("");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject objdatos = new JSONObject(result);

        //JSONArray ResultadoPais  = objdatos.getJSONArray("Results");
        //JSONObject  datos = ResultadoPais.getJSONObject(0);
        JSONObject  datos = (JSONObject)objdatos.get("Results");

        TextView nombre = (TextView)findViewById(R.id.LblNombre);
        nombre.setText(datos.getString("Name"));

        //Obtengo los datos del array Capital
        JSONObject capitalDatos = datos.getJSONObject("Capital");

        TextView capital = (TextView)findViewById(R.id.LblCapital);
        capital.setText(capitalDatos.getString("Name"));


        //Obtengo los datos del array GeoRectangle(Coordenadas)
        JSONObject GeoDatos = datos.getJSONObject("GeoRectangle");

        TextView norte = (TextView)findViewById(R.id.LblNorte);
        norte.setText(GeoDatos.getString("North"));

        TextView sur = (TextView)findViewById(R.id.LblSur);
        sur.setText(GeoDatos.getString("South"));

        TextView este = (TextView)findViewById(R.id.LblEste);
        este.setText(GeoDatos.getString("East"));

        TextView oeste = (TextView)findViewById(R.id.LblOeste);
        oeste.setText(GeoDatos.getString("West"));

    }
}
