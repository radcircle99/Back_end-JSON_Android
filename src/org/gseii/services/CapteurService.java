package org.gseii.services;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gseii.capteurs.Capteurs;
import org.gseii.capteurs.Database;

@Path("/capteur")
public class CapteurService {


	@GET
	@Path("/get/{idCapteur}")
	@Produces(MediaType.APPLICATION_JSON)
	public Capteurs getCapteurById(@PathParam("idCapteur") int idCapteur) {
		return Database.cat[idCapteur];
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Capteurs[] getCapteur(){
		
		return Database.cat;		
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateCapteur( Capteurs capteur) {
		System.out.println("update"+ capteur.getNomCapteur());
		Database.cat[capteur.getIdCapteur()]=capteur;
		return true;
		
	}
}
