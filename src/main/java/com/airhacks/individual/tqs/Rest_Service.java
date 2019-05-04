package com.airhacks.individual.tqs;


import static java.awt.SystemColor.text;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.client.Entity.html;
import static javax.ws.rs.client.Entity.text;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sun.net.www.content.text.plain;

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
                + "    <td>/DIA</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(0)) +"gay" +"<span style=\"float:right;\"><i class=\"fa fa-toggle-on\"></i></span></td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(0) + "    tMax: " + data.get_tMax().get(0)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(0) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(0) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(0))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>/DIA</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(1)) +"</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(1) + "    tMax: " + data.get_tMax().get(1)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(1) + "<i class=\"fa fa-tint low\" aria-hidden=\"true\"></i></td>\n"
                + "    <td>" + data.get_wind_Direction().get(1) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(1))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>/DIA</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(2)) + "</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(2) + "    tMax: " + data.get_tMax().get(2)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(2) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(2) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(2))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>/DIA</td>\n"
                + "    <td>" + Codes.idWeatherType(data.get_weatherTtype().get(3)) + "</td>\n"
                + "    <td>" + "tMin: " + data.get_tMin().get(3) + "    tMax: " + data.get_tMax().get(3)  + "</td>\n"
                + "    <td>"+ data.get_prob_prec().get(3) + "</td>\n"
                + "    <td>" + data.get_wind_Direction().get(3) + "</td>\n"
                + "    <td>" + Codes.idWindSpeed(data.get_windSpeed().get(3))+ "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>/DIA</td>\n"
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
        String html_response = "<html>" + "<title>" + cidade + "</title>" + "<body>" + "<h1>" + "DATA:" + skeleton + "<span>" + "</h1>" + "</body>" + "</html>";
        return html_response;

    }
//<div id=\"2\" class=\"weekly-column\"><div class=\"date\">2 Qui</div><img class=\"weatherImg\" src=\"http://www.ipma.pt\" title=\"Céu limpo\"><span class=\"tempMin\">13º</span><span class=\"tempMax\">30º</span><img class=\"windImg d180\" src=\"/opencms/bin/icons/svg/wind/wind-2.svg\" alt=\"Vento: Moderado de N\" title=\"Vento: Moderado de N\"><div class=\"windDir\">N</div><div class=\"precProb\" alt=\"Probabilidade precipitação: 0%\" title=\"Probabilidade precipitação: 0%\">0% <sup><i class=\"fa fa-tint low\" aria-hidden=\"true\"></i></sup></div><div class=\"wrapper\"><div class=\"warning wc-green\">&nbsp;</div></div><img class=\"iuvImg\" src=\"/opencms/bin/images.site/otempo/uv8.gif\" alt=\"I. Ultravioleta: 8\" title=\"IUV: 8\"></div>
}

//"<a class=\"weatherwidget-io\" href=\"https://forecast7.com/en/40d71n74d01/new-york/\" data-label_1=" + cidade + "data-label_2=" + cidade + " data-theme=\"original\" >NEW YORK WEATHER</a>\n" +
//"<script>\n" +
//"!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');\n" +
//"</script>";



//<span style="float:right;"><i class="fa fa-toggle-on"></i></span>
//<i class="fa fa-tint low" aria-hidden="true"></i>
//<div class="precProb" alt="Probabilidade precipitação: 0%" title="Probabilidade precipitação: 0%">0% <sup><i class="fa fa-tint low" aria-hidden="true"></i></sup></div>