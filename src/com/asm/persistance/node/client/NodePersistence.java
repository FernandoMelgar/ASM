package com.asm.persistance.node.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NodePersistence {


    public static String sendGetRequest(String query_url) throws IOException {
        URL url = new URL(query_url);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        return getResponseAsString(conn);
    }

    public static String sendPostRequest(String json, String query_url) throws IOException {
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response


            return getResponseAsString(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Not found";
    }


    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
        StringBuilder res = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return res.toString();
    }

}
