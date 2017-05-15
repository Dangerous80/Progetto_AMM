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
public class PostFactory {
    
//Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        NerdFactory nerdFactory = NerdFactory.getInstance();
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        
        //Creazione dei Post
        
        //Post 1 con immagine da Luke a Yoda , gruppo default 
        Post post1 = new Post();
        post1.setId(0);
        post1.setAutore(nerdFactory.getNerdById(1));
        post1.setUser(nerdFactory.getNerdById(0));
        post1.setGruppo(gruppoFactory.getGruppoById(999));
        post1.setTesto("Ti mando l'immagine promessa di Star Wars");
        post1.setContenuto("http://localhost:8080/Progetto_AMM/Asset/StarWarsImg.jpg");
        post1.setPostType(Post.Type.IMAGE);
        
        //Post 2 testo da Yoda al gruppo Star Wars, user  e autore uguali
        Post post2 = new Post();
        post2.setId(1);
        post2.setAutore(nerdFactory.getNerdById(0));
        post2.setUser(nerdFactory.getNerdById(0));
        post2.setGruppo(gruppoFactory.getGruppoById(1));
        post2.setTesto("Che la forza sia con voi");
        
        
        //Post 3 con immagine da Spock a Kirk, gruppo default
        Post post3 = new Post();
        post3.setId(2);
        post3.setAutore(nerdFactory.getNerdById(3));
        post3.setUser(nerdFactory.getNerdById(2));
        post3.setGruppo(gruppoFactory.getGruppoById(999));
        post3.setTesto("Ti mando l'immagine promessa di Star Trek");
        post3.setContenuto("http://localhost:8080/Progetto_AMM/Asset/StarTrekImg.jpg");
        post3.setPostType(Post.Type.IMAGE);
        
        //Post 4 con URL da Kirk al gruppo Star Trek, autore e user uguali
        Post post4 = new Post();
        post4.setId(3);
        post4.setAutore(nerdFactory.getNerdById(2));
        post4.setUser(nerdFactory.getNerdById(2));
        post4.setGruppo(gruppoFactory.getGruppoById(0));
        post4.setTesto("Mantenete sempre la barra di curvatura");
        post4.setContenuto("https://gaetaniumberto.files.wordpress.com/2014/05/star-trek-warp_h_partb.jpg");
        post4.setPostType(Post.Type.IMAGE);
        
        //Post 5 testuale da Leila a gruppo D&G , autore e user uguali
        Post post5 = new Post();
        post5.setId(4);
        post5.setAutore(nerdFactory.getNerdById(4));
        post5.setUser(nerdFactory.getNerdById(4));
        post5.setGruppo(gruppoFactory.getGruppoById(2));
        post5.setTesto("Uscite un pochino di casa");
        
        
        //Post 6 con Url da Spock a Kirk , gruppo default
        Post post6 = new Post();
        post6.setId(5);
        post6.setAutore(nerdFactory.getNerdById(3));
        post6.setUser(nerdFactory.getNerdById(2));
        post6.setGruppo(gruppoFactory.getGruppoById(999));
        post6.setTesto("Ti mando l'url di cui tiparlavo");
        post6.setContenuto("http://www.stic.it/");
        post6.setPostType(Post.Type.URL);
        
        //Post 7 con immagine da Spock a Kirk , gruppo default
        Post post7 = new Post();
        post7.setId(6);
        post7.setAutore(nerdFactory.getNerdById(3));
        post7.setUser(nerdFactory.getNerdById(2));
        post7.setGruppo(gruppoFactory.getGruppoById(999));
        post7.setTesto("guarda che bella locandina");
        post7.setContenuto("http://localhost:8080/Progetto_AMM/Asset/StarTrekOriginal.jpg");
        post7.setPostType(Post.Type.IMAGE);
        
        //Post 8 con immagine da Yoda a Luke, gruppo default 
        Post post8 = new Post();
        post8.setId(7);
        post8.setAutore(nerdFactory.getNerdById(0));
        post8.setUser(nerdFactory.getNerdById(1));
        post8.setGruppo(gruppoFactory.getGruppoById(999));
        post8.setTesto("Questa immagine l'avevo già");
        post8.setContenuto("http://localhost:8080/Progetto_AMM/Asset/StarWarsImg.jpg");
        post8.setPostType(Post.Type.IMAGE);
        
        //Post 9 testuale da spoke alla sua bacheca, autore e user uguali
        Post post9 = new Post();
        post9.setId(8);
        post9.setAutore(nerdFactory.getNerdById(3));
        post9.setUser(nerdFactory.getNerdById(3));
        post9.setGruppo(gruppoFactory.getGruppoById(999));
        post9.setTesto("Seguo il colinar");
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
        listaPost.add(post6);
        listaPost.add(post7);
        listaPost.add(post8);
        listaPost.add(post9);
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite il loro id
    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite l'id di un determinato utente
    public List getUserPostList(Nerd nrd) {
        List<Post> listaPost = new ArrayList<Post>();
        for (Post post : this.listaPost) {
            if(post.getUser().equals(nrd)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
           
    //definiamo un metodo che ci consenta di accedere ai vari post tramite l'id di un determinato gruppo
    public List getGroupPostList(Gruppo grp) {
        List<Post> listaPost = new ArrayList<Post>();
        for (Post post : this.listaPost) {
            if(post.getGruppo().equals(grp)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB
}
