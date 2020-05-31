package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Result;

import model.Account;

@Path("/check")
public class CheckAccountService {

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String checkAccount(@PathParam("id") Long id) {
		Result<Account> result = ObjectifyService.ofy().load().type(Account.class).id(id);
		
		Account acc = result.now();
		
		Gson gson = new Gson();
		String json = gson.toJson(acc.getRisk());
		return json;
	}
	
}
