package com.example.myapplication.Helper;

import com.example.myapplication.Controllers.CompetitionController;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class JsonHelper<T> {

    public T getObjectFromJson(String urlTarget, Class<T> myClass) {

        Gson gson = new Gson();
        String json = null;
        T result = null;

        json = JsonHelper.getJsonStringByUrl(urlTarget);

        if (json != null) {
            result = gson.fromJson(json, myClass);
        }

        return result;
    }

    public static String getJsonStringByUrl(String urlTarget) {
        try {
            URL url = new URL(urlTarget);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("X-Auth-Token", CompetitionController.TOKEN);
            http.setUseCaches(false);
            http.setAllowUserInteraction(false);
            http.connect();

            int status = http.getResponseCode();

            if (status == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }

                br.close();
                return sb.toString();
            } else {
                return "URL does not answer.";
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
            return "Something didn't work";

        } catch (IOException e) {
            e.printStackTrace();
            return "Something didn't work";
        }
    }
}

