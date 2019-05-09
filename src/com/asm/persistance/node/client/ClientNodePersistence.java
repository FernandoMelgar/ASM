package com.asm.persistance.node.client;

import com.asm.entities.client.Client;
import com.asm.interactors.ClientPersistence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientNodePersistence  implements ClientPersistence {

    public static void main(String[] args) {
        ClientNodePersistence cln = new ClientNodePersistence();
        Client c = new Client();
        c.setName("Fernando");
        cln.save(c);
    }

    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    public void save(Client c) {
        {
            String json ="";
            ObjectMapper mapper = new ObjectMapper();
            try {
                 json  = mapper.writeValueAsString(c);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            String query_url = "http://localhost:3000/save";
            sendPostRequest(json, query_url);
        }
    }

    private void sendPostRequest(String json, String query_url) {
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
            InputStream in = new BufferedInputStream(conn.getInputStream());
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // optional default is GET
    //add request header

    private StringBuffer getResponseAsString(HttpURLConnection con) throws IOException {
        StringBuffer response = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response;
    }
}
