/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.NerdFactory;
import amm.nerdbook.Classi.Nerd;
import amm.nerdbook.Classi.GruppoFactory;
import amm.nerdbook.Classi.Gruppo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class Profilo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Verifico se è già inizializzato un oggetto sessione in modo da capire se esiste già un utente loggato
        HttpSession session = request.getSession(false);
                
        /*se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true recupero lo userid dell'utente loggato 
        per visualizzare i suoi dati*/
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true)){
            Integer userID = (Integer)session.getAttribute("loggedUserID");
            Nerd nerd = NerdFactory.getInstance().getNerdById(userID);
            if(nerd != null){
                request.setAttribute("nerd", nerd);
                
                //recuperiamo la lista degli utenti esistenti da passare alla sidebar
                List<Nerd> listaUtenti = NerdFactory.getInstance().getNerdList();
                request.setAttribute("listaUtenti", listaUtenti);
                
                //recuperiamo la lista dei gruppi esistenti da passare alla sidebar
                List<Gruppo> listaGruppi = GruppoFactory.getInstance().getGroupList();
                request.setAttribute("listaGruppi", listaGruppi);
                
                //codice di verifica modifica dati
                String pulsanteAggiornaDati=request.getParameter("pulsanteAggiornaDati");
                boolean aggiornamento;
                if(pulsanteAggiornaDati != null){
                    String nomeUtente = request.getParameter("nomeUtente");
                    String cognomeUtente = request.getParameter("cognomeUtente");
                    String dataNascita = request.getParameter("dataNascita");
                    String frasePresentazione = request.getParameter("frasePresentazione");
                    String fotoProfilo = request.getParameter("fotoProfilo");
                    String pswdUtente = request.getParameter("pswdUtente");
                    if(nomeUtente != nerd.getNome()){
                        request.setAttribute("nome",nomeUtente);
                    }
                    if(cognomeUtente != nerd.getCognome()){
                        request.setAttribute("cognome",cognomeUtente);
                    }
                    if(dataNascita != nerd.getDataNascita()){
                        request.setAttribute("data",dataNascita);
                    }
                    if(fotoProfilo != nerd.getUrlFotoProfilo()){
                        request.setAttribute("foto",fotoProfilo);
                    }
                    if(frasePresentazione != nerd.getFrasePresentazione()){
                        request.setAttribute("frase",frasePresentazione);
                    }
                    if(pswdUtente != nerd.getPassword()){
                        request.setAttribute("password",pswdUtente);
                    }
                    if(nomeUtente == nerd.getNome() && cognomeUtente == nerd.getCognome() && dataNascita == nerd.getDataNascita() && fotoProfilo == nerd.getUrlFotoProfilo() && frasePresentazione == nerd.getFrasePresentazione() && pswdUtente == nerd.getPassword()){
                       aggiornamento=false;
                       request.setAttribute("aggiornamento", aggiornamento);
                    }
                    else{
                       aggiornamento=true;
                       request.setAttribute("aggiornamento", aggiornamento);  
                    }
                }
                
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            } 
            else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else{
            request.setAttribute("accessoNonAutorizzato", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
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
