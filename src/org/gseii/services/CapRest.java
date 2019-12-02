package org.gseii.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gseii.capteurs.Capteurs;
import org.gseii.ressources.CapService;

@Path("/capteurs")
public class CapRest {
CapService capService = new CapService();
	
@GET
@Path("/{idCapteur}")
@Produces(MediaType.APPLICATION_JSON)
public Capteurs getCapteurById(@PathParam("idCapteur") int idCapteur) {
	return capService.getCapteurs(idCapteur);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Capteurs> getCapteurs() {
	return capService.getAllCapteurs();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Capteurs addCapteur(Capteurs cap) {
	return capService.addCapteurs(cap);
}
@PUT
@Path("/{idCapteur}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Capteurs updateCapteur(@PathParam("idCapteur") int idCapteur,Capteurs cap) {
	cap.setIdCapteur(idCapteur);
	return capService.updateCapteurs(cap);
}

@DELETE
@Path("/{idCapteur}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteCapteur(@PathParam("idCapteur") int idCapteur) {
	capService.removeCapteurs(idCapteur);
}




}
