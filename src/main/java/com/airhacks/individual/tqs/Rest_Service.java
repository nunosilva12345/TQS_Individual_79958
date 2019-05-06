package com.airhacks.individual.tqs;


import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nunos
 */


@Path("/Meteorologia")
public class Rest_Service {
    private Codes code;

    @EJB
    private GetData data = new GetData();
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)

    public String doGetAsHtml(@FormParam("cidade") String cidade) throws IOException {
        System.out.println("REST_SERVICE");
        data.sendLiveRequest();
        
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
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(0)) +"<span style=\"float:right;\"><i class=\"fa fa-toggle-on\"></i></span></td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(0) + "    tMax: " + data.get_tMax().get(0)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(0) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(0) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(0))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(1) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(1)) +"</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(1) + "    tMax: " + data.get_tMax().get(1)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(1) + "<i class=\"fa fa-tint low\" aria-hidden=\"true\"></i></td>\n"
                + "    <td>" + data.get_wind_Direction().get(1) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(1))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(2) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(2)) + "</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(2) + "    tMax: " + data.get_tMax().get(2)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(2) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(2) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(2))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(3) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(3)) + "</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(3) + "    tMax: " + data.get_tMax().get(3)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(3) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(3) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(3))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>"+ data.getDate().get(4) + "</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(4)) + "</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(4) + "    tMax: " + data.get_tMax().get(4)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(4) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(4) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(4))+ "</td>\n"
                + "  </tr>\n"
                + "</table>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
        
        data.getDate().clear();
        data.get_prob_prec().clear();
        data.get_tMax().clear();
        data.get_tMin().clear();
        data.get_weatherTtype().clear();
        data.get_windSpeed().clear();
        data.get_wind_Direction().clear();
        String html_response = "<html>" + "<title>" + cidade + "</title>" + "<body>" + "<h1>" + "DATA:" + skeleton + "<span>" + "</h1>" + "</body>" + "</html>";
        return html_response;

    }
}