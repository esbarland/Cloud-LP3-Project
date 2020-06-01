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

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;

import model.Account;

@Path("/account")
public class AccountService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccounts() {
		List<Account> listAccounts = ObjectifyService.ofy().load().type(Account.class).list();

		Gson gson = new Gson();
		String json = gson.toJson(listAccounts);
		return json;
	}

	@POST
	@Path("{lastname}/{firstname}/{amount}/{risk}")
	@Produces(MediaType.APPLICATION_JSON)
	public String addAccount(@PathParam("lastname") String lastname, @PathParam("firstname") String firstname, @PathParam("amount") int amount, @PathParam("risk") String risk) {
		Account a = new Account(firstname, lastname, amount, risk);
		ObjectifyService.ofy().save().entity(a).now();
		
		Gson gson = new Gson();
		String json = gson.toJson(a);
		return json;
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeAccount(@PathParam("id") Long id) {
		ObjectifyService.ofy().delete().type(Account.class).id(id).now();
		
		return "deleted";
	}
	
	@PUT
	@Path("{id}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateAmount(@PathParam("id") Long id, @PathParam("amount")int amount) {
		Account a = ObjectifyService.ofy().load().type(Account.class).id(id).now();
		a.setAmount(a.getAmount() + amount);
		Gson gson = new Gson();
		String json = gson.toJson(a);
		return json;
		
	}

	
}