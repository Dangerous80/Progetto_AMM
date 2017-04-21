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
public class Nerd {
    
    /*definiamo Type per definire se l'utente è l'amministratore o un utente standard*/
    public enum Type {
        STANDARD, ADMIN
    };
    
    /*definiamo gli attributi di Nerd*/
    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String frasePresentazione;
    private String urlFotoProfilo;
    private String password;
    private Type tipoUtente;
    
    /*definiamo ora il costruttore di Nerd*/
     public Nerd() {
        id = 0;
        nome = "";
        cognome = "";
        dataNascita = "";
        frasePresentazione= "";
        urlFotoProfilo= "";
        password = "";
        tipoUtente = Type.STANDARD;
    }

    /*verifichiamo tramite l'id che non ci siano due Nerd uguali*/
    @Override
    public boolean equals(Object altroNerd) {
        if (altroNerd instanceof Nerd)
            if (this.getId() == ((Nerd)altroNerd).getId()) return true;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipoUtente
     */
    public Type getTipoUtente() {
        return tipoUtente;
    }

    /**
     * @param tipoUtente the tipoUtente to set
     */
    public void setTipoUtente(Type tipoUtente) {
        this.tipoUtente = tipoUtente;
    }   
}
