package enrian.otis;

import enrian.otis.entity.Users;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("user")
@RequestScoped
public class UserResource {

    @Context
    private UriInfo context;
    
    @PersistenceUnit(unitName = "otis_pu")
    private EntityManagerFactory emf;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(@QueryParam("password") String password) {
        try {
            return emf.createEntityManager().createNamedQuery(Users.FIND_BY_PASSWORD, Users.class).setParameter("password", password).getSingleResult();
        } catch (Exception e) {
            throw new BadRequestException("User with password " + password + " not found!");
        }
    }

}
