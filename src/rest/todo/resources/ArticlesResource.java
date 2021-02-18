package rest.todo.resources;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.ArticleDao;
import rest.todo.model.Article;
import rest.todo.model.Categorie;



/// Will map the resource to the URL articles
@Path("/articles")
public class ArticlesResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of all articles to the user in the browser
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getArticlesJson() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(ArticleDao.instance.getModel().values());
        return articles;
    }
    // add an article to the DAO from an html form
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
                Article article = new Article(Integer.parseInt(id),libelle,marque,Double.valueOf(prix),Categorie.valueOf(categorie));
                if (photo != null) {
                    article.setPhoto(photo);
                }
                ArticleDao.instance.getModel().put(id, article);
                servletResponse.sendRedirect("../create_article.html");
            }
  
     
    

}
