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
import javax.ejb.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author nunos
 */


@Singleton
public class GetData {
    private static String urlFormat;
    private static String data;
    private static String cityCode;
    private static String dataExtracted;
    public static final String BASE_URL = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/";
    public static final String FINAL_URL = ".json";
    protected final static  List<String> tMin = new ArrayList<String>();
    protected final static List<String> tMax = new ArrayList<String>();
    protected final static List<String> prob_prec = new ArrayList<String>();
    protected final static List<Integer> weather_type = new ArrayList<Integer>();
    protected final static List<Integer> windSpeed = new ArrayList<Integer>();
    protected final static List<String> wind_Direction = new ArrayList<String>();
    protected final static List<String> day = new ArrayList<String>();
    
    private static Cache<String, String> cache = new Cache<>();


    public static String setCity_Code(String cityCode) {
        GetData.cityCode = cityCode;
        return GetData.cityCode;
    }
    
    public static String getUrl(){
        GetData.urlFormat = urlFormat;
        return GetData.urlFormat;
    }
    
    public static String getCityCode(){
        return GetData.cityCode;
    }
    
    public static String GetJsonResponse(){
        GetData.data = data;
        return GetData.data;
    }

    public static void sendLiveRequest() throws IOException {
          
        //GetData.city_code
        //1121400
        //GetData.setCity_Code("1121400");
        urlFormat = BASE_URL + GetData.cityCode + FINAL_URL;
        URL obj = new URL(urlFormat);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + urlFormat);
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
            cache.put(GetData.cityCode, data);
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
        return dataExtracted;
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