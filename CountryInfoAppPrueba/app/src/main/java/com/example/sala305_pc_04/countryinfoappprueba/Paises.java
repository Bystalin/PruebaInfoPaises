package com.example.sala305_pc_04.countryinfoappprueba;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {


    private String name;
    private String alpha2_code;
    private String alpha3_code;
    private String imagen;


    public Paises(JSONObject a) throws JSONException {
        name =  a.getString("name").toString();
        alpha2_code = a.getString("alpha2_code").toString();
        alpha3_code = a.getString("alpha3_code").toString();
        imagen = "http://www.geognos.com/api/en/countries/flag/"+a.getString("alpha2_code").toString()+".png";

    }

    public String getName() {
        return name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }

    public String getImagen() {
        return imagen;
    }

    public static ArrayList<Paises> JsonObjectsBuild(JSONArray datos) throws JSONException {

        ArrayList<Paises> pais = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            pais.add(new Paises(datos.getJSONObject(i)));
        }

        return pais;

    }

}
