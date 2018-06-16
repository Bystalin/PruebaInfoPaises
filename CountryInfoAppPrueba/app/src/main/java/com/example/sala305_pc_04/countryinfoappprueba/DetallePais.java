package com.example.sala305_pc_04.countryinfoappprueba;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetallePais {
    private String nombre;



    private String capital;
    private String Norte;
    private String Sur;
    private String Este;
    private String Oeste;

    public String getNombre() {
        return nombre;
    }

    public String getCapital() {
        return capital;
    }

    public String getNorte() {
        return Norte;
    }

    public String getSur() {
        return Sur;
    }

    public String getEste() {
        return Este;
    }

    public String getOeste() {
        return Oeste;
    }
    public DetallePais(JSONObject a) throws JSONException {
        nombre =  a.getString("Name").toString();
        capital = a.getString("Name").toString();
        Norte = a.getString("North").toString();
        Sur = a.getString("South").toString();
        Este = a.getString("East").toString();
        Oeste = a.getString("West").toString();

    }



    public static ArrayList<DetallePais> JsonObjectsBuild(JSONArray datos) throws JSONException {

        ArrayList<DetallePais> detalle = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            detalle.add(new DetallePais(datos.getJSONObject(i)));
        }

        return detalle;

    }
}
