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
public class PostFactory {
    
//Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
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
       
    private PostFactory() {
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite il loro id
    public Post getPostById(int id) {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select * from post "
                    + "join posttype on post.tipopost = posttype.posttype_id "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            //ciclo sulle righe e creazione di un post
            if (res.next()) {
                Post currentPost = new Post();
                
                //imposto id del post
                currentPost.setId(res.getInt("post_id"));
                
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                currentPost.setAutore(autore);
                
                //imposto lo userReciver del post
                Nerd userReciver = nerdFactory.getNerdById(res.getInt("userReciver"));
                currentPost.setUser(userReciver);
                
                //imposto il groupReciver del post
                Gruppo groupReciver = gruppoFactory.getGruppoById(res.getInt("groupReciver"));
                currentPost.setGruppo(groupReciver);
                
                //imposto il testo del post
                currentPost.setTesto(res.getString("testo"));
                
                //impost il contenuto del post
                currentPost.setContenuto(res.getString("contenuto"));
                
                //imposto il tipo del post
                currentPost.setPostType(this.postTypeFromString(res.getString("posttype_tipo")));
                
                
                stmt.close();
                conn.close();
                return currentPost;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite l'id di un determinato utente
    public List getUserPostList(Nerd nrd) {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select * from post "
                    + "join posttype on post.tipopost = posttype.posttype_id "
                    + "where autore = ? or userreciver = ? or groupreciver = (select idgruppo from iscrizionegruppo where idiscritto = ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, nrd.getId());
            stmt.setInt(2, nrd.getId());
            stmt.setInt(3, nrd.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post currentPost = new Post();
                
                //imposto id del post
                currentPost.setId(res.getInt("post_id"));
                
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                currentPost.setAutore(autore);
                
                //imposto lo userReciver del post
                Nerd userReciver = nerdFactory.getNerdById(res.getInt("userReciver"));
                currentPost.setUser(userReciver);
                
                //imposto il groupReciver del post
                Gruppo groupReciver = gruppoFactory.getGruppoById(res.getInt("groupReciver"));
                currentPost.setGruppo(groupReciver);
                
                //imposto il testo del post
                currentPost.setTesto(res.getString("testo"));
                
                //impost il contenuto del post
                currentPost.setContenuto(res.getString("contenuto"));
                
                //imposto il tipo del post
                currentPost.setPostType(this.postTypeFromString(res.getString("posttype_tipo")));
                
                listaPost.add(currentPost);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    //definiamo un metodo che ci consenta di accedere ai vari post tramite l'id di un determinato gruppo
    public List getGroupPostList(Gruppo grp) {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "select * from post "
                    + "join posttype on post.tipopost = posttype.posttype_id "
                    + "where groupreciver = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, grp.getId());
                        
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post currentPost = new Post();
                
                //imposto id del post
                currentPost.setId(res.getInt("post_id"));
                
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                currentPost.setAutore(autore);
                
                //imposto lo userReciver del post
                Nerd userReciver = nerdFactory.getNerdById(res.getInt("userReciver"));
                currentPost.setUser(userReciver);
                
                //imposto il groupReciver del post
                Gruppo groupReciver = gruppoFactory.getGruppoById(res.getInt("groupReciver"));
                currentPost.setGruppo(groupReciver);
                
                //imposto il testo del post
                currentPost.setTesto(res.getString("testo"));
                
                //impost il contenuto del post
                currentPost.setContenuto(res.getString("contenuto"));
                
                //imposto il tipo del post
                currentPost.setPostType(this.postTypeFromString(res.getString("posttype_tipo")));
                
                listaPost.add(currentPost);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
        
    //inseriamo un metodo che ci consenta di recuperare il tipo di post
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE")){
            return Post.Type.IMAGE;
        }
        else{
            if(type.equals("URL")){
               return Post.Type.URL;
            }
            else{
                 return Post.Type.TEXT;
            }
        }
    } 
    //inseriamo un metodo che ci consenta di inserire un post verso uno user 
    public void addNewPostUser(Post post){
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "insert into post (post_id, autore, userreciver, testo, contenuto, tipopost) "
                    + "values (default, ? , ? , ? , ? , ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            //imposto l'autore
            stmt.setInt(1, post.getAutore().getId());
            //imposto lo userReciver
            stmt.setInt(2, post.getUser().getId());
            //imposto il testo
            stmt.setString(3, post.getTesto());
            //imposto il contenuto
            stmt.setString(4, post.getContenuto());
            //imposto il tipo post
            stmt.setInt(5, this.postTypeFromEnum(post.getPostType()));
                        
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //inseriamo un metodo che ci consenta di inserire un post verso un gruppo
    public void addNewPostGroup(Post post){
        try {
            //accesso al DB indicando Username e Password
            Connection conn = DriverManager.getConnection(connectionString, "Dangerous80", "DarkSchneider");
            
            //prepariamo il testo della query
            String query = 
                      "insert into post (post_id, autore, groupreciver, testo, contenuto, tipopost) "
                    + "values (default, ? , ? , ? , ? , ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            //imposto l'autore
            stmt.setInt(1, post.getAutore().getId());
            //imposto lo userReciver
            stmt.setInt(2, post.getGruppo().getId());
            //imposto il testo
            stmt.setString(3, post.getTesto());
            //imposto il contenuto
            stmt.setString(4, post.getContenuto());
            //imposto il tipo post
            stmt.setInt(5, this.postTypeFromEnum(post.getPostType()));
                        
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //inseriamo un metodo che ci consenta di impostare il tipo di post
    private int postTypeFromEnum(Post.Type type){
        if(type == Post.Type.IMAGE){
            return 2;
        }
        else {
            if(type == Post.Type.URL){
                return 3; 
            } 
            else {
                return 1; 
            }
        }    
    }
}
