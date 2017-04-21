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
    private String nomeGruppo;
    private String urlImmagineGruppo;
    private Nerd creatoreGruppo;
    
    /*definiamo ora il costruttore di Nerd*/
     public Gruppo() {
        id = 0;
        nomeGruppo = "";
        urlImmagineGruppo= "";
        creatoreGruppo = null;
    }
    
    /*verifichiamo tramite l'id che non ci siano due Nerd uguali*/
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

    /**
     * @return the creatoreGruppo
     */
    public Nerd getCreatoreGruppo() {
        return creatoreGruppo;
    }

    /**
     * @param creatoreGruppo the creatoreGruppo to set
     */
    public void setCreatoreGruppo(Nerd creatoreGruppo) {
        this.creatoreGruppo = creatoreGruppo;
    }
}
