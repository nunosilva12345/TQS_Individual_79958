package com.airhacks.individual.tqs;


//@WebServlet(urlPatterns = {"/MyServlet"})


import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunos
 */
@WebServlet(name = "Meteorologia", urlPatterns = {"/Meteorologia"})
//@WebServlet("/Meteorologia")
public class MyServlet extends HttpServlet {
    private Rest_Service rest = new Rest_Service();
    private GetData data;
    private Codes city;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{

            String cidade = request.getParameter("cidade");
            out.println("enter");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Meteorologia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cidade" + request.getParameter("cidade")   + "</h1>");

            //aqui <h1> meteoroglia paraa 3 dias, e chamar funcao que faz e imprimi isso, fechar h1. ----> esse que vem é que é o do post
            
            //chamar funcao que recebe primeiro cidade e vai buscar dadaos e guarda no map
            //depois e que chamo o de baixo porque o mapa esta feito
            out.println("<h1>tentar das display dos dados: </h1>");
            out.println("<h1>agora chamar primeira funcao com nome da cidade para o switch case</h1>");
            out.println("<h1>" + city.returnCityCode(cidade) + "</h1>");
            String city_code  = String.valueOf(city.returnCityCode(cidade));
            out.println("<h1>1 +" + city_code + "</h1>");
            
            out.println("<h1>" + data.setCity_Code(city_code) + "</h1>");
            out.println("<h1>2 "+ "</h1>");
            out.println("porque nao entra na linha em baixo?");
            out.println("<h1>" + rest.doGetAsHtml(cidade) + "</h1>");
            out.println("depois dessa tal linha");
            out.println("</body>");
            out.println("</html>");
        }finally{
            out.close();
        }
    }

    // primeiro, pegar no nome da cidade
    //adicionar a url
    //ir buscar essa informacao a essa url
    //post dessa informcao( ja o tempo para 3 dias)
           
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }
        
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}