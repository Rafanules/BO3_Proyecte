package com.example.bo3_proyecte;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Bo3_Api {

    private final String BASE_URL = "https://gmgcqfdylamfobtmguih.supabase.co/rest/v1/";
    private final String API_KEY = "<eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImdtZ2NxZmR5bGFtZm9idG1ndWloIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTk1MjI0MDksImV4cCI6MjAxNTA5ODQwOX0.jzk3Eq9NZ5o8xvtiXpyu_a4EkUltdX-l5WYe1EVSuAQ>";

    ArrayList<Especialista> getPersonajes() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("NombreESP")
                .appendPath("FotoESP")
                .appendPath("AvilidadesESP")
                .appendPath("TipoESP")
                .appendQueryParameter("api_key", API_KEY)
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private ArrayList<Especialista> processJson(String jsonResponse) {
        ArrayList<Especialista> Especialistas = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonEspecialista = data.getJSONArray("results");
            for (int i = 0; i < jsonEspecialista.length(); i++) {
                JSONObject jsonEspecialistas = jsonEspecialista.getJSONObject(i);

                Especialista Especialista = new Especialista();
                Especialista.setNombreEsp(jsonEspecialistas.getString("title"));
                Especialista.setAvilidadesEsp(jsonEspecialistas.getString("release_date"));
                Especialista.setFotoEsp(jsonEspecialistas.getString("overview"));
                Especialista.setTipoEsp(jsonEspecialistas.getString("poster_path"));

                 Especialistas.add(Especialista);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Especialistas;
    }

    private ArrayList doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
