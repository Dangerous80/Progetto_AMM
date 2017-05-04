/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author Pisano Daniele
 */
public class Gruppo {

    
    /*definiamo gli attributi di Gruppo*/
    private int id;
    private Nerd creatore;
    private String nomeGruppo;
    private String urlImmagineGruppo;
        
    /*definiamo ora il costruttore di Nerd*/
     public Gruppo() {
        id = 0;
        creatore = null;
        nomeGruppo = "";
        urlImmagineGruppo= "";
        
    }
    
    /*verifichiamo tramite l'id che non ci siano due Gruppi uguali*/
    @Override
    public boolean equals(Object altroGruppo) {
        if (altroGruppo instanceof Gruppo)
            if (this.getId() == ((Gruppo)altroGruppo).getId()) return true;
        return false;
    }
        
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the creatore
     */
    public Nerd getCreatore() {
        return creatore;
    }

    /**
     * @param creatore the creatore to set
     */
    public void setCreatore(Nerd creatore) {
        this.creatore = creatore;
    }

    /**
     * @return the nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo the nomeGruppo to set
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    /**
     * @return the urlImmagineGruppo
     */
    public String getUrlImmagineGruppo() {
        return urlImmagineGruppo;
    }

    /**
     * @param urlImmagineGruppo the urlImmagineGruppo to set
     */
    public void setUrlImmagineGruppo(String urlImmagineGruppo) {
        this.urlImmagineGruppo = urlImmagineGruppo;
    }

}
