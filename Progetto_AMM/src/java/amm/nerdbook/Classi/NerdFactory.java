/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Pisano Daniele
 */
public class NerdFactory {
    
    //Pattern Design Singleton
    private static NerdFactory singleton;

    public static NerdFactory getInstance() {
        if (singleton == null) {
            singleton = new NerdFactory();
        }
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
        
    
    private NerdFactory() {
    }
    
    //inseriamo un metodo che ci consenta di reperire le info sull'utente mediante il suo id
    public Nerd getNerdById(int id) {
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select * from nerd "
                    + "join nerdtype on nerd.tipoutente = nerdtype.nerdtype_id "
                    + "where nerd_id = ?";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //associamo i valori alla query
            stmt.setInt(1, id);
            
            //eseguiamo la query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe e creazione di un nerd
            if (res.next()) {
                Nerd currentNerd = new Nerd();
                currentNerd.setId(res.getInt("nerd_id"));
                currentNerd.setNome(res.getString("nome"));
                currentNerd.setCognome(res.getString("cognome"));
                currentNerd.setDataNascita(res.getString("dataNascita"));
                currentNerd.setFrasePresentazione(res.getString("frasePresentazione"));
                currentNerd.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                currentNerd.setPassword(res.getString("password"));
                currentNerd.setTipoUtente(this.tipoUtenteFromString(res.getString("nerdtype_abilitazione")));
                
                //quido lo statment, chiudo la connessione e restituisco un nerd
                stmt.close();
                conn.close();
                return currentNerd;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
      
    public int getIdByUserAndPassword(String username, String password){
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select nerd_id from nerd "
                    + "where nome = ? and password = ?";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //associamo i valori alla query
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            //eseguiamo la query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe e definizione dell id del nerd
            if (res.next()) {
                int id = res.getInt("nerd_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        
    }
    
    //inseriamo un metodo che ci consenta di recuperare la lista degli utenti
    public List getNerdList(){
        List<Nerd> listaNerd = new ArrayList<Nerd>();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = "select * from nerd "
                         + "join nerdtype on nerd.tipoutente = nerdtype.nerdtype_id ";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //eseguo la  query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe, creo un nerd e lo inserisco nella lista nerd
            while (res.next()) {
                Nerd currentNerd = new Nerd();
                currentNerd.setId(res.getInt("nerd_id"));
                currentNerd.setNome(res.getString("nome"));
                currentNerd.setCognome(res.getString("cognome"));
                currentNerd.setDataNascita(res.getString("dataNascita"));
                currentNerd.setFrasePresentazione(res.getString("frasePresentazione"));
                currentNerd.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                currentNerd.setPassword(res.getString("password"));
                currentNerd.setTipoUtente(this.tipoUtenteFromString(res.getString("nerdtype_abilitazione")));
                
                listaNerd.add(currentNerd);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNerd;
    }
    //inseriamo un metodo che ci consenta di recuperare il tipo di utente
    private Nerd.Type tipoUtenteFromString(String type){
        
        if(type.equals("ADMIN"))
            return Nerd.Type.ADMIN;
        
        return Nerd.Type.STANDARD;
    }
    //inseriamo un metodo che ci consenta di aggiornare i dati di un utente
    public void updateUser(Nerd nerd, String nome, String cognome, String dataNascita, String frasePresentazione, String urlFotoProfilo, String password){
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "update nerd set "
                    + "nome= ?, cognome= ?, datanascita= ?, frasepresentazione= ?, urlfotoprofilo= ?, password= ? "
                    + "where nerd_id= ?";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //si associano i valori all'operazione di update
            //imposto il nuovo nome
            stmt.setString(1, nome);
            //imposto il nuovo cognome
            stmt.setString(2, cognome);
            //imposto la nuova data di nascita
            stmt.setString(3, dataNascita);
            //imposto la nuova frase di presentazione
            stmt.setString(4, frasePresentazione);
            //imposto il nuovo url della foto del profilo
            stmt.setString(5, urlFotoProfilo);
            //imposto la nuova password
            stmt.setString(6, password);
            //imposto l'id del nerd da modificare
            stmt.setInt(7, nerd.getId());           
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //inseriamo un metodo che ci consenta di validare la data inserita da un utente
    public boolean validazioneData(String data) {
        boolean risultatoVerifica= false; 
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ITALIAN);
            sdf.setLenient(false);
            sdf.parse(data);
            risultatoVerifica=true;
            return risultatoVerifica;
        } catch(Exception e) {
            risultatoVerifica=false;
            return risultatoVerifica;
        }
    }
    //inseriamo un metodo che elimina tutti i post associati ad un utente e poi l'utente stesso
    public boolean deleteUser(Nerd nerd){
        //definiamo due Statement
        PreparedStatement deletePost = null;
        PreparedStatement deleteNerd = null;
        
        //definiamo le due operazioni da eseguire sul DB
        //operazione che cancella tutti i post associati ad un utente, sia come autore che come ricevente
        String cancellaPost = "delete from post "
                            + "where autore = ? or userReciver= ?";
        //operazione che cancella l'utente
        String cancellaNerd = "delete from nerd "
                            + "where nerd_id = ?";
        try{
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            // Attivazione del supporto delle transazioni. 
            conn.setAutoCommit(false); 
            
            //preparazione degli Statement
            deletePost= conn.prepareStatement(cancellaPost);
            deleteNerd= conn.prepareStatement(cancellaNerd);
            
            //si associano i valori all'operazione di cancellazione dei post
            deletePost.setInt(1, nerd.getId());
            deletePost.setInt(2, nerd.getId());
            
            //esecuzione operazione cancella post
            int esitoCancellazionePost = deletePost.executeUpdate();

            //si associa il valore all'operazione di cancellazione dell'utente
            deleteNerd.setInt(1, nerd.getId());
            
            //esecuzione operazione cancella utente
            int esitoCancellazioneNerd = deleteNerd.executeUpdate();
            
            //verifichiamo se le due operazioni sono andate a buon fine e nel caso rendiamo permanenti le modifiche al DB
            if(esitoCancellazionePost != 0 && esitoCancellazioneNerd != 0){
                conn.commit();
                deletePost.close();
                deleteNerd.close();
                conn.close();
                boolean cancellazioneEseguita = true;
                return cancellazioneEseguita;
            }
            else{
                conn.rollback();
                boolean cancellazioneEseguita = false;
                return cancellazioneEseguita;
            }
            
        } 
        catch(SQLException e){
           e.printStackTrace();
           boolean cancellazioneEseguita = false;
           return cancellazioneEseguita;
        }
    }    
}    