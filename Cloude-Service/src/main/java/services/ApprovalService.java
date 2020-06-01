package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;

import model.Account;
import model.Approval;

@Path("/approval")
public class ApprovalService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getApprovals() {		
		List<Approval> approvals = ObjectifyService.ofy().load().type(Approval.class).list();
		
		Gson gson = new Gson();
		String json = gson.toJson(approvals);
		
		return Response.status(200).entity(json).build();
	}
	
	
	@POST
	@Path("{idAccount}/{reponse}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addApproval(@PathParam("idAccount") Long idAccount, @PathParam("reponse") String reponse) {
		Approval approval = new Approval(idAccount, reponse);
		ObjectifyService.ofy().save().entity(approval).now();
		
		Gson gson = new Gson();
		String json = gson.toJson(approval);
		return Response.status(200).entity(json).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAccount(@PathParam("id") Long id) {
		Approval a =  ObjectifyService.ofy().load().type(Approval.class).id(id).now();
		if(a == null)
			return Response.status(400).build();
		ObjectifyService.ofy().delete().type(Approval.class).id(id).now();
		
		Gson gson = new Gson();
		String json = gson.toJson("deleted");
		
		return Response.status(200).entity(json).build();
	}
}
