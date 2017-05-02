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
public class NerdFactory {
    
    //Pattern Design Singleton
    private static NerdFactory singleton;

    public static NerdFactory getInstance() {
        if (singleton == null) {
            singleton = new NerdFactory();
        }
        return singleton;
    }
    
    //Definiamo un array che conterrà la lista dei nostri Nerd 
    private ArrayList<Nerd> listaNerd = new ArrayList<Nerd>();
    
    //Ora creiamo gli utenti
    private NerdFactory() {
        
        //Mario Rossi Yoda
        Nerd nerd1 = new Nerd();
        nerd1.setId(0);
        nerd1.setNome("Mario");
        nerd1.setCognome("Rossi");
        nerd1.setDataNascita("10/11/1992");
        nerd1.setFrasePresentazione("Che la forza sia con te");
        nerd1.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/Yoda.jpg");
        nerd1.setPassword("12345");
        nerd1.setTipoUtente(Nerd.Type.ADMIN);
        
        //Luca Viale Luke
        Nerd nerd2 = new Nerd();
        nerd2.setId(1);
        nerd2.setNome("Luca");
        nerd2.setCognome("Viale");
        nerd2.setDataNascita("15/12/1996");
        nerd2.setFrasePresentazione("Welcome to my jungle");
        nerd2.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/Luke.jpg");
        nerd2.setPassword("12345");

        //Francesco Marras Kirk
        Nerd nerd3 = new Nerd();
        nerd3.setId(2);
        nerd3.setNome("Francesco");
        nerd3.setCognome("Marras");
        nerd3.setDataNascita("15/08/1991");
        nerd3.setFrasePresentazione("Mantenete la curvatura");
        nerd3.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/kirk.jpg");
        nerd3.setPassword("12345");

        //Gianluca Ghidoli Spoke
        Nerd nerd4 = new Nerd();
        nerd4.setId(3);
        nerd4.setNome("Gianluca");
        nerd4.setCognome("Ghidoli");
        nerd4.setDataNascita("15/12/1989");
        nerd4.setFrasePresentazione("Lunga vita e prosperità");
        nerd4.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/spock.jpg");
        nerd4.setPassword("12345");

        //Elenia Loche Leila utente con mancanza di dato frase presentazione
        Nerd nerd5 = new Nerd();
        nerd5.setId(4);
        nerd5.setNome("Elenia");
        nerd5.setCognome("Loche");
        nerd5.setDataNascita("15/10/1996");
        nerd5.setFrasePresentazione("");
        nerd5.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/Leila.jpg");
        nerd5.setPassword("12345");
        
        //Marco Zuddas Artorias D&G
        Nerd nerd6 = new Nerd();
        nerd6.setId(5);
        nerd6.setNome("Marco");
        nerd6.setCognome("Zuddas");
        nerd6.setDataNascita("11/07/1981");
        nerd6.setFrasePresentazione("Viva i draghi");
        nerd6.setUrlFotoProfilo("http://localhost:8080/Progetto_AMM/Asset/artorias.jpg");
        nerd6.setPassword("12345");
        
        listaNerd.add(nerd1);
        listaNerd.add(nerd2);
        listaNerd.add(nerd3);
        listaNerd.add(nerd4);
        listaNerd.add(nerd5);
        listaNerd.add(nerd6);
    }
    //inseriamo un metodo che ci consenta di reperire le info sull'utente mediante il suo id
    public Nerd getNerdById(int id) {
        for (Nerd nerd : this.listaNerd) {
            if (nerd.getId() == id) {
                return nerd;
            }
        }
        return null;
    }
      
    public int getIdByUserAndPassword(String username, String password){
        for(Nerd nerd : this.listaNerd){
            if(nerd.getNome().equals(username) && nerd.getPassword().equals(password)){
                return nerd.getId();
            }
        }
        return -1;
    }
    //inseriamo un metodo che ci consenta di recuperare la lista degli utenti
    public List getNerdList()
    {
        return listaNerd;
    }
}
