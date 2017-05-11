/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

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
    
    //Definiamo un array che conterrà la lista dei nostri Gruppi 
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    //Ora creiamo i gruppi
    private GruppoFactory() {
        
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
        //Star Trek
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.setCreatore(nerdFactory.getNerdById(0));
        gruppo1.setNomeGruppo("Star Wars");
        gruppo1.setUrlImmagineGruppo("http://localhost:8080/Progetto_AMM/Asset/StarWars.jpg");
        
        
        //Star Wars
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setCreatore(nerdFactory.getNerdById(2));
        gruppo2.setNomeGruppo("Star Trek");
        gruppo2.setUrlImmagineGruppo("http://localhost:8080/Progetto_AMM/Asset/StarTrek.png");
        
        
        //dungeons & dragons
        Gruppo gruppo3 = new Gruppo();
        gruppo3.setId(2);
        gruppo3.setCreatore(nerdFactory.getNerdById(5));
        gruppo3.setNomeGruppo("D&D");
        gruppo3.setUrlImmagineGruppo("http://localhost:8080/Progetto_AMM/Asset/dungeons&dragons.jpg");
        
        
        //gruppo default da inserire nel caso il post sia scritto sulla bacheca di un utente o di se stessi
        Gruppo gruppo4 = new Gruppo();
        gruppo4.setId(999);
        gruppo4.setCreatore(nerdFactory.getNerdById(5));
        gruppo4.setNomeGruppo("Default");
        gruppo4.setUrlImmagineGruppo("http://localhost:8080/Progetto_AMM/Asset/nerdLogo.jpg");
                
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
        listaGruppi.add(gruppo4);
        
    }
    //inseriamo un metodo che ci consenta di reperire le info su di un gruppo mediante il suo id
    public Gruppo getGruppoById(int id) {
        for (Gruppo gruppo : this.listaGruppi) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }  
    //inseriamo un metodo che ci consenta di recuperare la lista dei gruppi
    public List getGroupList() 
    {
            return listaGruppi;
    }
    //inseriamo una variabile di istanza connectionString di tipo stringa
    String connectionString;
    //inseriamo ora due metodi pubblici
    public void setConnectionString(String s){
        this.connectionString = s;
    }
    public String getConnectionString(){
        return this.connectionString;
    }
}
