package rest.todo.resources;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ApplicationPath;

import rest.todo.dao.ArticleDao;
import rest.todo.dao.CategorieDao;
import rest.todo.model.Article;
import rest.todo.model.Categorie;



/// Will map the resource to the URL articles
@Path("/categories")
public class CategoriesResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of all categories to the user in the browser
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategoriesJson() {
    	System.out.println("entree");
        List<Categorie> categories = new ArrayList<Categorie>();
        categories.addAll(CategorieDao.instance.getModel().values());
        return categories;
    }
    // add a categorie to the DAO from an html form
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newCategorie(
    		@FormParam("id")  Integer id,
            @FormParam("libelle") String libelle,
            @Context HttpServletResponse servletResponse) throws IOException {
                CategorieDao.instance.getModel().put(id, new Categorie(id, libelle));
                servletResponse.sendRedirect("../create_article.html");
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie getCategorie(@PathParam("id") String id) {
    	System.out.println("entree");
        Categorie categorie = CategorieDao.instance.getModel().get(id);
        if(categorie==null)
            throw new RuntimeException("Get: categorie with " + id +  " not found");
        return categorie;
    }
    
    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA})
    public void UpdateCategorie(@PathParam("id") Integer id,
            @FormParam("libelle") String libelle,
            @Context HttpServletResponse servletResponse) {
          	if(CategorieDao.instance.getModel().get(id) != null) {
          			CategorieDao.instance.getModel().get(id).setLibelle(libelle);
          	}
    }
    
    @Path("/{id}")
    @DELETE
    public void deleteCategorie(@PathParam("id") String id) {
    	CategorieDao.instance.getModel().remove(id);
    }
    
    @Path("/{id}/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, Categorie> getArticleByCategories(@PathParam("id") Integer id) {
    	return ArticleDao.instance.getModel().entrySet().stream().filter(x -> x.getValue().getCategories().contains(id)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
	}

}