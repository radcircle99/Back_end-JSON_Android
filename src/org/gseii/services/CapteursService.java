package org.gseii.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.gseii.capteurs.CapteurDao;
import org.gseii.capteurs.Capteurs;

@Path("/CapteurService")
public class CapteursService {

		CapteurDao capdao = new CapteurDao();
		   private static final String SUCCESS_RESULT="<result>success</result>";
		   private static final String FAILURE_RESULT="<result>failure</result>";


		   @GET
		   @Path("/getall")
		   @Produces(MediaType.APPLICATION_JSON)
		   public List<Capteurs> getCapteurs(){
		      return capdao.getAllCapteurs();
		   }

		   @GET
		   @Path("/get/{idCapteur}")
		   @Produces(MediaType.APPLICATION_JSON)
		   public Capteurs getCapteurs(@PathParam("idCapteur") int idCapteur){
		      return capdao.getCapteur(idCapteur);
		   }

		   @POST
		   @Path("/post")
		   @Produces(MediaType.APPLICATION_JSON)
		   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		   public String createCapteur(@FormParam("idCapteur") int idCapteur,
		      @FormParam("nomCapteur") String nomCapteur,
		      @FormParam("placeCapteur") String placeCapteur,
		      @FormParam("valeur") double valeur,
		      @Context HttpServletResponse servletResponse) throws IOException{
		      Capteurs cap = new Capteurs(idCapteur, nomCapteur, placeCapteur, valeur);
		      int result = capdao.addCapteur(cap);
		      if(result == 1){
		         return SUCCESS_RESULT;
		      }
		      return FAILURE_RESULT;
		   }

		   @PUT
		   @Path("/update")
		   @Produces(MediaType.APPLICATION_JSON)
		   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		   public String updateCapteur(@FormParam("idCapteur") int idCapteur,
				      @FormParam("nomCapteur") String nomCapteur,
				      @FormParam("placeCapteur") String placeCapteur,
				      @FormParam("valeur") double valeur,	      
				      @Context HttpServletResponse servletResponse) throws IOException{
				      Capteurs cap = new Capteurs(idCapteur, nomCapteur, placeCapteur, valeur);
		      int result = capdao.updateCapteur(cap);
		      if(result == 1){
		         return SUCCESS_RESULT;
		      }
		      return FAILURE_RESULT;
		   }

		   @DELETE
		   @Path("/delete/{idCapteur}")
		   @Produces(MediaType.APPLICATION_JSON)
		   public String deleteUser(@PathParam("idCapteur") int idCapteur){
		      int result = capdao.deleteCapteur(idCapteur);
		      if(result == 1){
		         return SUCCESS_RESULT;
		      }
		      return FAILURE_RESULT;
		   }

		   @OPTIONS
		   @Path("/users")
		   @Produces(MediaType.APPLICATION_JSON)
		   public String getSupportedOperations(){
		      return "<operations>GET, PUT, POST, DELETE</operations>";
		   }
}
