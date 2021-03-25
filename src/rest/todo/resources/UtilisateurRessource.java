package rest.todo.resources;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.DAO.ArticleDAO;
import rest.todo.DAO.UtilisateurDAO;
import rest.todo.model.Article;
import rest.todo.model.Utilisateur;



@Path("/utilisateurs")
public class UtilisateurRessource {
    

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    // add an sign in to the DAO from an html form
    @Path("/sign_in")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Utilisateur Connexion(
        @FormParam("username") String username,
        @FormParam("password") String password,
        @Context HttpServletResponse servletResponse) throws RuntimeException {
    		
       Optional<Utilisateur> utilisateur = UtilisateurDAO.instance.getModel().values().stream().filter(u -> (u.getUsername() == username) && (u.getPassword() == password)).findFirst(); 
    								
    			  if(!utilisateur.isPresent())
    		            throw new RuntimeException("Wrong username or password");
    			 /* {
    				  System.out.println("non trouvé Username : "+username+" password : "+password);
    			        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    			        utilisateurs.addAll(UtilisateurDAO.instance.getModel().values());
    			        return utilisateurs.get(0);
    			  }*/
    		        return utilisateur.get();
           
    		
        }




}
