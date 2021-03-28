package rest.todo.resources;



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

import rest.todo.DAO.CategorieDAO;
import rest.todo.DAO.ArticleDAO;

import rest.todo.model.Article;
import rest.todo.model.Categorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/categories")
public class CategoriesResource {
	   // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategoriesJson() {
        List<Categorie> categories = new ArrayList<Categorie>();
        categories.addAll(CategorieDAO.instance.getModel().values());
        return categories;
    }
    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newCategorie(
            @FormParam("libelle") String libelle,
            @Context HttpServletResponse servletResponse) throws IOException {
    	Integer idmax = CategorieDAO.instance.getModel().keySet().stream().max(Integer::compare).get(); 

        Categorie categorie = new Categorie(idmax+1, libelle);

        CategorieDAO.instance.getModel().put(idmax+1, categorie);
        servletResponse.sendRedirect("../create_article.html");
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCategorieJson(
            Categorie c,
            @Context HttpServletResponse servletResponse) throws IOException {
    	Integer idmax = CategorieDAO.instance.getModel().keySet().stream().max(Integer::compare).get(); 

        c.setId(idmax+1);

        CategorieDAO.instance.getModel().put(idmax+1, c);
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie getCategorie(@PathParam("id") String id) {
        Categorie categorie = CategorieDAO.instance.getModel().get(Integer.parseInt(id));
        if(categorie==null)
            throw new RuntimeException("Get: article with " + id +  " not found");
        return categorie;
    }
    
    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.MULTIPART_FORM_DATA})
    public void UpdateCategorie(@PathParam("id") String id,
    						  @FormParam("libelle") String libelle,                          
                              @Context HttpServletResponse servletResponse) {
        Categorie categorie = CategorieDAO.instance.getModel().get(Integer.parseInt(id));
        CategorieDAO.instance.getModel().put(Integer.parseInt(id), categorie);
    }
    
    @Path("/{id}")
    @DELETE
    public void UpdateCategorie(@PathParam("id") String id) {

    	CategorieDAO.instance.getModel().remove(Integer.parseInt(id));
    }
    
    @Path("/{id}/articles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getCategorieArticles(@PathParam("id") String id) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	return categorie.getArticles();
    }
    @Path("/{id}/sous-categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getSousCategories(@PathParam("id") String id) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	return categorie.getSousCategories();
    }
    
    @Path("/{id}/categories-parent")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategoriesParent(@PathParam("id") String id) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	return categorie.getCategoriesParent();
    }
    
    @Path("/{id}/articles/{id_article}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addArticle(@PathParam("id") String id,@PathParam("id_article") String id_article) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Article article = ArticleDAO.instance.getModel().get(Integer.parseInt(id_article));
    	article.addCategorie(categorie);
    }
    @Path("/{id}/sous-categories/{id_sousCategorie}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addSousCategories(@PathParam("id") String id,@PathParam("id_sousCategorie") String id_sousCategorie) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Categorie sousCategorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id_sousCategorie));
    	categorie.addSousCategorie(sousCategorie);
    	sousCategorie.addCategorieParent(categorie);
    }
    
    @Path("/{id}/categories-parent/{id_categorieParent}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addCategoriesParent(@PathParam("id") String id,@PathParam("id_categorieParent") String id_categorieParent) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Categorie categorieParent =CategorieDAO.instance.getModel().get(Integer.parseInt(id_categorieParent));
    	categorie.addCategorieParent(categorieParent);
    	categorieParent.addSousCategorie(categorie);

    }
    
    
    @Path("/{id}/articles/{id_article}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteArticle(@PathParam("id") String id,@PathParam("id_article") String id_article) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Article article = ArticleDAO.instance.getModel().get(Integer.parseInt(id_article));
    	categorie.removeArticle(article);
    }
    @Path("/{id}/sous-categories/{id_sousCategorie}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteSousCategories(@PathParam("id") String id,@PathParam("id_sousCategorie") String id_sousCategorie) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Categorie sousCategorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id_sousCategorie));
    	categorie.removeSousCategorie(sousCategorie);
    	sousCategorie.removeCategorieParent(categorie);

    }
    
    @Path("/{id}/categories-parent/{id_categorieParent}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCategoriesParent(@PathParam("id") String id,@PathParam("id_categorieParent") String id_categorieParent) {

    	Categorie categorie =CategorieDAO.instance.getModel().get(Integer.parseInt(id));
    	Categorie categorieParent =CategorieDAO.instance.getModel().get(Integer.parseInt(id_categorieParent));
    	categorie.removeCategorieParent(categorieParent);
    	categorieParent.removeSousCategorie(categorie);

    }


}
