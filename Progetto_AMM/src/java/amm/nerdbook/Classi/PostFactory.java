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
        
        //Creazione Post
        
        //Post 1 con immagine da Luke a Yoda 
        Post post1 = new Post();
        post1.setId(0);
        post1.setAutore(nerdFactory.getNerdById(1));
        post1.setUser(nerdFactory.getNerdById(0));
        post1.setTesto("Ti mando l'immagine promessa di Star Wars");
        post1.setContenuto("../Asset/StarWarsImg.jpg");
        post1.setPostType(Post.Type.IMAGE);
        
        //Post 2 testo da Yoda al gruppo Star Wars
        Post post2 = new Post();
        post2.setId(1);
        post2.setAutore(nerdFactory.getNerdById(0));
        post2.setGruppo(gruppoFactory.getGruppoById(1));
        post2.setTesto("Che la forza sia con voi");
        post2.setPostSend(Post.Send.GROUP);
        
        //Post 3 con immagine da Spock a Kirk 
        Post post3 = new Post();
        post3.setId(2);
        post3.setAutore(nerdFactory.getNerdById(3));
        post3.setUser(nerdFactory.getNerdById(2));
        post3.setTesto("Ti mando l'immagine promessa di Star Trek");
        post3.setContenuto("../Asset/StarTrekImg.jpg");
        post3.setPostType(Post.Type.IMAGE);
        
        //Post 4 con URL da Kirk al gruppo Star Trek
        Post post4 = new Post();
        post4.setId(3);
        post4.setAutore(nerdFactory.getNerdById(2));
        post4.setGruppo(gruppoFactory.getGruppoById(0));
        post4.setTesto("Mantenete sempre la barra di curvatura");
        post4.setContenuto("https://gaetaniumberto.files.wordpress.com/2014/05/star-trek-warp_h_partb.jpg");
        post4.setPostSend(Post.Send.GROUP);
        post4.setPostType(Post.Type.URL);
        
        //Post 5 testuale da Leila a gruppo D&G 
        Post post5 = new Post();
        post5.setId(4);
        post5.setAutore(nerdFactory.getNerdById(4));
        post5.setGruppo(gruppoFactory.getGruppoById(2));
        post5.setTesto("Sapete solo giocare");
        post5.setPostSend(Post.Send.GROUP);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
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
    public List getPostList(Nerd nrd) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(nrd)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite l'id ddi un determinato gruppo
    public List getPostList(Gruppo grp) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getGruppo().equals(grp)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
