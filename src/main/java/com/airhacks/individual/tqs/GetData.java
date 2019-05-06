package com.airhacks.individual.tqs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// necessary components are imported
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;
;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author nunos
 */


@Singleton
public class GetData {
    private Codes code;
    private static String url_format;
    private static String data;
    private static String city_code;
    private static String data_extracted;
    public static final String BASE_URL = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/";  //falta isto {globalIdLocal}.json";
    public static final String FINAL_URL = ".json";
    public final static List<String> tMin = new ArrayList<String>();
    public final static List<String> tMax = new ArrayList<String>();
    public final static List<String> prob_prec = new ArrayList<String>();
    public final static List<Integer> weather_type = new ArrayList<Integer>();
    public final static List<Integer> windSpeed = new ArrayList<Integer>();
    public final static List<String> wind_Direction = new ArrayList<String>();
    public final static List<String> day = new ArrayList<String>();
    
    private static Cache<String, String> cache = new Cache<>();


    public static String setCity_Code(String city_code) {
        GetData.city_code = city_code;
        return GetData.city_code;
    }
    
    public static String getUrl(){
        GetData.url_format = url_format;
        return GetData.url_format;
    }
    
    public static String getCityCode(){
        return GetData.city_code;
    }
    
    public static String GetJsonResponse(){
        GetData.data = data;
        return GetData.data;
    }

    public static void sendLiveRequest() throws IOException {
          
        //GetData.city_code
        //1121400
        //GetData.setCity_Code("1121400");
        url_format = BASE_URL + GetData.city_code + FINAL_URL;
        URL obj = new URL(url_format);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url_format);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer json = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            json.append(inputLine);
        }
        in.close();

        JSONObject myResponse = new JSONObject(json.toString());
        System.out.println("result after Reading JSON Response");
        data = myResponse.optString("data");
        
        System.out.println("--------------------------------------------");
        
        
        if(cache.get(GetData.getCityCode()) == null){
            cache.put(GetData.city_code, data);
        }
        System.out.println("GET: " + cache.get(GetData.getCityCode()));
        
        System.out.println("------------------------------------------------------------");
        
        JSONArray array = myResponse.getJSONArray("data");
        for (int i = 0; i < array.length(); i++) {
            tMin.add(array.getJSONObject(i).getString("tMin"));
            tMax.add(array.getJSONObject(i).getString("tMax"));
            prob_prec.add(array.getJSONObject(i).getString("precipitaProb"));
            weather_type.add(array.getJSONObject(i).getInt("idWeatherType"));
            windSpeed.add(array.getJSONObject(i).getInt("classWindSpeed"));
            wind_Direction.add(array.getJSONObject(i).getString("predWindDir"));
            day.add(array.getJSONObject(i).getString("forecastDate"));
        }
        
       
    }
    
    public String getDataExtracted(){
        return data_extracted;
    }
    
    public List<String> get_tMax(){
        return tMax;
    } 
    
    public List<String> get_prob_prec(){
        return prob_prec;
    }
    
    public List<String> getDate(){
        return day;
    }
     
    public List<String> get_tMin(){
        return tMin;
    }
    
    public List<Integer> get_weatherTtype(){
        return weather_type;
    }
    
    public List<Integer> get_windSpeed(){
        return windSpeed;
    }
    
    public List<String> get_wind_Direction(){
        return wind_Direction;
    }
    
    
}

//http://localhost:8080/Individual/webresources/Meteorologia?cidade=aveiro