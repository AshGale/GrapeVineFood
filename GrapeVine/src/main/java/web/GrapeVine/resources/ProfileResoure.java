package web.GrapeVine.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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
	public Response getFilterRequestProfile(@PathParam("username") String username, @PathParam("password") String password) {

		System.out.println("in getRequestProfileLogin");
		Profile getprofile = service.getProfile(username,password);
		// System.out.println("got Member: " + getprofile.toString());
		return Response.ok().entity(getprofile).build();

	}
	
	@GET
	@Path("/{id}")
	public Response getRequestProfile(@PathParam("id") Long id) {

		System.out.println("in getRequestProfile");
		Profile getprofile = service.getProfile(id);
		// System.out.println("got Member: " + getprofile.toString());
		return Response.ok().entity(getprofile).build();

	}

	@POST
	// @Path("/{id}")//not needed
	public Response createRequestProfile(Profile profile) {

		System.out.println("in crateRequestProfile");
		System.out.println("got Member: " + profile.toString());
		//Profile createdProfile = null;
		//if (profile.get(0) != null) {
			//createdProfile = service.createProfile(profile.get(0));
		//}
		Profile createdProfile = service.createProfile(profile);
		System.out.println("created Member: " + createdProfile.toString());
		return Response.ok().entity(createdProfile).build();

	}

	@PUT
	@Path("/{id}")
	public Response updateRequestProfile(Profile profile) {

		System.out.println("in updateRequestProfile");
		Profile updatedProfile = service.updateProfile(profile);
		System.out.println("got Member: " + updatedProfile.toString());
		return Response.ok().entity(updatedProfile).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteRequestProfile(Profile profile) {

		System.out.println("in deleteRequestProfile");
		service.deleteProfile(profile);
		return Response.ok().entity(null).build();

	}

}
