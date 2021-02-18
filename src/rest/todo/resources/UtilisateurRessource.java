package rest.todo.resources;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.UtilisateurDao;



@Path("/utilisateurs")
public class UtilisateurRessource {
    

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    String id;




    public UtilisateurRessource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;

}



    // add an utilsateur to the DAO from an html form
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void NewUtilisateur(
        @FormParam("id")  String id,
        @FormParam("username") String username,
        @FormParam("password") String password,
        @Context HttpServletResponse servletResponse) throws IOException {

            Utilisateur utilisateur = new Utilisateur(id, username,password);

            UtilisateurDao.instance.getModel().put(id, utilisateur);
            servletResponse.sendRedirect("../create_utilisateur.html");
        }




}
