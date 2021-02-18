package rest.todo.resources;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import rest.todo.dao.ArticleDao;
import rest.todo.dao.CategorieDao;
import rest.todo.model.Article;
import rest.todo.model.Categorie;



/// Will map the resource to the URL articles
public class ArticlesResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of all articles to the user in the browser
    @Path("/articles/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getArticlesJson() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(ArticleDao.instance.getModel().values());
        return articles;
    }
    // add an article to the DAO from an html form
    @Path("/articles/")
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newArticle(
    		@FormParam("id")  String id,
            @FormParam("libelle") String libelle,
            @FormParam("marque") String marque,
            @FormParam("prix") String prix,
            @FormParam("Categorie") String categorie,
            @FormParam("photo") String photo,
            @Context HttpServletResponse servletResponse) throws IOException {

                Article article = new Article(Integer.parseInt(id), libelle, marque, Double.valueOf(prix));

                if (photo != null) {
                    article.setPhoto(photo);
                }
                if (categorie != null) {
                    article.addCategorie(CategorieDao.instance.getModel().get(Integer.parseInt(categorie)));
                }
                ArticleDao.instance.getModel().put(Integer.parseInt(id), article);
                servletResponse.sendRedirect("../create_article.html");
            }
    
    @Path("/articles/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") String id) {
    	System.out.println("entree");
        Article article = ArticleDao.instance.getModel().get(Integer.parseInt(id));
        if(article==null)
            throw new RuntimeException("Get: article with " + id +  " not found");
        return article;
    }
    
    @Path("/articles/{id}")
    @PUT
    public void UpdateArticle(@PathParam("id") String id,
            @FormParam("libelle") String libelle,
            @FormParam("marque") String marque,
            @FormParam("prix") String prix,
            @FormParam("Categorie") String categorie,
            @FormParam("photo") String photo,
            @Context HttpServletResponse servletResponse) {
    	  Article article = new Article(Integer.parseInt(id), libelle, marque, Double.valueOf(prix));

          if (photo != null) {
              article.setPhoto(photo);
          }
          if (categorie != null) {
              article.addCategorie(CategorieDao.instance.getModel().get(Integer.parseInt(categorie)));
          }
          ArticleDao.instance.getModel().put(Integer.parseInt(id), article);
    }
    
    @Path("/articles/{id}")
    @DELETE
    public void UpdateArticle(@PathParam("id") String id) {
    	 
          ArticleDao.instance.getModel().remove(Integer.parseInt(id));
    }
    @Path("/articles/{id}/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getArticleCategories(@PathParam("id") String id) {
    	Article article = ArticleDao.instance.getModel().get(Integer.parseInt(id));    	  
		return article.getCategories();   	
	}
    
    
 
    
  /*  public ArticleResource getTodo(@PathParam("article") String id) {
        return new ArticleResource(uriInfo, request, id);
    }*/
}
