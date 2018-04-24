package web.GrapeVine.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import web.GrapeVine.modules.Profile;
import web.GrapeVine.service.MemberService;

@Path("member")
@XmlRootElement
public class MemberResoure {

	public MemberService service = new MemberService();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getRequestMember(@PathParam("id") Long id){
		
		System.out.println("int getRequestMember");
		Profile member = service.getMember(id);
		System.out.println("got Member: " + member.toString());
		return Response.ok().entity("Get Request for Member: \n\r "+member).build();
		
	}
}
