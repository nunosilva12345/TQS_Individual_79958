package com.airhacks.individual.tqs;


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
    protected static final  List<String> tMin = new ArrayList<>();
    protected static final List<String> tMax = new ArrayList<>();
    protected static final List<String> prob_prec = new ArrayList<>();
    protected static final List<Integer> weather_type = new ArrayList<>();
    protected static final List<Integer> windSpeed = new ArrayList<>();
    protected static final List<String> wind_Direction = new ArrayList<>();
    protected static final List<String> day = new ArrayList<>();
    
    private static Cache<String, String> cache = new Cache<>();


    public static String setCityCode(String cityCode) {
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
    
    public static String getJsonResponse(){
        GetData.data = data;
        return GetData.data;
    }

    public static void sendLiveRequest() throws IOException {
          
        
        urlFormat = BASE_URL + GetData.cityCode + FINAL_URL;
        URL obj = new URL(urlFormat);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer json = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            json.append(inputLine);
        }
        in.close();

        JSONObject myResponse = new JSONObject(json.toString());
        data = myResponse.optString("data");
     
        if(cache.get(GetData.getCityCode()) == null){
            cache.put(GetData.cityCode, data);
        }
        
        System.out.println("GET: " + cache.get(GetData.getCityCode()));
        
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
    
    public List<String> getTmax(){
        return tMax;
    } 
    
    public List<String> getProbPrec(){
        return prob_prec;
    }
    
    public List<String> getDate(){
        return day;
    }
     
    public List<String> getTmin(){
        return tMin;
    }
    
    public List<Integer> getWeatherTtype(){
        return weather_type;
    }
    
    public List<Integer> getWindSpeed(){
        return windSpeed;
    }
    
    public List<String> getWindDirection(){
        return wind_Direction;
    }
    
    
}

//http://localhost:8080/Individual/webresources/Meteorologia?cidade=aveiro