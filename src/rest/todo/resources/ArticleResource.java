package rest.todo.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

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
    
}