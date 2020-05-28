package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
public class CheckAccountService {

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public String getMsg() {
		return "<html><h3>get check account service</h3></html>";
	}
	
}
