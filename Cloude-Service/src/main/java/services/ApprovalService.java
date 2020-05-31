package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;

import model.Account;
import model.Approval;

@Path("/approval")
public class ApprovalService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getApprovals() {
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>Liste des approvals</h3>");
		sb.append("<ul>");
		
		
		List<Approval> approvals = ObjectifyService.ofy().load().type(Approval.class).list();
		
		Gson gson = new Gson();
		String json = gson.toJson(approvals);
		return json;
	}
	
	
	@POST
	@Path("{nom}/{reponse}")
	@Produces(MediaType.APPLICATION_JSON)
	public String addApproval(@PathParam("nom") String nom, @PathParam("reponse") String reponse) {
		Approval approval = new Approval(nom, reponse);
		ObjectifyService.ofy().save().entity(approval).now();
		
		Gson gson = new Gson();
		String json = gson.toJson(approval);
		return json;
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeAccount(@PathParam("id") Long id) {
		ObjectifyService.ofy().delete().type(Approval.class).id(id).now();
		
		return "deleted";
	}
}
