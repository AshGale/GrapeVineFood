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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import web.GrapeVine.modules.Ingredient;
import web.GrapeVine.service.IngredientService;

@Path("ingredient")
@XmlRootElement
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IngredientResourse {

	public IngredientService service = new IngredientService();

	@GET
	@Path("/init")
	public boolean initServer() {//TODO put in server Resourse
		http://localhost:8080/GrapeVine/api/ingredient/init
		return service.init();
	}
	
	@GET
	public Response getFilterRequestIngredient(@QueryParam("name") String name) {

		List<Ingredient> getIngredient = service.getIngredient(name);
		return Response.ok().entity(getIngredient).build();
	}

	@GET
	@Path("/{id}")
	public Response getRequestIngredient(@PathParam("id") Long id) {

		Ingredient getIngredient = service.getIngredient(id);
		return Response.ok().entity(getIngredient).build();
	}
	
	@GET
	@Path("/exists")
	public Response checkIfExistIngredient(@QueryParam("name") String name) {

		Ingredient namedIngredient = service.getNamedIngredient(name);
		return Response.ok().entity(namedIngredient).build();
	}

	@POST
	public Response createRequestIngredient(Ingredient ingredient) {

		Ingredient createdIngredient = service.createIngredient(ingredient);
		return Response.ok().entity(createdIngredient).build();
	}

	@PUT
	public Response updateRequestIngredient(Ingredient ingredient) {

		Ingredient updatedIngredient = service.updateIngredient(ingredient);
		return Response.ok().entity(updatedIngredient).build();
	}
	
	@DELETE
	public Response deleteRequestIngredient(Ingredient ingredient) {

		service.deleteIngredient(ingredient);
		return Response.ok().entity(null).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteselectedIngredient(Ingredient ingredient) {
		//TODO add new method with no paramiters and gets instance to remove
		System.out.println("revise logic at this point");
		service.deleteIngredient(ingredient);
		return Response.ok().entity(null).build();
	}

}
