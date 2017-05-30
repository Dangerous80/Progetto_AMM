/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Nerd;
import amm.nerdbook.Classi.NerdFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Filter extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String command = request.getParameter("cmd");
        if (command != null){
            // Verifica che commando e id siano stati impostati
            if (command.equals("search")) {
                // Esegue la ricerca
                List<Nerd> listaUtenti = NerdFactory.getInstance().getNerdList(request.getParameter("q"));
                if(listaUtenti.isEmpty()){
                  request.getRequestDispatcher("sidebar.jsp").forward(request, response);  
                }
                else{
                   request.setAttribute("listaUtenti", listaUtenti);
                                
                    // segnialimao che stiamo restituendo json in modo da evitare il caching
                    response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, "
                        + "must-revalidate");
                
                    //Ora generiamo il json con una jsp chiamata filter_json.jsp
                    request.getRequestDispatcher("filter_json.jsp").forward(request, response);
                }    
            }    
        }
    }    

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
