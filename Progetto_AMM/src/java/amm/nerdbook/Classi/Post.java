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
public class Post {

    public enum Type {
        TEXT, IMAGE, URL
    };
    
        
    private int id;
    private Nerd user;
    private Nerd autore;
    private Gruppo gruppo;
    private String testo;
    private String contenuto;
    private Type postType;
        
    public Post() {
        id = 0;
        autore = null;
        user = null;
        gruppo = null;
        testo = "";
        contenuto = "";
        postType = Type.TEXT;
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
     * @return the user
     */
    public Nerd getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Nerd user) {
        this.user = user;
    }
    
    /**
     * @return the autore
     */
    public Nerd getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(Nerd autore) {
        this.autore = autore;
    }

    /**
     * @return the gruppo
     */
    public Gruppo getGruppo() {
        return gruppo;
    }

    /**
     * @param gruppo the gruppo to set
     */
    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the contenuto to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
}
