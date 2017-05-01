/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.NerdFactory;
import amm.nerdbook.Classi.Nerd;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Apriamo la sessione al fine di verificare se esiste già un utente loggato
        HttpSession session = request.getSession();
        
        //Se il pararametro GET logout è impostato si distrugge la sessione e si ritorna alla login.jsp
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true allora esiste già un utente loggato e si richiama la servlet Bacheca
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {
            //verifica se l'utente ha tutti i dati correttamente inseriti
            Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
            Nerd nerd = NerdFactory.getInstance().getNerdById(loggedUserID);
            if (nerd != null){
                //se l'utente non ha indicato uno dei dati va al profilo
                if (nerd.getNome().isEmpty() || nerd.getCognome().isEmpty() || nerd.getUrlFotoProfilo().isEmpty() || nerd.getFrasePresentazione().isEmpty()){
                    request.getRequestDispatcher("Profilo").forward(request, response);
                    return;
                }
                //se l'utente ha indicato tutti i dati va alla bacheca
                else{
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                }
            }
        }        
        //Se l'utente non è loggato preleva userid e pswd dalla richiesta inserita dall'utente nella login.jsp
        else {        
            String username = request.getParameter("username");   
            String password = request.getParameter("password");
        
        /*Ora si verifica se username e password inseriti corrispondono ad un utente esistente e nel caso l'utente esista impostiamo 
        l'attributo di sessione logedIn a true e l'altro attributo di sessione loggedUserId con lo userId dell'utente loggato*/
            if(username != null && password != null){
                int loggedUserID = NerdFactory.getInstance().getIdByUserAndPassword(username, password);
                
                /*se userid e pswd inseriti corrisppondono effettivamente ad un utente si impostano i due attributi di sessione 
                LoggedIn a true e LoggedUserId al valore ID dell'utente che si è loggato e si va alla servelet Bacheca nel caso l'utente abbia tutti i suoi dati inseriti
                Se invece l'utente non ha inserito uno dei seguenti dati: nome, cognome, urlFotoProfilo o frase di presentazione si va alla pagina di modifica dei dati del profilo*/
                if(loggedUserID!=-1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    
                    //verifica se l'utente ha tutti i dati correttamente inseriti
                    Nerd nerd = NerdFactory.getInstance().getNerdById(loggedUserID);
                    if (nerd != null){
                        //se l'utente non ha indicato uno dei dati va al profilo
                        if (nerd.getNome().isEmpty() || nerd.getCognome().isEmpty() || nerd.getUrlFotoProfilo().isEmpty() || nerd.getFrasePresentazione().isEmpty()){
                            request.getRequestDispatcher("Profilo").forward(request, response);
                            return;
                        }
                        //se l'utente ha indicato tutti i dati va alla bacheca
                        else{
                            request.getRequestDispatcher("Bacheca").forward(request, response);
                            return;
                        }
                    }
                }    
                /*se invece username e password non corrispondono a nessun utente esistente si imposta la variabile invalidData a true
                si torna alla login.jsp e si informa l'utente che i dati inseriti non sono validi*/
                else { 
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }
        
        //se non si verifica nessuno dei casi sovra indicati si va direttamente alla login.jsp per effettuare l'accesso
        request.getRequestDispatcher("login.jsp").forward(request, response);
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