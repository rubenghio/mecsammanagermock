package samManager.request;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/")
public interface SamManagerServiceResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/request")
	CreditResult request(SamCreditRequest request);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rechargeRequest")
	RechargeCreditResult rechargeRequest(SamRechargeCreditRequest rechargeRequest);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getInformation")
	SamInformation getInformation();
	
}
