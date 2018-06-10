package web.GrapeVine.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import web.GrapeVine.modules.Profile;
import web.GrapeVine.service.ProfileService;

@Path("profile")
@XmlRootElement
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResoure {

	public ProfileService service = new ProfileService();

	@GET
	public Response getFilterRequestProfile(@QueryParam("username") String username, @QueryParam("password") String password) {

		Profile getprofile = service.getProfile(username,password);
		return Response.ok().entity(getprofile).build();

	}
	
	@GET
	@Path("/{id}")
	public Response getRequestProfile(@PathParam("id") Long id) {

		Profile getprofile = service.getProfile(id);
		return Response.ok().entity(getprofile).build();

	}

	@POST
	public Response createRequestProfile(Profile profile) {
		
		Profile createdProfile = service.createProfile(profile);
		return Response.ok().entity(createdProfile).build();

	}

	@PUT
	public Response updateRequestProfile(Profile profile) {

		Profile updatedProfile = service.updateProfile(profile);
		return Response.ok().entity(updatedProfile).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteRequestProfile(Profile profile) {

		service.deleteProfile(profile);
		return Response.ok().entity(null).build();

	}

}
