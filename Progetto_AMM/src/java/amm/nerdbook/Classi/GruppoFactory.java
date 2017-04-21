/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.List;
import java.util.ArrayList;
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
        gruppo1.setNomeGruppo("Star Trek");
        gruppo1.setUrlImmagineGruppo("../Asset/StarTrek.png");
        gruppo1.setCreatoreGruppo(nerdFactory.getNerdById(3));
        
        //Star Wars
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNomeGruppo("Star Wars");
        gruppo2.setUrlImmagineGruppo("../Asset/StarWars.png");
        gruppo2.setCreatoreGruppo(nerdFactory.getNerdById(0));
        
        //dungeons & dragons
        Gruppo gruppo3 = new Gruppo();
        gruppo3.setId(2);
        gruppo3.setNomeGruppo("Dungeons & Dragons");
        gruppo3.setUrlImmagineGruppo("../Asset/dungeons&dragons.jpg");
        gruppo3.setCreatoreGruppo(nerdFactory.getNerdById(5));
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
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
}
