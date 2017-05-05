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
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.Post;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Bacheca extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //verifico se è già stato inizializzato un oggetto sessione, inserendo l'attirbuto false se l'oggetto esiste viene recuperato se non esiste non viene creato
        HttpSession session = request.getSession(false);
                
        //se l'oggetto sessione esiste e allora esistono anche i suoi attributi LoggedIn e LoggedUserID che mi consnetono di visualizzare i dati di un utente loggato
        if(session!=null && session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true)){
            
            //se la richiesta ha passato un parametro user si utilizzerà per visualizzare i post di quell'utente
            //se la richiesta ha passato un parametro group si utilizzerà per visualizzare i post di quel gruppo
            String user = request.getParameter("user");
            String group = request.getParameter("group");
            
            int userID;
            int bachecaID;
            String pulsanteCreaPost=request.getParameter("pulsanteCreaPost");
            String pulsanteConferma=request.getParameter("pulsanteConferma");
            String testoPost = request.getParameter("testoPost");
            String urlPost = request.getParameter("urlPost");
            String tipoPost=request.getParameter("tipoPost");
            boolean inserimento;
            boolean conferma;
                                               
            if(user != null){
                bachecaID = Integer.parseInt(user);
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
                Nerd nerd = NerdFactory.getInstance().getNerdById(userID);
                if( nerd != null){
                    request.setAttribute("nerd", nerd);
                }
                else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                Nerd userBacheca = NerdFactory.getInstance().getNerdById(bachecaID);
                if( userBacheca != null){
                    List<Post> posts = PostFactory.getInstance().getUserPostList(userBacheca);
                    request.setAttribute("posts", posts);
                }
                else {
                   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
              
                //recuperiamo la lista degli utenti esistenti da passare alla sidebar
                List<Nerd> listaUtenti = NerdFactory.getInstance().getNerdList();
                request.setAttribute("listaUtenti", listaUtenti);
                
                //recuperiamo la lista dei gruppi esistenti da passare alla sidebar
                List<Gruppo> listaGruppi = GruppoFactory.getInstance().getGroupList();
                request.setAttribute("listaGruppi", listaGruppi);
                
                request.setAttribute("bachecaUtente", user);
                
                //verifichiamo ora se è stato inserito un nuovo post
                if(pulsanteCreaPost != null){
                    if(testoPost != null){
                        request.setAttribute("testo",testoPost);
                    }
                    if(urlPost != null){
                        request.setAttribute("url",urlPost);
                    }
                    if(testoPost == null){
                        inserimento=false;
                        request.setAttribute("inserimento", inserimento);
                    }
                    else{
                        inserimento=true;
                        request.setAttribute("inserimento", inserimento);
                    }
                }
                //se l'inserimento viene confermato scriviamo sulla bacheca (nostra, dell'utente o del gruppo scelto)
                if(pulsanteConferma != null){
                    conferma=true;
                    request.setAttribute("conferma", conferma);
                    request.setAttribute("bacheca", userBacheca.getNome());
                }
                               
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }    
            else{
                if(group != null){
                    bachecaID = Integer.parseInt(group);
                    Gruppo gruppoBacheca = GruppoFactory.getInstance().getGruppoById(bachecaID);
                    if(gruppoBacheca != null){
                      List<Post> posts = PostFactory.getInstance().getGroupPostList(gruppoBacheca);
                      request.setAttribute("posts", posts);
                    }
                    else {
                      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
                    Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                    userID = loggedUserID;
                    Nerd nerd = NerdFactory.getInstance().getNerdById(userID);
                    if(nerd != null){
                       request.setAttribute("nerd", nerd);
                    }
                    else {
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
                    
                    //recuperiamo la lista degli utenti esistenti da passare alla sidebar
                    List<Nerd> listaUtenti = NerdFactory.getInstance().getNerdList();
                    request.setAttribute("listaUtenti", listaUtenti);
                
                    //recuperiamo la lista dei gruppi esistenti da passare alla sidebar
                    List<Gruppo> listaGruppi = GruppoFactory.getInstance().getGroupList();
                    request.setAttribute("listaGruppi", listaGruppi);
                    
                    request.setAttribute("bachecaGruppo", group);
                    
                    //verifichiamo ora se è stato inserito un nuovo post
                    if(pulsanteCreaPost != null){
                        if(testoPost != null){
                            request.setAttribute("testo",testoPost);
                        }
                        if(urlPost != null){
                            request.setAttribute("url",urlPost);
                        }
                        if(testoPost.isEmpty()){
                            inserimento=false;
                            
                            request.setAttribute("inserimento", inserimento);
                        }
                        else{
                            inserimento=true;
                            request.setAttribute("inserimento", inserimento); 
                        }
                    }
                    //se l'inserimento viene confermato scriviamo sulla bacheca (nostra, dell'utente o del gruppo scelto)
                    if(pulsanteConferma != null){
                        conferma=true;
                        request.setAttribute("conferma", conferma);
                        request.setAttribute("bacheca", gruppoBacheca.getNomeGruppo());
                    }
                    
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    
                }    
                else{
                    Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                    userID = loggedUserID;
                    Nerd nerd = NerdFactory.getInstance().getNerdById(userID);
                    if( nerd != null){
                        request.setAttribute("nerd", nerd);
                        
                        List<Post> posts = PostFactory.getInstance().getUserPostList(nerd);
                        request.setAttribute("posts", posts);
                    }
                    else {
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
                    //recuperiamo la lista degli utenti esistenti da passare alla sidebar
                    List<Nerd> listaUtenti = NerdFactory.getInstance().getNerdList();
                    request.setAttribute("listaUtenti", listaUtenti);
                
                    //recuperiamo la lista dei gruppi esistenti da passare alla sidebar
                    List<Gruppo> listaGruppi = GruppoFactory.getInstance().getGroupList();
                    request.setAttribute("listaGruppi", listaGruppi);
                    
                    //verifichiamo ora se è stato inserito un nuovo post
                    if(pulsanteCreaPost != null){
                        if(testoPost != null){
                            request.setAttribute("testo",testoPost);
                        }
                        if(urlPost != null){
                            request.setAttribute("url",urlPost);
                        }
                        if(testoPost.isEmpty()){
                            inserimento=false;
                            request.setAttribute("inserimento", inserimento);
                        }
                        else{
                            inserimento=true;
                            request.setAttribute("inserimento", inserimento); 
                        }
                    }
                    //se l'inserimento viene confermato scriviamo sulla bacheca (nostra, dell'utente o del gruppo scelto)
                    if(pulsanteConferma != null){
                        conferma=true;
                        request.setAttribute("conferma", conferma);
                        request.setAttribute("bacheca", nerd.getNome());
                        }
                    
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
            }
        }
        else{
            request.setAttribute("accessoNonAutorizzato", true);
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
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
