package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Result;

import model.Account;

@Path("/account")
public class AccountService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccounts() {
		List<Account> listAccounts = ObjectifyService.ofy().load().type(Account.class).list();

		Gson gson = new Gson();
		String json = gson.toJson(listAccounts);
		return Response.status(200).entity(json).build();
	}

	@POST
	@Path("{lastname}/{firstname}/{amount}/{risk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(@PathParam("lastname") String lastname, @PathParam("firstname") String firstname, @PathParam("amount") int amount, @PathParam("risk") String risk) {
		if(!risk.equalsIgnoreCase("low") && !risk.equalsIgnoreCase("high"))
			return Response.status(400).build();
		Account a = new Account(firstname, lastname, amount, risk);
		ObjectifyService.ofy().save().entity(a).now();
		
		Gson gson = new Gson();
		String json = gson.toJson(a);
		return Response.status(201).entity(json).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAccount(@PathParam("id") Long id) {
		Account a =  ObjectifyService.ofy().load().type(Account.class).id(id).now();
		if(a == null)
			return Response.status(400).build();
		ObjectifyService.ofy().delete().type(Account.class).id(id).now();
		Gson gson = new Gson();
		String json = gson.toJson("deleted");
		return Response.status(200).entity(json).build();
	}
	
	@PUT
	@Path("{id}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAmount(@PathParam("id") Long id, @PathParam("amount")int amount) {
		Account a = ObjectifyService.ofy().load().type(Account.class).id(id).now();
		if(a == null)
			return Response.status(400).build();
		a.setAmount(a.getAmount() + amount);
		ObjectifyService.ofy().save().entity(a).now();
		Gson gson = new Gson();
		String json = gson.toJson(a);
		return Response.status(200).entity(json).build();
		
	}

	
}