package com.uv.ggnore;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ApiWrapper {

    private String key = "228a6513-aabe-47c9-865b-f3218670c264";
    private String baseCdnUrl = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg";
    private String baseApiUrl = "";

    public ApiWrapper() {
    }

    // Jsoup methods

    private Document getSource(String url, int timeout)    {
        Document doc = null;

        try {
            doc = Jsoup.connect(url).timeout(timeout).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
        //Hello world.
    }

    private void getRotations()  {
    }

    // JSON methods

    private String getSource(String url)  {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuilder str = null;
        try {
            response = client.execute(request);
            in = response.getEntity().getContent();
            reader = new BufferedReader(new InputStreamReader(in));
            str = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
            {
                str.append(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }

    private JsonNode getJSON(String url, String key)   {
        String request_url = url + (url.contains("?") ? "&" : "?") + "api_key=" + this.key;
        String data = getSource(request_url);

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getJsonFactory(); // since 2.1 use mapper.getFactory() instead
        JsonParser jp = null;
        JsonNode obj = null;
        try {
            jp = factory.createJsonParser(data);
            obj = mapper.readTree(jp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(key == "")    {
            obj = obj.get(0);
        }
        else    {
            obj = obj.get(key);
        }

      return obj;
    }

    public ArrayList<Champion> getAllChampions()    {
        ArrayList<Champion> champions = new ArrayList<Champion>();
        JsonNode champData = getJSON("https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion?champData=image", "data");

        return champions;
    }

    public Champion getChampion(Champion champion)   {
        return champion;
    }
}
