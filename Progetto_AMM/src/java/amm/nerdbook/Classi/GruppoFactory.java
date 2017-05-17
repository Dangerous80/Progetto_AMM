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
public class GruppoFactory {
    
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
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
        
    
    private GruppoFactory() {
    }
    
    //inseriamo un metodo che ci consenta di reperire le info su di un gruppo mediante il suo id
    public Gruppo getGruppoById(int id) {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select * from gruppo "
                    + "join nerd on gruppo.creatoregruppo = nerd.nerd_id "
                    + "where gruppo_id = ?";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //associamo i valori alla query
            stmt.setInt(1, id);
            
            //eseguiamo la query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe e creazione di un gruppo
            if (res.next()) {
                Gruppo currentGroup = new Gruppo();
                //imposto id del gruppo
                currentGroup.setId(res.getInt("gruppo_id"));
                
                //imposto il creatore del gruppo
                Nerd creatore = nerdFactory.getNerdById(res.getInt("creatoregruppo"));
                currentGroup.setCreatore(creatore);
                
                //imposto il nome del gruppo                
                currentGroup.setNomeGruppo(res.getString("nomegruppo"));
                
                //imposto l'immagine del gruppo
                currentGroup.setUrlImmagineGruppo(res.getString("urlImmagineGruppo"));
                                
                //quido lo statment, chiudo la connessione e restituisco un nerd
                stmt.close();
                conn.close();
                return currentGroup;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }  
    //inseriamo un metodo che ci consenta di recuperare la lista dei gruppi
    public List getGroupList() {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        List<Gruppo> listaGruppi = new ArrayList<Gruppo>();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = "select * from gruppo "
                         + "join nerd on gruppo.creatoregruppo = nerd.nerd_id ";
            
            //preparazione Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //eseguo la  query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe, creo un gruppo e lo inserisco nella lista gruppi
            while (res.next()) {
                Gruppo currentGroup = new Gruppo();
                
                //imposto id del gruppo
                currentGroup.setId(res.getInt("gruppo_id"));
                
                //imposto il creatore del gruppo
                Nerd creatore = nerdFactory.getNerdById(res.getInt("creatoregruppo"));
                currentGroup.setCreatore(creatore);
                
                //imposto il nome del gruppo                
                currentGroup.setNomeGruppo(res.getString("nomegruppo"));
                
                //imposto l'immagine del gruppo
                currentGroup.setUrlImmagineGruppo(res.getString("urlImmagineGruppo"));
                
                listaGruppi.add(currentGroup);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaGruppi;
    }
}
