package com.airhacks.individual.tqs;


import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("/Meteorologia")
public class RestService {

    @EJB
    private GetData data = new GetData();
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)

    public String doGetAsHtml(@FormParam("cidade") String cidade) throws IOException {
        GetData.sendLiveRequest();
        
        String skeleton = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table {\n"
                + "  font-family: arial, sans-serif;\n"
                + "  border-collapse: collapse;\n"
                + "  width: 80%;\n"
                + "}\n"
                + "\n"
                + "td, th {\n"
                + "  border: 1px solid #dddddd;\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even) {\n"
                + "  background-color: #dddddd;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h2>Meteorologia</h2>\n"
                + "\n"
                + "<table>\n"
                + "  <tr>\n"
                + "    <th>" + cidade + "</th>\n"
                + "    <th>Tempo</th>\n"
                + "    <th>Temperatura</th>\n"
                + "    <th>Probabilidade de Precipitação(%)</th>\n"
                + "    <th>Direção do Vento</th>\n"
                + "    <th>Intensidade do Vento</th>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>" + data.getDate().get(0) +"</td>\n"
                + "    <td>" + Codes.idWeatherType(data.getWeatherTtype().get(0)) +"<span style=\"float:right;\"><i class=\"fa fa-toggle-on\"></i></span></td>\n"
                + "    <td>" + "tMin: " + data.getTmin().get(0) + "    tMax: " + data.getTmax().get(0)  + "</td>\n"
                + "    <td>"+ data.getProbPrec().get(0) + "</td>\n"
                + "    <td>" + data.getWindDirection().get(0) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.getWindSpeed().get(0))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(1) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.getWeatherTtype().get(1)) +"</td>\n"
                + "    <td>" + "tMin: " + data.getTmin().get(1) + "    tMax: " + data.getTmax().get(1)  + "</td>\n"
                + "    <td>"+ data.getProbPrec().get(1) + "<i class=\"fa fa-tint low\" aria-hidden=\"true\"></i></td>\n"
                + "    <td>" + data.getWindDirection().get(1) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.getWindSpeed().get(1))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(2) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.getWeatherTtype().get(2)) + "</td>\n"
                + "    <td>" + "tMin: " + data.getTmin().get(2) + "    tMax: " + data.getTmax().get(2)  + "</td>\n"
                + "    <td>"+ data.getProbPrec().get(2) + "</td>\n"
                + "    <td>" + data.getWindDirection().get(2) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.getWindSpeed().get(2))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(3) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.getWeatherTtype().get(3)) + "</td>\n"
                + "    <td>" + "tMin: " + data.getTmin().get(3) + "    tMax: " + data.getTmax().get(3)  + "</td>\n"
                + "    <td>"+ data.getProbPrec().get(3) + "</td>\n"
                + "    <td>" + data.getWindDirection().get(3) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.getWindSpeed().get(3))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(4) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.getWeatherTtype().get(4)) + "</td>\n"
                + "    <td>" + "tMin: " + data.getTmin().get(4) + "    tMax: " + data.getTmax().get(4)  + "</td>\n"
                + "    <td>"+ data.getProbPrec().get(4) + "</td>\n"
                + "    <td>" + data.getWindDirection().get(4) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.getWindSpeed().get(4))+ "</td>\n"
                + "  </tr>\n"
                + "</table>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
        
        data.getDate().clear();
        data.getProbPrec().clear();
        data.getTmax().clear();
        data.getTmin().clear();
        data.getWeatherTtype().clear();
        data.getWindSpeed().clear();
        data.getWindDirection().clear();
        return "<html>" + "<title>" + cidade + "</title>" + "<body>" + "<h1>" + "DATA:" + skeleton + "<span>" + "</h1>" + "</body>" + "</html>";
        
    }
}