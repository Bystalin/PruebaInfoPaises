package com.example.sala305_pc_04.countryinfoappprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://services.groupkt.com/country/get/all", datos,MainActivity.this, MainActivity.this);
        ws.execute("");

        ListView lstOpciones = (ListView)findViewById(R.id.ListPaises);
        //Listener para el Evento Click
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent intent = new Intent(MainActivity.this, ActivityDetallePais.class);

                Bundle b = new Bundle();
                b.putString("Codigo2",((Paises)a.getItemAtPosition(position)).getAlpha2_code());
                intent.putExtras(b);

                startActivity(intent);

            }
        });

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONObject objdatos1 = new JSONObject(result);
        JSONObject node = (JSONObject)objdatos1.get("RestResponse");
        JSONArray objarray = (JSONArray)node.get("result");

        ArrayList<Paises> paises = Paises.JsonObjectsBuild(objarray);
        AdaptadorPaises adaptadorpais= new AdaptadorPaises(this,paises);

        ListView lstOpciones = (ListView)findViewById(R.id.ListPaises);
        lstOpciones.setAdapter(adaptadorpais);
    }
}
