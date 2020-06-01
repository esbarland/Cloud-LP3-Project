package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;

import model.Account;

@Path("/check")
public class CheckAccountService {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkAccount(@PathParam("id") Long id) {
		Account result = ObjectifyService.ofy().load().type(Account.class).id(id).now();
		if(result == null)
			return Response.status(400).build();
		String risk = result.getRisk();
		
		Gson gson = new Gson();
		String json = gson.toJson(risk);
		return Response.status(200).entity(json).build();
	}
	
}
