package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;

import model.Account;

@Path("/check")
public class CheckAccountService {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkAccount(@PathParam("id") Long id) {
		Account result = ObjectifyService.ofy().load().type(Account.class).id(id).now();
		String risk = result.getRisk();
		
		Gson gson = new Gson();
		String json = gson.toJson(risk);
		return json;
	}
	
}
