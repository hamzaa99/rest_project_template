package rest.todo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.ArticleDao;
import rest.todo.model.Article;

public class ArticleResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    
    public ArticleResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;

}
    //Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle() {
        Article article = ArticleDao.instance.getModel().get(Integer.parseInt(id));
        if(article==null)
            throw new RuntimeException("Get: article with " + id +  " not found");
        return article;
    }
    
    
    
    
}