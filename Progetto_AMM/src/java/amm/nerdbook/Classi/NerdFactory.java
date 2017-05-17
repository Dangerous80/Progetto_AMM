/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}    